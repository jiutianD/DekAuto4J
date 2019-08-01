public class Logger {
    /**
     * 正常输出写入的值
     *
     * @param info
     */
    public static void log(String tag,String info) {
        System.out.println(LogTool.printLogPrefix(tag,info));
    }
}
