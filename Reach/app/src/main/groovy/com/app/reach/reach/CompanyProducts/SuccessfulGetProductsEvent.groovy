package com.app.reach.reach.CompanyProducts

import com.app.reach.model.OrderlineListItem
/**
 * Created by tenzin on 24/3/16.
 */
public class SuccessfulGetProductsEvent {
   List<OrderlineListItem> productList

   SuccessfulGetProductsEvent(List<OrderlineListItem> productList) {
      this.productList = productList
   }

   List<OrderlineListItem> getProductList() {
      return productList
   }

   void setProductList(List<OrderlineListItem> productList) {
      this.productList = productList
   }
}
