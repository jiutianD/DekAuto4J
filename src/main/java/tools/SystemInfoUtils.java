import java.util.Properties;

public class SystemInfoUtils {
    static Properties props = System.getProperties();
    public static String getSystemVersion() {
        return props.getProperty("os.version");
    }

}
