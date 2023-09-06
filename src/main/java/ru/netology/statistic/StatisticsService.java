package ru.netology.statistic;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.InputStream;


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

  public static void taji001() throws Exception {
      // String s はユーザに制御されているかもしれない
      // NFKC では \uFE64 は < に、\uFE65 は > に標準化される
      String s = "\uFE64" + "script" + "\uFE65";

      // 検証する
      Pattern pattern = Pattern.compile("[<>]"); // 山括弧かどうかのチェック
      Matcher matcher = pattern.matcher(s);
      if (matcher.find()) {
          // ブラックリストに登録されたタグを見つけた場合の処理
          throw new IllegalStateException();
      } else {
          // ...
      }
      // 標準化する
      s = Normalizer.normalize(s, Form.NFKC);
  }

}
