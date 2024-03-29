package com.company;

import java.util.Scanner;

public class Main {
  final char[] alphabet = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Æ', 'Ø', 'Å'};
  Scanner sc = new Scanner(System.in);

  //Generate the key by looping the key string to the length of the desired text to encrypt
  //If text = "This is a test"   and key "test", the method will return key = "testtesttestte"
  public String keyGenerator(String text, String key) {
    for (int x = 0; x < text.length(); x++) {
      key += key.charAt(x);
    }
    return key;
  }

  public char convertNumberToLetter(int position) {
    char letter = alphabet[position];
    return letter;
  }

  public int convertLetterToNumber(char letter) {
    int position = 0;
    for (int x = 0; x < alphabet.length; x++) {
      if (letter == alphabet[x]) {
        position = x;
      }
    }
    return position;
  }


  public String vigenereEncryption(String text, String key) {
    key = keyGenerator(text, key);
    String encryptedText = "";
    for (int x = 0; x < text.length(); x++) {
      if (convertLetterToNumber(text.charAt(x)) == 0) {
        encryptedText += " ";
      } else {
        int position = convertLetterToNumber(key.charAt(x)) + convertLetterToNumber(text.charAt(x));
        if (position > (alphabet.length - 1)) {
          position -= (alphabet.length - 1);
        }
        encryptedText += "" + convertNumberToLetter(position);
      }
    }
    return encryptedText;
  }

  public String vigenereDecryption(String text, String key) {
    key = keyGenerator(text, key);
    String decryptedText = "";
    int position = 0;
    for (int x = 0; x < text.length(); x++) {
      if (convertLetterToNumber(text.charAt(x)) == 0) {
        decryptedText += " ";
      } else {
        position = convertLetterToNumber(text.charAt(x)) - convertLetterToNumber(key.charAt(x));
        if (position < 0) {
          position += (alphabet.length - 1);
        }decryptedText += "" + convertNumberToLetter(position);
      }
    }
    return decryptedText;
  }

  public static void main(String[] args) {
    Main prg = new Main();
    Scanner sc = new Scanner(System.in);
    System.out.println(prg.vigenereEncryption("THIS IS A TEST TO TEST THIS TEST", "TEST"));
    System.out.println(prg.vigenereDecryption("KMØJ NI U JYJY KF JYJY KØNI KJIK", "TEST"));

  }
}
