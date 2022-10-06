package com.bigdata;

import java.io.File;

public class FileExercise {
    private void exploreDirectory() {
        File dir = new File("./");
        File[] files = dir.listFiles();

        for (File file: files) {
            System.out.println(file);
        }
    }

    public static void main(String[] args) {
        FileExercise fileExercise = new FileExercise();

        fileExercise.exploreDirectory();

        

    }
}
