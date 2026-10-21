package com.izumih.flowreply.ui.screens;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.core.view.MotionEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: OnboardingScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.izumih.flowreply.ui.screens.OnboardingScreenKt$OnboardingScreen$1", f = "OnboardingScreen.kt", i = {}, l = {MotionEventCompat.AXIS_GENERIC_8}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class OnboardingScreenKt$OnboardingScreen$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $accessibilityPermissionGranted$delegate;
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<Boolean> $overlayPermissionGranted$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingScreenKt$OnboardingScreen$1(Context context, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super OnboardingScreenKt$OnboardingScreen$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$overlayPermissionGranted$delegate = mutableState;
        this.$accessibilityPermissionGranted$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingScreenKt$OnboardingScreen$1(this.$context, this.$overlayPermissionGranted$delegate, this.$accessibilityPermissionGranted$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OnboardingScreenKt$OnboardingScreen$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0027 -> B:5:0x002a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L18
            if (r1 != r2) goto L10
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
            goto L2a
        L10:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L18:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
        L1c:
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.label = r2
            r3 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r3, r1)
            if (r1 != r0) goto L2a
            return r0
        L2a:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r1 = r6.$overlayPermissionGranted$delegate
            com.izumih.flowreply.util.PermissionHelper r3 = com.izumih.flowreply.util.PermissionHelper.INSTANCE
            android.content.Context r4 = r6.$context
            boolean r3 = r3.canDrawOverlays(r4)
            com.izumih.flowreply.ui.screens.OnboardingScreenKt.access$OnboardingScreen$lambda$5(r1, r3)
            androidx.compose.runtime.MutableState<java.lang.Boolean> r1 = r6.$accessibilityPermissionGranted$delegate
            com.izumih.flowreply.util.PermissionHelper r3 = com.izumih.flowreply.util.PermissionHelper.INSTANCE
            android.content.Context r4 = r6.$context
            boolean r3 = r3.isAccessibilityServiceEnabled(r4)
            com.izumih.flowreply.ui.screens.OnboardingScreenKt.access$OnboardingScreen$lambda$8(r1, r3)
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.izumih.flowreply.ui.screens.OnboardingScreenKt$OnboardingScreen$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
