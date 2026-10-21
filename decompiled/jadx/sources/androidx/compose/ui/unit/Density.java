package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* compiled from: Density.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\b\u001a\u00020\t*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\n*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0010\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0012J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0017J\u0016\u0010 \u001a\u00020\u0016*\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0018J\u0019\u0010\"\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0019\u0010\"\u001a\u00020\r*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010%R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006&À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "(J)F", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(F)J", "(I)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface Density extends FontScaling {

    /* compiled from: Density.kt */
    /* renamed from: androidx.compose.ui.unit.Density$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* renamed from: $default$roundToPx--R2X_6o, reason: not valid java name */
        public static int m5757$default$roundToPxR2X_6o(Density density, long j) {
            return MathKt.roundToInt(density.mo315toPxR2X_6o(j));
        }

        /* renamed from: $default$roundToPx-0680j_4, reason: not valid java name */
        public static int m5758$default$roundToPx0680j_4(Density density, float f) {
            float mo316toPx0680j_4 = density.mo316toPx0680j_4(f);
            if (Float.isInfinite(mo316toPx0680j_4)) {
                return Integer.MAX_VALUE;
            }
            return MathKt.roundToInt(mo316toPx0680j_4);
        }

        /* renamed from: $default$toDp-u2uoSUM, reason: not valid java name */
        public static float m5759$default$toDpu2uoSUM(Density density, float f) {
            return Dp.m5793constructorimpl(f / density.getDensity());
        }

        /* renamed from: $default$toDp-u2uoSUM, reason: not valid java name */
        public static float m5760$default$toDpu2uoSUM(Density density, int i) {
            return Dp.m5793constructorimpl(i / density.getDensity());
        }

        /* renamed from: $default$toDpSize-k-rfVVM, reason: not valid java name */
        public static long m5761$default$toDpSizekrfVVM(Density density, long j) {
            return (j > Size.INSTANCE.m3270getUnspecifiedNHjbRc() ? 1 : (j == Size.INSTANCE.m3270getUnspecifiedNHjbRc() ? 0 : -1)) != 0 ? DpKt.m5815DpSizeYgX7TsA(density.mo312toDpu2uoSUM(Size.m3262getWidthimpl(j)), density.mo312toDpu2uoSUM(Size.m3259getHeightimpl(j))) : DpSize.INSTANCE.m5900getUnspecifiedMYxV2XQ();
        }

        /* renamed from: $default$toPx--R2X_6o, reason: not valid java name */
        public static float m5762$default$toPxR2X_6o(Density density, long j) {
            if (TextUnitType.m6016equalsimpl0(TextUnit.m5987getTypeUIouoOA(j), TextUnitType.INSTANCE.m6021getSpUIouoOA())) {
                return density.mo316toPx0680j_4(density.mo311toDpGaN1DYA(j));
            }
            throw new IllegalStateException("Only Sp can convert to Px".toString());
        }

        /* renamed from: $default$toPx-0680j_4, reason: not valid java name */
        public static float m5763$default$toPx0680j_4(Density density, float f) {
            return f * density.getDensity();
        }

        public static Rect $default$toRect(Density density, DpRect dpRect) {
            return new Rect(density.mo316toPx0680j_4(dpRect.m5876getLeftD9Ej5fM()), density.mo316toPx0680j_4(dpRect.m5878getTopD9Ej5fM()), density.mo316toPx0680j_4(dpRect.m5877getRightD9Ej5fM()), density.mo316toPx0680j_4(dpRect.m5875getBottomD9Ej5fM()));
        }

        /* renamed from: $default$toSize-XkaWNTQ, reason: not valid java name */
        public static long m5764$default$toSizeXkaWNTQ(Density density, long j) {
            return (j > DpSize.INSTANCE.m5900getUnspecifiedMYxV2XQ() ? 1 : (j == DpSize.INSTANCE.m5900getUnspecifiedMYxV2XQ() ? 0 : -1)) != 0 ? SizeKt.Size(density.mo316toPx0680j_4(DpSize.m5891getWidthD9Ej5fM(j)), density.mo316toPx0680j_4(DpSize.m5889getHeightD9Ej5fM(j))) : Size.INSTANCE.m3270getUnspecifiedNHjbRc();
        }

        /* renamed from: $default$toSp-kPz2Gy4, reason: not valid java name */
        public static long m5765$default$toSpkPz2Gy4(Density density, float f) {
            return density.mo318toSp0xMU5do(density.mo312toDpu2uoSUM(f));
        }

        /* renamed from: $default$toSp-kPz2Gy4, reason: not valid java name */
        public static long m5766$default$toSpkPz2Gy4(Density density, int i) {
            return density.mo318toSp0xMU5do(density.mo313toDpu2uoSUM(i));
        }
    }

    /* compiled from: Density.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m5779roundToPxR2X_6o(Density density, long j) {
            return CC.m5757$default$roundToPxR2X_6o(density, j);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m5780roundToPx0680j_4(Density density, float f) {
            return CC.m5758$default$roundToPx0680j_4(density, f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m5781toDpGaN1DYA(Density density, long j) {
            return FontScaling.CC.m5902$default$toDpGaN1DYA(density, j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5782toDpu2uoSUM(Density density, float f) {
            return CC.m5759$default$toDpu2uoSUM(density, f);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5783toDpu2uoSUM(Density density, int i) {
            return CC.m5760$default$toDpu2uoSUM(density, i);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m5784toDpSizekrfVVM(Density density, long j) {
            return CC.m5761$default$toDpSizekrfVVM(density, j);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m5785toPxR2X_6o(Density density, long j) {
            return CC.m5762$default$toPxR2X_6o(density, j);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m5786toPx0680j_4(Density density, float f) {
            return CC.m5763$default$toPx0680j_4(density, f);
        }

        @Deprecated
        public static Rect toRect(Density density, DpRect dpRect) {
            return CC.$default$toRect(density, dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m5787toSizeXkaWNTQ(Density density, long j) {
            return CC.m5764$default$toSizeXkaWNTQ(density, j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m5788toSp0xMU5do(Density density, float f) {
            return FontScaling.CC.m5903$default$toSp0xMU5do(density, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5789toSpkPz2Gy4(Density density, float f) {
            return CC.m5765$default$toSpkPz2Gy4(density, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5790toSpkPz2Gy4(Density density, int i) {
            return CC.m5766$default$toSpkPz2Gy4(density, i);
        }
    }

    float getDensity();

    /* renamed from: roundToPx--R2X_6o */
    int mo309roundToPxR2X_6o(long j);

    /* renamed from: roundToPx-0680j_4 */
    int mo310roundToPx0680j_4(float f);

    /* renamed from: toDp-u2uoSUM */
    float mo312toDpu2uoSUM(float f);

    /* renamed from: toDp-u2uoSUM */
    float mo313toDpu2uoSUM(int i);

    /* renamed from: toDpSize-k-rfVVM */
    long mo314toDpSizekrfVVM(long j);

    /* renamed from: toPx--R2X_6o */
    float mo315toPxR2X_6o(long j);

    /* renamed from: toPx-0680j_4 */
    float mo316toPx0680j_4(float f);

    Rect toRect(DpRect dpRect);

    /* renamed from: toSize-XkaWNTQ */
    long mo317toSizeXkaWNTQ(long j);

    /* renamed from: toSp-kPz2Gy4 */
    long mo319toSpkPz2Gy4(float f);

    /* renamed from: toSp-kPz2Gy4 */
    long mo320toSpkPz2Gy4(int i);
}
