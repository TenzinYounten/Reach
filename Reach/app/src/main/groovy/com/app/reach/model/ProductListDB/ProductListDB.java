package com.app.reach.model.ProductListDB;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by tenzin on 25/4/16.
 */
@RealmClass
public class ProductListDB extends RealmObject {
    String date;
    RealmList<ProductDB> productListDB;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public RealmList<ProductDB> getProductListDB() {
        return productListDB;
    }

    public void setProductListDB(RealmList<ProductDB> productListDB) {
        this.productListDB = productListDB;
    }
}
