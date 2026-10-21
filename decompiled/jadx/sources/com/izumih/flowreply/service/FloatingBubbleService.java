package com.izumih.flowreply.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.izumih.flowreply.FlowReplyApplication;
import com.izumih.flowreply.R;
import com.izumih.flowreply.ui.ConfigOverlayActivity;
import com.izumih.flowreply.util.PreferencesManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: FloatingBubbleService.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\"\u0010!\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/izumih/flowreply/service/FloatingBubbleService;", "Landroid/app/Service;", "()V", "doubleTapThreshold", "", "floatingView", "Landroid/view/View;", "initialTouchX", "", "initialTouchY", "initialX", "", "initialY", "lastTapTime", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "windowManager", "Landroid/view/WindowManager;", "checkDismissZone", "", "currentY", "createFloatingBubble", "createNotification", "Landroid/app/Notification;", "handleClick", "handleDoubleTap", "handleSingleTap", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "flags", "startId", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FloatingBubbleService extends Service {
    public static final String ACTION_SHOW_CONFIG = "com.izumih.flowreply.SHOW_CONFIG";
    public static final String ACTION_START_ANALYSIS = "com.izumih.flowreply.START_ANALYSIS";
    public static final String BROADCAST_CONFIG_CLICKED = "com.izumih.flowreply.CONFIG_CLICKED";
    private static FloatingBubbleService instance;
    private View floatingView;
    private float initialTouchX;
    private float initialTouchY;
    private int initialX;
    private int initialY;
    private long lastTapTime;
    private WindowManager windowManager;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final long doubleTapThreshold = 300;
    private final CoroutineScope serviceScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));

    /* compiled from: FloatingBubbleService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/izumih/flowreply/service/FloatingBubbleService$Companion;", "", "()V", "ACTION_SHOW_CONFIG", "", "ACTION_START_ANALYSIS", "BROADCAST_CONFIG_CLICKED", "instance", "Lcom/izumih/flowreply/service/FloatingBubbleService;", "getInstance", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FloatingBubbleService getInstance() {
            return FloatingBubbleService.instance;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkDismissZone(int currentY) {
        if (currentY > getResources().getDisplayMetrics().heightPixels * 0.85f) {
            stopSelf();
        }
    }

    private final void createFloatingBubble() {
        Object systemService = getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager) systemService;
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.logo_flowreply);
        imageView.setPadding(8, 8, 8, 8);
        imageView.setElevation(12.0f);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setBackgroundResource(R.drawable.bubble_background);
        imageView.setClipToOutline(true);
        imageView.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        this.floatingView = imageView;
        int i = Build.VERSION.SDK_INT >= 26 ? 2038 : 2002;
        int i2 = (int) (60 * getResources().getDisplayMetrics().density);
        final WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(i2, i2, i, 8, -3);
        layoutParams.gravity = 8388659;
        layoutParams.x = 0;
        layoutParams.y = 100;
        WindowManager windowManager = this.windowManager;
        if (windowManager != null) {
            windowManager.addView(this.floatingView, layoutParams);
        }
        View view = this.floatingView;
        if (view != null) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.izumih.flowreply.service.FloatingBubbleService$createFloatingBubble$2
                private final float dragThreshold = 10.0f;
                private boolean isDragging;

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View v, MotionEvent event) {
                    float f;
                    float f2;
                    int i3;
                    int i4;
                    WindowManager windowManager2;
                    View view2;
                    if (event == null) {
                        return false;
                    }
                    int action = event.getAction();
                    if (action == 0) {
                        FloatingBubbleService.this.initialX = layoutParams.x;
                        FloatingBubbleService.this.initialY = layoutParams.y;
                        FloatingBubbleService.this.initialTouchX = event.getRawX();
                        FloatingBubbleService.this.initialTouchY = event.getRawY();
                        this.isDragging = false;
                        return true;
                    }
                    if (action == 1) {
                        if (this.isDragging) {
                            FloatingBubbleService.this.checkDismissZone(layoutParams.y);
                        } else {
                            FloatingBubbleService.this.handleClick();
                        }
                        return true;
                    }
                    if (action != 2) {
                        return false;
                    }
                    float rawX = event.getRawX();
                    f = FloatingBubbleService.this.initialTouchX;
                    float f3 = rawX - f;
                    float rawY = event.getRawY();
                    f2 = FloatingBubbleService.this.initialTouchY;
                    float f4 = rawY - f2;
                    if (!this.isDragging && (Math.abs(f3) > this.dragThreshold || Math.abs(f4) > this.dragThreshold)) {
                        this.isDragging = true;
                    }
                    if (this.isDragging) {
                        WindowManager.LayoutParams layoutParams2 = layoutParams;
                        i3 = FloatingBubbleService.this.initialX;
                        layoutParams2.x = i3 + ((int) f3);
                        WindowManager.LayoutParams layoutParams3 = layoutParams;
                        i4 = FloatingBubbleService.this.initialY;
                        layoutParams3.y = i4 + ((int) f4);
                        windowManager2 = FloatingBubbleService.this.windowManager;
                        if (windowManager2 != null) {
                            view2 = FloatingBubbleService.this.floatingView;
                            windowManager2.updateViewLayout(view2, layoutParams);
                        }
                    }
                    return true;
                }
            });
        }
    }

    private final Notification createNotification() {
        Notification build = new NotificationCompat.Builder(this, FlowReplyApplication.NOTIFICATION_CHANNEL_ID).setContentTitle(getString(R.string.notification_title)).setContentText(getString(R.string.notification_content)).setSmallIcon(R.drawable.ic_notification).setPriority(-1).setOngoing(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastTapTime < this.doubleTapThreshold) {
            handleDoubleTap();
            this.lastTapTime = 0L;
        } else {
            this.lastTapTime = currentTimeMillis;
            BuildersKt__Builders_commonKt.launch$default(this.serviceScope, null, null, new FloatingBubbleService$handleClick$1(this, null), 3, null);
        }
    }

    private final void handleDoubleTap() {
        Intent intent = new Intent(this, (Class<?>) ConfigOverlayActivity.class);
        intent.setFlags(268566528);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSingleTap() {
        try {
            PreferencesManager preferencesManager = new PreferencesManager(this);
            FlowReplyAccessibilityService companion = FlowReplyAccessibilityService.INSTANCE.getInstance();
            if (companion == null) {
                Toast.makeText(this, "Veuillez activer le service d'accessibilité FlowReply", 1).show();
            } else if (!preferencesManager.hasConfiguration()) {
                Toast.makeText(this, getString(R.string.toast_config_required), 0).show();
            } else {
                Toast.makeText(this, getString(R.string.toast_analysis_started), 0).show();
                companion.analyzeAndGenerateResponse();
            }
        } catch (Exception e) {
            Log.e("FloatingBubbleService", "Error in handleSingleTap", e);
            Toast.makeText(this, "Erreur lors de l'analyse: " + e.getMessage(), 0).show();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        instance = this;
        createFloatingBubble();
        startForeground(1001, createNotification());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Service
    public void onDestroy() {
        WindowManager windowManager;
        super.onDestroy();
        instance = null;
        try {
            try {
                View view = this.floatingView;
                if (view != null && (windowManager = this.windowManager) != null) {
                    windowManager.removeView(view);
                }
            } catch (Exception e) {
                Log.e("FloatingBubbleService", "Error removing floating view", e);
            }
            CoroutineScopeKt.cancel$default(this.serviceScope, null, 1, null);
        } finally {
            this.floatingView = null;
            this.windowManager = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        return 1;
    }
}
