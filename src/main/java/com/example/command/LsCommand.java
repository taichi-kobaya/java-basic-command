package com.example.command;

import java.io.File;
import java.util.Arrays;

public class LsCommand {
    public static void main(String[] args) {
        File currentDirectory = new File(".");
        if (args.length > 0) {
            currentDirectory = new File(args[0]); // 引数があればそのディレクトリを表示
        }

        File[] files = currentDirectory.listFiles();

        if (files != null) {
            Arrays.sort(files, (f1, f2) -> f1.getName().compareTo(f2.getName()));
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.err.println("指定されたディレクトリが存在しないか、アクセスできません: " + currentDirectory.getAbsolutePath());
        }
    }
}