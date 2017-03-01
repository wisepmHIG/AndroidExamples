package com.example.administrator.smsex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SMS 수신을 위한 브로드캐스트 수신자입니다.
 *
 * @author Mike
 */
public class MySMSBroadcastReceiver extends BroadcastReceiver {

    /**
     * 로깅을 위한 태그
     */
    public static final String TAG = "SMSBroadcastReceiver";
    /**
     * 시간 포맷을 위한 형식
     */
    public SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive() 메소드 호출됨.");

        // SMS 수신 시의 메시지인지 다시 한번 확인합니다.
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            Log.i(TAG, "SMS를 수신하였습니다.");

            // SMS 메시지를 파싱합니다.
            Bundle bundle = intent.getExtras(); // 모든데이터를 Bundle객체로 받는다.
            Object[] objs = (Object[])bundle.get("pdus"); // SMS데이터만 Object배열로 얻기

            // Object 배열을 SmsMessage 배열로 변환해야 한다.
            SmsMessage[] messages = new SmsMessage[objs.length]; // 같은크기의 배열선언

            int smsCount = objs.length; // 문자의 개수
            for(int i = 0; i < smsCount; i++) {
                // PDU 포맷으로 되어 있는 메시지를 복원합니다.
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {  // API 23 이상
                    String format = bundle.getString("format");
                    messages[i] = SmsMessage.createFromPdu((byte[]) objs[i], format);
                } else {
                    messages[i] = SmsMessage.createFromPdu((byte[]) objs[i]);
                }
            }

            // SmsMessage 배열에서 필요한 정보만 뽑아낸다.
            // 가장 최근의 문자 1개만 처리한다.

            // SMS 수신 시간 확인
            Date receivedDate = new Date(messages[0].getTimestampMillis());
            Log.i(TAG, "SMS received date : " + receivedDate.toString());

            // SMS 발신 번호 확인
            String sender = messages[0].getOriginatingAddress();
            Log.i(TAG, "SMS sender : " + sender);

            // SMS 메시지 확인
            String contents = messages[0].getMessageBody().toString();
            Log.i(TAG, "SMS contents : " + contents);

            // 메시지를 보여줄 액티비티를 띄워줍니다.
            Intent myIntent = new Intent(context, SMSDisplayActivity.class);

            // 플래그를 이용합니다.
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);

            myIntent.putExtra("sender", sender);
            myIntent.putExtra("contents", contents);
            myIntent.putExtra("receivedDate", format.format(receivedDate));

            context.startActivity(myIntent);

        }

    }

}
