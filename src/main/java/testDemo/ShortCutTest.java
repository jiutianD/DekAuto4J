
/**
 * 快捷键测试
 * created by JT
 */
public class ShortCutTest {
    public static void main(String[] args) throws Exception {
        ControlEventUtils
                .shortcutCommand(ShortCutEvent.WINDOWS,ShortCutEvent.D)//win+D:显示桌面
                .delay(500)
                .shortcutCommand(ShortCutEvent.CTRL,ShortCutEvent.ALT,ShortCutEvent.A);//打开QQ后运行,Ctrl+alt+a，打开截图
    }
}
