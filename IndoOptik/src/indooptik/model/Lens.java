/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indooptik.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Yoeda H
 */
public class Lens {
    private int IdLens;
    private String type;
    private String materialLens;    
    private String color;
    private BigDecimal price = new BigDecimal(0.0);
    private Date createdDate;
    private String sph;
    private String cyl;
    private String add;
    private String merk;
    private int stock;

    /**
     * @return the IdLens
     */
    public int getIdLens() {
        return IdLens;
    }

    /**
     * @param IdLens the IdLens to set
     */
    public void setIdLens(int IdLens) {
        this.IdLens = IdLens;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the lensVariance
     */
    public String getMaterialLens() {
        return materialLens;
    }

    /**
     * @param lensVariance the lensVariance to set
     */
    public void setMaterialLens(String lensVariance) {
        this.materialLens = lensVariance;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
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
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the sph
     */
    public String getSph() {
        return sph;
    }

    /**
     * @param sph the sph to set
     */
    public void setSph(String sph) {
        this.sph = sph;
    }

    /**
     * @return the cyl
     */
    public String getCyl() {
        return cyl;
    }

    /**
     * @param cyl the cyl to set
     */
    public void setCyl(String cyl) {
        this.cyl = cyl;
    }

    /**
     * @return the add
     */
    public String getAdd() {
        return add;
    }

    /**
     * @param add the add to set
     */
    public void setAdd(String add) {
        this.add = add;
    }

    /**
     * @return the merk
     */
    public String getMerk() {
        return merk;
    }

    /**
     * @param merk the merk to set
     */
    public void setMerk(String merk) {
        this.merk = merk;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
