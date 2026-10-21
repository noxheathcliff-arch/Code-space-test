package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyGridMeasure.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\bH\u0083\b\u001a\u008c\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002\u001aõ\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042/\u00105\u001a+\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u0002080\b¢\u0006\u0002\b9\u0012\u0004\u0012\u00020:06H\u0000ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"calculateExtraItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "pinnedItems", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "itemConstraints", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Constraints;", "filter", "", "calculateItemsOffsets", "", "lines", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "isVertical", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-W2FL7xs", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;Ljava/util/List;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridMeasureKt {
    private static final List<LazyGridMeasuredItem> calculateExtraItems(List<Integer> list, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, Function1<? super Integer, Constraints> function1, Function1<? super Integer, Boolean> function12) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            int intValue = list.get(i).intValue();
            if (function12.invoke(Integer.valueOf(intValue)).booleanValue()) {
                LazyGridMeasuredItem m710getAndMeasure3p2s80s$default = LazyGridMeasuredItemProvider.m710getAndMeasure3p2s80s$default(lazyGridMeasuredItemProvider, intValue, 0, function1.invoke(Integer.valueOf(intValue)).getValue(), 2, null);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(m710getAndMeasure3p2s80s$default);
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyGridMeasuredItem> calculateItemsOffsets(List<LazyGridMeasuredLine> list, List<LazyGridMeasuredItem> list2, List<LazyGridMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3) {
            if (!(i5 == 0)) {
                throw new IllegalStateException("non-zero firstLineScrollOffset".toString());
            }
        }
        int size = list.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            i7 += list.get(i8).getItems().length;
        }
        ArrayList arrayList = new ArrayList(i7);
        if (z3) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                throw new IllegalArgumentException("no items".toString());
            }
            int size2 = list.size();
            int[] iArr = new int[size2];
            for (int i9 = 0; i9 < size2; i9++) {
                iArr[i9] = list.get(calculateItemsOffsets$reverseAware(i9, z2, size2)).getMainAxisSize();
            }
            int[] iArr2 = new int[size2];
            for (int i10 = 0; i10 < size2; i10++) {
                iArr2[i10] = 0;
            }
            if (z) {
                if (vertical == null) {
                    throw new IllegalArgumentException("null verticalArrangement".toString());
                }
                vertical.arrange(density, i6, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    throw new IllegalArgumentException("null horizontalArrangement".toString());
                }
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z2) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i11 = iArr2[first];
                    LazyGridMeasuredLine lazyGridMeasuredLine = list.get(calculateItemsOffsets$reverseAware(first, z2, size2));
                    if (z2) {
                        i11 = (i6 - i11) - lazyGridMeasuredLine.getMainAxisSize();
                    }
                    CollectionsKt.addAll(arrayList, lazyGridMeasuredLine.position(i11, i, i2));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list2.size() - 1;
            if (size3 >= 0) {
                int i12 = i5;
                while (true) {
                    int i13 = size3 - 1;
                    LazyGridMeasuredItem lazyGridMeasuredItem = list2.get(size3);
                    int mainAxisSizeWithSpacings = i12 - lazyGridMeasuredItem.getMainAxisSizeWithSpacings();
                    lazyGridMeasuredItem.position(mainAxisSizeWithSpacings, 0, i, i2, (r16 & 16) != 0 ? -1 : 0, (r16 & 32) != 0 ? -1 : 0);
                    arrayList.add(lazyGridMeasuredItem);
                    if (i13 < 0) {
                        break;
                    }
                    size3 = i13;
                    i12 = mainAxisSizeWithSpacings;
                }
            }
            int size4 = list.size();
            int i14 = i5;
            for (int i15 = 0; i15 < size4; i15++) {
                LazyGridMeasuredLine lazyGridMeasuredLine2 = list.get(i15);
                CollectionsKt.addAll(arrayList, lazyGridMeasuredLine2.position(i14, i, i2));
                i14 += lazyGridMeasuredLine2.getMainAxisSizeWithSpacings();
            }
            int i16 = i14;
            int i17 = 0;
            for (int size5 = list3.size(); i17 < size5; size5 = size5) {
                LazyGridMeasuredItem lazyGridMeasuredItem2 = list3.get(i17);
                lazyGridMeasuredItem2.position(i16, 0, i, i2, (r16 & 16) != 0 ? -1 : 0, (r16 & 32) != 0 ? -1 : 0);
                arrayList.add(lazyGridMeasuredItem2);
                i16 += lazyGridMeasuredItem2.getMainAxisSizeWithSpacings();
                i17++;
            }
        }
        return arrayList;
    }

    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* renamed from: measureLazyGrid-W2FL7xs, reason: not valid java name */
    public static final LazyGridMeasureResult m707measureLazyGridW2FL7xs(int i, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider, List<Integer> list, CoroutineScope coroutineScope, final MutableState<Unit> mutableState, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        boolean z3;
        int i8;
        int i9;
        int i10;
        LazyGridMeasuredLine lazyGridMeasuredLine;
        LazyGridMeasuredLine lazyGridMeasuredLine2;
        int i11;
        List<LazyGridMeasuredItem> list2;
        int i12;
        LazyGridMeasuredItem[] items;
        LazyGridMeasuredItem lazyGridMeasuredItem;
        int i13;
        int i14;
        boolean z4;
        int i15;
        List<Integer> list3 = list;
        if (!(i3 >= 0)) {
            throw new IllegalArgumentException("negative beforeContentPadding".toString());
        }
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException("negative afterContentPadding".toString());
        }
        if (i <= 0) {
            return new LazyGridMeasureResult(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(Constraints.m5741getMinWidthimpl(j)), Integer.valueOf(Constraints.m5740getMinHeightimpl(j)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }
            }), false, CollectionsKt.emptyList(), -i3, i2 + i4, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
        }
        int roundToInt = MathKt.roundToInt(f);
        int i16 = i7 - roundToInt;
        if (i6 == 0 && i16 < 0) {
            roundToInt += i16;
            i16 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i17 = -i3;
        int i18 = (i5 < 0 ? i5 : 0) + i17;
        int i19 = i16 + i18;
        int i20 = i6;
        while (i19 < 0 && i20 > 0) {
            i20--;
            LazyGridMeasuredLine andMeasure = lazyGridMeasuredLineProvider.getAndMeasure(i20);
            arrayDeque.add(0, andMeasure);
            i19 += andMeasure.getMainAxisSizeWithSpacings();
        }
        if (i19 < i18) {
            roundToInt += i19;
            i19 = i18;
        }
        int i21 = i19 - i18;
        int i22 = i2 + i4;
        int i23 = i20;
        int coerceAtLeast = RangesKt.coerceAtLeast(i22, 0);
        int i24 = -i21;
        int i25 = i23;
        int i26 = i21;
        int i27 = 0;
        boolean z5 = false;
        while (i27 < arrayDeque.size()) {
            if (i24 >= coerceAtLeast) {
                arrayDeque.remove(i27);
                z5 = true;
            } else {
                i25++;
                i24 += ((LazyGridMeasuredLine) arrayDeque.get(i27)).getMainAxisSizeWithSpacings();
                i27++;
            }
        }
        int i28 = i25;
        boolean z6 = z5;
        while (i28 < i && (i24 < coerceAtLeast || i24 <= 0 || arrayDeque.isEmpty())) {
            int i29 = coerceAtLeast;
            LazyGridMeasuredLine andMeasure2 = lazyGridMeasuredLineProvider.getAndMeasure(i28);
            if (andMeasure2.isEmpty()) {
                break;
            }
            int mainAxisSizeWithSpacings = i24 + andMeasure2.getMainAxisSizeWithSpacings();
            if (mainAxisSizeWithSpacings <= i18) {
                i13 = mainAxisSizeWithSpacings;
                i14 = i18;
                if (((LazyGridMeasuredItem) ArraysKt.last(andMeasure2.getItems())).getIndex() != i - 1) {
                    i15 = i28 + 1;
                    i26 -= andMeasure2.getMainAxisSizeWithSpacings();
                    z4 = true;
                    i28++;
                    i23 = i15;
                    z6 = z4;
                    coerceAtLeast = i29;
                    i18 = i14;
                    i24 = i13;
                }
            } else {
                i13 = mainAxisSizeWithSpacings;
                i14 = i18;
            }
            arrayDeque.add(andMeasure2);
            z4 = z6;
            i15 = i23;
            i28++;
            i23 = i15;
            z6 = z4;
            coerceAtLeast = i29;
            i18 = i14;
            i24 = i13;
        }
        if (i24 < i2) {
            int i30 = i2 - i24;
            i24 += i30;
            int i31 = i23;
            i10 = i26 - i30;
            while (i10 < i3 && i31 > 0) {
                i31--;
                int i32 = i17;
                LazyGridMeasuredLine andMeasure3 = lazyGridMeasuredLineProvider.getAndMeasure(i31);
                arrayDeque.add(0, andMeasure3);
                i10 += andMeasure3.getMainAxisSizeWithSpacings();
                z6 = z6;
                i17 = i32;
            }
            z3 = z6;
            i8 = i17;
            i9 = 0;
            roundToInt += i30;
            if (i10 < 0) {
                roundToInt += i10;
                i24 += i10;
                i10 = 0;
            }
        } else {
            z3 = z6;
            i8 = i17;
            i9 = 0;
            i10 = i26;
        }
        float f2 = (MathKt.getSign(MathKt.roundToInt(f)) != MathKt.getSign(roundToInt) || Math.abs(MathKt.roundToInt(f)) < Math.abs(roundToInt)) ? f : roundToInt;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException("negative initial offset".toString());
        }
        int i33 = -i10;
        LazyGridMeasuredLine lazyGridMeasuredLine3 = (LazyGridMeasuredLine) arrayDeque.first();
        LazyGridMeasuredItem lazyGridMeasuredItem2 = (LazyGridMeasuredItem) ArraysKt.firstOrNull(lazyGridMeasuredLine3.getItems());
        int index = lazyGridMeasuredItem2 != null ? lazyGridMeasuredItem2.getIndex() : 0;
        LazyGridMeasuredLine lazyGridMeasuredLine4 = (LazyGridMeasuredLine) arrayDeque.lastOrNull();
        if (lazyGridMeasuredLine4 == null || (items = lazyGridMeasuredLine4.getItems()) == null || (lazyGridMeasuredItem = (LazyGridMeasuredItem) ArraysKt.lastOrNull(items)) == null) {
            lazyGridMeasuredLine = lazyGridMeasuredLine3;
        } else {
            lazyGridMeasuredLine = lazyGridMeasuredLine3;
            i9 = lazyGridMeasuredItem.getIndex();
        }
        int size = list.size();
        ArrayList arrayList = null;
        int i34 = i10;
        ArrayList arrayList2 = null;
        int i35 = 0;
        while (i35 < size) {
            int i36 = size;
            int intValue = list3.get(i35).intValue();
            if (intValue >= 0 && intValue < index) {
                LazyGridMeasuredItem m710getAndMeasure3p2s80s$default = LazyGridMeasuredItemProvider.m710getAndMeasure3p2s80s$default(lazyGridMeasuredItemProvider, intValue, 0, lazyGridMeasuredLineProvider.m713itemConstraintsOenEA2s(intValue), 2, null);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                i12 = index;
                List list4 = arrayList2;
                list4.add(m710getAndMeasure3p2s80s$default);
                arrayList2 = list4;
            } else {
                i12 = index;
            }
            i35++;
            index = i12;
            size = i36;
        }
        int i37 = index;
        if (arrayList2 == null) {
            arrayList2 = CollectionsKt.emptyList();
        }
        List list5 = arrayList2;
        int size2 = list.size();
        int i38 = 0;
        while (i38 < size2) {
            int intValue2 = list3.get(i38).intValue();
            if (i9 + 1 <= intValue2 && intValue2 < i) {
                LazyGridMeasuredItem m710getAndMeasure3p2s80s$default2 = LazyGridMeasuredItemProvider.m710getAndMeasure3p2s80s$default(lazyGridMeasuredItemProvider, intValue2, 0, lazyGridMeasuredLineProvider.m713itemConstraintsOenEA2s(intValue2), 2, null);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                List list6 = arrayList;
                list6.add(m710getAndMeasure3p2s80s$default2);
                arrayList = list6;
            }
            i38++;
            list3 = list;
        }
        if (arrayList == null) {
            arrayList = CollectionsKt.emptyList();
        }
        List list7 = arrayList;
        if (i3 > 0 || i5 < 0) {
            int size3 = arrayDeque.size();
            LazyGridMeasuredLine lazyGridMeasuredLine5 = lazyGridMeasuredLine;
            int i39 = i34;
            int i40 = 0;
            while (i40 < size3) {
                int mainAxisSizeWithSpacings2 = ((LazyGridMeasuredLine) arrayDeque.get(i40)).getMainAxisSizeWithSpacings();
                if (i39 == 0 || mainAxisSizeWithSpacings2 > i39) {
                    break;
                }
                int i41 = size3;
                if (i40 == CollectionsKt.getLastIndex(arrayDeque)) {
                    break;
                }
                i39 -= mainAxisSizeWithSpacings2;
                i40++;
                lazyGridMeasuredLine5 = (LazyGridMeasuredLine) arrayDeque.get(i40);
                size3 = i41;
            }
            lazyGridMeasuredLine2 = lazyGridMeasuredLine5;
            i11 = i39;
        } else {
            lazyGridMeasuredLine2 = lazyGridMeasuredLine;
            i11 = i34;
        }
        int m5739getMaxWidthimpl = z ? Constraints.m5739getMaxWidthimpl(j) : ConstraintsKt.m5753constrainWidthK40F9xA(j, i24);
        int m5752constrainHeightK40F9xA = z ? ConstraintsKt.m5752constrainHeightK40F9xA(j, i24) : Constraints.m5738getMaxHeightimpl(j);
        int i42 = i8;
        final List<LazyGridMeasuredItem> calculateItemsOffsets = calculateItemsOffsets(arrayDeque, list5, list7, m5739getMaxWidthimpl, m5752constrainHeightK40F9xA, i24, i2, i33, z, vertical, horizontal, z2, density);
        lazyGridItemPlacementAnimator.onMeasured((int) f2, m5739getMaxWidthimpl, m5752constrainHeightK40F9xA, calculateItemsOffsets, lazyGridMeasuredItemProvider, lazyGridSpanLayoutProvider, z, coroutineScope);
        boolean z7 = i9 != i + (-1) || i24 > i2;
        MeasureResult invoke = function3.invoke(Integer.valueOf(m5739getMaxWidthimpl), Integer.valueOf(m5752constrainHeightK40F9xA), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                List<LazyGridMeasuredItem> list8 = calculateItemsOffsets;
                int size4 = list8.size();
                for (int i43 = 0; i43 < size4; i43++) {
                    list8.get(i43).place(placementScope);
                }
                ObservableScopeInvalidator.m745attachToScopeimpl(mutableState);
            }
        });
        if (list5.isEmpty() && list7.isEmpty()) {
            list2 = calculateItemsOffsets;
        } else {
            ArrayList arrayList3 = new ArrayList(calculateItemsOffsets.size());
            int size4 = calculateItemsOffsets.size();
            for (int i43 = 0; i43 < size4; i43++) {
                LazyGridMeasuredItem lazyGridMeasuredItem3 = calculateItemsOffsets.get(i43);
                int index2 = lazyGridMeasuredItem3.getIndex();
                if (i37 <= index2 && index2 <= i9) {
                    arrayList3.add(lazyGridMeasuredItem3);
                }
            }
            list2 = arrayList3;
        }
        return new LazyGridMeasureResult(lazyGridMeasuredLine2, i11, z7, f2, invoke, z3, list2, i42, i22, i, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
    }
}
