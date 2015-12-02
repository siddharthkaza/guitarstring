/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.towson.cosc237;

import java.util.Random;

/**
 *
 * @author skaza
 */
public class GuitarString {
    private RingBuffer rb;
    private final int N;
    private int tics = 0;
    
    public GuitarString (double frequency) {
        
        N = (int) Math.round(44100/frequency);
        rb = new RingBuffer(N);
        
        for (int i=0;i<N;i++) {
            rb.enqueue(0);
        }
    }
    
    public void pluck() {
        double rangeMin = -0.5;
        double rangeMax = 0.5;
        Random r = new Random();
        double randomValue;
        
        rb = new RingBuffer(N); //replace the values with random valuea
        
        for (int i=0;i<N;i++) {
            randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
            rb.enqueue(randomValue);
        }
        
    }
    
    public void tic() {
        double first = rb.dequeue();
        double second = rb.peek();
        tics++;
        
        rb.enqueue((0.5 * (first+second))*0.994);    
    }
    
    /**
     * Return the value of the item at the front of the ring buffer.
     * @return 
     */
    public double sample() {
        
        return rb.peek();
    }
    
    public int time() {
        return tics;
    }
}
