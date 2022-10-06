package com.bigdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileExercise {
    private String filename;

    public FileExercise(String filename) {
        this.filename = filename;
    }

    private void exploreDirectory() {
        File dir = new File("./");
        File[] files = dir.listFiles();

        for (File file: files) {
            System.out.println(file);
        }
    }
    private char readAChar() throws IOException {
        FileReader fileReader = new FileReader(this.filename);
        return (char)fileReader.read();
    }

    private String readChars(int N) throws IOException {
        FileReader fileReader = new FileReader(this.filename);
        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int ascii = fileReader.read();
            if(ascii == -1) {  // 더 이상 읽을 글자가 없다면
                return sb.toString();
            }
            sb.append((char)ascii);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        FileExercise fileExercise = new FileExercise("./hello.txt");

        // fileExercise.exploreDirectory();

        char ch = fileExercise.readAChar();
        // System.out.println(ch);

        String str = fileExercise.readChars(3);
        System.out.println(str);

    }

}
