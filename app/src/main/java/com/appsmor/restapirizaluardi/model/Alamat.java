package com.appsmor.restapirizaluardi.model;

import com.google.gson.annotations.SerializedName;

public class Alamat {
    @SerializedName("id")
    private String id;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("kodepos")
    private String kodepos;

    public Alamat(String id, String alamat, String kodepos) {
        this.id = id;
        this.alamat = alamat;
        this.kodepos = kodepos;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getKodepos() {
        return kodepos;
    }
    public void setKodepos(String kodepos) {
        this.kodepos = kodepos;
    }
}

