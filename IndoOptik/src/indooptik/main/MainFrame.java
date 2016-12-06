/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indooptik.main;

import indooptik.controller.CustomerController;
import indooptik.controller.DisplayTableController;
import indooptik.controller.FrameController;
import indooptik.controller.FrameTransactionController;
import indooptik.controller.LensController;
import indooptik.controller.ProductController;
import indooptik.controller.ProductTransactionController;
import indooptik.controller.UserInfoController;
import indooptik.internalframe.CustomerInternalFrame;
import indooptik.internalframe.DisplayTableInternalFrame;
import indooptik.internalframe.FrameInternalFrame;
import indooptik.internalframe.FrameTransactionInternalFrame;
import indooptik.internalframe.LensInternalFrame;
import indooptik.internalframe.OrderInternalFrame;
import indooptik.internalframe.ProductInternalFrame;
import indooptik.internalframe.ProductTransactionInternalFrame;
import indooptik.internalframe.UserInfoInternalFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author Yoeda H
 */
public class MainFrame extends javax.swing.JFrame {

	UserInfoInternalFrame userInfoInternalFrame = new UserInfoInternalFrame();
	DisplayTableInternalFrame displayTableInternalFrame = new DisplayTableInternalFrame();
	LensInternalFrame lensInternalFrame = new LensInternalFrame();
	FrameInternalFrame frameInternalFrame = new FrameInternalFrame();
	FrameTransactionInternalFrame frameTransactionInternalFrame = new FrameTransactionInternalFrame();
	CustomerInternalFrame customerInternalFrame = new CustomerInternalFrame();
	ProductInternalFrame productInternalFrame = new ProductInternalFrame();
	OrderInternalFrame orderInternalFrame = new OrderInternalFrame();
	ProductTransactionInternalFrame productTransactionInternalFrame = new ProductTransactionInternalFrame();

	public ProductTransactionInternalFrame getProductTransactionInternalFrame() {
		return productTransactionInternalFrame;
	}

	/**
	 * Creates new form MainFrame
	 */
	public MainFrame() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")

