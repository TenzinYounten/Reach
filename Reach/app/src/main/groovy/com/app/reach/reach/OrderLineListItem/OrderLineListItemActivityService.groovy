package com.app.reach.reach.OrderLineListItem
import android.content.Context
import android.util.Log
import com.app.reach.model.Order.OrderLine
import com.app.reach.model.Order.PurchasedOrderLineDB
import com.app.reach.model.OrderlineListItem
import io.realm.Realm
import io.realm.RealmList

import java.util.concurrent.atomic.AtomicInteger
/**
 * Created by tenzin on 13/4/16.
 */
public class OrderLineListItemActivityService {

    private Realm realm;

    private static AtomicInteger count = new AtomicInteger(0);
    int nextInt
   /* static OrderlineListItem getOrderLineListItem(Bundle bundle) {
        ArrayList<OrderlineListItem> orderlineListItems = bundle.getParcelableArrayList("OrderLine")
        Log.d("Service Ordeline",""+orderlineListItems.name)
        Log.d("ServiceOrdeline",""+orderlineListItems.companyId)
        return orderlineListItems
    }*/

    def calculateTotal(ArrayList<Double> sellingPriceWithTax, ArrayList<Integer> quantity) {
        Log.d("price",""+sellingPriceWithTax.dump())
        Log.d("price",""+quantity.dump())
        ArrayList<Double> total = []
        sellingPriceWithTax.eachWithIndex {def value, index-> total <<  value * quantity[index]}
        double totalSum = total.sum() as double
        Log.d("sum",""+totalSum)
        return totalSum

    }

    void onSubmitOrder(ArrayList<OrderLine> orderlineListItems,Context context, double totalSum) {

        Date currentDate = Calendar.getInstance().getTime();
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String formattedCurrentDate = simpleDateFormat.format(currentDate);
        Log.d("date", "" + formattedCurrentDate)
        Log.d("orderline", "" + orderlineListItems.id)


        realm = Realm.getDefaultInstance();

        /* realm.beginTransaction()

        PurchasedOrderDB listItemDB = realm.createObject(PurchasedOrderDB.class)
        int nextID = 1

        listItemDB.setId(nextID)
        listItemDB.setOrderDate(formattedCurrentDate)
        listItemDB.setTotal(totalSum)

        realm.commitTransaction()

        listItemDB = realm.where(PurchasedOrderDB.class).findFirst()
        Log.d("Realm",""+listItemDB.total)
         Long id;
    String productCode;
    String name;
    String companyId;
    String productDescription;
    Double mrpPrice;
    Double sellingPriceWithoutTax;
    Double sellingPriceWithTax;
    Integer quantity;
*/
        RealmList<OrderLine> orders = new RealmList<OrderLine>()
        Log.d("Realmlist", "" + orders.class)

        Long orderId = 1
        realm.beginTransaction()
        PurchasedOrderLineDB orderLineitem = realm.createObject(PurchasedOrderLineDB.class)
        orderlineListItems.each {
            Log.d("null", "" + it.id)
            OrderLine orderLine = realm.createObject(OrderLine.class)
            orderLine.id = it.id
            orderLine.productCode = it.productCode
            orderLine.name = it.name
            orderLine.companyId = it.companyId
            orderLine.productDescription = it.productDescription
            orderLine.mrpPrice = it.mrpPrice
            orderLine.sellingPriceWithoutTax = it.sellingPriceWithoutTax
            orderLine.sellingPriceWithTax = it.sellingPriceWithTax
            orderLine.quantity = it.quantity
            orders << orderLine
            Log.d("dborderline", "" + orders.dump())

            /* Log.d("id",""+it.id)
            Log.d("id",""+it.productCode)
            Log.d("id",""+it.name)
            Log.d("id",""+it.companyId)*/
        }
        orderLineitem.setOrderNumber(orderId)
        orderLineitem.setOrderLine(orders)
        realm.commitTransaction()

        orderLineitem = realm.where(PurchasedOrderLineDB.class).findFirst()
        Log.d("Realm orderlinelis", "" + orderLineitem.orderLine.name)

        realm.close()

    }
    ArrayList<OrderlineListItem> getQuantifiedOrders(ArrayList<OrderlineListItem> orderlineListItems) {
        ArrayList<OrderlineListItem> orderline = orderlineListItems.findAll{ it.quantity > 0 }
        return orderline
        /* List<DataPoint> myList = new ArrayList<DataPoint>();
 //Fill up myList with your Data Points

         List<DataPoint> dataPointsCalledJohn =
                 myList
                         .stream()
                         .filter((p)-> p.getName().equals(("john")))
                         .collect(Collectors.toList());*/
    }
   /* }
    public RealmList<OrderLine> toRealmList(ArrayList<String> arrayList){
        mRealmList = new RealmList<OrderLine>();
        for (int i = 0; i < arrayList.size(); i++){
            OrderLine orderLine = new OrderLine();
            incidentPhoto.setPhotoPath(arrayList.get(i));
            mRealmList.add(incidentPhoto);
        }
        return mRealmList;*/
    }



