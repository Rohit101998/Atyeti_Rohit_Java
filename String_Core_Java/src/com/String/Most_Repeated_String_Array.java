package com.String;

public class Most_Repeated_String_Array {
    public static void main(String[] args) {
        String[] array = {"apple","banana","apple","orange","apple"};
        String maxRepeatedString = findMaxRepeatedString(array);
        System.out.println("String with max count: "+maxRepeatedString);
    }

    public static String findMaxRepeatedString(String[] array) {
        String maxRepeatedString =null;
        int maxCount= 0;
        for(int i=0;i<array.length;i++){
            int currentCount = 1;
            for(int j=i+1;j<array.length;j++){
                if(array[i].equals(array[j])){
                    currentCount++;
                }
            }
            if(currentCount > maxCount){
                maxCount = currentCount;
                maxRepeatedString = array[i];
            }
        }
        return maxRepeatedString;
    }


}
