package com.agosh.keycloak2fa;

public interface SmsService {
    void send(String mobileNumber, String smsText);
}
