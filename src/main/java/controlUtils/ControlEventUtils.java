
import org.opencv.core.Point;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.io.IOException;

/**
 * 2019-5-28-19-15
 * 当前初步整合完毕
 * 鼠标滚轮的相关方法暂时没有写
 */
public class ControlEventUtils {
    static Robot robot;
    private final static int MOUSE_LEFT_BUTTON = 1 << 4;
    private final static int MOUSE_MID_BUTTON = 1 << 3;
    private final static int MOUSE_RIGHT_BUTTON = 1 << 2;

    public ControlEventUtils() {
    }

    /**
     * 延迟
     *
     * @param time
     * @return
     * @throws InterruptedException
     */
    public static ControlEventUtils delay(long time) throws InterruptedException {
        Thread.sleep(time);
        return new ControlEventUtils();
    }


    public static ControlEventUtils shortcutCommand(int key) throws AWTException, InterruptedException {
        ShortCutEvent event = new ShortCutEvent(key);
        shortcutCommand(event);
        Thread.sleep(500);
        return new ControlEventUtils();
    }

    /**
     * 两键的快捷键
     * 例：Ctrl+C
     *
     * @param key1
     * @param key2
     * @return
     * @throws AWTException
     * @throws InterruptedException
     */
    public static ControlEventUtils shortcutCommand(int key1, int key2) throws AWTException, InterruptedException {
        ShortCutEvent event = new ShortCutEvent(key1, key2);
        shortcutCommand(event);
        Thread.sleep(500);
        return new ControlEventUtils();
    }

    /**
     * 三键快捷键
     * 例如：ctrl+Alt+A
     *
     * @param key1
     * @param key2
     * @param key3
     * @return
     * @throws AWTException
     */
    public static ControlEventUtils shortcutCommand(int key1, int key2, int key3) throws AWTException {
        ShortCutEvent event = new ShortCutEvent(key1, key2, key3);
        shortcutCommand(event);
        return new ControlEventUtils();
    }

    /**
     * 四键快捷键
     * 例如：ctrl+shift+alt+F
     *
     * @param key1
     * @param key2
     * @param key3
     * @param key4
     * @return
     * @throws AWTException
     */
    public static ControlEventUtils shortcutCommand(int key1, int key2, int key3, int key4) throws AWTException {
        ShortCutEvent event = new ShortCutEvent(key1, key2, key3, key4);
        shortcutCommand(event);
        return new ControlEventUtils();
    }

    /**
     * 快捷键Command命令
     *
     * @param event
     * @return
     * @throws AWTException
     */
    private static ControlEventUtils shortcutCommand(ShortCutEvent event) throws AWTException {
        robot = new Robot();
        int[] keys = new int[4];
        keys[0] = event.command_key_1;
        keys[1] = event.command_key_2;
        keys[2] = event.command_key_3;
        keys[3] = event.command_key_4;
        int count = 0;
        if (keys[0] != 0) {
            robot.keyPress(event.command_key_1);
            count += 1;
            if (keys[1] != 0) {
                robot.keyPress(event.command_key_2);
                count += 1;
            }
            if (keys[2] != 0) {
                robot.keyPress(event.command_key_3);
                count += 1;
            }
            if (keys[3] != 0) {
                robot.keyPress(event.command_key_4);
                count += 1;
            }
        }
        for (int i = count; i > 0; i--) {
            System.out.println(keys[count - i]);
            robot.keyRelease(keys[count - i]);
        }
        return new ControlEventUtils();
    }

    /**
     * Type：鼠标事件的种类
     * [x,y]：即将操作的坐标位置
     *
     * @param type
     * @param x
     * @param y
     * @return
     * @throws IOException
     * @throws AWTException
     */
    public static ControlEventUtils mouseEvent(int type, int x, int y) throws Exception {
        MouseEvent event = new MouseEvent(type, x, y);
        mouseEvent(event);
        return new ControlEventUtils();
    }

    /**
     * Type：鼠标事件的种类
     * [x,y]：即将操作的坐标位置
     * Time:长摁鼠标的时间长度
     *
     * @param type
     * @param x
     * @param y
     * @return
     * @throws IOException
     * @throws AWTException
     */
    public static ControlEventUtils mouseEvent(int type, int x, int y, long time) throws Exception {
        MouseEvent event = new MouseEvent(type, x, y, time);
        mouseEvent(event);
        return new ControlEventUtils();
    }

