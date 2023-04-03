package Morse;

import java.util.HashMap;
import java.util.Map;

public class Morse {
    public static void main(String[] args) {
        Morse morse = new Morse();
        System.out.println(morse.zeichenketteToMorse("Klausur"));
    }

    public static String[][] tabelle = {
            {"A", ".−"},
            {"B", "−..."},
            {"C", "−.-."},
            {"D", "-.."},
            {"E", "."},
            {"F", "..-."},
            {"G", "--."},
            {"H", "...."},
            {"I", ".."},
            {"J", ".---"},
            {"K", "_._"},
            {"L", ".-.."},
            {"M", "--"},
            {"N", "-."},
            {"O", "---"},
            {"P", ".--."},
            {"Q", "--.-"},
            {"R", ".-."},
            {"S", "..."},
            {"T", "-"},
            {"U", "..-"},
            {"V", "...-"},
            {"W", ".--"},
            {"X", "-..-"},
            {"Y", "-.--"},
            {"Z", "--.."}
    };

    public HashMap getMorseCodeMap(String[][] table) {
        Map<String, String> morse = new HashMap<>();
        for (int i = 0; i < table.length; i++) {
            morse.put(table[i][0], table[i][1]);
        }
        return (HashMap) morse;
    }

    public String zeichenketteToMorse(String s) {

        Morse morse = new Morse();
        Map<String, String> mapmorse = morse.getMorseCodeMap(tabelle);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String letter = Character.toString(s.charAt(i)).toUpperCase();
            if (mapmorse.containsKey(letter)) {
                builder.append(mapmorse.get(letter));
                builder.append(" ");
            }
        }


        return builder.toString();
    }
}
