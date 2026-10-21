package com.izumih.flowreply;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import kotlin.Metadata;

/* compiled from: FlowReplyApplication.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/izumih/flowreply/FlowReplyApplication;", "Landroid/app/Application;", "()V", "createNotificationChannel", "", "onCreate", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FlowReplyApplication extends Application {
    public static final int $stable = 0;
    public static final String NOTIFICATION_CHANNEL_ID = "flowreply_service_channel";
    public static final int NOTIFICATION_ID = 1001;

    private final void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, getString(R.string.notification_channel_name), 2);
            notificationChannel.setDescription(getString(R.string.notification_channel_desc));
            notificationChannel.setShowBadge(false);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }
}
