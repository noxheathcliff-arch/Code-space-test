package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyStaggeredGridMeasurePolicy.kt */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aw\u0010\u0000\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a)\u0010\u001a\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\u001d\u001a)\u0010\u001e\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\u001d\u001a!\u0010\u001f\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010 \u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"rememberStaggeredGridMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "rememberStaggeredGridMeasurePolicy-1tP8Re8", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;FFLkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "afterPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/unit/LayoutDirection;)F", "beforePadding", "startPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/unit/LayoutDirection;)F", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridMeasurePolicyKt {

    /* compiled from: LazyStaggeredGridMeasurePolicy.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float afterPadding(PaddingValues paddingValues, Orientation orientation, boolean z, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            return z ? paddingValues.getTop() : paddingValues.getBottom();
        }
        if (i == 2) {
            return z ? PaddingKt.calculateStartPadding(paddingValues, layoutDirection) : PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float beforePadding(PaddingValues paddingValues, Orientation orientation, boolean z, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            return z ? paddingValues.getBottom() : paddingValues.getTop();
        }
        if (i == 2) {
            return z ? PaddingKt.calculateEndPadding(paddingValues, layoutDirection) : PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: rememberStaggeredGridMeasurePolicy-1tP8Re8, reason: not valid java name */
    public static final Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> m779rememberStaggeredGridMeasurePolicy1tP8Re8(final LazyStaggeredGridState lazyStaggeredGridState, final Function0<? extends LazyStaggeredGridItemProvider> function0, final PaddingValues paddingValues, final boolean z, final Orientation orientation, final float f, float f2, final CoroutineScope coroutineScope, final LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, Composer composer, int i) {
        composer.startReplaceableGroup(-72951591);
        ComposerKt.sourceInformation(composer, "C(rememberStaggeredGridMeasurePolicy)P(8,3!1,6,5,4:c#ui.unit.Dp,2:c#ui.unit.Dp)48@2083L2788:LazyStaggeredGridMeasurePolicy.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-72951591, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridMeasurePolicy (LazyStaggeredGridMeasurePolicy.kt:48)");
        }
        Object[] objArr = {lazyStaggeredGridState, function0, paddingValues, Boolean.valueOf(z), orientation, Dp.m5791boximpl(f), Dp.m5791boximpl(f2), lazyGridStaggeredGridSlotsProvider};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean z2 = false;
        for (int i2 = 0; i2 < 8; i2++) {
            z2 |= composer.changed(objArr[i2]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyStaggeredGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m780invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyStaggeredGridMeasureResult m780invoke0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
                    float beforePadding;
                    float afterPadding;
                    float startPadding;
                    CheckScrollableContainerConstraintsKt.m241checkScrollableContainerConstraintsK40F9xA(j, Orientation.this);
                    LazyStaggeredGridSlots mo762invoke0kLqBqw = lazyGridStaggeredGridSlotsProvider.mo762invoke0kLqBqw(lazyLayoutMeasureScope, j);
                    boolean z3 = Orientation.this == Orientation.Vertical;
                    LazyStaggeredGridItemProvider invoke = function0.invoke();
                    lazyStaggeredGridState.setSlots$foundation_release(mo762invoke0kLqBqw);
                    lazyStaggeredGridState.setVertical$foundation_release(z3);
                    lazyStaggeredGridState.setSpanProvider$foundation_release(invoke.getSpanProvider());
                    beforePadding = LazyStaggeredGridMeasurePolicyKt.beforePadding(paddingValues, Orientation.this, z, lazyLayoutMeasureScope.getLayoutDirection());
                    int i3 = lazyLayoutMeasureScope.mo310roundToPx0680j_4(beforePadding);
                    afterPadding = LazyStaggeredGridMeasurePolicyKt.afterPadding(paddingValues, Orientation.this, z, lazyLayoutMeasureScope.getLayoutDirection());
                    int i4 = lazyLayoutMeasureScope.mo310roundToPx0680j_4(afterPadding);
                    startPadding = LazyStaggeredGridMeasurePolicyKt.startPadding(paddingValues, Orientation.this, lazyLayoutMeasureScope.getLayoutDirection());
                    int i5 = lazyLayoutMeasureScope.mo310roundToPx0680j_4(startPadding);
                    int m5738getMaxHeightimpl = ((z3 ? Constraints.m5738getMaxHeightimpl(j) : Constraints.m5739getMaxWidthimpl(j)) - i3) - i4;
                    long IntOffset = z3 ? IntOffsetKt.IntOffset(i5, i3) : IntOffsetKt.IntOffset(i3, i5);
                    PaddingValues paddingValues2 = paddingValues;
                    int i6 = lazyLayoutMeasureScope.mo310roundToPx0680j_4(Dp.m5793constructorimpl(PaddingKt.calculateStartPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection()) + PaddingKt.calculateEndPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection())));
                    PaddingValues paddingValues3 = paddingValues;
                    boolean z4 = z3;
                    LazyStaggeredGridMeasureResult m778measureStaggeredGridsdzDtKU = LazyStaggeredGridMeasureKt.m778measureStaggeredGridsdzDtKU(lazyLayoutMeasureScope, lazyStaggeredGridState, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, lazyStaggeredGridState.getPinnedItems(), lazyStaggeredGridState.getBeyondBoundsInfo()), invoke, mo762invoke0kLqBqw, Constraints.m5730copyZbe2FdA$default(j, ConstraintsKt.m5753constrainWidthK40F9xA(j, i6), 0, ConstraintsKt.m5752constrainHeightK40F9xA(j, lazyLayoutMeasureScope.mo310roundToPx0680j_4(Dp.m5793constructorimpl(paddingValues3.getTop() + paddingValues3.getBottom()))), 0, 10, null), z4, z, IntOffset, m5738getMaxHeightimpl, lazyLayoutMeasureScope.mo310roundToPx0680j_4(f), i3, i4, coroutineScope);
                    LazyStaggeredGridState.applyMeasureResult$foundation_release$default(lazyStaggeredGridState, m778measureStaggeredGridsdzDtKU, false, 2, null);
                    return m778measureStaggeredGridsdzDtKU;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> function2 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float startPadding(PaddingValues paddingValues, Orientation orientation, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            return PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
        }
        if (i == 2) {
            return paddingValues.getTop();
        }
        throw new NoWhenBranchMatchedException();
    }
}
