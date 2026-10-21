package com.izumih.flowreply.ui.screens;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.izumih.flowreply.ui.theme.ColorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingScreen.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0014\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001d\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\r\u001a\u001d\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0015\u001a#\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a3\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u001a\u001a\u0015\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001d\u001a%\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010!¨\u0006\"²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010$\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"AccessibilityPermissionStep", "", "isGranted", "", "onRequestPermission", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ExplanationItem", "number", "", "text", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ExplanationStep", "(Landroidx/compose/runtime/Composer;I)V", "HorizontalStepper", "currentStep", "", "totalSteps", "(IILandroidx/compose/runtime/Composer;I)V", "OnboardingScreen", "onComplete", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "OverlayPermissionStep", "PermissionStepContent", "title", "description", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "StepConnector", "isCompleted", "(ZLandroidx/compose/runtime/Composer;I)V", "StepIndicator", "stepNumber", "isActive", "(IZZLandroidx/compose/runtime/Composer;I)V", "app_release", "overlayPermissionGranted", "accessibilityPermissionGranted"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OnboardingScreenKt {
    public static final void AccessibilityPermissionStep(final boolean z, final Function0<Unit> onRequestPermission, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onRequestPermission, "onRequestPermission");
        Composer startRestartGroup = composer.startRestartGroup(-2043373344);
        ComposerKt.sourceInformation(startRestartGroup, "C(AccessibilityPermissionStep)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(onRequestPermission) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2043373344, i2, -1, "com.izumih.flowreply.ui.screens.AccessibilityPermissionStep (OnboardingScreen.kt:243)");
            }
            int i3 = i2 << 6;
            PermissionStepContent("Permission d'accessibilité", "Autorisez FlowReply à lire les messages à l'écran et à insérer automatiquement les réponses.", z, onRequestPermission, startRestartGroup, (i3 & 896) | 54 | (i3 & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.screens.OnboardingScreenKt$AccessibilityPermissionStep$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i4) {
                OnboardingScreenKt.AccessibilityPermissionStep(z, onRequestPermission, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void ExplanationItem(final String number, final String text, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(text, "text");
        Composer startRestartGroup = composer.startRestartGroup(-2071029893);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExplanationItem)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(number) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(text) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2071029893, i3, -1, "com.izumih.flowreply.ui.screens.ExplanationItem (OnboardingScreen.kt:398)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
            Updater.m2970setimpl(m2963constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2970setimpl(m2963constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2963constructorimpl.getInserting() || !Intrinsics.areEqual(m2963constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m2963constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m2963constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m2954boximpl(SkippableUpdater.m2955constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier background$default = BackgroundKt.background$default(ClipKt.clip(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(36)), RoundedCornerShapeKt.getCircleShape()), Brush.Companion.m3384horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m3425boximpl(ColorKt.getPrimaryGreen()), Color.m3425boximpl(ColorKt.getPrimaryBlue())}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(background$default);
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
            Updater.m2970setimpl(m2963constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2970setimpl(m2963constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2963constructorimpl2.getInserting() || !Intrinsics.areEqual(m2963constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m2963constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m2963constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m2954boximpl(SkippableUpdater.m2955constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            TextKt.m2141Text4IGK_g(number, (Modifier) null, ColorKt.getWhite(), TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, (i3 & 14) | 200064, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            SpacerKt.Spacer(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(16)), startRestartGroup, 6);
            long sp = TextUnitKt.getSp(15);
            long textPrimary = ColorKt.getTextPrimary();
            long sp2 = TextUnitKt.getSp(22);
            Modifier weight$default = RowScope.CC.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            composer2 = startRestartGroup;
            TextKt.m2141Text4IGK_g(text, weight$default, textPrimary, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, sp2, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, ((i3 >> 3) & 14) | 3456, 6, 130032);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.screens.OnboardingScreenKt$ExplanationItem$2
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
                OnboardingScreenKt.ExplanationItem(number, text, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void ExplanationStep(Composer composer, final int i) {
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-376529942);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExplanationStep)");
        if (i == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-376529942, i, -1, "com.izumih.flowreply.ui.screens.ExplanationStep (OnboardingScreen.kt:344)");
            }
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
            Updater.m2970setimpl(m2963constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2970setimpl(m2963constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2963constructorimpl.getInserting() || !Intrinsics.areEqual(m2963constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m2963constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m2963constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m2954boximpl(SkippableUpdater.m2955constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer2 = startRestartGroup;
            TextKt.m2141Text4IGK_g("Comment utiliser FlowReply", (Modifier) null, ColorKt.getTextPrimary(), TextUnitKt.getSp(24), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m5668boximpl(TextAlign.INSTANCE.m5675getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 200070, 0, 130514);
            SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(32)), composer2, 6);
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m847RoundedCornerShape0680j_4(Dp.m5793constructorimpl(16)), CardDefaults.INSTANCE.m1303cardColorsro_MJ88(ColorKt.getWhite(), 0L, 0L, 0L, composer2, ((CardDefaults.$stable | 0) << 12) | 6, 14), CardDefaults.INSTANCE.m1304cardElevationaqJV_2Y(Dp.m5793constructorimpl(4), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, ((CardDefaults.$stable | 0) << 18) | 6, 62), null, ComposableSingletons$OnboardingScreenKt.INSTANCE.m6114getLambda4$app_release(), composer2, 196614, 16);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.screens.OnboardingScreenKt$ExplanationStep$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i2) {
                OnboardingScreenKt.ExplanationStep(composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void HorizontalStepper(final int i, final int i2, Composer composer, final int i3) {
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(173414498);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalStepper)");
        if ((i3 & 14) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 112) == 0) {
            i4 |= startRestartGroup.changed(i2) ? 32 : 16;
        }
        if ((i4 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(173414498, i4, -1, "com.izumih.flowreply.ui.screens.HorizontalStepper (OnboardingScreen.kt:147)");
            }
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier m571paddingVpY3zN4$default = PaddingKt.m571paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m5793constructorimpl(16), 1, null);
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, startRestartGroup, 54);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m571paddingVpY3zN4$default);
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
            Updater.m2970setimpl(m2963constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2970setimpl(m2963constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2963constructorimpl.getInserting() || !Intrinsics.areEqual(m2963constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m2963constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m2963constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m2954boximpl(SkippableUpdater.m2955constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(541564614);
            int i5 = 0;
            while (i5 < i2) {
                int i6 = i5 + 1;
                StepIndicator(i6, i5 < i, i5 == i, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(968387668);
                if (i5 < i2 - 1) {
                    StepConnector(i5 < i, startRestartGroup, 0);
                }
                startRestartGroup.endReplaceableGroup();
                i5 = i6;
            }
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.screens.OnboardingScreenKt$HorizontalStepper$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i7) {
                OnboardingScreenKt.HorizontalStepper(i, i2, composer2, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x055a A[LOOP:0: B:80:0x0558->B:81:0x055a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x05ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OnboardingScreen(final kotlin.jvm.functions.Function0<kotlin.Unit> r43, androidx.compose.runtime.Composer r44, final int r45) {
        /*
            Method dump skipped, instructions count: 1541
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.izumih.flowreply.ui.screens.OnboardingScreenKt.OnboardingScreen(kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int OnboardingScreen$lambda$1(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OnboardingScreen$lambda$2(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean OnboardingScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OnboardingScreen$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean OnboardingScreen$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OnboardingScreen$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public static final void OverlayPermissionStep(final boolean z, final Function0<Unit> onRequestPermission, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onRequestPermission, "onRequestPermission");
        Composer startRestartGroup = composer.startRestartGroup(1928880354);
        ComposerKt.sourceInformation(startRestartGroup, "C(OverlayPermissionStep)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(onRequestPermission) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1928880354, i2, -1, "com.izumih.flowreply.ui.screens.OverlayPermissionStep (OnboardingScreen.kt:230)");
            }
            int i3 = i2 << 6;
            PermissionStepContent("Permission d'affichage", "Autorisez FlowReply à afficher une bulle flottante sur vos autres applications.", z, onRequestPermission, startRestartGroup, (i3 & 896) | 54 | (i3 & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.screens.OnboardingScreenKt$OverlayPermissionStep$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i4) {
                OnboardingScreenKt.OverlayPermissionStep(z, onRequestPermission, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void PermissionStepContent(final String title, final String description, final boolean z, final Function0<Unit> onRequestPermission, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(onRequestPermission, "onRequestPermission");
        Composer startRestartGroup = composer.startRestartGroup(-1388291883);
        ComposerKt.sourceInformation(startRestartGroup, "C(PermissionStepContent)P(3)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(description) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changedInstance(onRequestPermission) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1388291883, i3, -1, "com.izumih.flowreply.ui.screens.PermissionStepContent (OnboardingScreen.kt:258)");
            }
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
            Updater.m2970setimpl(m2963constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2970setimpl(m2963constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m2963constructorimpl.getInserting() || !Intrinsics.areEqual(m2963constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m2963constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m2963constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m2954boximpl(SkippableUpdater.m2955constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TextKt.m2141Text4IGK_g(title, (Modifier) null, ColorKt.getTextPrimary(), TextUnitKt.getSp(24), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m5668boximpl(TextAlign.INSTANCE.m5675getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, (i3 & 14) | 200064, 0, 130514);
            SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(16)), startRestartGroup, 6);
            TextKt.m2141Text4IGK_g(description, (Modifier) null, ColorKt.getTextSecondary(), TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m5668boximpl(TextAlign.INSTANCE.m5675getCentere0LSkKk()), TextUnitKt.getSp(24), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, ((i3 >> 3) & 14) | 3456, 6, 129522);
            composer2 = startRestartGroup;
            SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(32)), composer2, 6);
            if (z) {
                composer2.startReplaceableGroup(-1639799470);
                CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m847RoundedCornerShape0680j_4(Dp.m5793constructorimpl(12)), CardDefaults.INSTANCE.m1303cardColorsro_MJ88(Color.m3434copywmQWz5c$default(ColorKt.getSuccessColor(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, composer2, ((CardDefaults.$stable | 0) << 12) | 6, 14), null, null, ComposableSingletons$OnboardingScreenKt.INSTANCE.m6112getLambda2$app_release(), composer2, 196614, 24);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(-1639798418);
                ButtonKt.Button(onRequestPermission, SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5793constructorimpl(56)), false, null, ButtonDefaults.INSTANCE.m1282buttonColorsro_MJ88(Color.INSTANCE.m3470getTransparent0d7_KjU(), 0L, 0L, 0L, composer2, ((ButtonDefaults.$stable | 0) << 12) | 6, 14), null, null, PaddingKt.m564PaddingValuesYgX7TsA$default(0.0f, 0.0f, 3, null), null, ComposableSingletons$OnboardingScreenKt.INSTANCE.m6113getLambda3$app_release(), composer2, ((i3 >> 9) & 14) | 817889328, 364);
                composer2.endReplaceableGroup();
            }
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.screens.OnboardingScreenKt$PermissionStepContent$2
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
                OnboardingScreenKt.PermissionStepContent(title, description, z, onRequestPermission, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StepConnector(final boolean z, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(625020748);
        ComposerKt.sourceInformation(startRestartGroup, "C(StepConnector)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(625020748, i2, -1, "com.izumih.flowreply.ui.screens.StepConnector (OnboardingScreen.kt:211)");
            }
            BoxKt.Box(BackgroundKt.background$default(SizeKt.m604height3ABfNKs(SizeKt.m623width3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(40)), Dp.m5793constructorimpl(2)), z ? Brush.Companion.m3384horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m3425boximpl(ColorKt.getPrimaryGreen()), Color.m3425boximpl(ColorKt.getPrimaryBlue())}), 0.0f, 0.0f, 0, 14, (Object) null) : Brush.Companion.m3384horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m3425boximpl(Color.INSTANCE.m3467getLightGray0d7_KjU()), Color.m3425boximpl(Color.INSTANCE.m3467getLightGray0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.screens.OnboardingScreenKt$StepConnector$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                OnboardingScreenKt.StepConnector(z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StepIndicator(final int i, final boolean z, final boolean z2, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(194530765);
        ComposerKt.sourceInformation(startRestartGroup, "C(StepIndicator)P(2,1)");
        if ((i2 & 14) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i3 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(194530765, i3, -1, "com.izumih.flowreply.ui.screens.StepIndicator (OnboardingScreen.kt:172)");
            }
            Modifier background$default = BackgroundKt.background$default(ClipKt.clip(SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(40)), RoundedCornerShapeKt.getCircleShape()), z ? Brush.Companion.m3384horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m3425boximpl(ColorKt.getPrimaryGreen()), Color.m3425boximpl(ColorKt.getPrimaryBlue())}), 0.0f, 0.0f, 0, 14, (Object) null) : z2 ? Brush.Companion.m3384horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m3425boximpl(ColorKt.getPrimaryGreen()), Color.m3425boximpl(ColorKt.getPrimaryBlue())}), 0.0f, 0.0f, 0, 14, (Object) null) : Brush.Companion.m3384horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m3425boximpl(Color.INSTANCE.m3467getLightGray0d7_KjU()), Color.m3425boximpl(Color.INSTANCE.m3467getLightGray0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(background$default);
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
            modifierMaterializerOf.invoke(SkippableUpdater.m2954boximpl(SkippableUpdater.m2955constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (z) {
                startRestartGroup.startReplaceableGroup(-147811325);
                IconKt.m1613Iconww6aTOc(CheckKt.getCheck(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m618size3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(24)), ColorKt.getWhite(), startRestartGroup, 3504, 0);
                startRestartGroup.endReplaceableGroup();
                composer2 = startRestartGroup;
            } else {
                startRestartGroup.startReplaceableGroup(-147811104);
                composer2 = startRestartGroup;
                TextKt.m2141Text4IGK_g(String.valueOf(i), (Modifier) null, ColorKt.getWhite(), TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 200064, 0, 131026);
                composer2.endReplaceableGroup();
            }
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.screens.OnboardingScreenKt$StepIndicator$2
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
                OnboardingScreenKt.StepIndicator(i, z, z2, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
            }
        });
    }
}
