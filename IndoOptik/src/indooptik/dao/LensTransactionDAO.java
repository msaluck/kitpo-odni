package indooptik.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import indooptik.model.Lens;
import indooptik.model.LensTransaction;
import indooptik.model.Transaction;

public class LensTransactionDAO {

	private Connection connection;
	ResultSet rs;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public LensTransactionDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<LensTransaction> retreiveALL() {
		String sql = "SELECT id, id_transaction, id_lens, axis FROM lens_transaction ";
		PreparedStatement statement = null;
		List<LensTransaction> listLensTransaction = new ArrayList<>();
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				LensTransaction lensTransaction = new LensTransaction();
				lensTransaction.setId(rs.getInt(1));
				lensTransaction.setIdTRansaction(rs.getInt(2));
				lensTransaction.setIdLens(rs.getInt(3));
				lensTransaction.setAxis(rs.getString(4));
				listLensTransaction.add(lensTransaction);
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
		return listLensTransaction;
	}
	
	public boolean insert(LensTransaction lensTransaction) {
		PreparedStatement statement = null;
		String sql = "INSERT INTO lens_transaction VALUES (null"
				+ ", " + lensTransaction.getIdTRansaction() + ", "
				+lensTransaction.getIdLens()+", '"
				+lensTransaction.getAxis()+"')";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(LensTransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					Logger.getLogger(LensTransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}
}
