package com.app.reach.model
import android.os.Parcel
import android.os.Parcelable

/**
 * Created by tenzin on 17/3/16.
 */
public class OrderlineListItem implements Parcelable {
    Long id
    String productCode
    String name
    String companyId
    String productDescription
    Double mrpPrice
    Double sellingPriceWithoutTax
    Double sellingPriceWithTax
    Integer quantity

    Integer getQuantity() {
        return quantity
    }

    void setQuantity(Integer quantity) {
        this.quantity = quantity
    }

    Double getMrpPrice() {
        return mrpPrice
    }

    void setMrpPrice(Double productMrp) {
        this.mrpPrice = productMrp
    }

    Double getSellingPriceWithoutTax() {
        return sellingPriceWithoutTax
    }

    void setSellingPriceWithoutTax(Double sellingPriceWithoutTax) {
        this.sellingPriceWithoutTax = sellingPriceWithoutTax
    }

    double getSellingPriceWithTax() {
        return sellingPriceWithTax
    }

    void setSellingPriceWithTax(Double sellingPriceWithTax) {
        this.sellingPriceWithTax = sellingPriceWithTax
    }


    void setId(Long id) {
        this.id = id
    }

    void setProductCode(String productCode) {
        this.productCode = productCode
    }

    void setName(String productName) {
        this.name = productName
    }

    void setProductDescription(String productDescription) {
        this.productDescription = productDescription
    }

    Long getId() {

        return id
    }

    String getProductCode() {
        return productCode
    }

    String getName() {
        return name
    }

    String getProductDescription() {
        return productDescription
    }

    String getCompanyId() {
        return companyId
    }

    void setCompanyId(String companyId) {
        this.companyId = companyId
    }


    OrderlineListItem(String productDescription, String companyId, String name, String productCode, Long id, Double mrpPrice, Double sellingPriceWithoutTax, Double sellingPriceWithTax, Integer quantity) {
        this.mrpPrice = mrpPrice
        this.sellingPriceWithoutTax = sellingPriceWithoutTax
        this.sellingPriceWithTax = sellingPriceWithTax
        this.productDescription = productDescription
        this.companyId = companyId
        this.name = name
        this.productCode = productCode
        this.id = id
        this.quantity = quantity
    }

    public OrderlineListItem(Parcel source) {
        this.id = source.readLong()
        this.productCode = source.readString()
        this.name = source.readString()
        this.productDescription = source.readString()
        this.mrpPrice = source.readDouble()
        this.sellingPriceWithoutTax = source.readDouble()
        this.sellingPriceWithTax = source.readDouble()
        this.quantity = source.readInt()
        this.companyId = source.readString()
       /* this.company = *//*(Company)source.readParcelable(Company.class.getClassLoader())*/
       /* this.companyId = source.readString()*/
    }


    @Override
    int describeContents() {
        return this.hashCode()
    }

    @Override
    void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id)
        dest.writeString(productCode)
        dest.writeString(name)
        dest.writeString(productDescription)
        dest.writeDouble(mrpPrice)
        dest.writeDouble(sellingPriceWithoutTax)
        dest.writeDouble(sellingPriceWithTax)
        dest.writeInt(quantity)
        dest.writeString(companyId)
        /*dest.writeParcelable(company);*/
        /*dest.writeString(companyId)*/
    }


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        OrderlineListItem createFromParcel(Parcel source) {
            return new OrderlineListItem(source)
        }

        @Override
        Object[] newArray(int size) {
            return new OrderlineListItem[size]
        }
    };
}



