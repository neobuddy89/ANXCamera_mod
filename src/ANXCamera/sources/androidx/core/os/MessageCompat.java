package androidx.core.os;

import android.os.Build;
import android.os.Message;

public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    private MessageCompat() {
    }

    public static boolean isAsynchronous(Message message) {
        if (Build.VERSION.SDK_INT >= 22) {
            return message.isAsynchronous();
        }
        if (sTryIsAsynchronous && Build.VERSION.SDK_INT >= 16) {
            try {
                return message.isAsynchronous();
            } catch (NoSuchMethodError e2) {
                sTryIsAsynchronous = false;
            }
        }
        return false;
    }

    public static void setAsynchronous(Message message, boolean z) {
        if (Build.VERSION.SDK_INT >= 22) {
            message.setAsynchronous(z);
        } else if (sTrySetAsynchronous && Build.VERSION.SDK_INT >= 16) {
            try {
                message.setAsynchronous(z);
            } catch (NoSuchMethodError e2) {
                sTrySetAsynchronous = false;
            }
        }
    }
}
