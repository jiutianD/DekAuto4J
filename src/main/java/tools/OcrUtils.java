import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class OcrUtils {
    /**
     * 图片路径，ocr路径，ocr字库
     *
     * @param filePath
     * @param ocrPath
     * @param ocrType
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
