import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;

public class main {
    /**
     * 5个5位数组，如何用最小时间复杂度，将数组中的最小的五个数找出来
     * @param args
     */
    public static void main(String args[]) throws AWTException, InterruptedException, IOException {
//        int[] a={19,20,22,23,25};
//        int[] b={16,17,23,25,30};
//        int[] c={17,19,19,22,25};
//        int[] d={19,22,23,25,25};
//        int[] e={20,21,23,24,26};
//
//        for(int i = 0;;){
//
//        }
//        OpenCvUtils.intiOpenCvDll("D:\\opencv-Java\\opencv_java401.dll");
//        OpenCvUtils.picHandle(ScreenHelper.filePath+"/1.jpg",OpenCvUtils.PIC_BINARY,"1.bmp");
//        ControlEventUtils.mouseMove(178,1049);
//        Robot robot = new Robot();
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        Thread.sleep(2000);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Rectangle rectangle = new Rectangle(100,100,100,100);
        ScreenHelper.getScreen(ScreenHelper.filePath+"/111.bmp",rectangle);
        Logger.log("Main","123123");


    }
}
