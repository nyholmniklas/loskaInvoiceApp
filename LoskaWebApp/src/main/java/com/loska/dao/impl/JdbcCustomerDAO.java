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

import com.loska.dao.CustomerDAO;
import com.loska.dao.UserDAO;
import com.loska.model.Address;
import com.loska.model.Customer;
import com.loska.model.Invoice;
import com.loska.model.InvoiceRow;
import com.loska.model.User;

public class JdbcCustomerDAO implements CustomerDAO {

	private DataSource dataSource;
	@Autowired
	private UserDAO userDAO;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insertCustomer(Customer customer) {
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
			ps.setString(1, customer.getBill_to().getName());
			ps.setString(2, customer.getBill_to().getName2());
			ps.setString(3, customer.getBill_to().getAddress());
			ps.setString(4, customer.getBill_to().getPostcode());
			ps.setString(5, customer.getBill_to().getCity());
			ps.setString(6, customer.getBill_to().getCountry());
			ps.setString(7, customer.getShip_to().getName());
			ps.setString(8, customer.getShip_to().getName2());
			ps.setString(9, customer.getShip_to().getAddress());
			ps.setString(10, customer.getShip_to().getPostcode());
			ps.setString(11, customer.getShip_to().getCity());
			ps.setString(12, customer.getShip_to().getCountry());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int address_info_id = 0;
			if (rs.next()) {
				address_info_id = rs.getInt(1);
			}

			// Insert customer
			String insertcustomer = "INSERT INTO customers "
					+ "(user_id, address_info_id, name, y_tunnus) VALUES (?,?,?,?)";
			ps = conn.prepareStatement(insertcustomer);
			ps.setInt(1, customer.getUser_id());
			ps.setInt(2, address_info_id);
			ps.setString(3, customer.getName());
			ps.setString(4, customer.getY_tunnus());
			ps.executeUpdate();
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
	public Customer findCustomerById(int customerId) {
		Customer customer = new Customer();
		String sql = "SELECT * FROM customers WHERE customer_id =?;";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();

			rs.next();

			customer.setName(rs.getString("name"));
			customer.setCustomer_id(rs.getInt("customer_id"));
			customer.setY_tunnus(rs.getString("y_tunnus"));
			// Get and set adress info for customer
			Address bill = new Address();
			Address ship = new Address();
			sql = "SELECT * FROM address_info WHERE address_info_id='"
					+ rs.getInt("address_info_id") + "';";
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
			customer.setBill_to(bill);
			customer.setShip_to(ship);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return customer;
	}

	@Override
	public List<Customer> findAllCustomersForUserId(int userId) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		String sql = "SELECT user_id, customer_id " + "FROM customers WHERE user_id=?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			// Get the customers
			while (rs.next()) {
				customers.add(findCustomerById(rs.getInt("customer_id")));
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
		return customers;
	}

}
