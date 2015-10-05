package com.istic.jeremy.mmm_tp1;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jeremy on 30/09/15.
 */
public class Person implements Parcelable {

    private String firstName;
    private String lastName;
    private String birthDay;
    private String birthCity;

    public Person(String firstName, String lastName, String birthDay, String birthCity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.birthCity = birthCity;
    }

    public Person(Parcel in) {
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.birthDay = in.readString();
        this.birthCity = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.birthDay);
        dest.writeString(this.birthCity);
    }

    public static final Parcelable.Creator<Person> CREATOR
            = new Parcelable.Creator<Person>() {
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getBirthDay() {
        return this.birthDay;
    }

    public String getBirthCity() {
        return this.birthCity;
    }
}
