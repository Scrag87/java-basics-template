package com.epam.izh.rd.online.service;

import java.util.Arrays;

public class SimpleMathService implements MathService {

  /**
   * Метод возвращает 0, если value1 = value2. Метод возвращает -1, если value1 < value2. Метод
   * возвращает 1, если value1 > value2.
   *
   * <p>Например для (-1, -1) метод должен вернуть 0; Например для (-3, -1) метод должен вернуть -1;
   * Например для (3, 1) метод должен вернуть 1;
   */
  @Override
  public int compare(int value1, int value2) {
    if (value1 == value2) {
      return 0;
    } else if (value1 < value2) {
      return -1;
    } else {
      return 1;
    }
  }

  /**
   * Метод возвращает максимальное число из пары. Например для списка (-1, 2) метод должен вернуть 2
   */
  @Override
  public int maxFrom(int value1, int value2) {
    //return value1 > value2 ? value1 : value2;
    return Math.max(value1, value2);
  }

  /**
   * Метод возвращает максимальное число из переданного массива. Например для списка {-1, -3, 4, 8,
   * 5, 22, -5} метод должен вернуть 22
   */
  @Override
  public int maxFrom(int[] values) {
    int maxNumber = values[0];
    for (int i = 1; i < values.length; i++) {
      if (values[i] > maxNumber) {
        maxNumber = values[i];
      }
    }
    return maxNumber;
  }

  /**
   * Метод возвращает сумму чисел массива. Например для списка {-1, -3, 4, 8, 5, 22, -5} метод
   * должен вернуть 30
   */
  @Override
  public int sum(int[] values) {
    int sum = 0;
    for (int value : values) {
      sum += value;
    }
    return sum;
  }

  /**
   * Метод фильтрует массив, оставляя только четные числа. Например для списка {-1, -3, 4, 8, 5, 22,
   * 17} метод должен вернуть {4, 8, 22}
   */
  @Override
  public int[] getEvenDigits(int[] values) {
    int[] result = new int[0];
    for (int i = 0; i < values.length; i++) {
      if (values[i] % 2 == 0) {
        int[] tmp = new int[result.length];
        System.arraycopy(result, 0, tmp, 0, result.length);
        result = new int[result.length + 1];
        System.arraycopy(tmp, 0, result, 0, tmp.length);
        System.arraycopy(values, i, result, result.length - 1, 1);
      }
    }

    return result;
  }

  /**
   * Метод считает факториал из заданного числа. Например для числа 5 метод должен вернуть 120.
   * Факториал 0 должен быть равен 1.
   */
  @Override
  public long calcFactorial(int initialVal) {
    if (initialVal <= 1) {
      return 1;
    }
    return initialVal * calcFactorial(initialVal - 1);
  }

  /**
   * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду
   * фибоначчи.
   *
   * <p>Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих. Ряд
   * начинается 0 и 1. Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
   *
   * <p>Для числа 9 метод должен вернуть 34 Для числа 0 метод должен вернуть 0
   */
  @Override
  public long calcFibonacci(int number) {
    if (number == 1) {
      return number;
    }
    if (number == 0) {
      return 0;
    }
    return calcFibonacci(number - 1) + calcFibonacci(number - 2);
  }

  /**
   * Метод возвращает отсортированный по возрастанию массив. Например для массива {-1, -3, 4, 8, 5,
   * 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
   */
  @Override
  public int[] sort(int[] values) {
    Arrays.sort(values);
    return values;
  }

  /**
   * Метод определяет, является ли заданное число простым. Простое число - число, которое делится
   * только на 1 и на само себя.
   *
   * <p>Например для числа 22 вернется false, а для числа 23 true.
   */
  @Override
  public boolean isPrimary(int number) {
    for (int i = 2; i < number; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Метод возвращает массив, в котором элементы расположены в обратном порядке.
   *
   * <p>Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
   */
  @Override
  public int[] reverseArray(int[] values) {
    int steps;
    if (values.length % 2 == 0) {
      steps = values.length / 2;
    } else {
      steps = (values.length / 2) + 1;
    }
    for (int i = 0; i < steps; i++) {
      int tmp1 = values[i];
      values[i] = values[values.length - (1 + i)];
      values[values.length - (1 + i)] = tmp1;
    }
    return values;
  }
}
