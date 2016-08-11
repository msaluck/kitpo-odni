/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indooptik.main;

import indooptik.dao.DAOFactory;
import indooptik.dao.UserInfoDAO;
import indooptik.model.UserInfo;
import javax.swing.JFrame;

/**
 *
 * @author Yoeda H
 */
public class Main {

	public static String[] sph = new String[161];
	public static String[] cly = new String[25];
	public static String[] add = new String[9];

	public static void main(String[] args){

		populateData();
		UserInfoDAO userInfoDAO = DAOFactory.create().getUserInfoDAO();
		UserInfo userInfo = userInfoDAO.retreive();
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setExtendedState(mainFrame.getExtendedState()|JFrame.MAXIMIZED_BOTH);        
		mainFrame.setTitle(userInfo.getStoreName());
	}

	private static void populateData() {
		int x = 2025;
		for (int i = 0; i < sph.length; i++) {
			x = x-25;
			if (Math.signum(x)==1) {
				sph[i] = "+"+x;
			}
			else if(Math.signum(x)==-1) {
				sph[i] = ""+x;
			}
			else {
				sph[i] = ""+x;
			}
		}
		
		int y = 0;
		
		for (int i = 0; i < cly.length; i++) {
			y = y + 25;
			cly[i] = "-"+y;
		}

		int b = 75;

		for (int i = 0; i < add.length; i++) {
			b = b + 25;
			add[i] = "+"+b;
		}
	}
}
