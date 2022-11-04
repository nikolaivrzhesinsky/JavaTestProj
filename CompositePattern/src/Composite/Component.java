package Composite;

import java.util.ArrayList;
import java.util.List;

public class Component implements ShapeComponent {

    private List<ShapeComponent>composites= new ArrayList<>();

    public void addComponent(ShapeComponent component){
        composites.add(component);
    }

    public void removeComponent(ShapeComponent component){
        composites.remove(component);
    }

    @Override
    public void draw() {
        for(ShapeComponent component:composites){
            component.draw();
        }

    }
}
