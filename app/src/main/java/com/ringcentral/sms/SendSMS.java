package com.ringcentral.sms;

import android.util.Log;

import com.ringcentral.*;
import com.ringcentral.definitions.*;

import java.io.IOException;

public class SendSMS implements Runnable {

  private String recipientNumber = "";
  private String smsMessage = "";

  // RingCentral App Credentials
  private static final String RINGCENTRAL_CLIENT_ID = "";
  private static final String RINGCENTRAL_CLIENT_SECRET = "";
  private static final String RINGCENTRAL_SERVER_URL = "";
  private static final String RINGCENTRAL_DEV_NUMBER = "";
  private static final String RINGCENTRAL_JWT = "";

  public SendSMS(String recipientNumber, String message) {
      this.recipientNumber = recipientNumber;
      this.smsMessage = message;
  }

  // Business logic of sending the SMS using RingCentral SendSMS API
  public void run() {
      RestClient rc = new RestClient(RINGCENTRAL_CLIENT_ID, RINGCENTRAL_CLIENT_SECRET, RINGCENTRAL_SERVER_URL);
      try {
        rc.authorize(RINGCENTRAL_JWT);
        CreateSMSMessage postParameters = new CreateSMSMessage();
        postParameters.from = new MessageStoreCallerInfoRequest().phoneNumber(RINGCENTRAL_DEV_NUMBER);
        postParameters.to = new MessageStoreCallerInfoRequest[]{
            new MessageStoreCallerInfoRequest().phoneNumber(recipientNumber)
        };
        postParameters.text = smsMessage;
        GetSMSMessageInfoResponse response = rc.restapi().account().extension().sms().post(postParameters);
        Log.i("SendSMS", "SMS sent. Message status: " + response.messageStatus);
      }
      catch (RestException | IOException e) {
        e.printStackTrace();
        Log.e("Error Occurred", e.getMessage());
      }
  }
}
