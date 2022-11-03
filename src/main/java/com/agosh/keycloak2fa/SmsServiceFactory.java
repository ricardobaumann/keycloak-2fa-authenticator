package com.agosh.keycloak2fa;

import java.util.Map;

public class SmsServiceFactory {
    public static SmsService get(Map<String, String> config) {
        return new NotificationSmsService(RestTemplateFactory.build(config.get("notificationServiceUrl")));
    }
}
