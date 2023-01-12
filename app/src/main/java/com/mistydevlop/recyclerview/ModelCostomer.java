package com.mistydevlop.recyclerview;

public class ModelCostomer {
    String name,number;
    int img;

    public ModelCostomer(String name, String number, int img) {
        this.name = name;
        this.number = number;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getImg() {
        return img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
