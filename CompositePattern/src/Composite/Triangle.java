package Composite;

public class Triangle implements ShapeComponent {

    @Override
    public void draw() {
        System.out.println("Вызвван треугольник");
    }
}
