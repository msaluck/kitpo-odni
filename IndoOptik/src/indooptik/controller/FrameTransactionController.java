/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indooptik.controller;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;

import indooptik.dao.DAOFactory;
import indooptik.dao.TransactionDAO;
import indooptik.internalframe.FrameTransactionInternalFrame;
import indooptik.model.Transaction;
import indooptik.utility.SystemID;

/**
 *
 * @author Yoeda H
 */
public class FrameTransactionController {
    private FrameTransactionInternalFrame frameTransactionInternalFrame;
    TransactionDAO transactionDAO;

    public FrameTransactionController(FrameTransactionInternalFrame frameTransactionInternalFrame) {
        this.frameTransactionInternalFrame = frameTransactionInternalFrame;
        transactionDAO = DAOFactory.create().getTransactionDAO();
    }
    
    public void show(JInternalFrame parent, JDialog child){
        child.setVisible(true);
        child.setLocation(parent.getWidth()/2,parent.getHeight()/2);
    }
    
    public void bayar(Transaction transaction){
    	//Transaction transaction = new Transaction();
    	//transaction.setIdTransaction();
    	//transaction.setIdCostumer();
    	//transaction.setIdLens();
    	//transaction.setIdFrame();
    	//transaction.setName();
    	//transaction.setTelp();
    	//transaction.setHP(HP);
    	//transaction.setBirthDate();
    	//transaction.setTransactionDate();
    	//transaction.setLens();
    	//transaction.setLensColor();
    	//transaction.setFrame();
    	//transaction.setDesc("");
    	
    	transactionDAO.insert(transaction);
    }
    
    public void newTransaction(){
    	
    }
    
	public void createNewTransaction() {
		SystemID.load();
		frameTransactionInternalFrame.getTransactionIdLabel().setText(SystemID.generate("TRX", "S"));
		SystemID.save();
	}
	
	public void clearField(){
		frameTransactionInternalFrame.getNameTxt().setText("");
		frameTransactionInternalFrame.getPhoneTxt().setText("");
		frameTransactionInternalFrame.getMobileTxt().setText("");
		frameTransactionInternalFrame.getBodTxt().setDate(null);
		
		frameTransactionInternalFrame.getLensTxt().setText("");
		frameTransactionInternalFrame.getColorTxt().setText("");
		frameTransactionInternalFrame.getOdSphCmbox().setSelectedIndex(80);
		frameTransactionInternalFrame.getOdClyCmbox().setSelectedIndex(0);
		frameTransactionInternalFrame.getOdAxisTextfield().setText("");
		frameTransactionInternalFrame.getOsSphCmbox().setSelectedIndex(80);
		frameTransactionInternalFrame.getOsClyCmbox().setSelectedIndex(0);
		frameTransactionInternalFrame.getOsAxisTextfield().setText("");
		
		frameTransactionInternalFrame.getFrameTxt().setText("");
		frameTransactionInternalFrame.getDescTxt().setText("");
		
		frameTransactionInternalFrame.getLensPriceTxt().setText("");
		frameTransactionInternalFrame.getFramePriceTxt().setText("");
		
		frameTransactionInternalFrame.getDpCashTextField().setText("");
		
		frameTransactionInternalFrame.getNoKartuTextField().setText("");
		frameTransactionInternalFrame.getNoTraceTextField().setText("");
		frameTransactionInternalFrame.getDpKartuTextField().setText("");
		
		frameTransactionInternalFrame.getNoLegalisasiTextField().setText("");
		frameTransactionInternalFrame.getDpInstansiTextField().setText("");
		
		frameTransactionInternalFrame.getDpTransferTextField().setText("");
	}
}
