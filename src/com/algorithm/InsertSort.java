package com.algorithm;

import java.util.Arrays;

/**
 * Сортировка вставками (Insertion Sort) — схоже на сортировку выбором, но является устойчивой и имеет квадратичную сложность — O(n^2)
 *
 * @see https://robotdreams.cc/blog/244-kakie-algoritmy-sortirovki-dolzhen-znat-junior-java-developer
 *      https://rukovodstvo.net/posts/id_798
 *      https://javarush.ru/groups/posts/1997-algoritmih-sortirovki-v-teorii-i-na-praktike
 *    ( https://habr.com/ru/post/204968 )
 *    ( https://habr.com/ru/post/204600 )
 *
 * Приимущества:
 * 1. такой способ использует специальный алгоритм проверки, в итоге, который уже уменьшает количество обращений к списку
 *      для работы с большими списками такая сортировка будет продуктивна, потому-что количество обращений к списку намного меньше
 *
 * Недостатки:
 * 1. чуть больше используется выделенных ресурсов для выполнения сортировки
 * 2. но для работаты со связанным списокм такой механизм не подходит,
 *      потому-что он заставляет повторно перебирать элементы связанного списка до нужной позиции
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {7, 8, 9, 1, 2, 3, 0, 6, 5, 4};

        System.out.println(Arrays.toString(array));

        for (int left = 0; left < array.length; left++) {
            /*
             * (сортировка-вставками похожа на сортировку выборкой)
             * За один проход, максимальный элемент сдвигается в крайнюю позицию
             * но, здесь мы уже не делаем полный проход, а только до первого найденного условного максимального-элемента
             */
            int maxVal = array[left];
            int j = left - 1;
            for (; j >= 0; j--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (maxVal < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            array[j + 1] = maxVal;
        }

        System.out.println(Arrays.toString(array));
    }
}
