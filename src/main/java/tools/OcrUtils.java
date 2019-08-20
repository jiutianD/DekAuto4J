import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class OcrUtils {
    /**
     * 根据图片，解析出图片中的文字
     *
     * @param filePath：图片路径
     * @param ocrPath：ocr路径
     * @param ocrType：ocr字库
     * @return
     */
    public static String getStrFromPic(String filePath, String ocrPath, String ocrType) {
        String ocrRes = "";
        File image = new File(filePath);
        ITesseract iTesseract = new Tesseract();
        iTesseract.setDatapath(ocrPath);
        iTesseract.setLanguage(ocrType);
        try {
            ocrRes = iTesseract.doOCR(image);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        System.out.println("识别的结果为：" + ocrRes);
        return ocrRes;
    }

}
