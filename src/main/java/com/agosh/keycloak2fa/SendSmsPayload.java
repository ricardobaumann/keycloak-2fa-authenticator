package com.agosh.keycloak2fa;

import lombok.Value;

@Value
class SendSmsPayload {
    String message;
    String to;
}
