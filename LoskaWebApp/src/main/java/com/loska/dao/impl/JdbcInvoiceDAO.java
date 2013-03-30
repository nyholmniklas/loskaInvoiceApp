package com.loska.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import com.loska.dao.InvoiceDAO;
import com.loska.model.invoice.Invoice;

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
		// TODO Auto-generated method stub
		return null;
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
