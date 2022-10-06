package com.bigdata;

import java.io.File;

public class FileExercise {
    public static void main(String[] args) {
        File dir = new File("./.idea/");
        File[] files = dir.listFiles();

        for (File file: files) {
            System.out.println(file);
        }
    }
}
