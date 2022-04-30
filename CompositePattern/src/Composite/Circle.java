package Composite;

public class Circle implements ShapeComposite{
    @Override
    public void draw() {
        System.out.println("Вызван круг");
    }
}
