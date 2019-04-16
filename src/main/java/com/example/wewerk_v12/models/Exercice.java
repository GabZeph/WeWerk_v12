package com.example.wewerk_v12.models;

import android.media.Image;

import java.io.Serializable;

public class Exercice implements Serializable {

    private String movementName;
    private int repNumber;
    private int setNumber;
    private Image image;

    public Exercice(String movementName, int repNumber, int setNumber, Image image) {
        this.movementName = movementName;
        this.repNumber = repNumber;
        this.setNumber = setNumber;
        this.image = image;
    }

    public Exercice(String movementName, int repNumber, int setNumber) {
        this.movementName = movementName;
        this.repNumber = repNumber;
        this.setNumber = setNumber;
    }



    public String getMovementName() {
        return movementName;
    }

    public void setMovementName(String movementName) {
        this.movementName = movementName;
    }

    public int getRepNumber() {
        return repNumber;
    }

    public void setRepNumber(int repNumber) {
        this.repNumber = repNumber;
    }

    public int getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(int setNumber) {
        this.setNumber = setNumber;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


}
