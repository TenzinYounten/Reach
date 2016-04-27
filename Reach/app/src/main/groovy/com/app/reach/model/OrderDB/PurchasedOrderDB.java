package com.app.reach.model.OrderDB;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by tenzin on 11/4/16.
 */
@RealmClass
public class PurchasedOrderDB extends RealmObject {

    String orderDate;
    double total;
    Long id;


    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {

        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

