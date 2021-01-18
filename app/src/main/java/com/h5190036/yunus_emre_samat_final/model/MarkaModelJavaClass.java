package com.h5190036.yunus_emre_samat_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarkaModelJavaClass {

    @SerializedName("KucukLogoUrl")
    @Expose
    private String kucukLogoUrl;

    @SerializedName("BuyukResimUrl")
    @Expose
    private String buyukResimUrl;

    @SerializedName("MarkaAdi")
    @Expose
    private String markaAdi;

    @SerializedName("KurulusTarihi")
    @Expose
    private String kurulusTarihi;

    @SerializedName("Degeri")
    @Expose
    private String degeri;

    @SerializedName("Hakkinda")
    @Expose
    private String hakkinda;

    public String getKucukLogoUrl() {
        return kucukLogoUrl;
    }

    public void setKucukLogoUrl(String kucukLogoUrl) {
        this.kucukLogoUrl = kucukLogoUrl;
    }

    public String getBuyukResimUrl() {
        return buyukResimUrl;
    }

    public void setBuyukResimUrl(String buyukResimUrl) {
        this.buyukResimUrl = buyukResimUrl;
    }

    public String getMarkaAdi() {
        return markaAdi;
    }

    public void setMarkaAdi(String markaAdi) {
        this.markaAdi = markaAdi;
    }

    public String getKurulusTarihi() {
        return kurulusTarihi;
    }

    public void setKurulusTarihi(String kurulusTarihi) {
        this.kurulusTarihi = kurulusTarihi;
    }

    public String getDegeri() {
        return degeri;
    }

    public void setDegeri(String degeri) {
        this.degeri = degeri;
    }

    public String getHakkinda() {
        return hakkinda;
    }

    public void setHakkinda(String hakkinda) {
        this.hakkinda = hakkinda;
    }

}