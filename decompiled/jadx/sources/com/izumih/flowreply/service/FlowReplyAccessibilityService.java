package com.izumih.flowreply.service;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.izumih.flowreply.api.GeminiService;
import com.izumih.flowreply.data.Message;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: FlowReplyAccessibilityService.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u001e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/izumih/flowreply/service/FlowReplyAccessibilityService;", "Landroid/accessibilityservice/AccessibilityService;", "()V", "geminiService", "Lcom/izumih/flowreply/api/GeminiService;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "analyzeAndGenerateResponse", "", "extractMessagesFromScreen", "", "Lcom/izumih/flowreply/data/Message;", "extractMessagesRecursively", "node", "Landroid/view/accessibility/AccessibilityNodeInfo;", "messages", "", "findInputField", "insertTextIntoInputField", "text", "", "isUserMessage", "", "onAccessibilityEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/accessibility/AccessibilityEvent;", "onDestroy", "onInterrupt", "onServiceConnected", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FlowReplyAccessibilityService extends AccessibilityService {
    private static final String TAG = "FlowReplyAccess";
    private static FlowReplyAccessibilityService instance;
    private final GeminiService geminiService = new GeminiService();
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: FlowReplyAccessibilityService.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/izumih/flowreply/service/FlowReplyAccessibilityService$Companion;", "", "()V", "TAG", "", "instance", "Lcom/izumih/flowreply/service/FlowReplyAccessibilityService;", "getInstance", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FlowReplyAccessibilityService getInstance() {
            return FlowReplyAccessibilityService.instance;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Message> extractMessagesFromScreen() {
        ArrayList arrayList = new ArrayList();
        AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
        try {
            try {
            } catch (Throwable th) {
                try {
                    rootInActiveWindow.recycle();
                } catch (Exception e) {
                    Log.e(TAG, "Error recycling root node", e);
                }
                throw th;
            }
        } catch (Exception e2) {
            Log.e(TAG, "Error recycling root node", e2);
        }
        if (rootInActiveWindow == null) {
            Log.w(TAG, "No root window available for message extraction");
            return CollectionsKt.emptyList();
        }
        try {
            extractMessagesRecursively(rootInActiveWindow, arrayList);
            Log.d(TAG, "Message extraction complete: " + arrayList.size() + " messages found");
            int i = 0;
            for (Object obj : arrayList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Message message = (Message) obj;
                Log.d(TAG, "Message " + i + ": sender=" + message.getSender() + ", content=" + StringsKt.take(message.getContent(), 50) + "..., isFromUser=" + message.isFromUser());
                i = i2;
            }
            rootInActiveWindow.recycle();
        } catch (Exception e3) {
            Log.e(TAG, "Error extracting messages", e3);
            rootInActiveWindow.recycle();
        }
        int size = arrayList.size();
        return size > 15 ? new ArrayList(arrayList.subList(size - 15, size)) : arrayList;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:2|3)|(15:(19:7|8|9|(15:13|(1:15)|16|17|(10:22|(7:26|27|28|29|(2:31|(2:33|(4:37|(3:62|(3:65|(1:67)(1:68)|63)|69)|41|(9:43|44|(2:48|(1:50))|52|53|54|55|56|57))))|71|(7:37|(1:39)|62|(1:63)|69|41|(0)))|73|74|75|76|(6:78|79|80|81|(5:83|84|86|87|89)(1:116)|90)|120|121|122)|125|(8:24|26|27|28|29|(0)|71|(0))|73|74|75|76|(0)|120|121|122)|129|(0)|16|17|(11:19|22|(0)|73|74|75|76|(0)|120|121|122)|125|(0)|73|74|75|76|(0)|120|121|122)|(16:11|13|(0)|16|17|(0)|125|(0)|73|74|75|76|(0)|120|121|122)|16|17|(0)|125|(0)|73|74|75|76|(0)|120|121|122)|132|8|9|129|(0)|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:(19:7|8|9|(15:13|(1:15)|16|17|(10:22|(7:26|27|28|29|(2:31|(2:33|(4:37|(3:62|(3:65|(1:67)(1:68)|63)|69)|41|(9:43|44|(2:48|(1:50))|52|53|54|55|56|57))))|71|(7:37|(1:39)|62|(1:63)|69|41|(0)))|73|74|75|76|(6:78|79|80|81|(5:83|84|86|87|89)(1:116)|90)|120|121|122)|125|(8:24|26|27|28|29|(0)|71|(0))|73|74|75|76|(0)|120|121|122)|129|(0)|16|17|(11:19|22|(0)|73|74|75|76|(0)|120|121|122)|125|(0)|73|74|75|76|(0)|120|121|122)|(16:11|13|(0)|16|17|(0)|125|(0)|73|74|75|76|(0)|120|121|122)|16|17|(0)|125|(0)|73|74|75|76|(0)|120|121|122) */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x00f0, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044 A[Catch: Exception -> 0x0140, TryCatch #6 {Exception -> 0x0140, blocks: (B:17:0x003d, B:19:0x0044, B:24:0x0050, B:26:0x0057, B:37:0x008b, B:39:0x0092, B:53:0x00d2, B:57:0x00e1, B:62:0x009d, B:63:0x00a1, B:65:0x00a7), top: B:16:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050 A[Catch: Exception -> 0x0140, TryCatch #6 {Exception -> 0x0140, blocks: (B:17:0x003d, B:19:0x0044, B:24:0x0050, B:26:0x0057, B:37:0x008b, B:39:0x0092, B:53:0x00d2, B:57:0x00e1, B:62:0x009d, B:63:0x00a1, B:65:0x00a7), top: B:16:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0077 A[Catch: Exception -> 0x0083, TRY_LEAVE, TryCatch #12 {Exception -> 0x0083, blocks: (B:29:0x0071, B:31:0x0077), top: B:28:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00a7 A[Catch: Exception -> 0x0140, TRY_LEAVE, TryCatch #6 {Exception -> 0x0140, blocks: (B:17:0x003d, B:19:0x0044, B:24:0x0050, B:26:0x0057, B:37:0x008b, B:39:0x0092, B:53:0x00d2, B:57:0x00e1, B:62:0x009d, B:63:0x00a1, B:65:0x00a7), top: B:16:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void extractMessagesRecursively(android.view.accessibility.AccessibilityNodeInfo r17, java.util.List<com.izumih.flowreply.data.Message> r18) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.izumih.flowreply.service.FlowReplyAccessibilityService.extractMessagesRecursively(android.view.accessibility.AccessibilityNodeInfo, java.util.List):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:0|1|2|3|(2:5|6)|7|(2:8|9)|(4:11|12|13|(3:(2:20|(2:22|(2:24|25)(1:(2:27|28)(6:29|30|32|(4:34|35|(3:37|38|(4:51|52|(2:54|56)(1:58)|57)(3:40|41|(2:43|44)(1:46)))(1:73)|45)|77|78))))|80|(0)(0))(2:16|17))|85|12|13|(0)|(0)|80|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x005b, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00eb, code lost:
    
        android.util.Log.e(com.izumih.flowreply.service.FlowReplyAccessibilityService.TAG, "Error in findInputField", r12);
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b A[Catch: Exception -> 0x005b, TryCatch #2 {Exception -> 0x005b, blocks: (B:16:0x0029, B:20:0x004b, B:24:0x0061, B:27:0x0073, B:75:0x00cd, B:35:0x008c, B:60:0x00a3, B:49:0x00b4, B:69:0x00cb, B:72:0x00c6, B:38:0x0092, B:64:0x00bb, B:66:0x00c1, B:41:0x00a9, B:43:0x00af, B:52:0x0098, B:54:0x009e), top: B:13:0x0025, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061 A[Catch: Exception -> 0x005b, TryCatch #2 {Exception -> 0x005b, blocks: (B:16:0x0029, B:20:0x004b, B:24:0x0061, B:27:0x0073, B:75:0x00cd, B:35:0x008c, B:60:0x00a3, B:49:0x00b4, B:69:0x00cb, B:72:0x00c6, B:38:0x0092, B:64:0x00bb, B:66:0x00c1, B:41:0x00a9, B:43:0x00af, B:52:0x0098, B:54:0x009e), top: B:13:0x0025, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.view.accessibility.AccessibilityNodeInfo findInputField(android.view.accessibility.AccessibilityNodeInfo r12) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.izumih.flowreply.service.FlowReplyAccessibilityService.findInputField(android.view.accessibility.AccessibilityNodeInfo):android.view.accessibility.AccessibilityNodeInfo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertTextIntoInputField(String text) {
        AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
        try {
            try {
                if (rootInActiveWindow == null) {
                    Log.e(TAG, "No root node available for inserting text");
                    return;
                }
                try {
                    AccessibilityNodeInfo findInputField = findInputField(rootInActiveWindow);
                    if (findInputField != null) {
                        Log.d(TAG, "Input field found, attempting to insert text: " + StringsKt.take(text, 50) + "...");
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, text);
                        if (findInputField.performAction(2097152, bundle)) {
                            Log.d(TAG, "Text inserted successfully using ACTION_SET_TEXT");
                        } else {
                            Log.d(TAG, "Direct text insertion failed, trying clipboard method");
                            try {
                                Log.d(TAG, "Focus action result: " + findInputField.performAction(1));
                                Object systemService = getSystemService("clipboard");
                                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("flowreply", text));
                                boolean performAction = findInputField.performAction(32768);
                                Log.d(TAG, "Paste action result: " + performAction);
                                if (performAction) {
                                    Log.d(TAG, "Text inserted successfully using clipboard method");
                                } else {
                                    Log.w(TAG, "Both insertion methods failed");
                                }
                            } catch (Exception e) {
                                Log.e(TAG, "Error using clipboard method", e);
                            }
                        }
                        try {
                            findInputField.recycle();
                        } catch (Exception e2) {
                            Log.e(TAG, "Error recycling input field", e2);
                        }
                    } else {
                        Log.w(TAG, "No input field found on screen");
                    }
                    rootInActiveWindow.recycle();
                } catch (Exception e3) {
                    Log.e(TAG, "Error inserting text into input field", e3);
                    rootInActiveWindow.recycle();
                }
            } catch (Throwable th) {
                try {
                    rootInActiveWindow.recycle();
                } catch (Exception e4) {
                    Log.e(TAG, "Error recycling root node", e4);
                }
                throw th;
            }
        } catch (Exception e5) {
            Log.e(TAG, "Error recycling root node", e5);
        }
    }

    private final boolean isUserMessage(AccessibilityNodeInfo node) {
        try {
            Rect rect = new Rect();
            node.getBoundsInScreen(rect);
            return ((double) rect.right) > ((double) getResources().getDisplayMetrics().widthPixels) * 0.6d;
        } catch (Exception e) {
            Log.e(TAG, "Error checking if user message", e);
            return false;
        }
    }

    public final void analyzeAndGenerateResponse() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FlowReplyAccessibilityService$analyzeAndGenerateResponse$1(this, null), 3, null);
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent event) {
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        instance = null;
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
        Log.d(TAG, "Service interrupted");
    }

    @Override // android.accessibilityservice.AccessibilityService
    protected void onServiceConnected() {
        super.onServiceConnected();
        instance = this;
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.eventTypes = 2096;
        accessibilityServiceInfo.feedbackType = 16;
        accessibilityServiceInfo.flags = 80;
        accessibilityServiceInfo.notificationTimeout = 100L;
        setServiceInfo(accessibilityServiceInfo);
        Log.d(TAG, "FlowReply Accessibility Service connected");
    }
}
