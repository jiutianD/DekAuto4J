import java.util.Date;

public class Logger {
    /**
     * 正常输出写入的值
     *
     * @param info
     */
    public static void log(String tag,String info) {
        System.out.println(printLogPrefix(tag,info));
    }



    /**
     * //获取当前时间
     *
     * @return
     */

    public static String getTimeNow() {
        String year, month, day, hour, min, sec;
        Date d = new Date(System.currentTimeMillis());
        year = "" + (d.getYear() + 1900);
        month = "" + (d.getMonth() + 1);
        day = "" + (d.getDate());// 有些小问题-暂未优化
        hour = "" + d.getHours();
        min = "" + d.getMinutes();
        sec = "" + d.getSeconds();
        return "[" + year + "/" + month + "/" + day + " " + hour + ":" + min + ":" + sec + "] ";
    }

    /**
     * //获取语句行号
     *
     * @return
     */
    public static String getLineInfo() {
        StackTraceElement ste = new Throwable().getStackTrace()[3];//0-1的区别，抽空仔细研究研究，写个blog
        return "[" + ste.getFileName() + "]" + ": Line " + ste.getLineNumber();
    }

    /**
     * //获取语句所运行的类名
     *
     * @return
     */
    public static String getClassPathAndName() {
        StackTraceElement ste = new Throwable().getStackTrace()[3];

        return ste.getClassName();
    }


    /**
     * 获取日志语句的前缀
     *
     * @return
     */
    public static String printLogPrefix(String tag, String logInfo) {
        return getTimeNow() + getClassPathAndName() + " " + getLineInfo() + " TAG:" + tag + "  LOG:" + logInfo;
    }

}
