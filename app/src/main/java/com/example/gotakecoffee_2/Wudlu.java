package com.example.gotakecoffee_2;

import android.os.Parcel;
import android.os.Parcelable;

public class Wudlu implements Parcelable {
    protected Wudlu(Parcel in) {
    }

    public static final Creator<Wudlu> CREATOR = new Creator<Wudlu>() {
        @Override
        public Wudlu createFromParcel(Parcel in) {
            return new Wudlu(in);
        }

        @Override
        public Wudlu[] newArray(int size) {
            return new Wudlu[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
