package com.example.rsaconnect;

import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName = "service_provider")
public class ServiceProvider{
    @PrimaryKey(autoGenerate = true)
    public int mId;
    public String mName, address;
    public String description;
    public String imageUrl;
    public int rate;

    public ServiceProvider(String mName, String description, String imageUrl, String address,int rate) {
        this.mName = mName;
        this.description = description;
        this.address = address;
        this.imageUrl = imageUrl;
        this.rate = rate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
@Ignore
    @Override
    public String toString() {
        return "ServiceProvider{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", rate=" + rate +
                '}';
    }
}
