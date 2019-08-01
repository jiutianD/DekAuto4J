
/**
 * 鼠标拖拽测试
 * created by JT
 */
public class MouseSwipeTest {
    public static void main(String[] args) throws Exception {
        //拖拽状态栏第一个图标,坐标[104，1054]，往后拖动一段距离至[500,1054]
        ControlEventUtils
                .mouseMove(104, 1054)
                .delay(20)
                .mouseEvent(MouseEvent.TYPE_DRAGMOVE, 500, 1054);
    }

}
