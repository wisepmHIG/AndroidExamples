package com.example.administrator.spinnerex02;

/**
 * Created by Administrator on 2017-02-05.
 */

public class Flag{
    private int imageID;
    private String flagName;

    public Flag() {
    }

    public Flag(int imageID, String flagName) {
        this.imageID = imageID;
        this.flagName = flagName;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }
}
