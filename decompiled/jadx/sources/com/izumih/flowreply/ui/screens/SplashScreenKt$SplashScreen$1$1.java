package com.izumih.flowreply.ui.screens;

import androidx.compose.runtime.MutableState;
import androidx.core.view.MotionEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SplashScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.izumih.flowreply.ui.screens.SplashScreenKt$SplashScreen$1$1", f = "SplashScreen.kt", i = {}, l = {MotionEventCompat.AXIS_GENERIC_6, MotionEventCompat.AXIS_GENERIC_7, MotionEventCompat.AXIS_GENERIC_15, MotionEventCompat.AXIS_GENERIC_16, 55, 56, 64, 65, 73, 74}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class SplashScreenKt$SplashScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Float> $buttonAlpha$delegate;
    final /* synthetic */ MutableState<Float> $logoAlpha$delegate;
    final /* synthetic */ MutableState<Float> $signatureAlpha$delegate;
    final /* synthetic */ MutableState<Float> $taglineAlpha$delegate;
    final /* synthetic */ MutableState<Float> $titleAlpha$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SplashScreenKt$SplashScreen$1$1(MutableState<Float> mutableState, MutableState<Float> mutableState2, MutableState<Float> mutableState3, MutableState<Float> mutableState4, MutableState<Float> mutableState5, Continuation<? super SplashScreenKt$SplashScreen$1$1> continuation) {
        super(2, continuation);
        this.$logoAlpha$delegate = mutableState;
        this.$titleAlpha$delegate = mutableState2;
        this.$taglineAlpha$delegate = mutableState3;
        this.$signatureAlpha$delegate = mutableState4;
        this.$buttonAlpha$delegate = mutableState5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashScreenKt$SplashScreen$1$1(this.$logoAlpha$delegate, this.$titleAlpha$delegate, this.$taglineAlpha$delegate, this.$signatureAlpha$delegate, this.$buttonAlpha$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SplashScreenKt$SplashScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x015f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0135 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0127 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00fd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0084 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.izumih.flowreply.ui.screens.SplashScreenKt$SplashScreen$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
