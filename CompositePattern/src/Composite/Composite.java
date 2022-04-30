package Composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements ShapeComposite{

    private List<ShapeComposite>composites= new ArrayList<>();

    public void addComponent(ShapeComposite component){
        composites.add(component);
    }

    public void removeComponent(ShapeComposite component){
        composites.remove(component);
    }

    @Override
    public void draw() {
        for(ShapeComposite component:composites){
            component.draw();
        }

    }
}
