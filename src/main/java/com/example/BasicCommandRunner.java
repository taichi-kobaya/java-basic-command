package com.example;

public class BasicCommandRunner {
    public static void main(String[] args) {
        if (args.length > 0) {
            String command = args[0];
            String[] commandArgs = java.util.Arrays.copyOfRange(args, 1, args.length);

            switch (command) {
                case "ls":
                    com.example.command.LsCommand.main(commandArgs);
                    break;
                case "pwd":
                    com.example.command.PwdCommand.main(commandArgs);
                    break;
                case "cd":
                    com.example.command.CdCommand.main(commandArgs);
                    break;
                default:
                    System.err.println("不明なコマンドです: " + command);
                    System.err.println("使用可能なコマンド: ls, pwd, cd");
                    break;
            }
        } else {
            System.err.println("実行するコマンドを指定してください (例: java -jar java-basic-command-1.0-SNAPSHOT.jar ls)");
            System.err.println("使用可能なコマンド: ls, pwd, cd");
        }
    }
}
