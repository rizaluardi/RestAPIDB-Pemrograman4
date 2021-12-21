package com.appsmor.restapirizaluardi.model;

import com.google.gson.annotations.SerializedName;

public class Instansi {
    @SerializedName("id")
    private String id;
    @SerializedName("instansi")
    private String instansi;
    @SerializedName("telepon")
    private String telepon;

    public Instansi(String id, String instansi, String telepon) {
        this.id = id;
        this.instansi = instansi;
        this.telepon = telepon;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getInstansi() {
        return instansi;
    }
    public void setInstansi(String instansi) {
        this.instansi = instansi;
    }
    public String getTelepon() {
        return telepon;
    }
    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
}

