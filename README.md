# java-basic-command

Java で実装された基本的なコマンドラインユーティリティ集

## 概要

このプロジェクトは、Java を用いて Unix 系オペレーティングシステムでよく使われる基本的なコマンドラインユーティリティを簡易的に実装したものです。学習目的や、Java でのコマンドラインツールの開発方法の理解に役立つことを目指しています。

現在のバージョンでは、以下のコマンドが実装されています。

- `ls`: 現在のディレクトリまたは指定されたディレクトリ内のファイルとディレクトリの一覧を表示します。
- `pwd`: 現在の作業ディレクトリの絶対パスを表示します。
- `cd`: 指定されたディレクトリに移動します（Java プログラムの実行コンテキスト内でのみ有効です。実際のシェルのカレントディレクトリは変更されません）。

## 動作環境

- Java Development Kit (JDK) 11 以上
- Apache Maven

## ビルド方法

1. ターミナルを開き、このプロジェクトのルートディレクトリ (`java-basic-command`) に移動します。
2. 以下の Maven コマンドを実行してプロジェクトをビルドします。

```bash
mvn clean package
```

このコマンドを実行すると、`target` ディレクトリに実行可能な JAR ファイル (`java-basic-command-1.0-SNAPSHOT.jar`) が生成されます。

## 実行方法

ビルドが成功すると、以下のコマンドを使用して各ユーティリティを実行できます。

### `ls` コマンド

現在のディレクトリの内容を表示する場合：

```bash
java -jar target/java-basic-command-1.0-SNAPSHOT.jar ls
```

特定のディレクトリの内容を表示する場合（パスは絶対パスまたは相対パスで指定）：

```bash
java -jar target/java-basic-command-1.0-SNAPSHOT.jar ls /path/to/directory
```

### `pwd` コマンド

現在の作業ディレクトリの絶対パスを表示する場合：

Bash

`java -jar target/java-basic-command-1.0-SNAPSHOT.jar pwd`

### `cd` コマンド

指定されたディレクトリに移動します（プログラムの実行コンテキスト内でのみ有効）。

Bash

`java -jar target/java-basic-command-1.0-SNAPSHOT.jar cd /path/to/directory`

`/path/to/directory` には、移動したいディレクトリの絶対パスまたは現在のディレクトリからの相対パスを指定します。

**注意:** この `cd` コマンドは、Java プログラムが実行されている間のみ有効で、実際のシェルのカレントディレクトリを変更するわけではありません。

### 不明なコマンドの実行

実装されていないコマンドを指定した場合、エラーメッセージが表示されます。

Bash

`java -jar target/java-basic-command-1.0-SNAPSHOT.jar unknown_command`

## ディレクトリ構造

```bash
java-basic-command/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/example/
                ├── BasicCommandRunner.java
                └── command/
                    ├── CdCommand.java
                    ├── LsCommand.java
                    └── PwdCommand.java
```

- `pom.xml`: Maven の設定ファイル
- `src/main/java/com/example/`: Java のソースコードのルートパッケージ
- `src/main/java/com/example/BasicCommandRunner.java`: コマンドライン引数を解析し、対応するコマンドを実行するエントリポイント
- `src/main/java/com/example/command/`: 各コマンドのロジックを実装するクラスを格納するパッケージ
    - `LsCommand.java`: `ls` コマンドのロジック
    - `PwdCommand.java`: `pwd` コマンドのロジック
    - `CdCommand.java`: `cd` コマンドのロジック

## 拡張性

新しいコマンドを追加するには、以下の手順を行います。

1. `src/main/java/com/example/command/` パッケージ内に、新しいコマンドに対応する Java クラス (`NewCommand.java` など) を作成します。
2. 作成したクラスに `public static void main(String[] args)` メソッドを実装し、コマンドのロジックを記述します。
3. `src/main/java/com/example/BasicCommandRunner.java` の `main` メソッド内の `switch` 文に、新しいコマンドの `case` を追加します。
    
    ```java
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
        case "newcommand": // 新しいコマンドの追加
            com.example.command.NewCommand.main(commandArgs);
            break;
        default:
            System.err.println("不明なコマンドです: " + command);
            System.err.println("使用可能なコマンド: ls, pwd, cd, newcommand"); // 使用可能なコマンドリストの更新
            break;
    }
    ```
    
4. `BasicCommandRunner.java` の使用可能なコマンドリストの出力部分も更新することを推奨します。
5. プロジェクトを再度 `mvn clean package` でビルドします。

## 今後の展望

- より多くの基本的なコマンドラインユーティリティの実装 (`mkdir`, `rm`, `cat` など)。
- コマンドのオプションや引数の解析機能の追加。
- エラー処理の改善。
- より実際の Unix コマンドに近い動作の実現。

## 作者

taichi-kobaya