package org.demos.url_shortener.services;

import java.util.Random;

public class HashGenerator {
    private static Random random = new Random();

    public static String getHash() {
        StringBuilder sb = new StringBuilder();

        while (sb.length() < 6) {
            int randomIndex = random.nextInt(characters.length);

            sb.append(characters[randomIndex]);
        }

        return sb.toString();
    }

    private static char[] characters = new char[] {
        'a',
        'b',
        'c',
        'd',
        'e',
        'f',
        'g',
        'h',
        'i',
        'j',
        'k',
        'l',
        'm',
        'n',
        'o',
        'p',
        'q',
        'r',
        's',
        't',
        'u',
        'v',
        'x',
        'y',
        'z',
        '0',
        '1',
        '2',
        '3',
        '4',
        '5',
        '6',
        '7',
        '8',
        '9',
    };


}
