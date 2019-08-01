
import com.sun.jna.Native;

public class SuperPatrick {
    /**
     * 输入本地SuperPatrick.dll的绝对路径
     * 获取ISuperPatrick实例
     *
     * @param dllPath
     * @return
     */
    public static ISuperPatrick getSuperPatrick(String dllPath) {
        System.setProperty("jna.encoding", "GBK");
        return (ISuperPatrick) Native.loadLibrary(dllPath, ISuperPatrick.class);
    }
}

