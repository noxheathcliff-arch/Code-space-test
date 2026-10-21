package com.izumih.flowreply.ui.screens;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.izumih.flowreply.ui.theme.ColorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SplashScreen.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\b\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\t\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\n\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\u000b\u001a\u00020\u0007X\u008a\u008e\u0002"}, d2 = {"SplashScreen", "", "onNavigateToOnboarding", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release", "logoAlpha", "", "titleAlpha", "taglineAlpha", "signatureAlpha", "buttonAlpha"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplashScreenKt {
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static final void SplashScreen(final Function0<Unit> onNavigateToOnboarding, Composer composer, final int i) {
        ?? r3;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onNavigateToOnboarding, "onNavigateToOnboarding");
        Composer startRestartGroup = composer.startRestartGroup(1827795294);
        ComposerKt.sourceInformation(startRestartGroup, "C(SplashScreen)");
        int i2 = (i & 14) == 0 ? (startRestartGroup.changedInstance(onNavigateToOnboarding) ? 4 : 2) | i : i;
        if ((i2 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1827795294, i2, -1, "com.izumih.flowreply.ui.screens.SplashScreen (SplashScreen.kt:28)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            MutableState mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            MutableState mutableState3 = (MutableState) rememberedValue3;
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceableGroup();
            MutableState mutableState4 = (MutableState) rememberedValue4;
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceableGroup();
            MutableState mutableState5 = (MutableState) rememberedValue5;
            Unit unit = Unit.INSTANCE;
            Object[] objArr = {mutableState, mutableState2, mutableState3, mutableState4, mutableState5};
            startRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean z = false;
            for (int i3 = 0; i3 < 5; i3++) {
                z |= startRestartGroup.changed(objArr[i3]);
            }
            SplashScreenKt$SplashScreen$1$1 rememberedValue6 = startRestartGroup.rememberedValue();
            if (z || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                r3 = 0;
                rememberedValue6 = new SplashScreenKt$SplashScreen$1$1(mutableState, mutableState2, mutableState3, mutableState4, mutableState5, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            } else {
                r3 = 0;
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue6, startRestartGroup, 70);
            Modifier m212backgroundbw27NRU$default = BackgroundKt.m212backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ColorKt.getBackgroundLight(), null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, r3, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, r3);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m212backgroundbw27NRU$default);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2963constructorimpl = Updater.m2963constructorimpl(startRestartGroup);
            Updater.m2970setimpl(m2963constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2970setimpl(m2963constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2963constructorimpl.getInserting() || !Intrinsics.areEqual(m2963constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m2963constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m2963constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m2954boximpl(SkippableUpdater.m2955constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((int) r3));
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
            float f = 32;
            Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5793constructorimpl(f));
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center2, centerHorizontally, startRestartGroup, 54);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, r3);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2963constructorimpl2 = Updater.m2963constructorimpl(startRestartGroup);
            Updater.m2970setimpl(m2963constructorimpl2, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2970setimpl(m2963constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2963constructorimpl2.getInserting() || !Intrinsics.areEqual(m2963constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m2963constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m2963constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m2954boximpl(SkippableUpdater.m2955constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((int) r3));
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            SpacerKt.Spacer(ColumnScope.CC.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, r3);
            SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(24)), startRestartGroup, 6);
            long sp = TextUnitKt.getSp(42);
            FontWeight bold = FontWeight.INSTANCE.getBold();
            long primaryGreen = ColorKt.getPrimaryGreen();
            Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, SplashScreen$lambda$4(mutableState2));
            Brush.Companion companion = Brush.INSTANCE;
            Color[] colorArr = new Color[2];
            colorArr[r3] = Color.m3425boximpl(ColorKt.getPrimaryGreen());
            colorArr[1] = Color.m3425boximpl(ColorKt.getPrimaryBlue());
            TextKt.m2141Text4IGK_g("FlowReply", alpha, primaryGreen, sp, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, new TextStyle(Brush.Companion.m3384horizontalGradient8A3gB4$default(companion, CollectionsKt.listOf((Object[]) colorArr), 0.0f, 0.0f, 0, 14, (Object) null), 0.0f, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 33554430, (DefaultConstructorMarker) null), startRestartGroup, 200070, 1572864, 65488);
            float f2 = 16;
            SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(f2)), startRestartGroup, 6);
            TextKt.m2141Text4IGK_g("Votre application de génération automatique\nde réponses via l'intelligence artificielle.", PaddingKt.m571paddingVpY3zN4$default(AlphaKt.alpha(Modifier.INSTANCE, SplashScreen$lambda$7(mutableState3)), Dp.m5793constructorimpl(f2), 0.0f, 2, null), Color.INSTANCE.m3465getGray0d7_KjU(), TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m5668boximpl(TextAlign.INSTANCE.m5675getCentere0LSkKk()), TextUnitKt.getSp(20), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 3462, 6, 129520);
            SpacerKt.Spacer(ColumnScope.CC.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, r3);
            TextKt.m2141Text4IGK_g("Izumi H.", AlphaKt.alpha(Modifier.INSTANCE, SplashScreen$lambda$10(mutableState4)), Color.INSTANCE.m3465getGray0d7_KjU(), TextUnitKt.getSp(24), (FontStyle) null, FontWeight.INSTANCE.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 200070, 0, 131024);
            SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(f)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            ButtonKt.Button(onNavigateToOnboarding, AlphaKt.alpha(SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5793constructorimpl(56)), SplashScreen$lambda$13(mutableState5)), false, RoundedCornerShapeKt.m847RoundedCornerShape0680j_4(Dp.m5793constructorimpl(6)), ButtonDefaults.INSTANCE.m1282buttonColorsro_MJ88(Color.INSTANCE.m3470getTransparent0d7_KjU(), 0L, 0L, 0L, startRestartGroup, ((ButtonDefaults.$stable | r3) << 12) | 6, 14), null, null, PaddingKt.m564PaddingValuesYgX7TsA$default(0.0f, 0.0f, 3, null), null, ComposableSingletons$SplashScreenKt.INSTANCE.m6115getLambda1$app_release(), composer2, (i2 & 14) | 817889280, 356);
            SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(48)), composer2, 6);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.screens.SplashScreenKt$SplashScreen$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i4) {
                SplashScreenKt.SplashScreen(onNavigateToOnboarding, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    private static final float SplashScreen$lambda$10(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SplashScreen$lambda$11(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    private static final float SplashScreen$lambda$13(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SplashScreen$lambda$14(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SplashScreen$lambda$2(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    private static final float SplashScreen$lambda$4(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SplashScreen$lambda$5(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    private static final float SplashScreen$lambda$7(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SplashScreen$lambda$8(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }
}
