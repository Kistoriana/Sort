package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[100000];
        for(int i = 0; i < arr1.length; i++) {
            arr1[i] = (int) (Math.random() * 100);
        }

        // На 1000 элементов выполняется за 2 миллисекунды
        // На 10_000 элементов выполняется за 9-11 миллисекунды
        // На 100_000 элементов выполняется за 570-580 миллисекунд

        long m = System.currentTimeMillis();
        insertionSort(arr1);
        System.out.println((double) (System.currentTimeMillis() - m));

        int[] arr2 = new int[100000];
        for(int i = 0; i < arr2.length; i++) {
            arr2[i] = (int) (Math.random() * 100);
        }

        // На 1000 элементов выполняется за 2-4 миллисекунды
        // На 10_000 элементов выполняется за 29-33 миллисекунды
        // На 100_000 элементов выполняется за 2560-2570 миллисекунды

        long n = System.currentTimeMillis();
        selectionSort(arr2);
        System.out.println((double) (System.currentTimeMillis() - n));

        int[] arr3 = new int[100000];
        for(int i = 0; i < arr3.length; i++) {
            arr3[i] = (int) (Math.random() * 100);
        }

        // На 1000 элементов выполняется за 1 миллисекунду
        // На 10_000 элементов выполняется за 2 миллисекунды
        // На 100_000 элементов выполняется за 8-13 миллисекунды

        long x = System.currentTimeMillis();
        Arrays.sort(arr3);
        System.out.println((double) (System.currentTimeMillis() - x));
    }

    public static void insertionSort(int[] sortArr) {
        int j;
        for(int i = 1; i < sortArr.length; i++) {
            int swap = sortArr[i];
            for (j = i; j > 0 && swap < sortArr[j - 1]; j--) {
                sortArr[j] = sortArr[j - 1];
            }
            sortArr[j] = swap;
        }
    }

    public static void selectionSort(int[] sortArr) {
        for(int i = 0; i < sortArr.length; i++) {
            int pos = i;
            int min = sortArr[i];
            for (int j = i + 1; j < sortArr.length; j++) {
                if(sortArr[j] < min) {
                    pos = j;
                    min = sortArr[j];
                }
            }
            sortArr[pos] = sortArr[i];
            sortArr[i] = min;
        }
    }
}