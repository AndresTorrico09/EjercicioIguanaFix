package com.andresleonel09.ejercicioiguanafix.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andres-PC on 2019-01-13.
 */

public class Contacto implements Parcelable {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("birth_date")
    @Expose
    private String birthDate;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("phones")
    @Expose
    private List<Phone> phones = new ArrayList<>();
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("addresses")
    @Expose
    private List<Address> addresses = new ArrayList<>();
    public final static Parcelable.Creator<Contacto> CREATOR = new Creator<Contacto>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Contacto createFromParcel(Parcel in) {
            return new Contacto(in);
        }

        public Contacto[] newArray(int size) {
            return (new Contacto[size]);
        }

    }
            ;

    protected Contacto(Parcel in) {
        this.userId = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.birthDate = ((String) in.readValue((String.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.phones, (Phone.class.getClassLoader()));
        this.thumb = ((String) in.readValue((String.class.getClassLoader())));
        this.photo = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.addresses, (Address.class.getClassLoader()));
    }

    public Contacto() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userId);
        dest.writeValue(createdAt);
        dest.writeValue(birthDate);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeList(phones);
        dest.writeValue(thumb);
        dest.writeValue(photo);
        dest.writeList(addresses);
    }

    public int describeContents() {
        return 0;
    }

}