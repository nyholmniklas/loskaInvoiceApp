package com.loska.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.loska.dao.InvoiceDAO;
import com.loska.model.Invoice;

public class JdbcInvoiceDAO implements InvoiceDAO {

	private DataSource dataSource;
	
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
				i.setBuyer_id(rs.getInt("buyer_id"));
				i.setDate(rs.getDate("date"));
				i.setDescription(rs.getString("description"));
				i.setUser_id(rs.getInt("user_id"));
				i.setTotalsum(rs.getFloat("totalsum"));
				invoices.add(i);
			}
//			insertUserRole(conn, user);
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
	public void insert(Invoice invoice) {
		String sql = "INSERT INTO invoices (user_id, reference, date, " +
				"buyer_id, description, totalsum) VALUES (?,?,?,?,?,?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, invoice.getUser_id());
			ps.setInt(2, invoice.getReference());
			ps.setDate(3, invoice.getDate());
			ps.setInt(4, invoice.getBuyer_id());
			ps.setString(5, invoice.getDescription());
			ps.setFloat(6, invoice.getTotalsum());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int id = 0;
			if (rs.next()) {
				id = rs.getInt(1);
			}
//			insertUserRole(conn, user);
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
