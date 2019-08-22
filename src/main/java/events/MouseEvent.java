import java.awt.*;

public class MouseEvent {

    public int type;
    public int x;
    public int y;
    public String picPath;
    public long time;
    public long waitTime;
    public Rectangle rectangle;

    public static boolean isWaitEnd = false;

    public final static int TYPE_MOVE = 0;
    public final static int TYPE_DRAGMOVE = 1;
    public final static int TYPE_LEFT_CLICK = 2;
    public final static int TYPE_RIGHT_CLICK = 4;
    public final static int TYPE_MID_CLICK = 8;
    public final static int TYPE_LEFT_DOUBLECLICK = 16;
    //    public final static int TYPE_RIGHT_DOUBLECLICK = 32;
//    public final static int TYPE_MID_DOUBLECLICK = 64;
    public final static int TYPE_PIC_CLICK = 128;
    public final static int TYPE_MOUSE_WHEEL = 256;
    public final static int TYPE_LEFT_LONGCLICK = 512;
    public final static int TYPE_AREA_PIC_CLICK = 1024;
    public final static int TYPE_PIC_WAIT_CLICK = 2048;
    public final static int TYPE_AREA_PIC_WAIT_CLICK = 4096;

    public void versionJudge(int x, int y) {
        if (SystemInfoUtils.getSystemVersion().equals("10.0")) {
            this.x = (int) (x * 0.8);
            this.y = (int) (y * 0.8);
        }
    }

    public MouseEvent(int type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
        versionJudge(x, y);
    }

    public MouseEvent(int type, int x, int y, long time) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.time = time;
        versionJudge(x, y);
    }

    public MouseEvent(int type, String picPath) {
        this.type = type;
        this.picPath = picPath;
    }

    public MouseEvent(int type, Rectangle rectangle, String picPath) {
        this.type = type;
        this.rectangle = rectangle;
        this.picPath = picPath;
    }

    public MouseEvent(int type, long waitTime, String picPath) {
        this.type = type;
        this.waitTime = waitTime;
        this.picPath = picPath;
    }


}
