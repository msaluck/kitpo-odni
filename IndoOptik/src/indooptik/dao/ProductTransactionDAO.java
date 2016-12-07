/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indooptik.dao;

import indooptik.model.Product;
import indooptik.model.ProductTransaction;
import indooptik.utility.DateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yoeda H
 */
public class ProductTransactionDAO {
	private Connection connection;
	ResultSet rs;

	public ProductTransactionDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Product> retreiveALL() {
		String sql = "SELECT id, barcode, name, type, color,minus, price, stock, created_date FROM product ORDER BY name";
		PreparedStatement statement = null;
		List<Product> listprProducts = new ArrayList<>();
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setBarcode(rs.getString(2));
				product.setName(rs.getString(3));
				product.setType(rs.getString(4));
				product.setColor(rs.getString(5));
				product.setMinus(rs.getInt(6));
				product.setPrice(rs.getBigDecimal(7));
				product.setStock(rs.getInt(8));
				product.setCreatedDate(rs.getDate(9));
				listprProducts.add(product);
			}
			rs.close();
		} catch (SQLException ex) {
			System.out.println("SQL Execption :" + ex.getMessage());
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException exception) {
					exception.printStackTrace();
				}
			}
		}
		return listprProducts;
	}

	public boolean insert(ProductTransaction productTransaction) {
		PreparedStatement statement = null;
		String sql = "INSERT INTO product_transaction (id, id_customer, created_date, remark, total_qty, total_amount, total_discount) VALUES (?,?,?,?,?,?,?)";
		try {            
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, productTransaction.getId());
			statement.setInt(2, productTransaction.getIdCustomer());
			statement.setDate(3, DateUtil.toDate(productTransaction.getCreatedDate()));
			statement.setString(4, productTransaction.getRemark());
			statement.setInt(5, productTransaction.getTotalQty());
			statement.setBigDecimal(6, productTransaction.getTotalAmount());
			statement.setBigDecimal(7, productTransaction.getTotalDiscount());

			statement.executeUpdate();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(ProductTransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					Logger.getLogger(ProductTransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}       
}
