
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenHelper {
    public static String filePath = System.getProperty("user.dir");

    /**
     * 使用Robot的自带方式
     * 经测试
     * 执行速度平均在  300-350ms
     * 优点：比较稳定，可以连续点击
     * 具体速度跟电脑速度有关
     *
     * @return
     * @throws IOException
     * @throws AWTException
     */
    public static boolean getScreen(String name) throws IOException, AWTException {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRect = new Rectangle(d);
        Robot robot = new Robot();
        BufferedImage bufferedImage = robot.createScreenCapture(screenRect);
        File file = new File(name);
        return ImageIO.write(bufferedImage, "bmp", file);
    }

    /**
     * 根据提供的矩形框Rect来截取屏幕
     *
     * @param name
     * @param rectangle
     * @return
     * @throws AWTException
     * @throws IOException
     */
    public static boolean getScreen(String name, Rectangle rectangle) throws AWTException, IOException {
        Robot robot = new Robot();
        BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
        File file = new File(name);
        return ImageIO.write(bufferedImage, "bmp", file);
    }

    /**
     * 调用系统自带截图PrintScreen
     * 然后从剪切板中拿到数据
     * 由于太快，会出现剪切板资源抢占的情况，故sleep50ms
     * 经测试
     * 执行速度平均在  190-220ms(未减50ms)
     * <p>
     * 缺点：高速率下，无法连续点击次数超过3-5次
     * <具体速度跟电脑速度有关>
     *
     * @return
     * @throws Exception
     */
    public static boolean getScreenByPrintScreen(String name) throws Exception {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PRINTSCREEN);
        robot.keyRelease(KeyEvent.VK_PRINTSCREEN);
        Image image = getImageFromClipboard();
//        BufferedImage.TYPE_INT_ARGB---bmp格式存储不了
//        TYPE_3BYTE_BGR---bmp格式，png格式都可存储
//        TYPE_INT_RGB---bmp格式，png格式都可存储
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(image, null, null);
        File file = new File(name);
        return ImageIO.write(bufferedImage, "bmp", file);
    }

    /**
     * 从剪切板获得图片。
     */
    private static Image getImageFromClipboard() throws Exception {
        Clipboard sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
        Thread.sleep(150);
        Transferable cc = sysc.getContents(null);
        if (cc == null)
            return null;
        else if (cc.isDataFlavorSupported(DataFlavor.imageFlavor)) {
            return (Image) cc.getTransferData(DataFlavor.imageFlavor);
        }
        return null;
    }
}
