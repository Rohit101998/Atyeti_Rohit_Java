package com.Collection_Exercises.Queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FrequencyQueue {

    private Map<Integer,Integer> freqMap =new HashMap<>();
    private Map<Integer,Stack<Integer>> freqStackMAp = new HashMap<>();

    private int maxFrequency =0;

    public void enqueue(int val){
        int freq = freqMap.getOrDefault(val,0)+1;
        freqMap.put(val,freq);

        freqStackMAp.putIfAbsent(freq,new Stack<>());
        freqStackMAp.get(freq).push(val);

        if(freq > maxFrequency){
            maxFrequency= freq;
        }
    }

    public Integer dequeue(){
        if(maxFrequency==0){
            return null;
        }
        Stack<Integer> stack = freqStackMAp.get(maxFrequency);
        if(stack==null && stack.isEmpty()){
            maxFrequency--;
            return dequeue();
        }
        int val = stack.pop();

        freqMap.put(val,freqMap.get(val)-1);
        if(stack.isEmpty()){
            freqStackMAp.remove(maxFrequency);
            maxFrequency--;
        }
        return  val;
    }

    public static void main(String[] args) {
        FrequencyQueue fq = new FrequencyQueue();

        fq.enqueue(5);
        fq.enqueue(7);
        fq.enqueue(5);
        fq.enqueue(7);
        fq.enqueue(4);
        fq.enqueue(5);

        System.out.println(fq.dequeue());
        System.out.println(fq.dequeue());
        System.out.println(fq.dequeue());
        System.out.println(fq.dequeue());



    }
}
