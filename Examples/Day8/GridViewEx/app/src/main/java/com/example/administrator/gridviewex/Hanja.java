package com.example.administrator.gridviewex;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017-02-05.
 */

public class Hanja implements Parcelable {

    private int idx;
    private String hanja;
    private String b;
    private int count;
    private String hangul;

    public Hanja() {
    }

    protected Hanja(Parcel in) {
        idx = in.readInt();
        hanja = in.readString();
        b = in.readString();
        count = in.readInt();
        hangul = in.readString();
    }

    public static final Creator<Hanja> CREATOR = new Creator<Hanja>() {
        @Override
        public Hanja createFromParcel(Parcel in) {
            return new Hanja(in);
        }

        @Override
        public Hanja[] newArray(int size) {
            return new Hanja[size];
        }
    };

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getHanja() {
        return hanja;
    }

    public void setHanja(String hanja) {
        this.hanja = hanja;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getHangul() {
        return hangul;
    }

    public void setHangul(String hangul) {
        this.hangul = hangul;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idx);
        dest.writeString(hanja);
        dest.writeString(b);
        dest.writeInt(count);
        dest.writeString(hangul);
    }

    @Override
    public String toString() {
        return "Hanja{" +
                "idx=" + idx +
                ", hanja='" + hanja + '\'' +
                ", b='" + b + '\'' +
                ", count=" + count +
                ", hangul='" + hangul + '\'' +
                '}';
    }
}
