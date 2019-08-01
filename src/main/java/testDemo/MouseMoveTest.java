
/**
 * 鼠标移动测试
 * created by JT
 */
public class MouseMoveTest {

    public static void main(String[] args) throws Exception {
        ControlEventUtils
                .mouseMove(960, 540)
                .delay(200)
                .mouseMove(100, 540)
                .delay(200)
                .mouseMove(500, 540)
                .delay(200)
                .mouseMove(400, 540);
    }
}
