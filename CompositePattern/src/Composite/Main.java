package Composite;


public class Main {

    public static void main(String[] args) {
        ShapeComponent component1= new Circle();
        ShapeComponent component2= new Square();
        ShapeComponent component3= new Triangle();

        Component composite1= new Component();
        Component composite2= new Component();
        Component composite3= new Component();

        composite1.addComponent(composite2);
        composite1.addComponent(composite3);
        composite1.addComponent(component3);
        composite2.addComponent(component1);
        composite3.addComponent(component2);

        composite1.draw();



    }
}
