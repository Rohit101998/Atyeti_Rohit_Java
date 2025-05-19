package com.String;

public class StringPrintAscending {
    public static void main(String[] args) {
        String[] strings = {"apple", "banana", "orange", "grape", "kiwi"};
        sortString(strings);

        System.out.println("String in Ascending order: ");

        for(String str: strings){
            System.out.println(str);
        }
    }

    public static void sortString(String[] arr) {
        int n = arr.length;
        for(int i= 0; i < n - 1 ; i++){
            for(int j= 0;j < n - i - 1; j++){
                if(arr[j].compareTo(arr[j + 1]) > 0){
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
