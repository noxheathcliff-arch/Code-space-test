package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

/* compiled from: RoundRect.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\u001a \u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a@\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a8\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a6\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a\u001e\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0012\u001a\u001c\u00101\u001a\u00020\u0002*\u00020\u00022\u0006\u00102\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b3\u00104\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b\"\u0015\u0010\f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\"\u0015\u0010\r\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u0015\u0010\u000e\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b\"\u0015\u0010\u000f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\"\u0015\u0010\u0010\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000b\"\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\"\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"boundingRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/RoundRect;", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter", "(Landroidx/compose/ui/geometry/RoundRect;)J", "isCircle", "", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "isEllipse", "isEmpty", "isFinite", "isRect", "isSimple", "maxDimension", "", "getMaxDimension", "(Landroidx/compose/ui/geometry/RoundRect;)F", "minDimension", "getMinDimension", "safeInnerRect", "getSafeInnerRect", "RoundRect", "rect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "RoundRect-sniSvfs", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/RoundRect;", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "radiusX", "radiusY", "left", "top", "right", "bottom", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", "lerp", "start", "stop", "fraction", "translate", "offset", "translate-Uv8p0NA", "(Landroidx/compose/ui/geometry/RoundRect;J)Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RoundRectKt {
    public static final RoundRect RoundRect(float f, float f2, float f3, float f4, float f5, float f6) {
        long CornerRadius = CornerRadiusKt.CornerRadius(f5, f6);
        return new RoundRect(f, f2, f3, f4, CornerRadius, CornerRadius, CornerRadius, CornerRadius, null);
    }

    public static final RoundRect RoundRect(Rect rect, float f, float f2) {
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f, f2);
    }

    /* renamed from: RoundRect-ZAM2FJo, reason: not valid java name */
    public static final RoundRect m3245RoundRectZAM2FJo(Rect rect, long j, long j2, long j3, long j4) {
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j, j2, j3, j4, null);
    }

    /* renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m3247RoundRectgG7oq9Y(float f, float f2, float f3, float f4, long j) {
        return RoundRect(f, f2, f3, f4, CornerRadius.m3168getXimpl(j), CornerRadius.m3169getYimpl(j));
    }

    /* renamed from: RoundRect-sniSvfs, reason: not valid java name */
    public static final RoundRect m3248RoundRectsniSvfs(Rect rect, long j) {
        return RoundRect(rect, CornerRadius.m3168getXimpl(j), CornerRadius.m3169getYimpl(j));
    }

    public static final Rect getBoundingRect(RoundRect roundRect) {
        return new Rect(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
    }

    public static final long getCenter(RoundRect roundRect) {
        return OffsetKt.Offset(roundRect.getLeft() + (roundRect.getWidth() / 2.0f), roundRect.getTop() + (roundRect.getHeight() / 2.0f));
    }

    public static final float getMaxDimension(RoundRect roundRect) {
        return Math.max(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final float getMinDimension(RoundRect roundRect) {
        return Math.min(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final Rect getSafeInnerRect(RoundRect roundRect) {
        return new Rect(roundRect.getLeft() + (Math.max(CornerRadius.m3168getXimpl(roundRect.m3241getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m3168getXimpl(roundRect.m3243getTopLeftCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getTop() + (Math.max(CornerRadius.m3169getYimpl(roundRect.m3243getTopLeftCornerRadiuskKHJgLs()), CornerRadius.m3169getYimpl(roundRect.m3244getTopRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getRight() - (Math.max(CornerRadius.m3168getXimpl(roundRect.m3244getTopRightCornerRadiuskKHJgLs()), CornerRadius.m3168getXimpl(roundRect.m3242getBottomRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getBottom() - (Math.max(CornerRadius.m3169getYimpl(roundRect.m3242getBottomRightCornerRadiuskKHJgLs()), CornerRadius.m3169getYimpl(roundRect.m3241getBottomLeftCornerRadiuskKHJgLs())) * 0.29289323f));
    }

    public static final boolean isCircle(RoundRect roundRect) {
        return ((roundRect.getWidth() > roundRect.getHeight() ? 1 : (roundRect.getWidth() == roundRect.getHeight() ? 0 : -1)) == 0) && isEllipse(roundRect);
    }

    public static final boolean isEllipse(RoundRect roundRect) {
        if (CornerRadius.m3168getXimpl(roundRect.m3243getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3168getXimpl(roundRect.m3244getTopRightCornerRadiuskKHJgLs())) {
            if (CornerRadius.m3169getYimpl(roundRect.m3243getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3169getYimpl(roundRect.m3244getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m3168getXimpl(roundRect.m3244getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m3168getXimpl(roundRect.m3242getBottomRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.m3169getYimpl(roundRect.m3244getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m3169getYimpl(roundRect.m3242getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.m3168getXimpl(roundRect.m3242getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m3168getXimpl(roundRect.m3241getBottomLeftCornerRadiuskKHJgLs())) {
                            if ((CornerRadius.m3169getYimpl(roundRect.m3242getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m3169getYimpl(roundRect.m3241getBottomLeftCornerRadiuskKHJgLs())) && roundRect.getWidth() <= CornerRadius.m3168getXimpl(roundRect.m3243getTopLeftCornerRadiuskKHJgLs()) * 2.0d && roundRect.getHeight() <= CornerRadius.m3169getYimpl(roundRect.m3243getTopLeftCornerRadiuskKHJgLs()) * 2.0d) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isEmpty(RoundRect roundRect) {
        return roundRect.getLeft() >= roundRect.getRight() || roundRect.getTop() >= roundRect.getBottom();
    }

    public static final boolean isFinite(RoundRect roundRect) {
        float left = roundRect.getLeft();
        if ((Float.isInfinite(left) || Float.isNaN(left)) ? false : true) {
            float top = roundRect.getTop();
            if ((Float.isInfinite(top) || Float.isNaN(top)) ? false : true) {
                float right = roundRect.getRight();
                if ((Float.isInfinite(right) || Float.isNaN(right)) ? false : true) {
                    float bottom = roundRect.getBottom();
                    if ((Float.isInfinite(bottom) || Float.isNaN(bottom)) ? false : true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        if ((androidx.compose.ui.geometry.CornerRadius.m3169getYimpl(r6.m3244getTopRightCornerRadiuskKHJgLs()) == 0.0f) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0067, code lost:
    
        if ((androidx.compose.ui.geometry.CornerRadius.m3169getYimpl(r6.m3241getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
    
        if ((androidx.compose.ui.geometry.CornerRadius.m3169getYimpl(r6.m3243getTopLeftCornerRadiuskKHJgLs()) == 0.0f) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean isRect(androidx.compose.ui.geometry.RoundRect r6) {
        /*
            long r0 = r6.m3243getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m3168getXimpl(r0)
            r1 = 1
            r2 = 0
            r3 = 0
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 != 0) goto L25
            long r4 = r6.m3243getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m3169getYimpl(r4)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L22
            r0 = 1
            goto L23
        L22:
            r0 = 0
        L23:
            if (r0 == 0) goto L8c
        L25:
            long r4 = r6.m3244getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m3168getXimpl(r4)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L33
            r0 = 1
            goto L34
        L33:
            r0 = 0
        L34:
            if (r0 != 0) goto L47
            long r4 = r6.m3244getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m3169getYimpl(r4)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L44
            r0 = 1
            goto L45
        L44:
            r0 = 0
        L45:
            if (r0 == 0) goto L8c
        L47:
            long r4 = r6.m3241getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m3168getXimpl(r4)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L55
            r0 = 1
            goto L56
        L55:
            r0 = 0
        L56:
            if (r0 != 0) goto L69
            long r4 = r6.m3241getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m3169getYimpl(r4)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L66
            r0 = 1
            goto L67
        L66:
            r0 = 0
        L67:
            if (r0 == 0) goto L8c
        L69:
            long r4 = r6.m3242getBottomRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m3168getXimpl(r4)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L77
            r0 = 1
            goto L78
        L77:
            r0 = 0
        L78:
            if (r0 != 0) goto L8d
            long r4 = r6.m3242getBottomRightCornerRadiuskKHJgLs()
            float r6 = androidx.compose.ui.geometry.CornerRadius.m3169getYimpl(r4)
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 != 0) goto L88
            r6 = 1
            goto L89
        L88:
            r6 = 0
        L89:
            if (r6 == 0) goto L8c
            goto L8d
        L8c:
            r1 = 0
        L8d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.geometry.RoundRectKt.isRect(androidx.compose.ui.geometry.RoundRect):boolean");
    }

    public static final boolean isSimple(RoundRect roundRect) {
        if (CornerRadius.m3168getXimpl(roundRect.m3243getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3169getYimpl(roundRect.m3243getTopLeftCornerRadiuskKHJgLs())) {
            if (CornerRadius.m3168getXimpl(roundRect.m3243getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3168getXimpl(roundRect.m3244getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m3168getXimpl(roundRect.m3243getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3169getYimpl(roundRect.m3244getTopRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.m3168getXimpl(roundRect.m3243getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3168getXimpl(roundRect.m3242getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.m3168getXimpl(roundRect.m3243getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3169getYimpl(roundRect.m3242getBottomRightCornerRadiuskKHJgLs())) {
                            if (CornerRadius.m3168getXimpl(roundRect.m3243getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3168getXimpl(roundRect.m3241getBottomLeftCornerRadiuskKHJgLs())) {
                                if (CornerRadius.m3168getXimpl(roundRect.m3243getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3169getYimpl(roundRect.m3241getBottomLeftCornerRadiuskKHJgLs())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final RoundRect lerp(RoundRect roundRect, RoundRect roundRect2, float f) {
        return new RoundRect(MathHelpersKt.lerp(roundRect.getLeft(), roundRect2.getLeft(), f), MathHelpersKt.lerp(roundRect.getTop(), roundRect2.getTop(), f), MathHelpersKt.lerp(roundRect.getRight(), roundRect2.getRight(), f), MathHelpersKt.lerp(roundRect.getBottom(), roundRect2.getBottom(), f), CornerRadiusKt.m3179lerp3Ry4LBc(roundRect.m3243getTopLeftCornerRadiuskKHJgLs(), roundRect2.m3243getTopLeftCornerRadiuskKHJgLs(), f), CornerRadiusKt.m3179lerp3Ry4LBc(roundRect.m3244getTopRightCornerRadiuskKHJgLs(), roundRect2.m3244getTopRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m3179lerp3Ry4LBc(roundRect.m3242getBottomRightCornerRadiuskKHJgLs(), roundRect2.m3242getBottomRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m3179lerp3Ry4LBc(roundRect.m3241getBottomLeftCornerRadiuskKHJgLs(), roundRect2.m3241getBottomLeftCornerRadiuskKHJgLs(), f), null);
    }

    /* renamed from: translate-Uv8p0NA, reason: not valid java name */
    public static final RoundRect m3249translateUv8p0NA(RoundRect roundRect, long j) {
        return new RoundRect(Offset.m3193getXimpl(j) + roundRect.getLeft(), Offset.m3194getYimpl(j) + roundRect.getTop(), Offset.m3193getXimpl(j) + roundRect.getRight(), Offset.m3194getYimpl(j) + roundRect.getBottom(), roundRect.m3243getTopLeftCornerRadiuskKHJgLs(), roundRect.m3244getTopRightCornerRadiuskKHJgLs(), roundRect.m3242getBottomRightCornerRadiuskKHJgLs(), roundRect.m3241getBottomLeftCornerRadiuskKHJgLs(), null);
    }
}
