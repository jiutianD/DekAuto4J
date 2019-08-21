
public class main {

    public static void main(String args[]) throws Exception {
        OpenCvUtils.intiOpenCvDll("D:\\opencv-Java\\opencv_java401.dll");
        String filePath = System.getProperty("user.dir");
        MouseEvent mouseEvent = new MouseEvent(MouseEvent.TYPE_PIC_WAIT_CLICK,3000,filePath+"\\waitTestPic.png");
//        ControlEventUtils.mouseEvent(MouseEvent.TYPE_PIC_WAIT_CLICK,3000,filePath+"\\waitTestPic.png");
        ControlEventUtils.mouseEvent(mouseEvent);

    }
}
