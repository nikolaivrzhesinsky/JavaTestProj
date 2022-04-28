package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JFrame;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;


public class RunKeyboard extends JFrame implements KeyListener{

    private Thread thread;
//    private static Random random = new Random();
    private static final int DIR_STEP = 2;
    private boolean isLeft = false;
    private boolean isRight = false;
//    private boolean isUp = false;
//    private boolean isDown = false;
    private int x, y;
    private int heightC=200;
    private int weightC=200;

    public RunKeyboard(int width, int height) {
        this.setSize(width, height);
        x = width/2;
        y = height/2;
        this.addKeyListener(this);
        thread = new MoveThread(this);
        thread.start();
    }

    //Start point

    public static void main(String... string) {
        JFrame frame = new RunKeyboard(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_LEFT) isLeft = true;
        if (e.getKeyCode()==KeyEvent.VK_RIGHT) isRight = true;
//        if (e.getKeyCode()==KeyEvent.VK_UP) isUp = true;
//        if (e.getKeyCode()==KeyEvent.VK_DOWN) isDown = true;
    }



    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_LEFT) isLeft = false;
        if (e.getKeyCode()==KeyEvent.VK_RIGHT) isRight = false;
//        if (e.getKeyCode()==KeyEvent.VK_UP) isUp = false;
//        if (e.getKeyCode()==KeyEvent.VK_DOWN) isDown = false;
    }

    @Override
    public void keyTyped(KeyEvent arg0) {}

    //Graphics

    @Override
    public void paint(Graphics gr) {
        Graphics2D g2d = (Graphics2D)gr;
//        int r = random.nextInt(256);
//        int g = random.nextInt(256);
//        int b = random.nextInt(256);
//        g2d.setColor(new Color(r,g,b));
        g2d.setStroke(new BasicStroke(4f));
        getContentPane().removeAll();
        g2d.drawOval(x-weightC/2, y-heightC/2, weightC, heightC);
        final Timer timer= new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int multiplier = ThreadLocalRandom.current().nextBoolean() ? 1 : -1;
                weightC+=multiplier*5;
                heightC+=multiplier*5;
            }
        },0,2000);
    }

    public void animate() {
        if (isLeft) {
            weightC+=DIR_STEP;
            heightC+=DIR_STEP;
        }
        if (isRight && weightC/2>4)
        {
            weightC-=DIR_STEP;
            heightC-=DIR_STEP;
        }
        this.repaint();
    }

    //Engine thread

    private class MoveThread extends Thread{
        RunKeyboard runKeyboard;

        public MoveThread(RunKeyboard runKeyboard) {
            super("MoveThread");
            this.runKeyboard = runKeyboard;
        }

        public void run(){
            while(true) {
                runKeyboard.animate();
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
