package indooptik.dao;

import indooptik.model.ProductTransactionDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductTransactionDetailDAO {
	private Connection connection;
	ResultSet resultSet;

	public ProductTransactionDetailDAO(Connection connection) {
		this.connection = connection;
	}

	public List<ProductTransactionDetail> retrieveAll() {
		String query = "SELECT ID, ID_PRODUCT_TRANSACTION, ID_PRODUCT, QTY, PRICE, AMOUNT, DISCOUNT FROM PRODUCT_TRANSACTION_DETAIL";
		PreparedStatement statement = null;
		List<ProductTransactionDetail> transactionDetails = new ArrayList<>();

		try {
			statement = connection.prepareStatement(query);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				ProductTransactionDetail productTransactionDetail = new ProductTransactionDetail();
				productTransactionDetail.setId(resultSet.getInt("ID"));
				productTransactionDetail.setIdProductTransaction(resultSet.getString("ID_PRODUCT_TRANSACTION"));
				productTransactionDetail.setIdProduct(resultSet.getInt("ID_PRODUCT"));
				productTransactionDetail.setQty(resultSet.getInt("QTY"));
				productTransactionDetail.setPrice(resultSet.getBigDecimal("PRICE"));
				productTransactionDetail.setAmount(resultSet.getBigDecimal("AMOUNT"));
				productTransactionDetail.setDiscount(resultSet.getBigDecimal("DISCOUNT"));

				transactionDetails.add(productTransactionDetail);
			}
			resultSet.close();
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
		return null;
	}

	public boolean insert(ProductTransactionDetail productTransactionDetail) {
		PreparedStatement statement = null;
		String sql = "INSERT INTO PRODUCT_TRANSACTION_DETAIL (ID_PRODUCT_TRANSACTION, ID_PRODUCT, QTY, PRICE, AMOUNT, DISCOUNT) VALUES (?,?,?,?,?,?)";
		try {            
			statement = (PreparedStatement) connection.prepareStatement(sql);

			statement.setString(1, productTransactionDetail.getIdProductTransaction());
			statement.setInt(2, productTransactionDetail.getIdProduct());
			statement.setInt(3, productTransactionDetail.getQty());
			statement.setBigDecimal(4, productTransactionDetail.getPrice());
			statement.setBigDecimal(5, productTransactionDetail.getAmount());
			statement.setBigDecimal(6, productTransactionDetail.getDiscount());

			statement.executeUpdate();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(ProductTransactionDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					Logger.getLogger(ProductTransactionDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}
}
