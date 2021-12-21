package com.appsmor.restapirizaluardi.model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelInstansi {
    @SerializedName("status")
    String statusinstansi;
    @SerializedName("result")
    Instansi mInstansi;
    @SerializedName("message")
    String messageinstansi;
    public String getStatusInstansi() {
        return statusinstansi;
    }
    public void setStatusInstansi(String statusinstansi) {
        this.statusinstansi = statusinstansi;
    }
    public String getMessageInstansi() {
        return messageinstansi;
    }
    public void setMessageInstansi(String messageinstansi) {
        this.messageinstansi = messageinstansi;
    }
    public Instansi getInstansi() {
        return mInstansi;
    }
    public void setInstansi(Instansi Instansi) {
        mInstansi = Instansi;
    }
}
