package com.app.reach.reach.CompanyProducts
import com.app.reach.model.Product
/**
 * Created by tenzin on 24/3/16.
 */
public class SuccessfulGetProductsEvent {
   List<Product> productList

   SuccessfulGetProductsEvent(List<Product> productList) {
      this.productList = productList
   }

   List<Product> getProductList() {
      return productList
   }

   void setProductList(List<Product> productList) {
      this.productList = productList
   }
}
