package com.co.choucair.utils;

import java.security.SecureRandom;
import java.util.stream.IntStream;

public class IdGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateId() {
        return IntStream.range(0, 5)
                .mapToObj(i -> String.valueOf(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length()))))
                .reduce("", (a, b) -> a + b);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("ID generado: " + generateId());
        }
    }
}
