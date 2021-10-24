package com.example.jam_azan2;

public class azantime {
    public static String Subuh;
    public static String Syuruk;
    public static String Zohor;
    public static String Asar;
    public static String Maghrib;
    public static String Isyak;

    //public String Subuh;
    //public String Syuruk;
    //public String Zohor;
    //public String Asar;
    //public String Maghrib;
    //public String Isyak;

    public azantime() {
    }

    public azantime(String subuh, String syuruk, String zohor, String asar, String maghrib, String isyak) {
        Subuh = subuh;
        Syuruk = syuruk;
        Zohor = zohor;
        Asar = asar;
        Maghrib = maghrib;
        Isyak = isyak;
    }

    public static String getSubuh() {
        return Subuh;
    }

    public void setSubuh(String subuh) {
        Subuh = subuh;
    }

    public static String getSyuruk() {
        return Syuruk;
    }

    public void setSyuruk(String syuruk) {
        Syuruk = syuruk;
    }

    public static String getZohor() {
        return Zohor;
    }

    public void setZohor(String zohor) {
        Zohor = zohor;
    }

    public static String getAsar() {
        return Asar;
    }

    public void setAsar(String asar) {
        Asar = asar;
    }

    public static String getMaghrib() {
        return Maghrib;
    }

    public void setMaghrib(String maghrib) {
        Maghrib = maghrib;
    }

    public static String getIsyak() {
        return Isyak;
    }

    public void setIsyak(String isyak) {
        Isyak = isyak;
    }
}
