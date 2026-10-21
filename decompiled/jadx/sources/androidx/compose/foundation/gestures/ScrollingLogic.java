package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\b \u0010\u001cJ\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\tJ\u0006\u0010(\u001a\u00020\tJ8\u0010)\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ$\u0010*\u001a\u00020\"*\u00020+2\u0006\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020.ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u0014\u00101\u001a\u00020\"*\u00020\"ø\u0001\u0000¢\u0006\u0004\b2\u0010%J\n\u00101\u001a\u000203*\u000203J\u0014\u00104\u001a\u00020\"*\u00020\"ø\u0001\u0000¢\u0006\u0004\b5\u0010%J\u0014\u00106\u001a\u00020\u0019*\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b7\u0010%J\u0014\u00108\u001a\u000203*\u00020\"ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0014\u00108\u001a\u000203*\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b;\u0010:J\u0017\u0010<\u001a\u00020\"*\u000203ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u001c\u0010)\u001a\u00020\u0019*\u00020\u00192\u0006\u0010?\u001a\u000203ø\u0001\u0000¢\u0006\u0004\b@\u0010AR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "reverseDirection", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/OverscrollEffect;ZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "isNestedFlinging", "Landroidx/compose/runtime/MutableState;", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "setScrollableState", "(Landroidx/compose/foundation/gestures/ScrollableState;)V", "shouldDispatchOverscroll", "getShouldDispatchOverscroll", "()Z", "doFlingAnimation", "Landroidx/compose/ui/unit/Velocity;", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "", "initialVelocity", "onDragStopped-sF-c-tU", "performRawScroll", "Landroidx/compose/ui/geometry/Offset;", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "registerNestedFling", "isFlinging", "shouldScrollImmediately", "update", "dispatchScroll", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialAvailableDelta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "newValue", "update-QWom1Mo", "(JF)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class ScrollingLogic {
    private FlingBehavior flingBehavior;
    private final MutableState<Boolean> isNestedFlinging = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    private NestedScrollDispatcher nestedScrollDispatcher;
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    private boolean reverseDirection;
    private ScrollableState scrollableState;

    public ScrollingLogic(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        this.scrollableState = scrollableState;
        this.orientation = orientation;
        this.overscrollEffect = overscrollEffect;
        this.reverseDirection = z;
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
    }

    private final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    /* renamed from: dispatchScroll-3eAAhYA, reason: not valid java name */
    public final long m406dispatchScroll3eAAhYA(final ScrollScope scrollScope, long j, final int i) {
        Function1<Offset, Offset> function1 = new Function1<Offset, Offset>() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$dispatchScroll$performScroll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Offset invoke(Offset offset) {
                return Offset.m3182boximpl(m417invokeMKHz9U(offset.getPackedValue()));
            }

            /* renamed from: invoke-MK-Hz9U, reason: not valid java name */
            public final long m417invokeMKHz9U(long j2) {
                NestedScrollDispatcher nestedScrollDispatcher;
                NestedScrollDispatcher nestedScrollDispatcher2;
                nestedScrollDispatcher = ScrollingLogic.this.nestedScrollDispatcher;
                long m4480dispatchPreScrollOzD1aCk = nestedScrollDispatcher.m4480dispatchPreScrollOzD1aCk(j2, i);
                long m3197minusMKHz9U = Offset.m3197minusMKHz9U(j2, m4480dispatchPreScrollOzD1aCk);
                ScrollingLogic scrollingLogic = ScrollingLogic.this;
                float m414toFloatk4lQ0M = scrollingLogic.m414toFloatk4lQ0M(scrollingLogic.m410reverseIfNeededMKHz9U(scrollingLogic.m411singleAxisOffsetMKHz9U(m3197minusMKHz9U)));
                ScrollingLogic scrollingLogic2 = ScrollingLogic.this;
                long m410reverseIfNeededMKHz9U = scrollingLogic2.m410reverseIfNeededMKHz9U(scrollingLogic2.m415toOffsettuRUvjQ(scrollScope.scrollBy(m414toFloatk4lQ0M)));
                long m3197minusMKHz9U2 = Offset.m3197minusMKHz9U(m3197minusMKHz9U, m410reverseIfNeededMKHz9U);
                nestedScrollDispatcher2 = ScrollingLogic.this.nestedScrollDispatcher;
                return Offset.m3198plusMKHz9U(Offset.m3198plusMKHz9U(m4480dispatchPreScrollOzD1aCk, m410reverseIfNeededMKHz9U), nestedScrollDispatcher2.m4478dispatchPostScrollDzOQY0M(m410reverseIfNeededMKHz9U, m3197minusMKHz9U2, i));
            }
        };
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        return NestedScrollSource.m4484equalsimpl0(i, NestedScrollSource.INSTANCE.m4492getWheelWNlRxjI()) ? function1.invoke(Offset.m3182boximpl(j)).getPackedValue() : (overscrollEffect == null || !getShouldDispatchOverscroll()) ? function1.invoke(Offset.m3182boximpl(j)).getPackedValue() : overscrollEffect.mo193applyToScrollRhakbz0(j, i, function1);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m407doFlingAnimationQWom1Mo(long r13, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L14
            r0 = r15
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r12, r15)
        L19:
            r4 = r0
            java.lang.Object r15 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L2f
            java.lang.Object r13 = r4.L$0
            kotlin.jvm.internal.Ref$LongRef r13 = (kotlin.jvm.internal.Ref.LongRef) r13
            kotlin.ResultKt.throwOnFailure(r15)
            goto L62
        L2f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L38:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlin.jvm.internal.Ref$LongRef r15 = new kotlin.jvm.internal.Ref$LongRef
            r15.<init>()
            r15.element = r13
            androidx.compose.foundation.gestures.ScrollableState r1 = r12.scrollableState
            r3 = 0
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r11 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r10 = 0
            r5 = r11
            r6 = r12
            r7 = r15
            r8 = r13
            r5.<init>(r6, r7, r8, r10)
            r13 = r11
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r5 = 1
            r6 = 0
            r4.L$0 = r15
            r4.label = r2
            r2 = r3
            r3 = r13
            java.lang.Object r13 = androidx.compose.foundation.gestures.ScrollableState.CC.scroll$default(r1, r2, r3, r4, r5, r6)
            if (r13 != r0) goto L61
            return r0
        L61:
            r13 = r15
        L62:
            long r13 = r13.element
            androidx.compose.ui.unit.Velocity r13 = androidx.compose.ui.unit.Velocity.m6023boximpl(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m407doFlingAnimationQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: onDragStopped-sF-c-tU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m408onDragStoppedsFctU(long r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            r0.<init>(r6, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 == r4) goto L33
            if (r2 != r3) goto L2a
            goto L33
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            java.lang.Object r7 = r0.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r7 = (androidx.compose.foundation.gestures.ScrollingLogic) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L73
        L3b:
            kotlin.ResultKt.throwOnFailure(r9)
            r6.registerNestedFling(r4)
            long r7 = r6.m412singleAxisVelocityAH228Gc(r7)
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1 r9 = new androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1
            r2 = 0
            r9.<init>(r6, r2)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            androidx.compose.foundation.OverscrollEffect r2 = r6.overscrollEffect
            if (r2 == 0) goto L64
            boolean r5 = r6.getShouldDispatchOverscroll()
            if (r5 == 0) goto L64
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r2.mo192applyToFlingBMRW4eQ(r7, r9, r0)
            if (r7 != r1) goto L62
            return r1
        L62:
            r7 = r6
            goto L73
        L64:
            androidx.compose.ui.unit.Velocity r7 = androidx.compose.ui.unit.Velocity.m6023boximpl(r7)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r9.invoke(r7, r0)
            if (r7 != r1) goto L62
            return r1
        L73:
            r8 = 0
            r7.registerNestedFling(r8)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m408onDragStoppedsFctU(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: performRawScroll-MK-Hz9U, reason: not valid java name */
    public final long m409performRawScrollMKHz9U(long scroll) {
        return this.scrollableState.isScrollInProgress() ? Offset.INSTANCE.m3209getZeroF1C5BW0() : m415toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m414toFloatk4lQ0M(scroll)))));
    }

    public final void registerNestedFling(boolean isFlinging) {
        this.isNestedFlinging.setValue(Boolean.valueOf(isFlinging));
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * (-1) : f;
    }

    /* renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m410reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m3200timestuRUvjQ(j, -1.0f) : j;
    }

    public final void setScrollableState(ScrollableState scrollableState) {
        this.scrollableState = scrollableState;
    }

    public final boolean shouldScrollImmediately() {
        if (!this.scrollableState.isScrollInProgress() && !this.isNestedFlinging.getValue().booleanValue()) {
            OverscrollEffect overscrollEffect = this.overscrollEffect;
            if (!(overscrollEffect != null ? overscrollEffect.isInProgress() : false)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: singleAxisOffset-MK-Hz9U, reason: not valid java name */
    public final long m411singleAxisOffsetMKHz9U(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m3187copydBAh8RU$default(j, 0.0f, 0.0f, 1, null) : Offset.m3187copydBAh8RU$default(j, 0.0f, 0.0f, 2, null);
    }

    /* renamed from: singleAxisVelocity-AH228Gc, reason: not valid java name */
    public final long m412singleAxisVelocityAH228Gc(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m6028copyOhffZ5M$default(j, 0.0f, 0.0f, 1, null) : Velocity.m6028copyOhffZ5M$default(j, 0.0f, 0.0f, 2, null);
    }

    /* renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m413toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m6032getXimpl(j) : Velocity.m6033getYimpl(j);
    }

    /* renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m414toFloatk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m3193getXimpl(j) : Offset.m3194getYimpl(j);
    }

    /* renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m415toOffsettuRUvjQ(float f) {
        return (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) == 0 ? Offset.INSTANCE.m3209getZeroF1C5BW0() : this.orientation == Orientation.Horizontal ? OffsetKt.Offset(f, 0.0f) : OffsetKt.Offset(0.0f, f);
    }

    public final void update(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean reverseDirection, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        this.scrollableState = scrollableState;
        this.orientation = orientation;
        this.overscrollEffect = overscrollEffect;
        this.reverseDirection = reverseDirection;
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
    }

    /* renamed from: update-QWom1Mo, reason: not valid java name */
    public final long m416updateQWom1Mo(long j, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m6028copyOhffZ5M$default(j, f, 0.0f, 2, null) : Velocity.m6028copyOhffZ5M$default(j, 0.0f, f, 1, null);
    }
}
