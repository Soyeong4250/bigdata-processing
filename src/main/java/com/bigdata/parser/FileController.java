package com.bigdata.parser;

import org.mozilla.universalchardet.UniversalDetector;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileController<T> {

    Parser<T> parser;

    public FileController(Parser<T> parser) {
        this.parser = parser;
    }

    public String findFileEncoding(String path) throws IOException {
        byte[] buf = new byte[4096];
        FileInputStream fis = new FileInputStream(new File(path));

        UniversalDetector detector = new UniversalDetector(null);

        int bufSize;
        while ((bufSize = fis.read(buf)) > 0 && !detector.isDone()) {
            detector.handleData(buf, 0, bufSize);
        }

        detector.dataEnd();

        String encoding = detector.getDetectedCharset();
        if (encoding != null) {
            System.out.println("Detected encoding = " + encoding);
        } else {
            System.out.println("No encoding detected.");
        }

        detector.reset();

        return encoding;
    }

    public List<T> readLines(String path, String encoding) throws IOException {
        List<T> fileContents = new ArrayList<>();

        BufferedReader br;


        br = new BufferedReader(new InputStreamReader(new FileInputStream(path), encoding));
        String line;
        br.readLine();
        while((line = br.readLine()) != null) {
            fileContents.add(parser.parse(line));
        }

        return fileContents;
    }

    public void createNewSqlFile(String newFilename) {
        File file = new File(newFilename);
        try {
            file.createNewFile();
            System.out.println("파일이 존재하는지 ? : " + file.exists());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void writeContents(String queries, String newFilename) {
        File file = new File(newFilename);

        try{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            bw.write(queries);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
