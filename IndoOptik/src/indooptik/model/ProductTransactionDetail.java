/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indooptik.model;

import java.math.BigDecimal;

/**
 *
 * @author Yoeda H
 */
public class ProductTransactionDetail {
    private int id;
    private String idProductTransaction;
    private int idProduct;
    private String productName;
    private int qty;
    private BigDecimal price = BigDecimal.ZERO;
    private BigDecimal amount = BigDecimal.ZERO;
    private BigDecimal discount = BigDecimal.ZERO;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idProductTransaction
     */
    public String getIdProductTransaction() {
        return idProductTransaction;
    }

    /**
     * @param idProductTransaction the idProductTransaction to set
     */
    public void setIdProductTransaction(String idProductTransaction) {
        this.idProductTransaction = idProductTransaction;
    }

    /**
     * @return the idProduct
     */
    public int getIdProduct() {
        return idProduct;
    }

    /**
     * @param idProduct the idProduct to set
     */
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return the discount
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

	@Override
	public String toString() {
		return "ProductTransactionDetail [id=" + id + ", idProductTransaction=" + idProductTransaction + ", idProduct="
				+ idProduct + ", productName=" + productName + ", qty=" + qty + ", price=" + price + ", amount="
				+ amount + ", discount=" + discount + "]";
	}
}
