package com.andresleonel09.ejercicioiguanafix.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andres-PC on 2019-01-14.
 */

public class Phone implements Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("number")
    @Expose
    private Object number;
    public final static Parcelable.Creator<Phone> CREATOR = new Creator<Phone>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Phone createFromParcel(Parcel in) {
            return new Phone(in);
        }

        public Phone[] newArray(int size) {
            return (new Phone[size]);
        }

    }
            ;

    protected Phone(Parcel in) {
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.number = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Phone() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getNumber() {
        return number;
    }

    public void setNumber(Object number) {
        this.number = number;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(number);
    }

    public int describeContents() {
        return 0;
    }

}
