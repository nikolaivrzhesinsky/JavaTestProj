package Composite;

public class Square implements ShapeComponent {
    @Override
    public void draw() {
        System.out.println("Вызван квадрат");
    }
}
