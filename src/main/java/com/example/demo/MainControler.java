package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

@RestController
public class MainControler {
    public static String loadFromFile(String filename) throws FileNotFoundException {
        int lineNumber = 1;
        String txt = "";
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                txt += line;
                lineNumber++;
            }
        }
     return txt;
    }
    @GetMapping("/scifi")
    public String scifi() throws FileNotFoundException {
        return loadFromFile("scifi");
    }
    @GetMapping("/romantic")
    public String romantic() throws FileNotFoundException  {
        return loadFromFile("romantic");
    }
    @GetMapping("/historic")
    public String historic() throws FileNotFoundException  {
        return loadFromFile("historic");
    }
}