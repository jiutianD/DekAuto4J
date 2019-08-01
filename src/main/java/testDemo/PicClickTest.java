
/**
 * 图片点击测试
 * created by JT
 */
public class PicClickTest {
    public static String filePath = System.getProperty("user.dir");

    public static void main(String[] args) throws Exception {
        //这里的dll路径，需要修改成自己本地的OpenCv的dll路径
        OpenCvUtils.intiOpenCvDll("D:\\opencv-Java\\opencv_java401.dll");
        //点击开始按钮
        ControlEventUtils.mouseEvent(MouseEvent.TYPE_PIC_CLICK, filePath + "\\picTest.png");
    }
}

