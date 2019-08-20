
/**
 * 图片点击测试
 * created by JT
 */
public class PicClickTest {
    public static String filePath = System.getProperty("user.dir");

    public static void main(String[] args) throws Exception {
        //这里的dll路径，需要修改成自己本地的OpenCv的dll路径
        OpenCvUtils.intiOpenCvDll("D:\\opencv-Java\\opencv_java401.dll");
        //点击开始按钮，这里的picTest.png就是开始按钮的截图，建议手动截图，然后放到项目根目录
        ControlEventUtils.mouseEvent(MouseEvent.TYPE_PIC_CLICK, filePath + "\\picTest.png");
    }
}

