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

/* compiled from: InstallMobile.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_installMobile", "Landroidx/compose/ui/graphics/vector/ImageVector;", "InstallMobile", "Landroidx/compose/material/icons/Icons$Filled;", "getInstallMobile", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InstallMobileKt {
    private static ImageVector _installMobile;

    public static final ImageVector getInstallMobile(Icons.Filled filled) {
        ImageVector imageVector = _installMobile;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.InstallMobile", Dp.m5793constructorimpl(24.0f), Dp.m5793constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3461getBlack0d7_KjU(), null);
        int m3795getButtKaPHkGw = StrokeCap.INSTANCE.m3795getButtKaPHkGw();
        int m3805getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3805getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(17.0f, 18.0f);
        pathBuilder.horizontalLineTo(7.0f);
        pathBuilder.verticalLineTo(6.0f);
        pathBuilder.horizontalLineToRelative(7.0f);
        pathBuilder.verticalLineTo(1.0f);
        pathBuilder.horizontalLineTo(7.0f);
        pathBuilder.curveTo(5.9f, 1.0f, 5.0f, 1.9f, 5.0f, 3.0f);
        pathBuilder.verticalLineToRelative(18.0f);
        pathBuilder.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        pathBuilder.horizontalLineToRelative(10.0f);
        pathBuilder.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilder.verticalLineToRelative(-5.0f);
        pathBuilder.horizontalLineToRelative(-2.0f);
        pathBuilder.verticalLineTo(18.0f);
        pathBuilder.close();
        ImageVector.Builder.m4080addPathoIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 1.0f, null, 1.0f, 1.0f, m3795getButtKaPHkGw, m3805getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(Color.INSTANCE.m3461getBlack0d7_KjU(), null);
        int m3795getButtKaPHkGw2 = StrokeCap.INSTANCE.m3795getButtKaPHkGw();
        int m3805getBevelLxFBmk82 = StrokeJoin.INSTANCE.m3805getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(18.0f, 14.0f);
        pathBuilder2.lineToRelative(5.0f, -5.0f);
        pathBuilder2.lineToRelative(-1.41f, -1.41f);
        pathBuilder2.lineToRelative(-2.59f, 2.58f);
        pathBuilder2.lineToRelative(0.0f, -7.17f);
        pathBuilder2.lineToRelative(-2.0f, 0.0f);
        pathBuilder2.lineToRelative(0.0f, 7.17f);
        pathBuilder2.lineToRelative(-2.59f, -2.58f);
        pathBuilder2.lineToRelative(-1.41f, 1.41f);
        pathBuilder2.close();
        ImageVector build = ImageVector.Builder.m4080addPathoIyEayM$default(builder, pathBuilder2.getNodes(), defaultFillType2, "", solidColor2, 1.0f, null, 1.0f, 1.0f, m3795getButtKaPHkGw2, m3805getBevelLxFBmk82, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _installMobile = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
