package com.app.reach.model.OrderDB;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by tenzin on 15/4/16.
 */
@RealmClass
public class PurchasedOrderLineDB extends RealmObject {
    Long OrderNumber;
    RealmList<OrderLine> orderLine;


    public RealmList<OrderLine> getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(RealmList<OrderLine> orderLine) {
        this.orderLine = orderLine;
    }


  /*  public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine ) {
        this.orderLine = orderLine;
    }*/

    public  Long getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        OrderNumber = orderNumber;
    }
}