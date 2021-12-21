package com.appsmor.restapirizaluardi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetInstansi {
    @SerializedName("status")
    String statusinstansi;
    @SerializedName("result")
    List<Instansi> listDataInstansi;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return statusinstansi;
    }
    public void setStatusInstansi(String statusinstansi) {
        this.statusinstansi = statusinstansi;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<Instansi> getListDataInstansi() {
        return listDataInstansi;
    }
    public void setListDataInstansi(List<Instansi> listDataInstansi) {
        this.listDataInstansi = listDataInstansi;
    }
}