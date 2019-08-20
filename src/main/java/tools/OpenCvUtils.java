
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class OpenCvUtils {

    //灰度处理
    public static final int PIC_GRAY = 0;
    //二进制处理
    public static final int PIC_BINARY = 1;

    /**
     * 模版匹配的种类类型
     * TM_SQDIFF = 0,
     * TM_SQDIFF_NORMED = 1,
     * TM_CCORR = 2,
     * TM_CCORR_NORMED = 3,
     * TM_CCOEFF = 4,
     * TM_CCOEFF_NORMED = 5;
     *
     * @param args
     */

    /**
     * 初始化OpenCv的Dll
     * dllPath：为本地存放OpenCv dll的路径
     *
     * @param dllPath
     */
    public static void intiOpenCvDll(String dllPath) {
        System.load(dllPath);
    }

    /**
     * 根据小图，查找小图在大图中的位置，返回坐标
     * Point：为小图的中心坐标点
     *
     * @param sPicPath
     * @param bPicPath
     * @return
     */
    public static Point findPicInPic(String sPicPath, String bPicPath) {
        Mat sPic = Imgcodecs.imread(sPicPath);
        Mat bPic = Imgcodecs.imread(bPicPath);
        Mat result = Mat.zeros(bPic.rows() - sPic.rows() + 1, bPic.cols() - sPic.cols() + 1, CvType.CV_32FC1);
        Imgproc.matchTemplate(sPic, bPic, result, Imgproc.TM_SQDIFF_NORMED);
        //规格化
        Core.normalize(result, result, 0, 1, Core.NORM_MINMAX, -1);
        //获得最可能点，MinMaxLocResult是其数据格式，包括了最大、最小点的位置x、y
        Core.MinMaxLocResult mlr = Core.minMaxLoc(result);
        Point matchLoc = mlr.minLoc;
        return new Point((matchLoc.x + sPic.width() / 2), (matchLoc.y + sPic.height() / 2));
    }

    /**
     * 大图中找小图，并且在工程根目录生产res.png的结果图
     *
     * @param sPicPath
     * @param bPicPath
     */
    public static void findSmallInLarger(String sPicPath, String bPicPath) {
        Mat sPic = Imgcodecs.imread(sPicPath);
        Mat bPic = Imgcodecs.imread(bPicPath);
        Mat result = Mat.zeros(bPic.rows() - sPic.rows() + 1, bPic.cols() - sPic.cols() + 1, CvType.CV_32FC1);
        Imgproc.matchTemplate(sPic, bPic, result, Imgproc.TM_SQDIFF_NORMED);
        //规格化
        Core.normalize(result, result, 0, 1, Core.NORM_MINMAX, -1);
        //获得最可能点，MinMaxLocResult是其数据格式，包括了最大、最小点的位置x、y
        Core.MinMaxLocResult mlr = Core.minMaxLoc(result);
        Point matchLoc = mlr.minLoc;
        Imgproc.rectangle(bPic, matchLoc, new Point(matchLoc.x + sPic.width(), matchLoc.y + sPic.height()), new Scalar(0, 0, 255), 2);
        //将结果输出到对应位置
        Imgcodecs.imwrite(ScreenHelper.filePath + "\\res.png", bPic);
        System.out.println(mlr.minVal);
        System.out.println(mlr.maxVal);
        System.out.println("左上坐标：" + "[" + matchLoc.x + "," + matchLoc.y + "]");
        System.out.println("宽高坐标：" + "[" + sPic.width() + ", " + sPic.height() + "]");
    }

    /**
     * 图片处理
     * 二进制化图片
     * 灰度化图片
     *
     * @param picPath
     * @param handleType
     * @param picName
     */
    public static void picHandle(String picPath, int handleType, String picName) {
        //IMREAD_ANYDEPTH、IMREAD_GRAYSCALE、IMREAD_IGNORE_ORIENTATION
        Mat src = Imgcodecs.imread(picPath, Imgcodecs.IMREAD_GRAYSCALE);
        switch (handleType) {
//            Imgproc.rectangle
            case PIC_GRAY:
                Imgcodecs.imwrite(ScreenHelper.filePath + "/" + picName, src);
                break;
            case PIC_BINARY:
                Mat dst = new Mat();
                //blockSize的数字必须%2 ==1才可以，其次值越大，图形里面的像素越粗，图越大
                //maxValue:值越大，图像越亮，反之越暗
                Imgproc.adaptiveThreshold(src, dst, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 7, 5);
                Imgcodecs.imwrite(ScreenHelper.filePath + "/" + picName, dst);
                break;
            default:
                break;
        }
    }

    /**
     * 根据Rect指定范围裁剪图片
     *
     * @param picPath
     * @param rect
     * @param outPutName
     */
    public static void cutPicByRect(String picPath, Rect rect, String outPutName) {
        Mat src = Imgcodecs.imread(picPath, Imgcodecs.IMREAD_GRAYSCALE);
        Mat img = new Mat(src, rect);
        Mat tmp = new Mat();
        img.copyTo(tmp);
        Imgcodecs.imwrite(outPutName, tmp);
    }
}