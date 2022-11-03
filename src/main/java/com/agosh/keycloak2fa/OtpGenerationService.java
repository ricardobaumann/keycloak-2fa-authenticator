package com.agosh.keycloak2fa;


import java.text.DecimalFormat;
import java.util.Random;

public class OtpGenerationService {

    private final Random random = new Random();

    String generateCode(Integer length) {
        DecimalFormat decimalFormat = new DecimalFormat("0".repeat(length));
        return decimalFormat.format(random.nextInt(9 * (Integer.parseInt("1".repeat(length)))));
    }

}
