package com.example.javanotificationtow;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;


//https://viblo.asia/p/tinh-nang-notification-channels-tren-android-80-oOVlYORVK8W
public class MainActivity extends AppCompatActivity {

    NotificationHelper helper;
    Button btnSend;
    EditText edtTitle,edtContent;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new NotificationHelper(this);
        edtTitle = (EditText)findViewById(R.id.edtTitle);
        edtContent = (EditText)findViewById(R.id.edtContent);
        btnSend = (Button)findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = edtTitle.getText().toString();
                String content = edtContent.getText().toString();
                Notification.Builder builder = helper.getEDMTChannelNotification(title,content);
                helper.getManager().notify(new Random().nextInt(),builder.build());
            }
        });

    }
}
