package com.example.administrator.listviewex04;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017-02-04.
 */

public class Chunja2 implements Parcelable{
    private int idx;
    private String h;
    private String k;
    private String word;
    private String desc;

    public Chunja2(){}

    protected Chunja2(Parcel in) {
        idx = in.readInt();
        h = in.readString();
        k = in.readString();
        word = in.readString();
        desc = in.readString();
    }

    public static final Creator<Chunja2> CREATOR = new Creator<Chunja2>() {
        @Override
        public Chunja2 createFromParcel(Parcel in) {
            return new Chunja2(in);
        }

        @Override
        public Chunja2[] newArray(int size) {
            return new Chunja2[size];
        }
    };

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idx);
        dest.writeString(h);
        dest.writeString(k);
        dest.writeString(word);
        dest.writeString(desc);
    }
}
