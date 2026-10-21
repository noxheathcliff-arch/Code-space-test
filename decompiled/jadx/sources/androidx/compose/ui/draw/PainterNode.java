package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

/* compiled from: PainterModifier.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001a\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002ø\u0001\u0000¢\u0006\u0004\b5\u00101J\b\u00106\u001a\u000207H\u0016J\f\u00108\u001a\u000209*\u00020:H\u0016J\u0016\u0010;\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u0016\u0010>\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010=J\u001c\u0010@\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010F\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016J&\u0010H\u001a\u00020I*\u00020J2\u0006\u0010C\u001a\u00020K2\u0006\u00104\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\u001c\u0010N\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010O\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010'\"\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010'\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006P"}, d2 = {"Landroidx/compose/ui/draw/PainterNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "getSizeToIntrinsics", "setSizeToIntrinsics", "(Z)V", "useIntrinsicSize", "getUseIntrinsicSize", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    public PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    public /* synthetic */ PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, z, (i & 4) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i & 8) != 0 ? ContentScale.INSTANCE.getInside() : contentScale, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter);
    }

    /* renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m3101calculateScaledSizeE7KxVPU(long dstSize) {
        if (!getUseIntrinsicSize()) {
            return dstSize;
        }
        long Size = SizeKt.Size(!m3103hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.getIntrinsicSize()) ? Size.m3262getWidthimpl(dstSize) : Size.m3262getWidthimpl(this.painter.getIntrinsicSize()), !m3102hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.getIntrinsicSize()) ? Size.m3259getHeightimpl(dstSize) : Size.m3259getHeightimpl(this.painter.getIntrinsicSize()));
        if (!(Size.m3262getWidthimpl(dstSize) == 0.0f)) {
            if (!(Size.m3259getHeightimpl(dstSize) == 0.0f)) {
                return ScaleFactorKt.m4810timesUQTWf7w(Size, this.contentScale.mo4714computeScaleFactorH7hwNQA(Size, dstSize));
            }
        }
        return Size.INSTANCE.m3271getZeroNHjbRc();
    }

    private final boolean getUseIntrinsicSize() {
        if (this.sizeToIntrinsics) {
            return (this.painter.getIntrinsicSize() > Size.INSTANCE.m3270getUnspecifiedNHjbRc() ? 1 : (this.painter.getIntrinsicSize() == Size.INSTANCE.m3270getUnspecifiedNHjbRc() ? 0 : -1)) != 0;
        }
        return false;
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m3102hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        if (Size.m3258equalsimpl0(j, Size.INSTANCE.m3270getUnspecifiedNHjbRc())) {
            return false;
        }
        float m3259getHeightimpl = Size.m3259getHeightimpl(j);
        return !Float.isInfinite(m3259getHeightimpl) && !Float.isNaN(m3259getHeightimpl);
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m3103hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        if (Size.m3258equalsimpl0(j, Size.INSTANCE.m3270getUnspecifiedNHjbRc())) {
            return false;
        }
        float m3262getWidthimpl = Size.m3262getWidthimpl(j);
        return !Float.isInfinite(m3262getWidthimpl) && !Float.isNaN(m3262getWidthimpl);
    }

    /* renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m3104modifyConstraintsZezNO4M(long constraints) {
        boolean z = Constraints.m5735getHasBoundedWidthimpl(constraints) && Constraints.m5734getHasBoundedHeightimpl(constraints);
        boolean z2 = Constraints.m5737getHasFixedWidthimpl(constraints) && Constraints.m5736getHasFixedHeightimpl(constraints);
        if ((!getUseIntrinsicSize() && z) || z2) {
            return Constraints.m5730copyZbe2FdA$default(constraints, Constraints.m5739getMaxWidthimpl(constraints), 0, Constraints.m5738getMaxHeightimpl(constraints), 0, 10, null);
        }
        long intrinsicSize = this.painter.getIntrinsicSize();
        long m3101calculateScaledSizeE7KxVPU = m3101calculateScaledSizeE7KxVPU(SizeKt.Size(ConstraintsKt.m5753constrainWidthK40F9xA(constraints, m3103hasSpecifiedAndFiniteWidthuvyYCjk(intrinsicSize) ? MathKt.roundToInt(Size.m3262getWidthimpl(intrinsicSize)) : Constraints.m5741getMinWidthimpl(constraints)), ConstraintsKt.m5752constrainHeightK40F9xA(constraints, m3102hasSpecifiedAndFiniteHeightuvyYCjk(intrinsicSize) ? MathKt.roundToInt(Size.m3259getHeightimpl(intrinsicSize)) : Constraints.m5740getMinHeightimpl(constraints))));
        return Constraints.m5730copyZbe2FdA$default(constraints, ConstraintsKt.m5753constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m3262getWidthimpl(m3101calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m5752constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m3259getHeightimpl(m3101calculateScaledSizeE7KxVPU))), 0, 10, null);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        long m3271getZeroNHjbRc;
        long intrinsicSize = this.painter.getIntrinsicSize();
        long Size = SizeKt.Size(m3103hasSpecifiedAndFiniteWidthuvyYCjk(intrinsicSize) ? Size.m3262getWidthimpl(intrinsicSize) : Size.m3262getWidthimpl(contentDrawScope.mo3913getSizeNHjbRc()), m3102hasSpecifiedAndFiniteHeightuvyYCjk(intrinsicSize) ? Size.m3259getHeightimpl(intrinsicSize) : Size.m3259getHeightimpl(contentDrawScope.mo3913getSizeNHjbRc()));
        if (!(Size.m3262getWidthimpl(contentDrawScope.mo3913getSizeNHjbRc()) == 0.0f)) {
            if (!(Size.m3259getHeightimpl(contentDrawScope.mo3913getSizeNHjbRc()) == 0.0f)) {
                m3271getZeroNHjbRc = ScaleFactorKt.m4810timesUQTWf7w(Size, this.contentScale.mo4714computeScaleFactorH7hwNQA(Size, contentDrawScope.mo3913getSizeNHjbRc()));
                long j = m3271getZeroNHjbRc;
                long mo3070alignKFBX0sM = this.alignment.mo3070alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m3262getWidthimpl(j)), MathKt.roundToInt(Size.m3259getHeightimpl(j))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m3262getWidthimpl(contentDrawScope.mo3913getSizeNHjbRc())), MathKt.roundToInt(Size.m3259getHeightimpl(contentDrawScope.mo3913getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
                float m5925getXimpl = IntOffset.m5925getXimpl(mo3070alignKFBX0sM);
                float m5926getYimpl = IntOffset.m5926getYimpl(mo3070alignKFBX0sM);
                ContentDrawScope contentDrawScope2 = contentDrawScope;
                contentDrawScope2.getDrawContext().getTransform().translate(m5925getXimpl, m5926getYimpl);
                this.painter.m4072drawx_KDEd0(contentDrawScope2, j, this.alpha, this.colorFilter);
                contentDrawScope2.getDrawContext().getTransform().translate(-m5925getXimpl, -m5926getYimpl);
                contentDrawScope.drawContent();
            }
        }
        m3271getZeroNHjbRc = Size.INSTANCE.m3271getZeroNHjbRc();
        long j2 = m3271getZeroNHjbRc;
        long mo3070alignKFBX0sM2 = this.alignment.mo3070alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m3262getWidthimpl(j2)), MathKt.roundToInt(Size.m3259getHeightimpl(j2))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m3262getWidthimpl(contentDrawScope.mo3913getSizeNHjbRc())), MathKt.roundToInt(Size.m3259getHeightimpl(contentDrawScope.mo3913getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
        float m5925getXimpl2 = IntOffset.m5925getXimpl(mo3070alignKFBX0sM2);
        float m5926getYimpl2 = IntOffset.m5926getYimpl(mo3070alignKFBX0sM2);
        ContentDrawScope contentDrawScope22 = contentDrawScope;
        contentDrawScope22.getDrawContext().getTransform().translate(m5925getXimpl2, m5926getYimpl2);
        this.painter.m4072drawx_KDEd0(contentDrawScope22, j2, this.alpha, this.colorFilter);
        contentDrawScope22.getDrawContext().getTransform().translate(-m5925getXimpl2, -m5926getYimpl2);
        contentDrawScope.drawContent();
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        long m3104modifyConstraintsZezNO4M = m3104modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        return Math.max(Constraints.m5740getMinHeightimpl(m3104modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        long m3104modifyConstraintsZezNO4M = m3104modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        return Math.max(Constraints.m5741getMinWidthimpl(m3104modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo89measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable mo4723measureBRTryo0 = measurable.mo4723measureBRTryo0(m3104modifyConstraintsZezNO4M(j));
        return MeasureScope.CC.layout$default(measureScope, mo4723measureBRTryo0.getWidth(), mo4723measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
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
                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        long m3104modifyConstraintsZezNO4M = m3104modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        return Math.max(Constraints.m5740getMinHeightimpl(m3104modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        long m3104modifyConstraintsZezNO4M = m3104modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        return Math.max(Constraints.m5741getMinWidthimpl(m3104modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.CC.$default$onMeasureResultChanged(this);
    }

    public final void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public final void setContentScale(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    public final void setPainter(Painter painter) {
        this.painter = painter;
    }

    public final void setSizeToIntrinsics(boolean z) {
        this.sizeToIntrinsics = z;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
