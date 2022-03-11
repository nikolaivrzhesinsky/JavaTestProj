package com.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MusicPlayer {
   // private List<Music>musicList= new ArrayList<Music>();
    private ClassicMusic classicMusic;
    private String name;
    private int volume;

    @Autowired
    public MusicPlayer(ClassicMusic classicMusic){
        this.classicMusic=classicMusic;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getVolume() {
//        return volume;
//    }
//
//    public void setVolume(int volume) {
//        this.volume = volume;
//    }
//
//
//    public void setMusic(Music music) {
//        this.music = music;
//    }

    public String playOneMusic(){
       return ("Playing "+ classicMusic.getSong());
    }

}
