package com.ringcentral.sms;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Executor {

  // When Send SMS button is pressed, create an SendSMS Object and pass it the number and text message
  @Override
  protected void onCreate(Bundle savedInstanceState) {
      Log.i("Main Activity", "Listening for send press to send the SMS");
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      Button startBtn = (Button) findViewById(R.id.btnSendSMS);
      startBtn.setOnClickListener(new View.OnClickListener() {
      public void onClick(View view) {
          Context context = getApplicationContext();
          EditText numberEditText = (EditText) findViewById((R.id.phoneNumber));
          String recipientNumber = numberEditText.getText().toString();
          EditText messageEditText = (EditText) findViewById(R.id.smsMessage);
          String messageContent = messageEditText.getText().toString();
          SendSMS sendSMS = new SendSMS(recipientNumber, messageContent);
          execute(sendSMS);
          // Show Toast
          Toast.makeText(context, "SMS Sent!", Toast.LENGTH_SHORT).show();
          // Clear out fields after sms has been sent
          numberEditText.getText().clear();
          messageEditText.getText().clear();
      }
    });
  }

  // Perform executing of the run() method from SendSMS Class in a new thread
  @Override
  public void execute(Runnable runnable) {
      new Thread(runnable).start();
  }
}

