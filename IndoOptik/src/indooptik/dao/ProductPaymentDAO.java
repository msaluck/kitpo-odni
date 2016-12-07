package indooptik.dao;

import indooptik.model.ProductPayment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductPaymentDAO {
	private Connection connection;
	ResultSet resultSet;

	public ProductPaymentDAO(Connection connection) {
		this.connection = connection;
	}

	public List<ProductPayment> getAllProductPayment() {
		String query = "SELECT ID, ID_PRODUCT_TRANSACTION, ID_PAYMENT_METHOD, ID_PAYMENT_PROVIDER, AMOUNT, VARIANCE, BATCH_NO FROM PRODUCT_PAYMENT";
		PreparedStatement statement = null;
		List<ProductPayment> productPayments = new ArrayList<>();

		try {
			statement = connection.prepareStatement(query);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				ProductPayment productPayment = new ProductPayment();
				productPayment.setId(resultSet.getString("ID"));
				productPayment.setIdProductTransaction(resultSet.getString("ID_PRODUCT_TRANSACTION"));
				productPayment.setIdPaymentMethod(resultSet.getInt("ID_PAYMENT_METHOD"));
				productPayment.setIdPaymentProvider(resultSet.getInt("ID_PAYMENT_PROVIDER"));
				productPayment.setAmount(resultSet.getBigDecimal("AMOUNT"));
				productPayment.setVariance(resultSet.getBigDecimal("VARIANCE"));
				productPayment.setBatchNo(resultSet.getString("BATCH_NO"));

				productPayments.add(productPayment);
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

	public boolean insert(ProductPayment productPayment) {
		PreparedStatement statement = null;
		String sql = "INSERT INTO PRODUCT_PAYMENT (ID, ID_PRODUCT_TRANSACTION, ID_PAYMENT_METHOD, ID_PAYMENT_PROVIDER, AMOUNT, VARIANCE, BATCH_NO ) VALUES (?,?,?,?,?,?,?)";
		try {            
			statement = (PreparedStatement) connection.prepareStatement(sql);

			statement.setString(1, productPayment.getId());
			statement.setString(2, productPayment.getIdProductTransaction());
			statement.setInt(3, productPayment.getIdPaymentMethod());
			statement.setInt(4, productPayment.getIdPaymentProvider());
			statement.setBigDecimal(4, productPayment.getAmount());
			statement.setBigDecimal(5, productPayment.getVariance());
			statement.setString(6, productPayment.getBatchNo());

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
