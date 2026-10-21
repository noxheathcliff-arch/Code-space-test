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

/* compiled from: Eco.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_eco", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Eco", "Landroidx/compose/material/icons/Icons$Filled;", "getEco", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EcoKt {
    private static ImageVector _eco;

    public static final ImageVector getEco(Icons.Filled filled) {
        ImageVector imageVector = _eco;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Eco", Dp.m5793constructorimpl(24.0f), Dp.m5793constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3461getBlack0d7_KjU(), null);
        int m3795getButtKaPHkGw = StrokeCap.INSTANCE.m3795getButtKaPHkGw();
        int m3805getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3805getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(6.05f, 8.05f);
        pathBuilder.curveToRelative(-2.73f, 2.73f, -2.73f, 7.15f, -0.02f, 9.88f);
        pathBuilder.curveToRelative(1.47f, -3.4f, 4.09f, -6.24f, 7.36f, -7.93f);
        pathBuilder.curveToRelative(-2.77f, 2.34f, -4.71f, 5.61f, -5.39f, 9.32f);
        pathBuilder.curveToRelative(2.6f, 1.23f, 5.8f, 0.78f, 7.95f, -1.37f);
        pathBuilder.curveTo(19.43f, 14.47f, 20.0f, 4.0f, 20.0f, 4.0f);
        pathBuilder.reflectiveCurveTo(9.53f, 4.57f, 6.05f, 8.05f);
        pathBuilder.close();
        ImageVector build = ImageVector.Builder.m4080addPathoIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 1.0f, null, 1.0f, 1.0f, m3795getButtKaPHkGw, m3805getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _eco = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
