package com.appsmor.restapirizaluardi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetAlamat {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Alamat> listDataAlamat;
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
    public List<Alamat> getListDataAlamat() {
        return listDataAlamat;
    }
    public void setListDataAlamat(List<Alamat> listDataAlamat) {
        this.listDataAlamat = listDataAlamat;
    }
}