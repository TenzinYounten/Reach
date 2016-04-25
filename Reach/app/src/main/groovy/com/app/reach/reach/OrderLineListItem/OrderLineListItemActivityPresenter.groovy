package com.app.reach.reach.OrderLineListItem
import android.content.Context
import android.view.MenuItem
import com.app.reach.model.Order.OrderLine
import com.app.reach.model.OrderlineListItem
import com.app.reach.reach.R
/**
 * Created by tenzin on 13/4/16.
 */
public class OrderLineListItemActivityPresenter {
    private OrderLineListItemActivityView view;
    private OrderLineListItemActivityService service

    OrderLineListItemActivityPresenter(OrderLineListItemActivityView view, OrderLineListItemActivityService service) {
        this.view = view
        this.service = service
    }

    public void onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_companies) {

        } else if (id == R.id.nav_category) {

        } else if (id == R.id.nav_aboutus) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }


    }

    public onOptionItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
    }

    /*OrderlineListItem getOrderLineListItem(Bundle b) {
       OrderlineListItem orderlineListItems = service.getOrderLineListItem(b)
        return orderlineListItems
    }

    def onCreate(OrderLineList orderlineListItems) {
        view.listItems(orderlineListItems)
    }

    def listItems() {
        view.listItems()
    }*/

    def listItems() {
        view.listItems()
    }

    def calculateTotal(ArrayList<Double> sellingPricewithTax, ArrayList<Integer> quantity) {
        double totalSum = service.calculateTotal(sellingPricewithTax,quantity)
        return totalSum
    }

    void onSubmitOrder(ArrayList<OrderLine> orderlineListItems,Context context,double totalSum) {
        service.onSubmitOrder(orderlineListItems, context, totalSum)
    }

    ArrayList<OrderlineListItem> getQuantifiedOrders(ArrayList<OrderlineListItem> orderlineListItems) {
        ArrayList<OrderlineListItem> order = service.getQuantifiedOrders(orderlineListItems)
        return order
    }
}
