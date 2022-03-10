package com.objects;

import org.springframework.stereotype.Component;

@Component()
public class ClassicMusic implements Music{

    private ClassicMusic(){}

    public static ClassicMusic getInstance(){
        return new ClassicMusic();
    }

    public void doMyInit(){
        System.out.println("Doing initialization");
    }
    public void doMyDestroy(){
        System.out.println("Was destroy");
    }

    public String getSong() {
        return "Времена года";
    }
}
