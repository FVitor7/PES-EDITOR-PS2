package editor.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {
    private static ResourceBundle bundle;
    static {
        setLocale(Locale.getDefault());
    }

    public static void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle("editor.i18n.messages", locale);
    }

    public static String getString(String key) {
        if (bundle == null) {
            setLocale(Locale.getDefault());
        }
        return bundle.containsKey(key) ? bundle.getString(key) : '!' + key + '!';
    }
}
