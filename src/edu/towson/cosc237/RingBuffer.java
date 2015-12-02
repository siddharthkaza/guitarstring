/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.towson.cosc237;

import java.util.LinkedList;

/**
 *
 * @author skaza
 */
public class RingBuffer {
    private final int CAPACITY;
    private int count;
    private LinkedList<Double> vibration;
    
    /**
     * 
     * @param capacity 
     */
    public RingBuffer(int capacity) {
        CAPACITY = capacity;
        count = 0;
        vibration = new LinkedList<Double>();
    }
    
    /**
     * 
     * @return the size 
     */
    public int size() {
        return count;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == CAPACITY;
    }
    
    public void enqueue(double x) {
        vibration.addLast(new Double(x));
        count++;
    }
    
    public double dequeue() {
        count--;
        return new Double(vibration.removeFirst());
    }
    
    public double peek() {
        return vibration.peekFirst();
    }
    
    
}
