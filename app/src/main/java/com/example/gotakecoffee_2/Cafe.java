package com.example.gotakecoffee_2;

import android.os.Parcel;
import android.os.Parcelable;

public class Cafe implements Parcelable {
    private String namaCafe;
    private String lokasiCafe;
    private String jamBuka;
    private String jamTutup;
    private int rating;
    private int seatTersedia;
    private int seatMax;
    private int fotoCafe;

    public Cafe(String namaCafe, String lokasiCafe, int rating, int seatTersedia, int seatMax, String jamBuka, String jamTutup, int fotoCafe){
        this.namaCafe = namaCafe;
        this.lokasiCafe = lokasiCafe;
        this.rating = rating;
        this.seatTersedia = seatTersedia;
        this.seatMax = seatMax;
        this.jamBuka = jamBuka;
        this.jamTutup = jamTutup;
        this.fotoCafe = fotoCafe;
    }

    public Cafe(Parcel in) {
        this.namaCafe = in.readString();
        this.lokasiCafe = in.readString();
        this.rating = in.readInt();
        this.seatTersedia = in.readInt();
        this.seatMax = in.readInt();
        this.jamBuka = in.readString();
        this.jamTutup = in.readString();
        this.fotoCafe = in.readInt();
    }

    private static final Creator<Cafe> CREATOR = new Creator<Cafe>() {
        @Override
        public Cafe createFromParcel(Parcel in) {
            return new Cafe(in);
        }

        @Override
        public Cafe[] newArray(int size) {
            return new Cafe[size];
        }
    };

    public static Creator<Cafe> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.namaCafe);
        dest.writeString(this.lokasiCafe);
        dest.writeInt(this.rating);
        dest.writeInt(this.seatTersedia);
        dest.writeInt(this.seatMax);
        dest.writeString(this.jamBuka);
        dest.writeString(this.jamTutup);
        dest.writeInt(this.fotoCafe);
    }

    public String getNamaCafe() {
        return namaCafe;
    }

    public void setNamaCafe(String namaCafe) {
        this.namaCafe = namaCafe;
    }

    public String getLokasiCafe() {
        return lokasiCafe;
    }

    public void setLokasiCafe(String lokasiCafe) {
        this.lokasiCafe = lokasiCafe;
    }

    public String getJamBuka() {
        return jamBuka;
    }

    public void setJamBuka(String jamBuka) {
        this.jamBuka = jamBuka;
    }

    public String getJamTutup() {
        return jamTutup;
    }

    public void setJamTutup(String jamTutup) {
        this.jamTutup = jamTutup;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getSeatTersedia() {
        return seatTersedia;
    }

    public void setSeatTersedia(int seatTersedia) {
        this.seatTersedia = seatTersedia;
    }

    public int getSeatMax() {
        return seatMax;
    }

    public void setSeatMax(int seatMax) {
        this.seatMax = seatMax;
    }

    public int getFotoCafe() {
        return fotoCafe;
    }

    public void setFotoCafe(int fotoCafe) {
        this.fotoCafe = fotoCafe;
    }
}
