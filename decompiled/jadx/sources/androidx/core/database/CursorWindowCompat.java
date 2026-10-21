package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;

/* loaded from: classes2.dex */
public final class CursorWindowCompat {

    static class Api15Impl {
        private Api15Impl() {
        }

        static CursorWindow createCursorWindow(String str) {
            return new CursorWindow(str);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static CursorWindow createCursorWindow(String str, long j) {
            return new CursorWindow(str, j);
        }
    }

    private CursorWindowCompat() {
    }

    public static CursorWindow create(String str, long j) {
        return Build.VERSION.SDK_INT >= 28 ? Api28Impl.createCursorWindow(str, j) : Api15Impl.createCursorWindow(str);
    }
}
