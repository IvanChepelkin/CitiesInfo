package com.example.user.citiesinfo;

public class CitiesData {
    private int img;
    private int txtId;

    public CitiesData (int img, int txt) {
        this.img = img;
        this.txtId = txt;
    }

    public int getImg() {
        return img;
    }

    public int getTxt() {
        return txtId;
    }
}
