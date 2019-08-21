
/**
 * 鼠标点击测试
 * created by JT
 */
public class MouseClickTest {
    public static void main(String[] args) throws Exception {
        //具体的坐标，建议使用MousePoint来查看
        //左键单击，点击桌面的开始按钮，坐标[30，1056]
        ControlEventUtils.mouseEvent(MouseEvent.TYPE_LEFT_CLICK, 30, 1056);
        //右键单击，点击任务栏，坐标[960，1040]
        ControlEventUtils.mouseEvent(MouseEvent.TYPE_RIGHT_CLICK, 960, 1040);
    }
}
