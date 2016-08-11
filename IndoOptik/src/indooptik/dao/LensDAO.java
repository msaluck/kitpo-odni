/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indooptik.dao;

import indooptik.model.Lens;
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
public class LensDAO {
	private Connection connection;
	ResultSet rs;

	public LensDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Lens> retreiveALL() {
		String sql = "SELECT id_lens, type, material_lens, color, price, created_date, sph, cyl, lens.add, merk, stock FROM lens ORDER BY id_lens DESC";
		PreparedStatement statement = null;
		List<Lens> listLens = new ArrayList<>();        
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				Lens lens = new Lens();
				lens.setIdLens(rs.getInt(1));
				lens.setType(rs.getString(2));
				lens.setMaterialLens(rs.getString(3));                
				lens.setColor(rs.getString(4));
				lens.setPrice(rs.getBigDecimal(5));
				lens.setCreatedDate(rs.getDate(6));
				lens.setSph(rs.getString(7));
				lens.setCyl(rs.getString(8));
				lens.setAdd(rs.getString(9));
				lens.setMerk(rs.getString(10));
				lens.setStock(rs.getInt(11));
				listLens.add(lens);
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
		return listLens;
	}

	public List<String> retreiveALLColor() {
		String sql = "SELECT id, name FROM color ORDER BY id ASC";
		PreparedStatement statement = null;
		List<String> listStr = new ArrayList<>();        
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				String color = rs.getString("name");
				listStr.add(color);
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
		return listStr;
	}

	public boolean insert(Lens lens) {
		PreparedStatement statement = null;
		String sql = "INSERT INTO lens VALUES (null"
				+ ", '" + lens.getType() + "', '"
				+lens.getMaterialLens()+"', '"
				+lens.getColor()+"', "+lens.getPrice()+", now(), '"+lens.getSph()+"', '"+lens.getCyl()+"', '"+lens.getAdd()+"', "+lens.getStock()+",'"+lens.getMerk()+"')";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(LensDAO.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					Logger.getLogger(LensDAO.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	public boolean update(Lens lens){
		PreparedStatement statement = null;        
		String sql= "UPDATE lens SET type = '"+lens.getType()+"', material_lens = '"
				+lens.getMaterialLens()
				+"', color = '"+lens.getColor()+"', price = "+lens.getPrice()+", created_date = now(), sph='"+lens.getSph()
				+"', cyl='"+lens.getCyl()+"', lens.add='"+lens.getAdd()+"', merk='"+lens.getMerk()+"', stock="+lens.getStock()+" WHERE id_lens = "+lens.getIdLens();
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.executeUpdate();
			System.out.println(sql);
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(LensDAO.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					Logger.getLogger(LensDAO.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	public boolean delete(Lens lens){
		PreparedStatement statement = null;        
		String sql= "DELETE FROM lens WHERE id_lens = "+lens.getIdLens();
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(LensDAO.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					Logger.getLogger(LensDAO.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

}
