import javax.swing.*;

public class Main
{
//    public static void main(String[] args)
//    {
//        JFrame f = new JFrame();
//
//        f.setSize(400, 400);
//        f.setVisible(true);
//
//        f.add(new ThirdComponent());
//    }
    public static void main(String[] args) {
        System.out.println("Рисуем флаг России:");
        Flag russianFlag = new RussianFlag();
        russianFlag.drawFlag();

        System.out.println("\nРисуем флаг Нидерландов:");
        Flag netherlandsFlag = new NetherlandFlag();
        netherlandsFlag.drawFlag();
    }
}
