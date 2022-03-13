package com.objects;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RockMusic implements Music {

    private List<String> rockList= new ArrayList<>();
    {
        rockList.add("Kiss");
        rockList.add("Should i stay or should i go");
        rockList.add("Rebel");
    }

    

    @Override
    public List<String> getSong() {
        return rockList;
    }
}
