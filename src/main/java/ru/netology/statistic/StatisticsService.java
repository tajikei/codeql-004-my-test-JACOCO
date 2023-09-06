package ru.netology.statistic;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        public void test() {
        }
//
//        public static void listFiles(String dir) throws Exception {
//          Runtime rt = Runtime.getRuntime();
//          Process proc = rt.exec(new String[] {"sh", "-c", "ls " + dir});
//          int result = proc.waitFor();
//          if (result != 0) {
//            System.out.println("process error: " + result);
//          }
//          InputStream in = (result == 0) ? proc.getInputStream() :
//                                           proc.getErrorStream();
//          int c;
//          while ((c = in.read()) != -1) {
//            System.out.print((char) c);
//         }
//        }

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
