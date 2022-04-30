package Composite;

public class Square implements ShapeComposite{
    @Override
    public void draw() {
        System.out.println("Вызван квадрат");
    }
}
