package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: RowColumnMeasurementHelper.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012¢\u0006\u0002\u0010\u0014J2\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00132\b\u0010-\u001a\u0004\u0018\u00010&2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020+H\u0002J(\u00102\u001a\u0002032\u0006\u00104\u001a\u00020+2\u0006\u00105\u001a\u0002032\u0006\u00102\u001a\u0002032\u0006\u00106\u001a\u000207H\u0002J0\u00108\u001a\u0002092\u0006\u00106\u001a\u0002072\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\b>\u0010?J&\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020+2\u0006\u0010/\u001a\u000200J\n\u0010\n\u001a\u00020+*\u00020\u0013J\n\u0010F\u001a\u00020+*\u00020\u0013R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001b\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0018\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;", "", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "arrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSize", "Landroidx/compose/foundation/layout/SizeMode;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "(Landroidx/compose/foundation/layout/LayoutOrientation;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getArrangementSpacing-D9Ej5fM", "()F", "F", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisSize", "()Landroidx/compose/foundation/layout/SizeMode;", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getMeasurables", "()Ljava/util/List;", "getOrientation", "()Landroidx/compose/foundation/layout/LayoutOrientation;", "getPlaceables", "()[Landroidx/compose/ui/layout/Placeable;", "[Landroidx/compose/ui/layout/Placeable;", "rowColumnParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "[Landroidx/compose/foundation/layout/RowColumnParentData;", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getCrossAxisPosition", "", "placeable", "parentData", "crossAxisLayoutSize", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "beforeCrossAxisAlignmentLine", "mainAxisPositions", "", "mainAxisLayoutSize", "childrenMainAxisSize", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measureWithoutPlacing", "Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "startIndex", "endIndex", "measureWithoutPlacing-_EkL_-Y", "(Landroidx/compose/ui/layout/MeasureScope;JII)Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;", "placeHelper", "", "placeableScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "measureResult", "crossAxisOffset", "mainAxisSize", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RowColumnMeasurementHelper {
    public static final int $stable = 8;
    private final float arrangementSpacing;
    private final CrossAxisAlignment crossAxisAlignment;
    private final SizeMode crossAxisSize;
    private final Arrangement.Horizontal horizontalArrangement;
    private final List<Measurable> measurables;
    private final LayoutOrientation orientation;
    private final Placeable[] placeables;
    private final RowColumnParentData[] rowColumnParentData;
    private final Arrangement.Vertical verticalArrangement;

    /* JADX WARN: Multi-variable type inference failed */
    private RowColumnMeasurementHelper(LayoutOrientation layoutOrientation, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment, List<? extends Measurable> list, Placeable[] placeableArr) {
        this.orientation = layoutOrientation;
        this.horizontalArrangement = horizontal;
        this.verticalArrangement = vertical;
        this.arrangementSpacing = f;
        this.crossAxisSize = sizeMode;
        this.crossAxisAlignment = crossAxisAlignment;
        this.measurables = list;
        this.placeables = placeableArr;
        int size = list.size();
        RowColumnParentData[] rowColumnParentDataArr = new RowColumnParentData[size];
        for (int i = 0; i < size; i++) {
            rowColumnParentDataArr[i] = RowColumnImplKt.getRowColumnParentData(this.measurables.get(i));
        }
        this.rowColumnParentData = rowColumnParentDataArr;
    }

    public /* synthetic */ RowColumnMeasurementHelper(LayoutOrientation layoutOrientation, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment, List list, Placeable[] placeableArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutOrientation, horizontal, vertical, f, sizeMode, crossAxisAlignment, list, placeableArr);
    }

    private final int getCrossAxisPosition(Placeable placeable, RowColumnParentData parentData, int crossAxisLayoutSize, LayoutDirection layoutDirection, int beforeCrossAxisAlignmentLine) {
        CrossAxisAlignment crossAxisAlignment;
        if (parentData == null || (crossAxisAlignment = parentData.getCrossAxisAlignment()) == null) {
            crossAxisAlignment = this.crossAxisAlignment;
        }
        int crossAxisSize = crossAxisLayoutSize - crossAxisSize(placeable);
        if (this.orientation == LayoutOrientation.Horizontal) {
            layoutDirection = LayoutDirection.Ltr;
        }
        return crossAxisAlignment.align$foundation_layout_release(crossAxisSize, layoutDirection, placeable, beforeCrossAxisAlignmentLine);
    }

    private final int[] mainAxisPositions(int mainAxisLayoutSize, int[] childrenMainAxisSize, int[] mainAxisPositions, MeasureScope measureScope) {
        if (this.orientation == LayoutOrientation.Vertical) {
            Arrangement.Vertical vertical = this.verticalArrangement;
            if (vertical == null) {
                throw new IllegalArgumentException("null verticalArrangement in Column".toString());
            }
            vertical.arrange(measureScope, mainAxisLayoutSize, childrenMainAxisSize, mainAxisPositions);
        } else {
            Arrangement.Horizontal horizontal = this.horizontalArrangement;
            if (horizontal == null) {
                throw new IllegalArgumentException("null horizontalArrangement in Row".toString());
            }
            horizontal.arrange(measureScope, mainAxisLayoutSize, childrenMainAxisSize, measureScope.getLayoutDirection(), mainAxisPositions);
        }
        return mainAxisPositions;
    }

    public final int crossAxisSize(Placeable placeable) {
        return this.orientation == LayoutOrientation.Horizontal ? placeable.getHeight() : placeable.getWidth();
    }

    /* renamed from: getArrangementSpacing-D9Ej5fM, reason: not valid java name and from getter */
    public final float getArrangementSpacing() {
        return this.arrangementSpacing;
    }

    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final SizeMode getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    public final List<Measurable> getMeasurables() {
        return this.measurables;
    }

    public final LayoutOrientation getOrientation() {
        return this.orientation;
    }

    public final Placeable[] getPlaceables() {
        return this.placeables;
    }

    public final Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    public final int mainAxisSize(Placeable placeable) {
        return this.orientation == LayoutOrientation.Horizontal ? placeable.getWidth() : placeable.getHeight();
    }

    /* renamed from: measureWithoutPlacing-_EkL_-Y, reason: not valid java name */
    public final RowColumnMeasureHelperResult m598measureWithoutPlacing_EkL_Y(MeasureScope measureScope, long constraints, int startIndex, int endIndex) {
        int i;
        int i2;
        int coerceIn;
        int i3;
        float f;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        long j;
        int i10 = endIndex;
        long m538constructorimpl = OrientationIndependentConstraints.m538constructorimpl(constraints, this.orientation);
        long j2 = measureScope.mo310roundToPx0680j_4(this.arrangementSpacing);
        int i11 = i10 - startIndex;
        long j3 = 0;
        int i12 = startIndex;
        long j4 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        float f2 = 0.0f;
        boolean z = false;
        while (true) {
            boolean z2 = true;
            if (i12 >= i10) {
                break;
            }
            Measurable measurable = this.measurables.get(i12);
            RowColumnParentData rowColumnParentData = this.rowColumnParentData[i12];
            float weight = RowColumnImplKt.getWeight(rowColumnParentData);
            if (weight > 0.0f) {
                f2 += weight;
                i15++;
                i8 = i12;
                j = j3;
            } else {
                int m5739getMaxWidthimpl = Constraints.m5739getMaxWidthimpl(m538constructorimpl);
                Placeable placeable = this.placeables[i12];
                if (placeable == null) {
                    i7 = i14;
                    i8 = i12;
                    i9 = m5739getMaxWidthimpl;
                    placeable = measurable.mo4723measureBRTryo0(OrientationIndependentConstraints.m551toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m540copyyUG9Ft0$default(m538constructorimpl, 0, m5739getMaxWidthimpl == Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) RangesKt.coerceAtLeast(m5739getMaxWidthimpl - j4, j3), 0, 0, 8, null), this.orientation));
                } else {
                    i7 = i14;
                    i8 = i12;
                    i9 = m5739getMaxWidthimpl;
                }
                j = 0;
                int min = Math.min((int) j2, (int) RangesKt.coerceAtLeast((i9 - j4) - mainAxisSize(placeable), 0L));
                j4 += mainAxisSize(placeable) + min;
                int max = Math.max(i7, crossAxisSize(placeable));
                if (!z && !RowColumnImplKt.isRelative(rowColumnParentData)) {
                    z2 = false;
                }
                this.placeables[i8] = placeable;
                i13 = min;
                i14 = max;
                z = z2;
            }
            j3 = j;
            i12 = i8 + 1;
        }
        long j5 = j3;
        if (i15 == 0) {
            j4 -= i13;
            i = i11;
            i2 = 0;
            coerceIn = 0;
        } else {
            long j6 = j2 * (i15 - 1);
            long coerceAtLeast = RangesKt.coerceAtLeast((((f2 <= 0.0f || Constraints.m5739getMaxWidthimpl(m538constructorimpl) == Integer.MAX_VALUE) ? Constraints.m5741getMinWidthimpl(m538constructorimpl) : Constraints.m5739getMaxWidthimpl(m538constructorimpl)) - j4) - j6, j5);
            float f3 = f2 > 0.0f ? coerceAtLeast / f2 : 0.0f;
            Iterator<Integer> it = RangesKt.until(startIndex, endIndex).iterator();
            int i16 = 0;
            while (it.hasNext()) {
                i16 += MathKt.roundToInt(RowColumnImplKt.getWeight(this.rowColumnParentData[((IntIterator) it).nextInt()]) * f3);
            }
            long j7 = coerceAtLeast - i16;
            int i17 = startIndex;
            int i18 = 0;
            while (i17 < i10) {
                if (this.placeables[i17] == null) {
                    Measurable measurable2 = this.measurables.get(i17);
                    RowColumnParentData rowColumnParentData2 = this.rowColumnParentData[i17];
                    float weight2 = RowColumnImplKt.getWeight(rowColumnParentData2);
                    if (!(weight2 > 0.0f)) {
                        throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                    }
                    int sign = MathKt.getSign(j7);
                    i3 = i11;
                    j7 -= sign;
                    int max2 = Math.max(0, MathKt.roundToInt(weight2 * f3) + sign);
                    if (!RowColumnImplKt.getFill(rowColumnParentData2) || max2 == Integer.MAX_VALUE) {
                        f = f3;
                        i4 = 0;
                    } else {
                        i4 = max2;
                        f = f3;
                    }
                    Placeable mo4723measureBRTryo0 = measurable2.mo4723measureBRTryo0(OrientationIndependentConstraints.m551toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m536constructorimpl(i4, max2, 0, Constraints.m5738getMaxHeightimpl(m538constructorimpl)), this.orientation));
                    i18 += mainAxisSize(mo4723measureBRTryo0);
                    i14 = Math.max(i14, crossAxisSize(mo4723measureBRTryo0));
                    boolean z3 = z || RowColumnImplKt.isRelative(rowColumnParentData2);
                    this.placeables[i17] = mo4723measureBRTryo0;
                    z = z3;
                } else {
                    i3 = i11;
                    f = f3;
                }
                i17++;
                i11 = i3;
                i10 = endIndex;
                f3 = f;
            }
            i = i11;
            i2 = 0;
            coerceIn = (int) RangesKt.coerceIn(i18 + j6, 0L, Constraints.m5739getMaxWidthimpl(m538constructorimpl) - j4);
        }
        if (z) {
            int i19 = 0;
            i5 = 0;
            for (int i20 = startIndex; i20 < endIndex; i20++) {
                Placeable placeable2 = this.placeables[i20];
                Intrinsics.checkNotNull(placeable2);
                CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(this.rowColumnParentData[i20]);
                Integer calculateAlignmentLinePosition$foundation_layout_release = crossAxisAlignment != null ? crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable2) : null;
                if (calculateAlignmentLinePosition$foundation_layout_release != null) {
                    Integer num = calculateAlignmentLinePosition$foundation_layout_release;
                    int intValue = num.intValue();
                    if (intValue == Integer.MIN_VALUE) {
                        intValue = 0;
                    }
                    i19 = Math.max(i19, intValue);
                    int crossAxisSize = crossAxisSize(placeable2);
                    int intValue2 = num.intValue();
                    if (intValue2 == Integer.MIN_VALUE) {
                        intValue2 = crossAxisSize(placeable2);
                    }
                    i5 = Math.max(i5, crossAxisSize - intValue2);
                }
            }
            i6 = i19;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int max3 = Math.max((int) RangesKt.coerceAtLeast(j4 + coerceIn, 0L), Constraints.m5741getMinWidthimpl(m538constructorimpl));
        int max4 = (Constraints.m5738getMaxHeightimpl(m538constructorimpl) == Integer.MAX_VALUE || this.crossAxisSize != SizeMode.Expand) ? Math.max(i14, Math.max(Constraints.m5740getMinHeightimpl(m538constructorimpl), i5 + i6)) : Constraints.m5738getMaxHeightimpl(m538constructorimpl);
        int i21 = i;
        int[] iArr = new int[i21];
        for (int i22 = 0; i22 < i21; i22++) {
            iArr[i22] = i2;
        }
        int[] iArr2 = new int[i21];
        for (int i23 = 0; i23 < i21; i23++) {
            Placeable placeable3 = this.placeables[i23 + startIndex];
            Intrinsics.checkNotNull(placeable3);
            iArr2[i23] = mainAxisSize(placeable3);
        }
        return new RowColumnMeasureHelperResult(max4, max3, startIndex, endIndex, i6, mainAxisPositions(max3, iArr2, iArr, measureScope));
    }

    public final void placeHelper(Placeable.PlacementScope placeableScope, RowColumnMeasureHelperResult measureResult, int crossAxisOffset, LayoutDirection layoutDirection) {
        int endIndex = measureResult.getEndIndex();
        for (int startIndex = measureResult.getStartIndex(); startIndex < endIndex; startIndex++) {
            Placeable placeable = this.placeables[startIndex];
            Intrinsics.checkNotNull(placeable);
            int[] mainAxisPositions = measureResult.getMainAxisPositions();
            Object parentData = this.measurables.get(startIndex).getParentData();
            int crossAxisPosition = getCrossAxisPosition(placeable, parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null, measureResult.getCrossAxisSize(), layoutDirection, measureResult.getBeforeCrossAxisAlignmentLine()) + crossAxisOffset;
            if (this.orientation == LayoutOrientation.Horizontal) {
                Placeable.PlacementScope.place$default(placeableScope, placeable, mainAxisPositions[startIndex - measureResult.getStartIndex()], crossAxisPosition, 0.0f, 4, null);
            } else {
                Placeable.PlacementScope.place$default(placeableScope, placeable, crossAxisPosition, mainAxisPositions[startIndex - measureResult.getStartIndex()], 0.0f, 4, null);
            }
        }
    }
}
