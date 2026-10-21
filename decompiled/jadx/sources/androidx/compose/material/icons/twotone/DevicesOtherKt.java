package androidx.compose.material.icons.twotone;

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

/* compiled from: DevicesOther.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_devicesOther", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DevicesOther", "Landroidx/compose/material/icons/Icons$TwoTone;", "getDevicesOther", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DevicesOtherKt {
    private static ImageVector _devicesOther;

    public static final ImageVector getDevicesOther(Icons.TwoTone twoTone) {
        ImageVector imageVector = _devicesOther;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.DevicesOther", Dp.m5793constructorimpl(24.0f), Dp.m5793constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3461getBlack0d7_KjU(), null);
        int m3795getButtKaPHkGw = StrokeCap.INSTANCE.m3795getButtKaPHkGw();
        int m3805getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3805getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(17.0f, 10.0f);
        pathBuilder.horizontalLineToRelative(4.0f);
        pathBuilder.verticalLineToRelative(8.0f);
        pathBuilder.horizontalLineToRelative(-4.0f);
        pathBuilder.close();
        ImageVector.Builder.m4080addPathoIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 0.3f, null, 0.3f, 1.0f, m3795getButtKaPHkGw, m3805getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(Color.INSTANCE.m3461getBlack0d7_KjU(), null);
        int m3795getButtKaPHkGw2 = StrokeCap.INSTANCE.m3795getButtKaPHkGw();
        int m3805getBevelLxFBmk82 = StrokeJoin.INSTANCE.m3805getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(11.0f, 16.0f);
        pathBuilder2.moveToRelative(-1.5f, 0.0f);
        pathBuilder2.arcToRelative(1.5f, 1.5f, 0.0f, true, true, 3.0f, 0.0f);
        pathBuilder2.arcToRelative(1.5f, 1.5f, 0.0f, true, true, -3.0f, 0.0f);
        ImageVector.Builder.m4080addPathoIyEayM$default(builder, pathBuilder2.getNodes(), defaultFillType2, "", solidColor2, 0.3f, null, 0.3f, 1.0f, m3795getButtKaPHkGw2, m3805getBevelLxFBmk82, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int defaultFillType3 = VectorKt.getDefaultFillType();
        SolidColor solidColor3 = new SolidColor(Color.INSTANCE.m3461getBlack0d7_KjU(), null);
        int m3795getButtKaPHkGw3 = StrokeCap.INSTANCE.m3795getButtKaPHkGw();
        int m3805getBevelLxFBmk83 = StrokeJoin.INSTANCE.m3805getBevelLxFBmk8();
        PathBuilder pathBuilder3 = new PathBuilder();
        pathBuilder3.moveTo(3.0f, 6.0f);
        pathBuilder3.horizontalLineToRelative(18.0f);
        pathBuilder3.lineTo(21.0f, 4.0f);
        pathBuilder3.lineTo(3.0f, 4.0f);
        pathBuilder3.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        pathBuilder3.verticalLineToRelative(12.0f);
        pathBuilder3.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        pathBuilder3.horizontalLineToRelative(4.0f);
        pathBuilder3.verticalLineToRelative(-2.0f);
        pathBuilder3.lineTo(3.0f, 18.0f);
        pathBuilder3.lineTo(3.0f, 6.0f);
        pathBuilder3.close();
        pathBuilder3.moveTo(22.0f, 8.0f);
        pathBuilder3.horizontalLineToRelative(-6.0f);
        pathBuilder3.curveToRelative(-0.5f, 0.0f, -1.0f, 0.5f, -1.0f, 1.0f);
        pathBuilder3.verticalLineToRelative(10.0f);
        pathBuilder3.curveToRelative(0.0f, 0.5f, 0.5f, 1.0f, 1.0f, 1.0f);
        pathBuilder3.horizontalLineToRelative(6.0f);
        pathBuilder3.curveToRelative(0.5f, 0.0f, 1.0f, -0.5f, 1.0f, -1.0f);
        pathBuilder3.lineTo(23.0f, 9.0f);
        pathBuilder3.curveToRelative(0.0f, -0.5f, -0.5f, -1.0f, -1.0f, -1.0f);
        pathBuilder3.close();
        pathBuilder3.moveTo(21.0f, 18.0f);
        pathBuilder3.horizontalLineToRelative(-4.0f);
        pathBuilder3.verticalLineToRelative(-8.0f);
        pathBuilder3.horizontalLineToRelative(4.0f);
        pathBuilder3.verticalLineToRelative(8.0f);
        pathBuilder3.close();
        pathBuilder3.moveTo(13.0f, 12.0f);
        pathBuilder3.lineTo(9.0f, 12.0f);
        pathBuilder3.verticalLineToRelative(1.78f);
        pathBuilder3.curveToRelative(-0.61f, 0.55f, -1.0f, 1.33f, -1.0f, 2.22f);
        pathBuilder3.reflectiveCurveToRelative(0.39f, 1.67f, 1.0f, 2.22f);
        pathBuilder3.lineTo(9.0f, 20.0f);
        pathBuilder3.horizontalLineToRelative(4.0f);
        pathBuilder3.verticalLineToRelative(-1.78f);
        pathBuilder3.curveToRelative(0.61f, -0.55f, 1.0f, -1.34f, 1.0f, -2.22f);
        pathBuilder3.reflectiveCurveToRelative(-0.39f, -1.67f, -1.0f, -2.22f);
        pathBuilder3.lineTo(13.0f, 12.0f);
        pathBuilder3.close();
        pathBuilder3.moveTo(11.0f, 17.5f);
        pathBuilder3.curveToRelative(-0.83f, 0.0f, -1.5f, -0.67f, -1.5f, -1.5f);
        pathBuilder3.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        pathBuilder3.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        pathBuilder3.reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f);
        pathBuilder3.close();
        ImageVector build = ImageVector.Builder.m4080addPathoIyEayM$default(builder, pathBuilder3.getNodes(), defaultFillType3, "", solidColor3, 1.0f, null, 1.0f, 1.0f, m3795getButtKaPHkGw3, m3805getBevelLxFBmk83, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _devicesOther = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
