package com.veda.map;
import java.util.*;
public class MaximumFrequencyStack {
    Map<Integer, Integer> stackFreq;
    Map<Integer, Stack<Integer>> groupMap;
    int maxFreq;
    public MaximumFrequencyStack() {
        stackFreq = new HashMap<>();
        groupMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int value) {
        int freq = stackFreq.getOrDefault(value, 0) + 1;
        stackFreq.put(value, freq);
        maxFreq = Math.max(maxFreq, freq);
        groupMap.computeIfAbsent(freq, x -> new Stack<>()).push(value);
    }

    public int pop() {
        // Replace this plaecholder return statement with your code
        Stack<Integer> stack = groupMap.get(maxFreq);
        int value = stack.pop();

        stackFreq.put(value, stackFreq.get(value) - 1);
        if(stack.isEmpty()) {
            groupMap.remove(maxFreq);
            maxFreq--;
        }
        return value;
    }
}