    /**
     * Type：鼠标事件的种类
     * picPath：查找的目标图片路径
     *
     * @param type
     * @param picPath
     * @return
     * @throws IOException
     * @throws AWTException
     */
    public static ControlEventUtils mouseEvent(int type, String picPath) throws Exception {
        MouseEvent event = new MouseEvent(type, picPath);
        mouseEvent(event);
        return new ControlEventUtils();
    }

    /**
     * 鼠标事件处理
     *
     * @param mouseEvent
     * @return
     * @throws Exception
     * @Link MouseEvent
     */
    private static ControlEventUtils mouseEvent(MouseEvent mouseEvent) throws Exception {
        robot = new Robot();
        switch (mouseEvent.type) {
            case MouseEvent.TYPE_MOVE:
                robot.mouseMove(mouseEvent.x, mouseEvent.y);
                break;
            case MouseEvent.TYPE_DRAGMOVE:
                robot.mousePress(MOUSE_LEFT_BUTTON);
                robot.mouseMove(mouseEvent.x, mouseEvent.y);
                robot.delay(50);
                robot.mouseRelease(MOUSE_LEFT_BUTTON);
                break;
            case MouseEvent.TYPE_LEFT_CLICK:
                mouseClick(mouseEvent.x, mouseEvent.y, MOUSE_LEFT_BUTTON);
                break;
            case MouseEvent.TYPE_RIGHT_CLICK:
                mouseClick(mouseEvent.x, mouseEvent .y, MOUSE_RIGHT_BUTTON);
                break;
            case MouseEvent.TYPE_MID_CLICK:
                mouseClick(mouseEvent.x, mouseEvent.y, MOUSE_MID_BUTTON);
                break;
            case MouseEvent.TYPE_LEFT_DOUBLECLICK:
                mouseClick(mouseEvent.x, mouseEvent.y, MOUSE_LEFT_BUTTON);
                mouseClick(mouseEvent.x, mouseEvent.y, MOUSE_LEFT_BUTTON);
                break;
            case MouseEvent.TYPE_LEFT_LONGCLICK:
                mouseLongClick(mouseEvent.x, mouseEvent.y, mouseEvent.time, MOUSE_LEFT_BUTTON);
                break;
            case MouseEvent.TYPE_PIC_CLICK:
                ScreenHelper.getScreen("dekAutoPic.bmp");
//                tools.ScreenHelper.getScreenByPrintScreen("screenRect1.bmp");
                Point p = OpenCvUtils.findPicInPic(mouseEvent.picPath, ScreenHelper.filePath + "\\dekAutoPic.bmp");
                mouseClick((int) p.x, (int) p.y, MOUSE_LEFT_BUTTON);
                break;
            case MouseEvent.TYPE_AREA_PIC_CLICK:
                ScreenHelper.getScreen("dekAutoPic.bmp", mouseEvent.rectangle);
                Point pa = OpenCvUtils.findPicInPic(mouseEvent.picPath, ScreenHelper.filePath + "\\dekAutoPic.bmp");
                mouseClick((int) (pa.x + mouseEvent.rectangle.x), (int) (pa.y + mouseEvent.rectangle.y), MOUSE_LEFT_BUTTON);
                break;
            default:
                break;
        }
        return new ControlEventUtils();
    }

    /**
     * 鼠标移动
     *
     * @param x
     * @param y
     * @return
     * @throws AWTException
     */
    public static ControlEventUtils mouseMove(int x, int y) throws AWTException {
        robot = new Robot();
        robot.mouseMove(x, y);
        return new ControlEventUtils();
    }

    /**
     * 鼠标点击
     *
     * @param x
     * @param y
     * @param button
     */
    private static void mouseClick(int x, int y, int button) {
        robot.mouseMove(x, y);
        robot.mousePress(button);
        robot.mouseRelease(button);
        robot.delay(50);
    }

    /**
     * 鼠标长摁
     *
     * @param x
     * @param y
     * @param time
     * @throws InterruptedException
     */
    private static void mouseLongClick(int x, int y, long time, int button) throws InterruptedException {
        robot.mouseMove(x, y);
        robot.mousePress(button);
        Thread.sleep(time);
        robot.mouseRelease(button);
    }

    /**
     * 输入字符串
     *
     * @param text
     * @throws AWTException
     */
    public static ControlEventUtils inputText(String text) throws AWTException {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
        ShortCutEvent event = new ShortCutEvent(ShortCutEvent.CTRL, ShortCutEvent.V);
        shortcutCommand(event);
        return new ControlEventUtils();
    }
}
