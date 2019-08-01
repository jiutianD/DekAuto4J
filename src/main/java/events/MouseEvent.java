import java.awt.*;

public class MouseEvent {

    public int type;
    public int x;
    public int y;
    public String picPath;
    public long time;
    public Rectangle rectangle;

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


    public MouseEvent(int type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public MouseEvent(int type, int x, int y, long time) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.time = time;
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


}
