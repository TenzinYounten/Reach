package com.app.reach.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by tenzin on 17/3/16.
 */
public class Company /*extends RealmObject*/ implements Parcelable {
    Long id
    String companyCode
    String companyName
    Boolean active


    Company(Long id, String companyCode, String companyName, Boolean active) {
        this.id = id
        this.companyCode = companyCode
        this.companyName = companyName
        this.active = active
    }

    void setId(Long id) {
        this.id = id
    }

    void setCompanyCode(String companyCode) {
        this.companyCode = companyCode
    }

    void setCompanyName(String companyName) {
        this.companyName = companyName
    }

    Long getId() {
        return id
    }

    Boolean getActive() {
        return active
    }

    void setActive(Boolean active) {
        this.active = active
    }

    String getCompanyCode() {
        return companyCode
    }

    String getCompanyName() {
        return companyName
    }
    public Company(Parcel source) {
        this.id = source.readLong()
        this.companyCode = source.readString()
        this.companyName = source.readString()
        this.active = source.readByte((byte) (active ? 1 : 0))
    }

    @Override
    int describeContents() {
        return 0
    }

    @Override
    void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id)
        dest.writeString(companyCode)
        dest.writeString(companyName)
        dest.writeByte((byte) (active ? 1 : 0));
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        Company createFromParcel(Parcel source) {
            return new Company(source)
        }

        @Override
        Object[] newArray(int size) {
            return new Company[size]
        }
    };

}
