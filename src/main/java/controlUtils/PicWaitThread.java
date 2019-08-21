import org.opencv.core.Point;

public class PicWaitThread extends Thread {
    String picPath;
    long waitTime;
    String filePath = System.getProperty("user.dir");
    static boolean flag = false;
    static Point point;

    public PicWaitThread() {
    }

    public PicWaitThread(String picPath, long waitTime) {
        this.picPath = picPath;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        super.run();
        while (!flag) {
            try {
                ScreenUtils.getScreenByPrintScreen("ThreadTemp.bmp");
                point = OpenCvUtils.findPicInPic(picPath, filePath + "\\ThreadTemp.bmp");
                if (MouseEvent.isWaitEnd) {
                    break;
                }
                if (point != null) {
                    flag = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