	private void initComponents() {

		panel1 = new indooptik.utility.Panel();
		jDesktopPane1 = new javax.swing.JDesktopPane();
		jMenuBar1 = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		exitMenuItem = new javax.swing.JMenuItem();
		salesMenu = new javax.swing.JMenu();
		lensAndFrameMenuItem = new javax.swing.JMenuItem();
		productMenuItem = new javax.swing.JMenuItem();
		stockMenu = new javax.swing.JMenu();
		lensMenuItem = new javax.swing.JMenuItem();
		stockFrameMenuItem = new javax.swing.JMenuItem();
		stockProdukMenuItem = new javax.swing.JMenuItem();
		orderMenu = new JMenu();
		orderLensMenuItem = new JMenuItem();
		customerMenu = new javax.swing.JMenu();
		customerItem = new javax.swing.JMenuItem();
		jMenu1 = new javax.swing.JMenu();
		displayTableMenuItem = new javax.swing.JMenuItem();
		userInfoMenuItem = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Indo Optik");
		getContentPane().setLayout(new java.awt.BorderLayout());

		panel1.setLayout(new java.awt.BorderLayout());

		jDesktopPane1.setOpaque(false);
		panel1.add(jDesktopPane1, java.awt.BorderLayout.CENTER);

		getContentPane().add(panel1, java.awt.BorderLayout.CENTER);

		fileMenu.setText("File");

		exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
		exitMenuItem.setText("Keluar");
		exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(exitMenuItem);

		jMenuBar1.add(fileMenu);

		salesMenu.setText("Penjualan");

		lensAndFrameMenuItem.setText("Lensa dan Frame");
		lensAndFrameMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				lensAndFrameMenuItemActionPerformed(evt);
			}
		});
		salesMenu.add(lensAndFrameMenuItem);

		productMenuItem.setText("Produk");
		productMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				productMenuItemActionPerformed(evt);
			}
		});
		salesMenu.add(productMenuItem);

		jMenuBar1.add(salesMenu);

		stockMenu.setText("Stock");

		lensMenuItem.setText("Lensa");
		lensMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				lensMenuItemActionPerformed(evt);
			}
		});
		stockMenu.add(lensMenuItem);

		stockFrameMenuItem.setText("Frame");
		stockFrameMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stockFrameMenuItemActionPerformed(evt);
			}
		});
		stockMenu.add(stockFrameMenuItem);

		stockProdukMenuItem.setText("Produk");
		stockProdukMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stockProdukMenuItemActionPerformed(evt);
			}
		});
		stockMenu.add(stockProdukMenuItem);

		jMenuBar1.add(stockMenu);

		orderMenu.setText("Order");
		orderLensMenuItem.setText("Order Lensa");

		orderMenu.add(orderLensMenuItem);

		orderLensMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				orderLensActionPerformed(evt);
			}
		});

		jMenuBar1.add(orderMenu);

		customerMenu.setText("Customer");

		customerItem.setText("Customer");
		customerItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				customerItemActionPerformed(evt);
			}
		});
		customerMenu.add(customerItem);

		jMenuBar1.add(customerMenu);

		jMenu1.setText("Lain - Lain");

		displayTableMenuItem.setText("Input Meja Display");
		displayTableMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				displayTableMenuItemActionPerformed(evt);
			}
		});
		jMenu1.add(displayTableMenuItem);

		userInfoMenuItem.setText("User Info");
		userInfoMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				userInfoMenuItemActionPerformed(evt);
			}
		});
		jMenu1.add(userInfoMenuItem);

		jMenuBar1.add(jMenu1);

		setJMenuBar(jMenuBar1);

		pack();
	}

	protected void orderLensActionPerformed(ActionEvent evt) {
		if (evt.getSource() == orderLensMenuItem) {
			if (!orderInternalFrame.isVisible()) {
				getjDesktopPane1().add(orderInternalFrame);
				orderInternalFrame.setVisible(true);
				orderInternalFrame.setLocation(10, 10);
				//FrameTransactionController frameTransactionController = new FrameTransactionController(getFrameTransactionInternalFrame());
				//getFrameTransactionInternalFrame().setFrameTransactionController(frameTransactionController);
			}

			//getFrameTransactionInternalFrame().moveToFront();
			/*try {
                getFrameTransactionInternalFrame().setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }*/   
		} else {
			/*try {
                getFrameTransactionInternalFrame().setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }*/
		}
	}

	private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
		System.exit(0);
	}//GEN-LAST:event_exitMenuItemActionPerformed

	private void lensAndFrameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lensAndFrameMenuItemActionPerformed
		if (evt.getSource() == lensAndFrameMenuItem) {
			if (!frameTransactionInternalFrame.isVisible()) {
				getjDesktopPane1().add(getFrameTransactionInternalFrame());
				getFrameTransactionInternalFrame().setVisible(true);
				getFrameTransactionInternalFrame().setLocation(10, 10);
				FrameTransactionController frameTransactionController = new FrameTransactionController(getFrameTransactionInternalFrame());
				getFrameTransactionInternalFrame().setFrameTransactionController(frameTransactionController);

			}
			getFrameTransactionInternalFrame().moveToFront();
			try {
				getFrameTransactionInternalFrame().setSelected(true);
			} catch (PropertyVetoException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			try {
				getFrameTransactionInternalFrame().setSelected(true);
			} catch (PropertyVetoException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private void productMenuItemActionPerformed(ActionEvent evt) {
		if (evt.getSource() == productMenuItem) {
			System.out.println("A");
			System.out.println(getProductTransactionInternalFrame().isVisible());
			getjDesktopPane1().add(getProductTransactionInternalFrame());
			getProductTransactionInternalFrame().setVisible(true);
			if (!getProductTransactionInternalFrame().isVisible()) {
				System.out.println("AB");
				getjDesktopPane1().add(getProductTransactionInternalFrame());
				getProductTransactionInternalFrame().setVisible(true);
				getProductTransactionInternalFrame().setLocation(10, 10);
				ProductTransactionController productTransactionController = new ProductTransactionController(getProductTransactionInternalFrame());
				getProductTransactionInternalFrame().setProductTransactionController(productTransactionController);
			}

			getProductTransactionInternalFrame().moveToFront();
			
			try {
				getProductTransactionInternalFrame().setSelected(true);
			} catch (Exception ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			try {
				getProductTransactionInternalFrame().setSelected(true);
			} catch (PropertyVetoException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private void userInfoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {

		if (evt.getSource() == userInfoMenuItem) {
			if (!userInfoInternalFrame.isVisible()) {
				getjDesktopPane1().add(userInfoInternalFrame);
				userInfoInternalFrame.setVisible(true);
				userInfoInternalFrame.setLocation(10, 10);
				UserInfoController userInfoController = new UserInfoController(userInfoInternalFrame);
				userInfoInternalFrame.setUserInfoController(userInfoController);

			}
			userInfoInternalFrame.moveToFront();
			try {
				userInfoInternalFrame.setSelected(true);
			} catch (PropertyVetoException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			try {
				userInfoInternalFrame.setSelected(true);
			} catch (PropertyVetoException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private void displayTableMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayTableMenuItemActionPerformed
		if (evt.getSource() == displayTableMenuItem) {
			if (!displayTableInternalFrame.isVisible()) {
				getjDesktopPane1().add(displayTableInternalFrame);
				displayTableInternalFrame.setVisible(true);
				displayTableInternalFrame.setLocation(10, 10);
				DisplayTableController displayTableController = new DisplayTableController(displayTableInternalFrame);
				displayTableInternalFrame.setDisplayTableController(displayTableController);                
			}
			displayTableInternalFrame.moveToFront();
			try {
				userInfoInternalFrame.setSelected(true);
			} catch (PropertyVetoException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			try {
				displayTableInternalFrame.setSelected(true);
			} catch (PropertyVetoException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private void lensMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lensMenuItemActionPerformed
		if (evt.getSource() == lensMenuItem) {
			if (!lensInternalFrame.isVisible()) {
				getjDesktopPane1().add(lensInternalFrame);
				lensInternalFrame.setVisible(true);
				lensInternalFrame.setLocation(10, 10);
				LensController lensController = new LensController(lensInternalFrame);
				lensInternalFrame.setLensController(lensController);
			}
			lensInternalFrame.moveToFront();
			try {
				lensInternalFrame.setSelected(true);
			} catch (PropertyVetoException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			try {
				lensInternalFrame.setSelected(true);
			} catch (PropertyVetoException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private void stockFrameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockFrameMenuItemActionPerformed
		if (evt.getSource() == stockFrameMenuItem) {
			if (!frameInternalFrame.isVisible()) {
				getjDesktopPane1().add(frameInternalFrame);
				frameInternalFrame.setVisible(true);
				frameInternalFrame.setLocation(10, 10);
				FrameController frameController = new FrameController(frameInternalFrame);
				frameInternalFrame.setFrameController(frameController);
			}
			frameInternalFrame.moveToFront();
			try {
				frameInternalFrame.setSelected(true);
			} catch (PropertyVetoException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			try {
				frameInternalFrame.setSelected(true);
			} catch (PropertyVetoException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private void customerItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerItemActionPerformed
		if (evt.getSource() == customerItem) {
			if (!customerInternalFrame.isVisible()) {
				getjDesktopPane1().add(customerInternalFrame);
				customerInternalFrame.setVisible(true);
				customerInternalFrame.setLocation(10, 10);
				CustomerController customerController = new CustomerController(customerInternalFrame,this);
				customerInternalFrame.setCustomerController(customerController);
			}
			customerInternalFrame.moveToFront();
			try {
				customerInternalFrame.setSelected(true);
			} catch (PropertyVetoException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			try {
				customerInternalFrame.setSelected(true);
			} catch (PropertyVetoException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private void stockProdukMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockProdukMenuItemActionPerformed
		if (evt.getSource() == stockProdukMenuItem) {
			if (!productInternalFrame.isVisible()) {
				getjDesktopPane1().add(productInternalFrame);
				productInternalFrame.setVisible(true);
				productInternalFrame.setLocation(10, 10);
				ProductController productController = new ProductController(productInternalFrame);
				productInternalFrame.setProductController(productController);
			}
			productInternalFrame.moveToFront();
			try {
				productInternalFrame.setSelected(true);
			} catch (PropertyVetoException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			try {
				productInternalFrame.setSelected(true);
			} catch (PropertyVetoException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private javax.swing.JMenuItem customerItem;
	private javax.swing.JMenu customerMenu;
	private javax.swing.JMenuItem displayTableMenuItem;
	private javax.swing.JMenuItem exitMenuItem;
	private javax.swing.JMenu fileMenu;
	private javax.swing.JDesktopPane jDesktopPane1;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem lensAndFrameMenuItem;
	private javax.swing.JMenuItem lensMenuItem;
	private indooptik.utility.Panel panel1;
	private javax.swing.JMenuItem productMenuItem;
	private javax.swing.JMenu salesMenu;
	private javax.swing.JMenuItem stockFrameMenuItem;
	private javax.swing.JMenu stockMenu;
	private javax.swing.JMenuItem stockProdukMenuItem;
	private javax.swing.JMenuItem userInfoMenuItem;
	private JMenu orderMenu;
	private JMenuItem orderLensMenuItem;

	/**
	 * @return the frameTransactionInternalFrame
	 */
	public FrameTransactionInternalFrame getFrameTransactionInternalFrame() {
		return frameTransactionInternalFrame;
	}

	/**
	 * @return the jDesktopPane1
	 */
	public javax.swing.JDesktopPane getjDesktopPane1() {
		return jDesktopPane1;
	}

}
