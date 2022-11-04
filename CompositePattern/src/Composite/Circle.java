package Composite;

public class Circle implements ShapeComponent {
    @Override
    public void draw() {
        System.out.println("Вызван круг");
    }
}
