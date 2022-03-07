package com.objects;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext(
                "applicationContext.xml");
       // Music music= context.getBean("musicBean2",Music.class);
        ClassicMusic classicMusic= context.getBean("musicBean1",ClassicMusic.class);
       // MusicPlayer musicPlayer= context.getBean("musicPlayer",MusicPlayer.class);

        System.out.println( classicMusic.getSong());

//        musicPlayer.playOneMusic();
//        musicPlayer.playMusicList();
//        System.out.println(musicPlayer.getVolume());
//        System.out.println(musicPlayer.getName());

        context.close();
    }
}
