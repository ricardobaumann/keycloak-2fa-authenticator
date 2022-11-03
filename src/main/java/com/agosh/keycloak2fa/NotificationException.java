package com.agosh.keycloak2fa;

import org.springframework.web.client.HttpStatusCodeException;

public class NotificationException extends RuntimeException {
    public NotificationException(HttpStatusCodeException e) {
        super(String.format(
                "Notification Service Status %s",
                e.getStatusCode()));
    }
}
