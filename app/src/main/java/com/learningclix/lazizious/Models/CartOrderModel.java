package com.learningclix.lazizious.Models;

public class CartOrderModel {
    int soldProductNumber;
    String soldProductName, soldProductPrice;
    long orderImage;

    public CartOrderModel(int soldProductNumber, String soldProductName, long orderImage, String soldProductPrice) {
        this.orderImage = orderImage;
        this.soldProductName = soldProductName;
        this.soldProductPrice = soldProductPrice;
        this.soldProductNumber = soldProductNumber;
    }

    public long getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(long orderImage) {
        this.orderImage = orderImage;
    }

    public String getSoldProductName() {
        return soldProductName;
    }

    public void setSoldProductName(String soldProductName) {
        this.soldProductName = soldProductName;
    }

    public String getSoldProductPrice() {
        return soldProductPrice;
    }

    public void setSoldProductPrice(String soldProductPrice) {
        this.soldProductPrice = soldProductPrice;
    }

    public int getSoldProductNumber() {
        return soldProductNumber;
    }

    public void setSoldProductNumber(int soldProductNumber) {
        this.soldProductNumber = soldProductNumber;
    }
}
