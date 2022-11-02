package com.agosh.keycloak2fa;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@AllArgsConstructor
public class NotificationSmsService implements SmsService {
    private final Map<String, String> config;

    @Override
    public void send(String mobileNumber, String smsText) {
        log.info("Config: {}", config);
        log.info("Sending \"{}\" to {}", smsText, mobileNumber);
    }
}
