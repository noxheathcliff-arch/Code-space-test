package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.core.view.MotionEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: PressDownGesture.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.selection.PressDownGestureKt$detectPressDownGesture$2", f = "PressDownGesture.kt", i = {0, 1, 1}, l = {32, MotionEventCompat.AXIS_GENERIC_7}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes.dex */
final class PressDownGestureKt$detectPressDownGesture$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TapOnPosition $onDown;
    final /* synthetic */ Function0<Unit> $onUp;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PressDownGestureKt$detectPressDownGesture$2(TapOnPosition tapOnPosition, Function0<Unit> function0, Continuation<? super PressDownGestureKt$detectPressDownGesture$2> continuation) {
        super(2, continuation);
        this.$onDown = tapOnPosition;
        this.$onUp = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PressDownGestureKt$detectPressDownGesture$2 pressDownGestureKt$detectPressDownGesture$2 = new PressDownGestureKt$detectPressDownGesture$2(this.$onDown, this.$onUp, continuation);
        pressDownGestureKt$detectPressDownGesture$2.L$0 = obj;
        return pressDownGestureKt$detectPressDownGesture$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((PressDownGestureKt$detectPressDownGesture$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a4 A[EDGE_INSN: B:26:0x00a4->B:17:0x00a4 BREAK  A[LOOP:0: B:7:0x007e->B:14:0x00a1], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0080  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006f -> B:6:0x0072). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 == r4) goto L28
            if (r2 != r3) goto L1f
            java.lang.Object r2 = r0.L$1
            androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            kotlin.ResultKt.throwOnFailure(r18)
            r7 = r18
            r6 = r0
            goto L72
        L1f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L28:
            java.lang.Object r2 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            kotlin.ResultKt.throwOnFailure(r18)
            r5 = r18
            goto L4c
        L32:
            kotlin.ResultKt.throwOnFailure(r18)
            java.lang.Object r2 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            r6 = 0
            r7 = 0
            r8 = r0
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r9 = 2
            r10 = 0
            r0.L$0 = r2
            r0.label = r4
            r5 = r2
            java.lang.Object r5 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            androidx.compose.foundation.text2.input.internal.selection.TapOnPosition r6 = r0.$onDown
            long r7 = r5.getPosition()
            r6.mo1178onEventk4lQ0M(r7)
            kotlin.jvm.functions.Function0<kotlin.Unit> r6 = r0.$onUp
            if (r6 == 0) goto Lab
            r6 = r0
            r16 = r5
            r5 = r2
            r2 = r16
        L61:
            r7 = r6
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r6.L$0 = r5
            r6.L$1 = r2
            r6.label = r3
            r8 = 0
            java.lang.Object r7 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r5, r8, r7, r4, r8)
            if (r7 != r1) goto L72
            return r1
        L72:
            androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
            java.util.List r7 = r7.getChanges()
            int r8 = r7.size()
            r9 = 0
            r10 = 0
        L7e:
            if (r10 >= r8) goto La4
            java.lang.Object r11 = r7.get(r10)
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            long r12 = r11.getId()
            long r14 = r2.getId()
            boolean r12 = androidx.compose.ui.input.pointer.PointerId.m4578equalsimpl0(r12, r14)
            if (r12 == 0) goto L9c
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L9c
            r11 = 1
            goto L9d
        L9c:
            r11 = 0
        L9d:
            if (r11 == 0) goto La1
            r9 = 1
            goto La4
        La1:
            int r10 = r10 + 1
            goto L7e
        La4:
            if (r9 != 0) goto L61
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r6.$onUp
            r1.invoke()
        Lab:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.PressDownGestureKt$detectPressDownGesture$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
