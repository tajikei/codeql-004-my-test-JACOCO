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
  //     // String s はユーザに制御されているかもしれない
  //     // NFKC では \uFE64 は < に、\uFE65 は > に標準化される
  //     String s = "\uFE64" + "script" + "\uFE65";

  //     // 検証する
  //     Pattern pattern = Pattern.compile("[<>]"); // 山括弧かどうかのチェック
  //     Matcher matcher = pattern.matcher(s);
  //     if (matcher.find()) {
  //         // ブラックリストに登録されたタグを見つけた場合の処理
  //         throw new IllegalStateException();
  //     } else {
  //         // ...
  //     }
  //     // 標準化する
  //     s = Normalizer.normalize(s, Form.NFKC);
  // }

  private static String fetchRemoteObject(String location) throws Exception {
    URL url = new URL(location);
    
    URLConnection connection = url.openConnection();
    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String body = reader.lines().collect(Collectors.joining());
    return body;
}

}
