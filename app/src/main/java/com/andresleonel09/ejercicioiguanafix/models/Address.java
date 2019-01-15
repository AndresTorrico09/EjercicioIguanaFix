package com.andresleonel09.ejercicioiguanafix.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andres-PC on 2019-01-14.
 */


public class Address implements Parcelable
{

    @SerializedName("work")
    @Expose
    private String work;
    public final static Parcelable.Creator<Address> CREATOR = new Creator<Address>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        public Address[] newArray(int size) {
            return (new Address[size]);
        }

    }
            ;

    protected Address(Parcel in) {
        this.work = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Address() {
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(work);
    }

    public int describeContents() {
        return 0;
    }

}