package com.objects;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        ClassicMusic classicMusic= context.getBean("classicMusic",ClassicMusic.class);
        MusicPlayer musicPlayer= new MusicPlayer(classicMusic);

        System.out.println( classicMusic.getSong());
       musicPlayer.playOneMusic();

        context.close();
    }
}
