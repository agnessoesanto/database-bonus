package com.example.lat24mei22;

public class DataModel {
    String nik;
    String nama;
    String password;

    public DataModel(String nik, String nama, String password) {
        this.nik = nik;
        this.nama = nama;
        this.password = password;
    }

    public String getnik(){
        return nik;

    }

    public void nik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
