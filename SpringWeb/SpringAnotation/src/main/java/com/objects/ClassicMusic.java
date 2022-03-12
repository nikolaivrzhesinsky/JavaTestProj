package com.objects;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component()
public class ClassicMusic implements Music{

    private List<String> classicList= new ArrayList<>();
    {
        classicList.add("Богемская рапсодия");
        classicList.add("Two girls, one cup");
        classicList.add("Well done");
    }

    private ClassicMusic(){}

    public static ClassicMusic getInstance(){
        return new ClassicMusic();
    }

    @Override
    public List<String> getSong() {

        return classicList;
    }
}
