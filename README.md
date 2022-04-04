# RingCentralSMS Android App (Java)
A simple android application that demonstrate how to use RingCentral Platform APIs to send SMS in Java.

<img src="https://github.com/suyashjoshi/RingCentralSMS-Android/blob/main/app/src/main/assets/screenshot.png" alt="drawing" width="400"/>


## Setup

- Download / Clone this project

- Open the file ["SendSMS.java"](https://github.com/suyashjoshi/RingCentralSMS-Android/blob/main/app/src/main/java/com/ringcentral/sms/SendSMS.java) and update the constant fields with your RingCentral application sandbox or production credentials. You will also need to provide JWT Credential, refer to this guide on how to create/access the same.

- Run the project from Android Studio on a device or emulator.

- Enter a valid **phone number** that can receive SMS and a **standard text message** and hit **Send**. Confirm the message on the recipient's device! If you're using Sandbox credentials, the message will be prefixed with the following text *"Test SMS using RingCentral Developer account"*.
