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



  public void echo() {
    int i = 0;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
    i++;
  }


}
