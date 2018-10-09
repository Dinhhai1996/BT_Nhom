package com.example.nguyenthai.bt_nhom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WaitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);
        //Dùng cài đặt sau 5 giây màn hình tự chuyển
        Thread bamgio=new Thread(){
            public void run()
            {
                try {
                    sleep(2000);
                } catch (Exception e) {

                }
                finally
                {
                    Intent activitymoi=new Intent("com.example.nguyenthai.bt_nhom.MAINACTIVITY");
                    startActivity(activitymoi);
                }
            }
        };
        bamgio.start();
    }
    //sau khi chuyển sang màn hình chính, kết thúc màn hình chào
    protected void onPause(){
        super.onPause();
        finish();
    }

}
