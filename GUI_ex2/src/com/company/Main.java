package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JComponent {

    public static void main(String[] args) {

        JFrame jFrame= new JFrame("Ex2");
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setSize(600,600);
        jFrame.setLocation(50,50);
        jFrame.getContentPane().add(new Main());
        jFrame.setVisible(true);
    }

    @Override
    public void paint(Graphics graphics){
        double[] arrArcDouble=getPercents();
        int[]arrArcInt= new int[arrArcDouble.length];
        for(int j=0;j<arrArcInt.length;j++){
            arrArcInt[j]=(int)arrArcDouble[j];
        }

        Random rand = new Random();
        Graphics2D graphics2D= (Graphics2D)graphics;
        int startAngle=0;

        for(int i=0;i<arrArcInt.length;i++){
            Color color = new Color(rand.nextInt(0xFFFFFF));
            graphics.setColor(color);
            graphics.fillArc(20,20,300,300,startAngle,arrArcInt[i]);
            startAngle+=arrArcInt[i];
        }





    }

    private double[] getPercents(){
        int[] array= new int[]{3,15,6,50};
        double[] temp= new double[array.length];
        int sum=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
        }
        for(int i=0;i< temp.length;i++){
            temp[i]=((double) array[i]/sum)*360;
        }

        return temp;
    }
}
