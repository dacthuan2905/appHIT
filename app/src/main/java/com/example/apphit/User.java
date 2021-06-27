package com.example.apphit;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private Integer Id;
    private String Name;
    private Integer StudentCode;
    private String Permission;
    private Integer PhoneNumber;
    private String Email;
    private String PassWord;

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public User(String passWord) {
        PassWord = passWord;
    }

    public User(Integer id, String name, Integer studentCode, String permission, Integer phoneNumber, String email) {
        Id = id;
        Name = name;
        StudentCode = studentCode;
        Permission = permission;
        PhoneNumber = phoneNumber;
        Email = email;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getStudentCode() {
        return StudentCode;
    }

    public void setStudentCode(Integer studentCode) {
        StudentCode = studentCode;
    }

    public String getPermission() {
        return Permission;
    }

    public void setPermission(String permission) {
        Permission = permission;
    }

    public Integer getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public static Creator<User> getCREATOR() {
        return CREATOR;
    }

    protected User(Parcel in) {
        if (in.readByte() == 0){
            Id=null;
        }else {
            Id=in.readInt();
        }
        Name=in.readString();
        if (in.readByte()==0){
            StudentCode=null;
        }else{
            StudentCode=in.readInt();
        }
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", StudentCode=" + StudentCode +
                ", Permission='" + Permission + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                ", Email='" + Email + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (Id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(Id);
        }
        dest.writeString(Name);
        dest.writeString(Email);
        dest.writeString(Permission);
        dest.writeString(PassWord);
        if (StudentCode == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(StudentCode);
        }
        if (PhoneNumber == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(PhoneNumber);
        }
    }
}
