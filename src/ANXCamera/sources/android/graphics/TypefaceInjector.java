package android.graphics;

import java.io.File;

public class TypefaceInjector {
    private static final String THEME_FONT_DIR = "/data/system/theme/fonts/";
    private static Boolean sIsUsingThemeFont;

    private TypefaceInjector() {
    }

    public static boolean isUsingThemeFont() {
        if (sIsUsingThemeFont == null) {
            File file = new File(THEME_FONT_DIR);
            boolean z = false;
            if (file.exists()) {
                String[] list = file.list();
                if (list != null && list.length > 0) {
                    z = true;
                }
                sIsUsingThemeFont = Boolean.valueOf(z);
            } else {
                sIsUsingThemeFont = false;
            }
        }
        return sIsUsingThemeFont.booleanValue();
    }
}
