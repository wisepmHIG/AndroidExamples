package com.example.administrator.gridviewex;

import android.content.Context;
import android.content.res.Resources;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Administrator on 2017-02-05.
 */

public class ReadHanja {

    public static ArrayList<Hanja> read(Context context){
        ArrayList<Hanja> list = new ArrayList<>(6300);
        // 리소스 디렉토리의 파일 읽기
        Resources resources = context.getResources();
        InputStream is = resources.openRawResource(R.raw.word);
        Scanner sc = new Scanner(is,"UTF-8");
        while(sc.hasNext()){
            StringTokenizer st = new StringTokenizer(sc.nextLine(),",");
            Hanja hanja = new Hanja();
            hanja.setIdx(Integer.parseInt(st.nextToken()));
            hanja.setHanja(st.nextToken());
            hanja.setB(st.nextToken());
            hanja.setCount(Integer.parseInt(st.nextToken()));
            hanja.setHangul(st.nextToken());
            list.add(hanja);
        }
        return list;
    }
}
