package Composite;

public class Triangle implements ShapeComposite{

    @Override
    public void draw() {
        System.out.println("Вызвван треугольник");
    }
}
