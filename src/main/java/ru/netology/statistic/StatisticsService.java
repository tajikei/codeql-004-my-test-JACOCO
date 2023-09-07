package ru.netology.statistic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class StatisticsService {
  public long findMax(long[] incomes) {
    long currentMax = incomes[0];
    for (long income : incomes) {
      if (currentMax < income) {
        currentMax = income;
      }
    }
    return currentMax;
  }

  // public static void taji001() throws Exception {
  // // String s はユーザに制御されているかもしれない
  // // NFKC では \uFE64 は < に、\uFE65 は > に標準化される
  // String s = "\uFE64" + "script" + "\uFE65";

  // // 検証する
  // Pattern pattern = Pattern.compile("[<>]"); // 山括弧かどうかのチェック
  // Matcher matcher = pattern.matcher(s);
  // if (matcher.find()) {
  // // ブラックリストに登録されたタグを見つけた場合の処理
  // throw new IllegalStateException();
  // } else {
  // // ...
  // }
  // // 標準化する
  // s = Normalizer.normalize(s, Form.NFKC);
  // }

  private static String fetchRemoteObject(String location) throws Exception {
    URL url = new URL(location);

    URLConnection connection = url.openConnection();
    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String body = reader.lines().collect(Collectors.joining());
    return body;
  }

  // 脆弱性のあるコード：https://wiki.sei.cmu.edu/confluence/display/java/IDS07-J.+Sanitize+untrusted+data+passed+to+the+Runtime.exec()+method
  private static void dirlist() throws Exception {
    String dir = System.getProperty("dir");
    Runtime rt = Runtime.getRuntime();
    Process proc = rt.exec(new String[] { "sh", "-c", "ls " + dir });
    int result = proc.waitFor();
    if (result != 0) {
      System.out.println("process error: " + result);
    }
    InputStream in = (result == 0) ? proc.getInputStream() : proc.getErrorStream();
    int c;
    while ((c = in.read()) != -1) {
      System.out.print((char) c);
    }
    String username = "myusername";
    String password = "mypassword";
    // Sensitive environment variable
    String databaseUrl = "jdbc:mysql://localhost:3306/mydatabase";
    String command = "mysql -u" + username + " -p" + password + " -h" + databaseUrl;

    // Create a process and execute the command
    Process process = Runtime.getRuntime().exec(command);
  }
}
