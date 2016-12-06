package indooptik.controller;

import indooptik.dao.ProductTransactionDAO;
import indooptik.internalframe.ProductTransactionInternalFrame;

public class ProductTransactionController {

	ProductTransactionInternalFrame productTransactionInternalFrame;
	ProductTransactionDAO productTransactionDAO;
	
	public ProductTransactionController(ProductTransactionInternalFrame productTransactionInternalFrame) {
		this.productTransactionInternalFrame = productTransactionInternalFrame;
	}
}
