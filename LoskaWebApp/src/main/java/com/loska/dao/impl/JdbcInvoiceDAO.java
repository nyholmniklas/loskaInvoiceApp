package com.loska.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.loska.dao.InvoiceDAO;
import com.loska.dao.UserDAO;
import com.loska.model.Address;
import com.loska.model.Invoice;
import com.loska.model.InvoiceRow;
import com.loska.model.User;

public class JdbcInvoiceDAO implements InvoiceDAO {

	private DataSource dataSource;

	@Autowired
	private UserDAO userDAO;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Invoice findInvoiceById(int id) {
		Invoice invoice = new Invoice();
		String sql = "SELECT * FROM invoices WHERE invoice_id ='" + id + "';";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		
			rs.next();
			
			//Get and set the user
			User user = userDAO.findByUserId(rs.getInt("user_id"));
			invoice.setUser(user);
			invoice.setInvoice_id(rs.getInt("invoice_id"));
			
			//Get and set all "invoice rows"
			invoice.setRows(getAllRowsForInvoiceByInvoiceId(id));
			
			//TODO Fetch all other invoice info(dates, etc)
			invoice.setDate(rs.getDate("date"));
			invoice.setDue_date(rs.getDate("due_date"));

			//Get and set adress info for invoice
			Address bill = new Address();
			Address ship = new Address();
			sql = "SELECT * FROM address_info WHERE address_info_id='" 
					+ rs.getInt("address_info_id")+"';";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			bill.setName(rs.getString("bill_to_name"));
			bill.setName2(rs.getString("bill_to_name2"));
			bill.setAddress(rs.getString("bill_to_address"));
			bill.setPostcode(rs.getString("bill_to_postcode"));
			bill.setCity(rs.getString("bill_to_city"));
			bill.setCountry(rs.getString("bill_to_country"));
			ship.setName(rs.getString("ship_to_name"));
			ship.setName2(rs.getString("ship_to_name2"));
			ship.setAddress(rs.getString("ship_to_address"));
			ship.setPostcode(rs.getString("ship_to_postcode"));
			ship.setCity(rs.getString("ship_to_city"));
			ship.setCountry(rs.getString("ship_to_country"));
			invoice.setBill_to(bill);
			invoice.setShip_to(ship);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		 finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		 }
		return invoice;
	}

	@Override
	// Currently not working
	public List<Invoice> getAllInvoicesBelongingToUserId(int user_Id) {
		ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		String sql = "SELECT user_id, invoice_id " + "FROM invoices WHERE user_id='"+user_Id+"'";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			// Get the invoices
			while (rs.next()) {
				invoices.add(findInvoiceById(rs.getInt("invoice_id")));
			}
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return invoices;
	}

	@Override
	@Transactional
	public void insert(Invoice invoice) {

		Connection conn = null;
		try {
			conn = dataSource.getConnection();

			// Insert address_info
			String setAddressInfo = "INSERT INTO address_info "
					+ "(bill_to_name, bill_to_name2, bill_to_address, bill_to_postcode,"
					+ "bill_to_city, bill_to_country, "
					+ "ship_to_name, ship_to_name2, ship_to_address, ship_to_postcode,"
					+ "ship_to_city, ship_to_country) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(setAddressInfo,
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, invoice.getBill_to().getName());
			ps.setString(2, invoice.getBill_to().getName2());
			ps.setString(3, invoice.getBill_to().getAddress());
			ps.setString(4, invoice.getBill_to().getPostcode());
			ps.setString(5, invoice.getBill_to().getCity());
			ps.setString(6, invoice.getBill_to().getCountry());
			ps.setString(7, invoice.getShip_to().getName());
			ps.setString(8, invoice.getShip_to().getName2());
			ps.setString(9, invoice.getShip_to().getAddress());
			ps.setString(10, invoice.getShip_to().getPostcode());
			ps.setString(11, invoice.getShip_to().getCity());
			ps.setString(12, invoice.getShip_to().getCountry());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int address_info_id = 0;
			if (rs.next()) {
				address_info_id = rs.getInt(1);
			}

			// Insert invoice
			String insertInvoice = "INSERT INTO invoices "
					+ "(user_id, address_info_id, date, due_date) VALUES (?,?,?,?)";
			ps = conn.prepareStatement(insertInvoice,
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, userDAO
					.findByUsername(invoice.getUser().getUsername())
					.getUser_Id());
			ps.setInt(2, address_info_id);
			ps.setDate(3, invoice.getDate());
			ps.setDate(4, invoice.getDue_date());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			int invoice_id = 0;
			if (rs.next()) {
				invoice_id = rs.getInt(1);
			}

			// Insert rows
			// This is not efficient look into IT!!!!!!
			for (InvoiceRow row : invoice.getRows()) {
				String insertRows = ("INSERT INTO invoice_rows (invoice_id, product_name, ammount, price, tax_percent) VALUES ("
						+ invoice_id
						+ ", \""
						+ row.getName()
						+ "\", "
						+ row.getAmmount()
						+ ","
						+ row.getPrice()
						+ ", "
						+ row.getTax() + ");");
				ps = conn.prepareStatement(insertRows);
				System.out.println(insertRows);
				ps.executeUpdate();
			}

			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public InvoiceRow findInvoiceRowById(int rowId) {
		InvoiceRow row = new InvoiceRow();
		String sql = "SELECT * FROM invoice_rows WHERE invoice_row_id ='"
				+ rowId + "';";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				row.setRow_id(rs.getInt("invoice_row_id"));
				row.setName(rs.getString("product_name"));
				row.setAmmount(rs.getInt("ammount"));
				row.setPrice(rs.getFloat("price"));
				row.setTax(rs.getFloat("tax_percent"));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		 }
		return row;
	}

	@Override
	public List<InvoiceRow> getAllRowsForInvoiceByInvoiceId(int invoiceId) {
		ArrayList<InvoiceRow> rows = new ArrayList<InvoiceRow>();
		String sql = "SELECT * FROM invoice_rows WHERE invoice_id ='"
				+ invoiceId + "';";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				InvoiceRow row = new InvoiceRow();
				row.setRow_id(rs.getInt("invoice_row_id"));
				row.setName(rs.getString("product_name"));
				row.setAmmount(rs.getInt("ammount"));
				row.setPrice(rs.getFloat("price"));
				row.setTax(rs.getFloat("tax_percent"));
				rows.add(row);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		 }
		return rows;
	}
}
