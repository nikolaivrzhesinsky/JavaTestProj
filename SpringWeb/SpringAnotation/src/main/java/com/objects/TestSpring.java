package com.objects;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        //ClassicMusic classicMusic= context.getBean("classicMusic",ClassicMusic.class);

        //MusicPlayer musicPlayer=context.getBean("musicPlayer",MusicPlayer.class);

       Computer computer=context.getBean("computer",Computer.class);
        System.out.println(computer);
        context.close();
    }
}
