package com.google.accompanist.systemuicontroller;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.google.accompanist.systemuicontroller.SystemUiController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SystemUiController.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006JA\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0&H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J9\u0010)\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\b2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0&H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR$\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR$\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR$\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/google/accompanist/systemuicontroller/AndroidSystemUiController;", "Lcom/google/accompanist/systemuicontroller/SystemUiController;", "view", "Landroid/view/View;", "window", "Landroid/view/Window;", "(Landroid/view/View;Landroid/view/Window;)V", "value", "", "isNavigationBarContrastEnforced", "()Z", "setNavigationBarContrastEnforced", "(Z)V", "isNavigationBarVisible", "setNavigationBarVisible", "isStatusBarVisible", "setStatusBarVisible", "navigationBarDarkContentEnabled", "getNavigationBarDarkContentEnabled", "setNavigationBarDarkContentEnabled", "statusBarDarkContentEnabled", "getStatusBarDarkContentEnabled", "setStatusBarDarkContentEnabled", "", "systemBarsBehavior", "getSystemBarsBehavior", "()I", "setSystemBarsBehavior", "(I)V", "windowInsetsController", "Landroidx/core/view/WindowInsetsControllerCompat;", "setNavigationBarColor", "", "color", "Landroidx/compose/ui/graphics/Color;", "darkIcons", "navigationBarContrastEnforced", "transformColorForLightContent", "Lkotlin/Function1;", "setNavigationBarColor-Iv8Zu3U", "(JZZLkotlin/jvm/functions/Function1;)V", "setStatusBarColor", "setStatusBarColor-ek8zF_U", "(JZLkotlin/jvm/functions/Function1;)V", "systemuicontroller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidSystemUiController implements SystemUiController {
    private final View view;
    private final Window window;
    private final WindowInsetsControllerCompat windowInsetsController;

    public AndroidSystemUiController(View view, Window window) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.window = window;
        this.windowInsetsController = window != null ? WindowCompat.getInsetsController(window, view) : null;
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public boolean getNavigationBarDarkContentEnabled() {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        return windowInsetsControllerCompat != null && windowInsetsControllerCompat.isAppearanceLightNavigationBars();
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public boolean getStatusBarDarkContentEnabled() {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        return windowInsetsControllerCompat != null && windowInsetsControllerCompat.isAppearanceLightStatusBars();
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public int getSystemBarsBehavior() {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        if (windowInsetsControllerCompat != null) {
            return windowInsetsControllerCompat.getSystemBarsBehavior();
        }
        return 0;
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public /* synthetic */ boolean getSystemBarsDarkContentEnabled() {
        return SystemUiController.CC.$default$getSystemBarsDarkContentEnabled(this);
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public boolean isNavigationBarContrastEnforced() {
        if (Build.VERSION.SDK_INT < 29) {
            return false;
        }
        Window window = this.window;
        return window != null && window.isNavigationBarContrastEnforced();
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public boolean isNavigationBarVisible() {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.view);
        return rootWindowInsets != null && rootWindowInsets.isVisible(WindowInsetsCompat.Type.navigationBars());
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public boolean isStatusBarVisible() {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.view);
        return rootWindowInsets != null && rootWindowInsets.isVisible(WindowInsetsCompat.Type.statusBars());
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public /* synthetic */ boolean isSystemBarsVisible() {
        return SystemUiController.CC.$default$isSystemBarsVisible(this);
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    /* renamed from: setNavigationBarColor-Iv8Zu3U, reason: not valid java name */
    public void mo6088setNavigationBarColorIv8Zu3U(long color, boolean darkIcons, boolean navigationBarContrastEnforced, Function1<? super Color, Color> transformColorForLightContent) {
        Intrinsics.checkNotNullParameter(transformColorForLightContent, "transformColorForLightContent");
        setNavigationBarDarkContentEnabled(darkIcons);
        setNavigationBarContrastEnforced(navigationBarContrastEnforced);
        Window window = this.window;
        if (window == null) {
            return;
        }
        if (darkIcons) {
            WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
            boolean z = false;
            if (windowInsetsControllerCompat != null && windowInsetsControllerCompat.isAppearanceLightNavigationBars()) {
                z = true;
            }
            if (!z) {
                color = transformColorForLightContent.invoke(Color.m3425boximpl(color)).m3445unboximpl();
            }
        }
        window.setNavigationBarColor(ColorKt.m3489toArgb8_81llA(color));
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public void setNavigationBarContrastEnforced(boolean z) {
        Window window;
        if (Build.VERSION.SDK_INT < 29 || (window = this.window) == null) {
            return;
        }
        window.setNavigationBarContrastEnforced(z);
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public void setNavigationBarDarkContentEnabled(boolean z) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        if (windowInsetsControllerCompat == null) {
            return;
        }
        windowInsetsControllerCompat.setAppearanceLightNavigationBars(z);
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public void setNavigationBarVisible(boolean z) {
        if (z) {
            WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
            if (windowInsetsControllerCompat != null) {
                windowInsetsControllerCompat.show(WindowInsetsCompat.Type.navigationBars());
                return;
            }
            return;
        }
        WindowInsetsControllerCompat windowInsetsControllerCompat2 = this.windowInsetsController;
        if (windowInsetsControllerCompat2 != null) {
            windowInsetsControllerCompat2.hide(WindowInsetsCompat.Type.navigationBars());
        }
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    /* renamed from: setStatusBarColor-ek8zF_U, reason: not valid java name */
    public void mo6089setStatusBarColorek8zF_U(long color, boolean darkIcons, Function1<? super Color, Color> transformColorForLightContent) {
        Intrinsics.checkNotNullParameter(transformColorForLightContent, "transformColorForLightContent");
        setStatusBarDarkContentEnabled(darkIcons);
        Window window = this.window;
        if (window == null) {
            return;
        }
        if (darkIcons) {
            WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
            boolean z = false;
            if (windowInsetsControllerCompat != null && windowInsetsControllerCompat.isAppearanceLightStatusBars()) {
                z = true;
            }
            if (!z) {
                color = transformColorForLightContent.invoke(Color.m3425boximpl(color)).m3445unboximpl();
            }
        }
        window.setStatusBarColor(ColorKt.m3489toArgb8_81llA(color));
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public void setStatusBarDarkContentEnabled(boolean z) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        if (windowInsetsControllerCompat == null) {
            return;
        }
        windowInsetsControllerCompat.setAppearanceLightStatusBars(z);
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public void setStatusBarVisible(boolean z) {
        if (z) {
            WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
            if (windowInsetsControllerCompat != null) {
                windowInsetsControllerCompat.show(WindowInsetsCompat.Type.statusBars());
                return;
            }
            return;
        }
        WindowInsetsControllerCompat windowInsetsControllerCompat2 = this.windowInsetsController;
        if (windowInsetsControllerCompat2 != null) {
            windowInsetsControllerCompat2.hide(WindowInsetsCompat.Type.statusBars());
        }
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public void setSystemBarsBehavior(int i) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        if (windowInsetsControllerCompat == null) {
            return;
        }
        windowInsetsControllerCompat.setSystemBarsBehavior(i);
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    /* renamed from: setSystemBarsColor-Iv8Zu3U, reason: not valid java name */
    public /* synthetic */ void mo6090setSystemBarsColorIv8Zu3U(long j, boolean z, boolean z2, Function1 function1) {
        SystemUiController.CC.m6091$default$setSystemBarsColorIv8Zu3U(this, j, z, z2, function1);
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public /* synthetic */ void setSystemBarsDarkContentEnabled(boolean z) {
        SystemUiController.CC.$default$setSystemBarsDarkContentEnabled(this, z);
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public /* synthetic */ void setSystemBarsVisible(boolean z) {
        SystemUiController.CC.$default$setSystemBarsVisible(this, z);
    }
}
