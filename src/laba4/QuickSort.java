package laba4;

import java.util.ArrayDeque;
import java.util.Deque;

public class QuickSort {
    // стек границ отрезков для сортировки
    private static final Deque<Integer> stack = new ArrayDeque<>();

    public static void quickSort(int[] pArr) {
        int start, end, pivot;

        // сначала кладем границы всего входящего массива
        stack.push(0);
        stack.push(pArr.length);

        while (!stack.isEmpty()) {
            // берем границы отрезка
            end = stack.pop();
            start = stack.pop();

            // маленькие отрезки не сортируем
            if (end - start < 2) {
                continue;
            }

            // ищем опорный элемент
            pivot = start + ((end - start) / 2);

            // разбиваем отрезок относительно опорного элемента
            pivot = partition(pArr, pivot, start, end);

            // кладем в стек отрезок правый от опорного элемента
            stack.push(pivot + 1);
            stack.push(end);

            // и левый
            stack.push(start);
            stack.push(pivot);

        }
    }

    // разбивка отрезка относительно опорного элемента
    private static int partition(int[] pArr, int pPivotPos, int pStart, int pEnd) {
        int l = pStart;
        int r = pEnd - 2;
        int piv = pArr[pPivotPos];

        // перенос опорного элемента в конец
        swap(pArr, pPivotPos, pEnd - 1);

        // и пока указатели не встретились
        while (l < r) {
            if (pArr[l] < piv) {
                // элемент на своем месте (левее), значит двигаем указатель дальше
                l++;
            } else if (pArr[r] >= piv) {
                // справа? двигаем указатель
                r--;
            } else {
                // не на своем месте? меняем
                swap(pArr, l, r);
            }
        }

        // определяем место опорного элемента
        int idx = r;
        if (pArr[r] < piv) {
            idx++;
        }

        // и ставим его
        swap(pArr, pEnd - 1, idx);
        return idx;
    }

    // обмен элементов местами
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
