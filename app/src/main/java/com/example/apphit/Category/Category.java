package com.example.apphit.Category;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.apphit.homepage.Image;

import java.util.List;

public class Category implements Parcelable {
    private String nameCategory;
    private List<Image>images;

    public Category(String nameCategory, List<Image> images) {
        this.nameCategory = nameCategory;
        this.images = images;
    }

    protected Category(Parcel in) {
        nameCategory = in.readString();
        images = in.createTypedArrayList(Image.CREATOR);
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameCategory);
        dest.writeTypedList(images);
    }
}
