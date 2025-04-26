package com.example.command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCommand {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("sort コマンドにはソートするファイル名を指定してください。");
            return;
        }

        String filename = args[0];
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            Collections.sort(lines);
            for (String sortedLine : lines) {
                System.out.println(sortedLine);
            }
        } catch (IOException e) {
            System.err.println("ファイルの読み込み中にエラーが発生しました: " + e.getMessage());
        }
    }
}