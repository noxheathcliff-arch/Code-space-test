package com.izumih.flowreply.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PermissionHelper.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u000b"}, d2 = {"Lcom/izumih/flowreply/util/PermissionHelper;", "", "()V", "canDrawOverlays", "", "context", "Landroid/content/Context;", "isAccessibilityServiceEnabled", "openAccessibilitySettings", "", "openOverlaySettings", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PermissionHelper {
    public static final int $stable = 0;
    public static final PermissionHelper INSTANCE = new PermissionHelper();

    private PermissionHelper() {
    }

    public final boolean canDrawOverlays(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.canDrawOverlays(context);
        }
        return true;
    }

    public final boolean isAccessibilityServiceEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", 0) == 0) {
            return false;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
        String packageName = context.getPackageName();
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append("/com.izumih.flowreply.service.FlowReplyAccessibilityService");
        return string != null && StringsKt.contains$default((CharSequence) string, (CharSequence) sb.toString(), false, 2, (Object) null);
    }

    public final void openAccessibilitySettings(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
        intent.setFlags(268435456);
        ContextCompat.startActivity(context, intent, null);
    }

    public final void openOverlaySettings(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 23) {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + context.getPackageName()));
            intent.setFlags(268435456);
            ContextCompat.startActivity(context, intent, null);
        }
    }
}
