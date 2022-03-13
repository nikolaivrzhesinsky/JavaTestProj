package com.objects;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component()
public class ClassicMusic implements Music{

    private List<String> classicList= new ArrayList<>();
    {
        classicList.add("Богемская рапсодия");
        classicList.add("Two girls, one cup");
        classicList.add("Well done");
    }

    private ClassicMusic(){}

    @PostConstruct
    public  void doInitialized(){
        System.out.println("Classical music was initialized successfully");
    }
    @PreDestroy
    public void doDestroy(){
        System.out.println("Classical music was destroy successfully");
    }

    public static ClassicMusic getInstance(){
        return new ClassicMusic();
    }

    @Override
    public List<String> getSong() {

        return classicList;
    }
}
