import org.opencv.core.Rect;

public class HandlePicTest {
    /**
     * 处理图片以及OpenCvUtils的Demo
     * 这里拿picTest.png为例
     *
     * @param args
     */
    public static void main(String args[]) {
        String filePath = System.getProperty("user.dir");
        OpenCvUtils.intiOpenCvDll("D:\\opencv-Java\\opencv_java401.dll");

        //灰度处理图片，并保存为GrayTest.png在工程根目录
        OpenCvUtils.picHandle(filePath + "//picTest.png", OpenCvUtils.PIC_GRAY, "GrayTest.png");

        //二进制处理图片，并保存为BinaryTest.png在工程根目录
        OpenCvUtils.picHandle(filePath + "//picTest.png", OpenCvUtils.PIC_BINARY, "BinaryTest.png");

        //在larger.png中查找small.png的小图，并生成res.png在工程根目录
        OpenCvUtils.findSmallInLarger(filePath + "//small.png", filePath + "//larger.png");

        // 从larger.png中裁剪左上坐标(0,0)到右下坐标(100,100)的区域的图片，并保存为cutPic.png
        Rect cutRect = new Rect(0, 0, 100, 100);
        OpenCvUtils.cutPicByRect(filePath + "//larger.png", cutRect, "cutPic.png");

    }
}
