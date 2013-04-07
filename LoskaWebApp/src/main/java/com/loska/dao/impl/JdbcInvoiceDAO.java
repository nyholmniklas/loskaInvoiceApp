package com.loska.dao.impl;

import java.sql.Connection;
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
import com.loska.model.Invoice;

public class JdbcInvoiceDAO implements InvoiceDAO {

	private DataSource dataSource;
	
	@Autowired
	private UserDAO userDAO;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public Invoice findInvoiceById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Invoice> getAllInvoicesBelongingToUserId(int user_Id) {
		ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		String sql = "SELECT invoice_id, user_id, reference, date, buyer_id, description, totalsum " +
				"FROM invoices WHERE user_id='"+ user_Id +"'";
		System.out.println(sql);
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Invoice i = new Invoice();
				i.setInvoice_id(rs.getInt("invoice_id"));
				i.setReference(rs.getInt("reference"));
				//TEMP next line
				i.setDate(rs.getDate("date"));
				i.setDescription(rs.getString("description"));
				i.setUser(userDAO.findByUserId(rs.getInt("user_id")));
				i.setTotalsum(rs.getFloat("totalsum"));
				invoices.add(i);
			}
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		return invoices;
	}

	@Override
	@Transactional
	public void insert(Invoice invoice) {
		String setAddressInfo = "INSERT INTO address_info " +
				"(ship_to_name, ship_to_name2, ship_to_address, ship_to_postcode," +
				"ship_to_city, ship_to_country) VALUES (?,?,?,?,?,?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(setAddressInfo,
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, invoice.getShip_to().getName());
			ps.setString(2, invoice.getShip_to().getName2());
			ps.setString(3, invoice.getShip_to().getAddress());
			ps.setString(4, invoice.getShip_to().getPostcode());
			ps.setString(5, invoice.getShip_to().getCity());
			ps.setString(6, invoice.getShip_to().getCountry());
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int address_info_id = 0;
			if (rs.next()) {
				address_info_id = rs.getInt(1);
			}
			
			String insertInvoice = "INSERT INTO invoices " +
					"(address_info_id) VALUES (?)";
			ps = conn.prepareStatement(insertInvoice);
			ps.setInt(1, address_info_id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}

	}

}
