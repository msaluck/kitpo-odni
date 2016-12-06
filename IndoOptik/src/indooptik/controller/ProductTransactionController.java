package indooptik.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import indooptik.dao.DAOFactory;
import indooptik.dao.ProductDAO;
import indooptik.dao.ProductTransactionDAO;
import indooptik.dao.ProductTransactionDetailDAO;
import indooptik.internalframe.ProductTransactionInternalFrame;
import indooptik.model.Product;
import indooptik.model.ProductTransaction;
import indooptik.model.ProductTransactionDetail;

public class ProductTransactionController {

	ProductTransactionInternalFrame productTransactionInternalFrame;
	ProductTransactionDAO productTransactionDAO;
	ProductTransactionDetailDAO productTransactionDetailDAO;
	ProductDAO productDAO;
	Map<String, Product> productMap = new HashMap<String, Product>();
	
	public ProductTransactionController(ProductTransactionInternalFrame productTransactionInternalFrame) {
		this.productTransactionInternalFrame = productTransactionInternalFrame;
		this.productTransactionDAO = DAOFactory.create().getProductTransactionDAO();
		this.productTransactionDetailDAO = DAOFactory.create().getProductTransactionDetailDAO();
		this.productDAO = DAOFactory.create().getProductDAO();
		System.out.println("JALAN NGGA SIH");
		setProductMap(poolingProduct()); 
	}
	
	private Map<String, Product> poolingProduct(){
		Map<String, Product> resultMap = new HashMap<String, Product>();
		
		List<Product> products = productDAO.retreiveALL();
		System.out.println(products.size());
		
		for (Product product : products) {
			System.out.println(product);
			resultMap.put(product.getBarcode(), product);
		}
		System.out.println(resultMap);
		
		return resultMap;	
	}
	
	public void saveProductTransaction(ProductTransaction productTransaction){
		productTransactionDAO.insert(productTransaction);
	}
	
	public void saveProductTransactionDetail(List<ProductTransactionDetail> transactionDetails) {
		for (ProductTransactionDetail productTransactionDetail : transactionDetails) {
			productTransactionDetailDAO.insert(productTransactionDetail);
		}
	}

	public Map<String, Product> getProductMap() {
		return productMap;
	}

	public void setProductMap(Map<String, Product> productMap) {
		this.productMap = productMap;
	}
}
