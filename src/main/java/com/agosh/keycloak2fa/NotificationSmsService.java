package com.agosh.keycloak2fa;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@AllArgsConstructor
public class NotificationSmsService implements SmsService {
    private final RestTemplate restTemplate;

    @Override
    public void send(String mobileNumber, String smsText) {
        log.info("Sending \"{}\" to {}", smsText, mobileNumber);
        try {
            String result = restTemplate.postForObject("/api/v1/sms/message",
                    new SendSmsPayload(
                            smsText,
                            mobileNumber
                    ), String.class);
            log.info("Notification service response: {}", result);
        } catch (HttpStatusCodeException e) {
            throw new NotificationException(e);
        }
    }
}
