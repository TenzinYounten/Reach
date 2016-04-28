package com.app.reach.reach.CompanyProducts

import com.app.reach.model.ProductListDB.ProductDB
import io.realm.RealmList
/**
 * Created by tenzin on 24/3/16.
 */
public class SuccessfulGetProductsEvent {
   RealmList<ProductDB> productList

   SuccessfulGetProductsEvent(RealmList<ProductDB> productList) {
      this.productList = productList
   }

   RealmList<ProductDB> getProductList() {
      return productList
   }

   void setProductList(RealmList<ProductDB> productList) {
      this.productList = productList
   }
}
