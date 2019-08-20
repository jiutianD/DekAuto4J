
import com.sun.jna.Library;

public interface ISuperPatrick extends Library {
    /**
     * 根据定位器提供的四要素定位并点击一次
     *
     * @param pStrId
     * @param pStrName
     * @param pStrClassName
     * @param controlType
     */
    void findElement(String pStrId, String pStrName, String pStrClassName, String controlType);

    /**
     * 往当前光标焦点处，输入字符
     *
     * @param pKeysString
     */
    void sendKeys(String pKeysString);

    /**
     * 快捷键
     *
     * @param pKeysString
     */
    void sendShortCutKeys(String pKeysString);

    /**
     * 图片识别点击（全屏）
     *
     * @param strPartImage
     * @return
     */
    boolean findImage(String strPartImage);

    /**
     * 静态图片识别点击（指定坐标区域）
     *
     * @param strPartImage
     * @param a left
     * @param b top
     * @param c right
     * @param d bottom
     * @return
     */
    boolean findStaticImage(String strPartImage, int a, int b, int c, int d);

    /**
     * 窗口图片识别点击（指定窗口区域）
     *
     * @param strClass
     * @param strTitle
     * @param strPartImage
     * @return
     */
    boolean findImageByHwnd(String strClass, String strTitle, String strPartImage);
}