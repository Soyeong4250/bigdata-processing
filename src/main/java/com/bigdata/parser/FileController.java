package com.bigdata.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileController<T> {

    Parser<T> parser;

    public FileController(Parser<T> parser) {
        this.parser = parser;
    }

    public List<T> readLines(String filename) throws IOException {
        List<T> fileContents = new ArrayList<>();

        BufferedReader br;
        br = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8);
        String line;
        br.readLine();
        while((line = br.readLine()) != null) {
            fileContents.add(parser.parse(line));
        }

        return fileContents;
    }
}
