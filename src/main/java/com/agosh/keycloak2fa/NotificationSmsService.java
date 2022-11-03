package com.agosh.keycloak2fa;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@AllArgsConstructor
public class NotificationSmsService implements SmsService {
    private final Map<String, String> config;
    private final RestTemplate restTemplate;

    @Override
    public void send(String mobileNumber, String smsText) {
        log.info("Config: {}", config);
        log.info("Sending \"{}\" to {}", smsText, mobileNumber);
        try {
            String result = restTemplate.postForObject("/api/v1/sms/message",
                    new SendSmsPayload(
                            String.format(
                                    "%s is the OTP for Agosh Account. OTP is valid for 15 mins. Pls do not share it with anyone.",
                                    smsText
                            ),
                            mobileNumber
                    ), String.class);
            log.info("Notification service response: {}", result);
        } catch (HttpStatusCodeException e) {
            throw new NotificationException(e);
        }
    }
}
