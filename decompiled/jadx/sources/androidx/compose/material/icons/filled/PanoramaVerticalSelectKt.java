package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PanoramaVerticalSelect.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_panoramaVerticalSelect", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanoramaVerticalSelect", "Landroidx/compose/material/icons/Icons$Filled;", "getPanoramaVerticalSelect", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PanoramaVerticalSelectKt {
    private static ImageVector _panoramaVerticalSelect;

    public static final ImageVector getPanoramaVerticalSelect(Icons.Filled filled) {
        ImageVector imageVector = _panoramaVerticalSelect;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.PanoramaVerticalSelect", Dp.m5793constructorimpl(24.0f), Dp.m5793constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3461getBlack0d7_KjU(), null);
        int m3795getButtKaPHkGw = StrokeCap.INSTANCE.m3795getButtKaPHkGw();
        int m3805getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3805getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(19.93f, 21.12f);
        pathBuilder.curveToRelative(-1.1f, -2.94f, -1.64f, -6.03f, -1.64f, -9.12f);
        pathBuilder.reflectiveCurveToRelative(0.55f, -6.18f, 1.64f, -9.12f);
        pathBuilder.curveToRelative(0.05f, -0.11f, 0.07f, -0.22f, 0.07f, -0.31f);
        pathBuilder.curveToRelative(0.0f, -0.34f, -0.24f, -0.57f, -0.64f, -0.57f);
        pathBuilder.horizontalLineTo(4.62f);
        pathBuilder.curveToRelative(-0.4f, 0.0f, -0.63f, 0.23f, -0.63f, 0.57f);
        pathBuilder.curveToRelative(0.0f, 0.1f, 0.02f, 0.2f, 0.06f, 0.31f);
        pathBuilder.curveTo(5.16f, 5.82f, 5.7f, 8.91f, 5.7f, 12.0f);
        pathBuilder.reflectiveCurveToRelative(-0.55f, 6.18f, -1.64f, 9.12f);
        pathBuilder.curveToRelative(-0.05f, 0.11f, -0.07f, 0.22f, -0.07f, 0.31f);
        pathBuilder.curveToRelative(0.0f, 0.33f, 0.23f, 0.57f, 0.63f, 0.57f);
        pathBuilder.horizontalLineToRelative(14.75f);
        pathBuilder.curveToRelative(0.39f, 0.0f, 0.63f, -0.24f, 0.63f, -0.57f);
        pathBuilder.curveToRelative(0.0f, -0.1f, -0.02f, -0.2f, -0.07f, -0.31f);
        pathBuilder.close();
        ImageVector build = ImageVector.Builder.m4080addPathoIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 1.0f, null, 1.0f, 1.0f, m3795getButtKaPHkGw, m3805getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _panoramaVerticalSelect = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
