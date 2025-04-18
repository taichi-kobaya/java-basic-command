package com.example.command;

import java.nio.file.Paths;

public class PwdCommand {
    public static void main(String[] args) {
        String currentWorkingDirectory = Paths.get("").toAbsolutePath().toString();
        System.out.println(currentWorkingDirectory);
    }
}