package com.Threads;

public class Threads_15_in_line {
    static int count = 15;
    static volatile int createdThreadCount;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {
        @Override
        public String toString() {
            return (createdThreadCount+" created");
        }

        public GenerateThread() {
            super(String.valueOf(++createdThreadCount));
            start();

        }

        @Override
        public void run() {
            if(createdThreadCount<count){
                System.out.println(new GenerateThread());
            }
        }
    }
}