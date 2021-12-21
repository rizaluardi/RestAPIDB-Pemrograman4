package com.appsmor.restapirizaluardi.model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelAlamat {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Alamat mAlamat;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Alamat getmAlamat() {
        return mAlamat;
    }
    public void setmAlamat(Alamat Alamat) {
        mAlamat = Alamat;
    }
}
