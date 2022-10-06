package com.bigdata;

import java.io.*;

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

    private String readALine() throws IOException {
        FileReader fileReader = new FileReader(this.filename);
        BufferedReader br = new BufferedReader(fileReader);

        return br.readLine();
    }

    private String readAll() throws IOException {
        FileReader fileReader = new FileReader(this.filename);
        BufferedReader br = new BufferedReader(fileReader);

        StringBuilder sb = new StringBuilder();
        String str;
        while((str = br.readLine()) != null) {
            sb.append(str);
            sb.append("\n");  // 줄바꿈
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        FileExercise fileExercise = new FileExercise("./hello.txt");

        // fileExercise.exploreDirectory();


        System.out.println("한 글자 읽기");
        char ch = fileExercise.readAChar();
        System.out.println(ch);

        System.out.println("----------------------------");

        System.out.println("N 글자 읽기");
        String str = fileExercise.readChars(3);
        System.out.println(str);

        System.out.println("----------------------------");

        System.out.println("한 줄 읽기");
        String str1 = fileExercise.readALine();
        System.out.println(str1);

        System.out.println("----------------------------");

        System.out.println("N 줄 읽기");
        String str2 = fileExercise.readAll();
        System.out.println(str2);
    }

}
