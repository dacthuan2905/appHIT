package com.example.apphit.homepage;

import android.os.Parcel;
import android.os.Parcelable;

public class Image implements Parcelable {
    private int resourceID;
    private String title;

    public Image(int resourceID, String title) {
        this.resourceID = resourceID;
        this.title = title;
    }

    protected Image(Parcel in) {
        if (in.readByte() == 0) {
            resourceID = Integer.parseInt(null);
        } else {
            resourceID = in.readInt();
        }
        title = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(resourceID);
        dest.writeString(title);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
