package Composite;


public class Main {

    public static void main(String[] args) {
        ShapeComposite component1= new Circle();
        ShapeComposite component2= new Square();
        ShapeComposite component3= new Triangle();

        Composite composite1= new Composite();
        Composite composite2= new Composite();
        Composite composite3= new Composite();

        composite1.addComponent(composite2);
        composite1.addComponent(composite3);
        composite1.addComponent(component3);
        composite2.addComponent(component1);
        composite3.addComponent(component2);

        composite1.draw();



    }
}
