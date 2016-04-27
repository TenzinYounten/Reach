package com.app.reach.reach.CompanyProducts

import com.app.reach.model.ProductListDB.ProductDB
import io.realm.RealmList
/**
 * Created by tenzin on 24/3/16.
 */
public class SuccessfulGetProductsEvent {
   RealmList<ProductDB> productList

   SuccessfulGetProductsEvent(List<ProductDB> productList) {
      this.productList = productList
   }

   List<ProductDB> getProductList() {
      return productList
   }

   void setProductList(List<ProductDB> productList) {
      this.productList = productList
   }
}
