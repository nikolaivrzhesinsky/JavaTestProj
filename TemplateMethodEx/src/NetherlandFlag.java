

public class NetherlandFlag extends Flag {
    @Override
    void drawUpperLevel() {
        Colors.paintRedColor();
    }

    @Override
    void drawMiddleLevel() {
        Colors.paintWhiteColor();
    }

    @Override
    void drawBottomLevel() {
        Colors.paintBlueColor();
    }
}
