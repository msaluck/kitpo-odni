package indooptik.internalframe;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import indooptik.controller.ProductTransactionController;
import indooptik.model.Product;
import indooptik.model.ProductTransactionDetail;
import indooptik.utility.NumberField;
import indooptik.utility.Panel;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;

public class ProductTransactionInternalFrame extends JInternalFrame{

	private static final long serialVersionUID = 2712102182898894967L;
	private Panel panel = new Panel();
	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	private ProductTransactionController productTransactionController;
	private NumberField totalGrossPayField;
	private NumberField totalDiscountField;
	private NumberField totalNetPaymentField;
	private NumberField cashDpField;
	private NumberField cardNumberField;
	private JTextField traceNumberField;
	private NumberField nonCashDpField;
	private JTextField legalitationNumberField;
	private NumberField instanceDpField;
	private NumberField dpTransferField;
	private NumberField remainingPaymentField;
	private JTable productTransactionTbl;
	private JScrollPane jScrollPane = new JScrollPane();
	private JTextField inputField;
	private JTextField qtyField;
	private List<ProductTransactionDetail> transactionDetails = new ArrayList<>();
	private JCheckBox cashChkBox;
	private JComboBox<String> nonCashCmbBox;
	private JCheckBox transferChkBox;
	private JCheckBox instanceChkBox;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel transactionDateField;
	private JLabel transactionIdField;
	private Map<String, ProductTransactionDetail> productTransactionDetailMap;
	private DefaultTableModel defaultTableModel;

	public void setProductTransactionController(ProductTransactionController productTransactionController) {
		this.productTransactionController = productTransactionController;
	}

	public ProductTransactionController getProductTransactionController() {
		return productTransactionController;
	}

