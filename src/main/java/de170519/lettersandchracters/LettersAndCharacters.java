/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package de170519.lettersandchracters;

/**
 *
 * @author DAO
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LettersAndCharacters {
    public static void main(String args[]) {
        // Nhận đầu vào từ người dùng
        String content = Input();

        // Loại bỏ ký tự không phải chữ cái và dấu cách từ đầu vào
        String newContent = getOnlyStrings(content);

        // Đếm và in ra số lần xuất hiện của các từ
        countAndPrintWordOccurrences(newContent);

        // Đếm và in ra số lần xuất hiện của các ký tự
        countAndPrintCharacterOccurrences(newContent);
    }

    // Phương thức để nhận đầu vào từ người dùng
    public static String Input() {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        return s;
    }

    // Phương thức để loại bỏ ký tự không phải chữ cái và dấu cách
    public static String getOnlyStrings(String s) {
        Pattern pattern = Pattern.compile("[^a-zA-Z ]");
        Matcher matcher = pattern.matcher(s);
        return matcher.replaceAll("");
    }

    // Phương thức để đếm và in ra số lần xuất hiện của từng từ
    public static void countAndPrintWordOccurrences(String content) {
        Map<String, Integer> wordCount = new HashMap<>();
        StringTokenizer st = new StringTokenizer(content);

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            wordCount.put(token, wordCount.getOrDefault(token, 0) + 1);
        }

        System.out.println("Word Occurrences:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    // Phương thức để đếm và in ra số lần xuất hiện của các ký tự
    public static void countAndPrintCharacterOccurrences(String content) {
        Map<Character, Integer> characterCount = new HashMap<>();
        String lowerString = content.toLowerCase().replaceAll(" ", "");

        for (int i = 0; i < lowerString.length(); i++) {
            char x = lowerString.charAt(i);
            characterCount.put(x, characterCount.getOrDefault(x, 0) + 1);
        }

        System.out.println("Character Occurrences:");
        for (Map.Entry<Character, Integer> entry : characterCount.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
