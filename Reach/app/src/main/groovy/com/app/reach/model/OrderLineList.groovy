package com.app.reach.model
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
/**
 * Created by tenzin on 12/4/16.
 */
public class OrderLineList implements Parcelable {
    ArrayList<OrderlineListItem> orderlineListItems;

    public ArrayList<OrderlineListItem> getOrderlineListItems() {
        return orderlineListItems;
    }

    public void setOrderlineListItems(ArrayList<OrderlineListItem> orderlineListItems) {
        this.orderlineListItems = orderlineListItems;
    }



    public OrderLineList(ArrayList<OrderlineListItem> orderlineListItems) {
        this.orderlineListItems = orderlineListItems;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle b = new Bundle();
        b.putParcelableArrayList("items", orderlineListItems )
        dest.writeBundle(b)
    }


    public static final Parcelable.Creator<OrderLineList> CREATOR = new Parcelable.Creator<OrderLineList>() {
        @Override
        public OrderLineList createFromParcel(Parcel source) {
            OrderLineList orderLineList = new OrderLineList()
            Bundle b = source.readBundle(OrderlineListItem.class.getClassLoader());
            orderLineList.orderlineListItems = b.getParcelableArrayList("items")
        }

        @Override
        public OrderLineList[] newArray(int size) {
            return new OrderLineList[size];
        }
    };
}
