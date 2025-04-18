package com.example.command;

import java.io.File;

public class CdCommand {
    public static void main(String[] args) {
        if (args.length > 0) {
            String path = args[0];
            File directory = new File(path);
            if (directory.exists() && directory.isDirectory()) {
                System.out.println("Changed directory to: " + directory.getAbsolutePath());
                // 実際のcdコマンドのようにカレントディレクトリを変更する処理はJavaの標準APIでは難しいです。
                // これはあくまで表示のみの簡易版です。
            } else {
                System.err.println("指定されたパスはディレクトリではないか、存在しません: " + path);
            }
        } else {
            System.err.println("cd コマンドには引数としてパスを指定してください。");
        }
    }
}