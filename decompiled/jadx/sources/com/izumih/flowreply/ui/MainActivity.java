package com.izumih.flowreply.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.accompanist.systemuicontroller.SystemUiController;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import com.izumih.flowreply.R;
import com.izumih.flowreply.service.FloatingBubbleService;
import com.izumih.flowreply.ui.theme.ColorKt;
import com.izumih.flowreply.ui.theme.ThemeKt;
import com.izumih.flowreply.util.NotificationHelper;
import com.izumih.flowreply.util.PermissionHelper;
import com.izumih.flowreply.util.PreferencesManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/izumih/flowreply/ui/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "prefsManager", "Lcom/izumih/flowreply/util/PreferencesManager;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "startFloatingService", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MainActivity extends ComponentActivity {
    public static final int $stable = 8;
    private PreferencesManager prefsManager;

    /* JADX INFO: Access modifiers changed from: private */
    public final void startFloatingService() {
        try {
            if (!PermissionHelper.INSTANCE.canDrawOverlays(this)) {
                Toast.makeText(this, getString(R.string.permission_overlay_required), 0).show();
                return;
            }
            Intent intent = new Intent(this, (Class<?>) FloatingBubbleService.class);
            if (Build.VERSION.SDK_INT >= 26) {
                startForegroundService(intent);
            } else {
                startService(intent);
            }
            new Handler(getMainLooper()).postDelayed(new Runnable() { // from class: com.izumih.flowreply.ui.MainActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.startFloatingService$lambda$0(MainActivity.this);
                }
            }, 500L);
        } catch (Exception e) {
            Toast.makeText(this, "Erreur lors du démarrage du service: " + e.getMessage(), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startFloatingService$lambda$0(MainActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.moveTaskToBack(true);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.prefsManager = new PreferencesManager(this);
            if (!NotificationHelper.INSTANCE.hasNotificationPermission(this)) {
                NotificationHelper.INSTANCE.requestNotificationPermission(this);
            }
            ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-1569003283, true, new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.MainActivity$onCreate$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    if ((i & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1569003283, i, -1, "com.izumih.flowreply.ui.MainActivity.onCreate.<anonymous> (MainActivity.kt:35)");
                    }
                    final MainActivity mainActivity = MainActivity.this;
                    ThemeKt.FlowReplyTheme(ComposableLambdaKt.composableLambda(composer, -453114925, true, new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.MainActivity$onCreate$1.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i2) {
                            PreferencesManager preferencesManager;
                            if ((i2 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-453114925, i2, -1, "com.izumih.flowreply.ui.MainActivity.onCreate.<anonymous>.<anonymous> (MainActivity.kt:36)");
                            }
                            PreferencesManager preferencesManager2 = null;
                            final SystemUiController rememberSystemUiController = SystemUiControllerKt.rememberSystemUiController(null, composer2, 0, 1);
                            composer2.startReplaceableGroup(1157296644);
                            ComposerKt.sourceInformation(composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                            boolean changed = composer2.changed(rememberSystemUiController);
                            Object rememberedValue = composer2.rememberedValue();
                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = (Function0) new Function0<Unit>() { // from class: com.izumih.flowreply.ui.MainActivity$onCreate$1$1$1$1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        SystemUiController.CC.m6094setSystemBarsColorIv8Zu3U$default(SystemUiController.this, ColorKt.getBackgroundLight(), true, false, null, 12, null);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue);
                            }
                            composer2.endReplaceableGroup();
                            EffectsKt.SideEffect((Function0) rememberedValue, composer2, 0);
                            preferencesManager = MainActivity.this.prefsManager;
                            if (preferencesManager == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("prefsManager");
                            } else {
                                preferencesManager2 = preferencesManager;
                            }
                            final MainActivity mainActivity2 = MainActivity.this;
                            MainActivityKt.FlowReplyApp(preferencesManager2, new Function0<Unit>() { // from class: com.izumih.flowreply.ui.MainActivity.onCreate.1.1.2
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    MainActivity.this.startFloatingService();
                                }
                            }, composer2, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 1, null);
        } catch (Exception e) {
            Toast.makeText(this, "Erreur lors du démarrage: " + e.getMessage(), 1).show();
        }
    }
}