	/**
	 * Create the frame.
	 */
	public ProductTransactionInternalFrame() {
		setBounds(10, 10, 950, 605);
		setBorder(BorderFactory.createEtchedBorder());
		setClosable(true);
		setIconifiable(true);
		setTitle("Transaksi Penjualan Produk");

		leftPanel.setBounds(10, 10, 560, 555);
		leftPanel.setBorder(BorderFactory.createEtchedBorder());
		leftPanel.setOpaque(false);
		leftPanel.setLayout(null);

		panel.add(leftPanel);

		JPanel topPanel = new JPanel();
		topPanel.setBounds(10, 10, 540, 175);
		topPanel.setBorder(BorderFactory.createEtchedBorder());
		topPanel.setOpaque(false);
		topPanel.setLayout(null);
		leftPanel.add(topPanel);

		JLabel lblIdTransaksi = new JLabel("ID Transaksi");
		lblIdTransaksi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdTransaksi.setForeground(Color.WHITE);
		lblIdTransaksi.setBounds(10, 10, 80, 20);
		topPanel.add(lblIdTransaksi);

		JLabel lblNewLabel_1 = new JLabel(":");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(90, 10, 10, 20);
		topPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tanggal");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(270, 10, 80, 20);
		topPanel.add(lblNewLabel_2);

		JLabel label_6 = new JLabel(":");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(350, 10, 10, 20);
		topPanel.add(label_6);

		transactionIdField = new JLabel("");
		transactionIdField.setBounds(100, 10, 80, 20);
		topPanel.add(transactionIdField);

		transactionDateField = new JLabel();
		transactionDateField.setBounds(360, 10, 80, 20);
		topPanel.add(transactionDateField);

		JLabel label_10 = new JLabel();
		label_10.setText("Nama");
		label_10.setPreferredSize(new Dimension(75, 15));
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_10.setBounds(10, 53, 75, 20);
		topPanel.add(label_10);

		JLabel label_11 = new JLabel();
		label_11.setText("Telepon");
		label_11.setPreferredSize(new Dimension(75, 15));
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_11.setBounds(10, 83, 75, 20);
		topPanel.add(label_11);

		JLabel label_12 = new JLabel();
		label_12.setText("HP");
		label_12.setPreferredSize(new Dimension(75, 15));
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_12.setBounds(10, 113, 75, 20);
		topPanel.add(label_12);

		JLabel label_13 = new JLabel();
		label_13.setText("HUT");
		label_13.setPreferredSize(new Dimension(75, 15));
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_13.setBounds(10, 143, 75, 20);
		topPanel.add(label_13);

		textField = new JTextField();
		textField.setToolTipText("");
		textField.setBounds(97, 56, 200, 20);
		topPanel.add(textField);

		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setBounds(97, 85, 150, 20);
		topPanel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setToolTipText("");
		textField_2.setBounds(97, 116, 150, 20);
		topPanel.add(textField_2);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(97, 144, 100, 20);
		topPanel.add(dateChooser);

		JPanel downPanel = new JPanel();
		downPanel.setBounds(10, 195, 540, 349);
		downPanel.setBorder(BorderFactory.createEtchedBorder());
		downPanel.setOpaque(false);
		downPanel.setLayout(null);
		leftPanel.add(downPanel);

		inputField = new JTextField();
		inputField.setBounds(10, 10, 330, 30);
		downPanel.add(inputField);
		inputField.setColumns(10);

		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setBounds(350, 10, 10, 30);
		downPanel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));

		qtyField = new JTextField();
		qtyField.setBounds(375, 10, 50, 30);
		downPanel.add(qtyField);
		qtyField.setColumns(10);

		JButton inputBtn = new JButton("+");
		inputBtn.setBounds(480, 10, 50, 30);
		downPanel.add(inputBtn);
		
		Object [] columnsName = {"Nama Produk","Qty","Harga","Sub Total"};

		defaultTableModel = new DefaultTableModel(columnsName, 0);
		
		productTransactionTbl = new JTable();
		productTransactionTbl.setModel(defaultTableModel);

		if (productTransactionTbl.getColumnModel().getColumnCount() > 0) {
			productTransactionTbl.getColumnModel().getColumn(0).setPreferredWidth(250);
			productTransactionTbl.getColumnModel().getColumn(1).setPreferredWidth(25);
			productTransactionTbl.getColumnModel().getColumn(2).setPreferredWidth(50);
			productTransactionTbl.getColumnModel().getColumn(3).setPreferredWidth(50);
		}

		jScrollPane.setBounds(10, 51, 520, 250);
		downPanel.add(jScrollPane);
		jScrollPane.setViewportView(productTransactionTbl);

		inputBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inputProduct(inputField.getText(), qtyField.getText());
			}
		});

		rightPanel.setBounds(580, 10, 356, 555);
		rightPanel.setBorder(BorderFactory.createEtchedBorder());
		rightPanel.setOpaque(false);
		rightPanel.setLayout(null);
		panel.add(rightPanel);

		JLabel lblTotalBayar = new JLabel();
		lblTotalBayar.setText("Total Bayar");
		lblTotalBayar.setPreferredSize(new Dimension(75, 15));
		lblTotalBayar.setForeground(Color.WHITE);
		lblTotalBayar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotalBayar.setBounds(10, 10, 80, 20);
		rightPanel.add(lblTotalBayar);

		totalGrossPayField = new NumberField(9);
		totalGrossPayField.setBounds(130, 10, 200, 20);
		rightPanel.add(totalGrossPayField);

		JLabel label_2 = new JLabel();
		label_2.setText("Diskon");
		label_2.setPreferredSize(new Dimension(75, 15));
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(10, 40, 80, 20);
		rightPanel.add(label_2);

		totalDiscountField = new NumberField(9);
		totalDiscountField.setBounds(130, 40, 200, 20);
		rightPanel.add(totalDiscountField);

		JLabel label_3 = new JLabel();
		label_3.setText("Jumlah");
		label_3.setPreferredSize(new Dimension(75, 15));
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(10, 70, 80, 20);
		rightPanel.add(label_3);

		totalNetPaymentField = new NumberField(9);
		totalNetPaymentField.setBounds(130, 70, 200, 20);
		rightPanel.add(totalNetPaymentField);

		JLabel label_4 = new JLabel();
		label_4.setText("Tipe \r\nPembayaran");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(10, 104, 100, 50);
		rightPanel.add(label_4);

		cashChkBox = new JCheckBox();
		cashChkBox.setText("Cash");
		cashChkBox.setBounds(128, 104, 95, 20);
		rightPanel.add(cashChkBox);

		cashChkBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cashMode();
			}
		});

		instanceChkBox = new JCheckBox();
		instanceChkBox.setText("Instansi");
		instanceChkBox.setBounds(233, 104, 95, 20);
		rightPanel.add(instanceChkBox);

		instanceChkBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				instanceMode();
			}
		});

		transferChkBox = new JCheckBox();
		transferChkBox.setText("Transfer");
		transferChkBox.setBounds(233, 134, 95, 20);
		rightPanel.add(transferChkBox);

		transferChkBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				transferMode();
			}
		});

		nonCashCmbBox = new JComboBox<String>();
		nonCashCmbBox.setBounds(128, 134, 95, 20);
		nonCashCmbBox.addItem("Pilih");
		nonCashCmbBox.addItem("Debit");
		nonCashCmbBox.addItem("Kredit");
		rightPanel.add(nonCashCmbBox);

		nonCashCmbBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nonCashMode();
			}
		});

		JPanel cashPanel = new JPanel();
		cashPanel.setLayout(null);
		cashPanel.setOpaque(false);
		cashPanel.setForeground(Color.WHITE);
		cashPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, null));
		cashPanel.setBounds(10, 165, 336, 40);
		rightPanel.add(cashPanel);

		JLabel label = new JLabel();
		label.setText("DP Cash");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 10, 90, 20);
		cashPanel.add(label);

		cashDpField = new NumberField(9);
		cashDpField.setEditable(false);
		cashDpField.setBounds(117, 10, 200, 20);
		cashPanel.add(cashDpField);

		JPanel nonCashPanel = new JPanel();
		nonCashPanel.setLayout(null);
		nonCashPanel.setOpaque(false);
		nonCashPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		nonCashPanel.setBounds(10, 216, 336, 100);
		rightPanel.add(nonCashPanel);

		JLabel label_1 = new JLabel();
		label_1.setText("No Kartu");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(10, 10, 90, 20);
		nonCashPanel.add(label_1);

		cardNumberField = new NumberField(9);
		cardNumberField.setEditable(false);
		cardNumberField.setBounds(117, 10, 200, 20);
		nonCashPanel.add(cardNumberField);

		JLabel label_5 = new JLabel();
		label_5.setText("Trace No");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(10, 40, 90, 20);
		nonCashPanel.add(label_5);

		traceNumberField = new JTextField();
		traceNumberField.setEditable(false);
		traceNumberField.setBounds(117, 40, 200, 20);
		nonCashPanel.add(traceNumberField);

		nonCashDpField = new NumberField(9);
		nonCashDpField.setEditable(false);
		nonCashDpField.setBounds(117, 70, 200, 20);
		nonCashPanel.add(nonCashDpField);

		JLabel lblDpKartu = new JLabel();
		lblDpKartu.setText("DP Kartu");
		lblDpKartu.setForeground(Color.WHITE);
		lblDpKartu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDpKartu.setBounds(10, 70, 90, 20);
		nonCashPanel.add(lblDpKartu);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setOpaque(false);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(10, 327, 336, 70);
		//rightPanel.add(panel_3);

		JLabel label_7 = new JLabel();
		label_7.setText("No. Legalisasi");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(10, 10, 90, 20);
		panel_3.add(label_7);

		legalitationNumberField = new JTextField();
		legalitationNumberField.setEditable(false);
		legalitationNumberField.setBounds(117, 10, 200, 20);
		panel_3.add(legalitationNumberField);

		instanceDpField = new NumberField(9);
		instanceDpField.setEditable(false);
		instanceDpField.setBounds(117, 40, 200, 20);
		panel_3.add(instanceDpField);

		JLabel label_8 = new JLabel();
		label_8.setText("DP Instansi");
		label_8.setPreferredSize(new Dimension(75, 15));
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(10, 40, 90, 20);
		panel_3.add(label_8);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setOpaque(false);
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(10, 408, 336, 40);
		//rightPanel.add(panel_4);

		JLabel lblDpTransfer = new JLabel();
		lblDpTransfer.setText("DP Transfer");
		lblDpTransfer.setPreferredSize(new Dimension(75, 15));
		lblDpTransfer.setForeground(Color.WHITE);
		lblDpTransfer.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDpTransfer.setBounds(10, 10, 90, 20);
		panel_4.add(lblDpTransfer);

		dpTransferField = new NumberField(9);
		dpTransferField.setEditable(false);
		dpTransferField.setBounds(117, 10, 200, 20);
		panel_4.add(dpTransferField);

		JPanel remainingPanel = new JPanel();
		remainingPanel.setLayout(null);
		remainingPanel.setOpaque(false);
		remainingPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		remainingPanel.setBounds(10, 459, 336, 40);
		rightPanel.add(remainingPanel);

		JLabel lblSisa = new JLabel();
		lblSisa.setText("Sisa");
		lblSisa.setPreferredSize(new Dimension(75, 15));
		lblSisa.setForeground(Color.WHITE);
		lblSisa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSisa.setBounds(10, 10, 90, 20);
		remainingPanel.add(lblSisa);

		remainingPaymentField = new NumberField(9);
		remainingPaymentField.setEditable(false);
		remainingPaymentField.setBounds(117, 10, 200, 20);
		remainingPanel.add(remainingPaymentField);

		JButton newTransactionBtn = new JButton();
		newTransactionBtn.setText("Baru");
		newTransactionBtn.setBounds(10, 510, 75, 25);
		rightPanel.add(newTransactionBtn);

		JButton resetTransactionBtn = new JButton();
		resetTransactionBtn.setText("Reset");
		resetTransactionBtn.setBounds(95, 510, 75, 25);
		rightPanel.add(resetTransactionBtn);

		JButton holdTransactionBtn = new JButton();
		holdTransactionBtn.setText("Tunda");
		holdTransactionBtn.setBounds(180, 510, 75, 25);
		rightPanel.add(holdTransactionBtn);

		JButton payTransactionBtn = new JButton();
		payTransactionBtn.setText("Bayar");
		payTransactionBtn.setBounds(265, 510, 75, 25);
		rightPanel.add(payTransactionBtn);

		panel.setLayout(null);
		panel.setSize(950,605);
		getContentPane().add(panel, null);

		initTransaction();
		
		totalGrossPayField.setText("0");
		totalDiscountField.setText("0");
		remainingPaymentField.setText("0");
	}

	private void initTransaction() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		transactionIdField.setText("S0000001");
		transactionDateField.setText(sdf.format(new Date()));

		productTransactionDetailMap = new HashMap<String, ProductTransactionDetail>();
	}

	protected void transferMode() {
		if(transferChkBox.isSelected()) {
			dpTransferField.setEditable(true);
			dpTransferField.setEnabled(true);
		} else {
			dpTransferField.setEditable(false);
			dpTransferField.setEnabled(false);
		}
	}

	protected void instanceMode() {
		if(instanceChkBox.isSelected()) {
			legalitationNumberField.setEditable(true);
			legalitationNumberField.setEnabled(true);
			instanceDpField.setEditable(true);
			instanceDpField.setEnabled(true);
		} else {
			legalitationNumberField.setEditable(false);
			legalitationNumberField.setEnabled(false);
			instanceDpField.setEditable(false);
			instanceDpField.setEnabled(false);
		}
	}

	protected void inputProduct(String barcode, String qty) {
		Map<String, Product> productMap = getProductTransactionController().getProductMap();

		Product product = productMap.get(barcode);

		if (!productTransactionDetailMap.containsKey(product.getBarcode())){

			ProductTransactionDetail productTransactionDetail = new ProductTransactionDetail();
			productTransactionDetail.setId(0);
			productTransactionDetail.setIdProductTransaction("X");
			productTransactionDetail.setIdProduct(product.getId());
			productTransactionDetail.setProductName(product.getName());
			productTransactionDetail.setQty(qty==null ? 1 : Integer.parseInt(qty));
			productTransactionDetail.setPrice(product.getPrice());
			productTransactionDetail.setAmount(new BigDecimal(productTransactionDetail.getQty()).multiply(product.getPrice()));

			productTransactionDetailMap.put(product.getBarcode(), productTransactionDetail);
		} else {
			
			productTransactionDetailMap.get(product.getBarcode()).setQty(productTransactionDetailMap.get(product.getBarcode()).getQty() + (qty==null? 1 : Integer.parseInt(qty)));
			productTransactionDetailMap.get(product.getBarcode()).setAmount(new BigDecimal(productTransactionDetailMap.get(product.getBarcode()).getQty()).multiply(product.getPrice()));
			
		}

		clearTableData();
		
		for (ProductTransactionDetail transactionDetail : productTransactionDetailMap.values()) {
			
			Vector vector = new Vector<>();
			vector.add(transactionDetail.getProductName());
			vector.add(transactionDetail.getQty());
			vector.add(transactionDetail.getPrice().intValue());
			vector.add(transactionDetail.getAmount().intValue());
			
			((DefaultTableModel) productTransactionTbl.getModel()).addRow(vector);
		}
		
		updatePayment(productTransactionDetailMap.values());
	}

	private void updatePayment(Collection<ProductTransactionDetail> collection) {
		BigDecimal totalGrossPayment = BigDecimal.ZERO;
		for (ProductTransactionDetail productTransactionDetail : collection) {
			totalGrossPayment = totalGrossPayment.add(productTransactionDetail.getAmount());
		}
		System.out.println(totalGrossPayment.intValueExact());
		totalGrossPayField.setText(""+totalGrossPayment.intValueExact());
		
		/*BigDecimal totalDiscount = BigDecimal.ZERO;
		
		totalDiscountField.setText(totalDiscount.toPlainString());
		
		System.out.println(cashDpField.getText());
		System.out.println(nonCashDpField.getText());
		
		BigDecimal cash = cashDpField.getText() == null ? BigDecimal.ZERO : new BigDecimal(cashDpField.getText());
		BigDecimal nonCash = nonCashDpField.getText() == null ? BigDecimal.ZERO : new BigDecimal(nonCashDpField.getText());
		
		BigDecimal remaining = totalGrossPayment.subtract(totalDiscount).subtract(cash).subtract(nonCash);
		
		remainingPaymentField.setText(remaining.toPlainString());*/
	}

	private void clearTableData() {
		int row = ((DefaultTableModel) productTransactionTbl.getModel()).getRowCount();
		System.out.println("row : "+row);
		
		if (row > 0) {
			for (int i = row - 1; i > -1; i--) {
				System.out.println("row ke"+i);
				((DefaultTableModel) productTransactionTbl.getModel()).removeRow(i);
			}
		}
	}

	protected void nonCashMode() {
		if(nonCashCmbBox.getSelectedIndex()!=0) {
			cardNumberField.setEnabled(true);
			cardNumberField.setEditable(true);
			traceNumberField.setEnabled(true);
			traceNumberField.setEditable(true);
			nonCashDpField.setEnabled(true);
			nonCashDpField.setEditable(true);
		} else {
			cardNumberField.setEnabled(false);
			cardNumberField.setEditable(false);
			traceNumberField.setEnabled(false);
			traceNumberField.setEditable(false);
			nonCashDpField.setEnabled(false);
			nonCashDpField.setEditable(false);
		}
	}

	private void cashMode() {
		if(cashChkBox.isSelected()) {
			cashDpField.setEnabled(true);
			cashDpField.setEditable(true);
		} else {
			cashDpField.setEnabled(false);
			cashDpField.setEditable(false);
		}
	}
}
