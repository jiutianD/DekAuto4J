public class OCRTest {

    public static void main(String args[]) {
        String filePath = System.getProperty("user.dir");
        String resText = OcrUtils.getStrFromPic(filePath + "//ocrTestPic1.png", "D:\\TessOCR\\Tesseract-OCR", "chi_sim+eng");
        System.out.println("结果为："+resText);
    }
}
