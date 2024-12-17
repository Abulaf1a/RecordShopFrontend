package com.northcoders.recordshopfrontend.model;


import androidx.databinding.Bindable;

public class Stock {

    long id;

    int quantity;

    public Stock(long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Stock() {
    }

    @Bindable
    public long getId() {
        return id;
    }

    @Bindable
    public int getQuantity() {
        return quantity;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
