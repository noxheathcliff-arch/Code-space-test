package com.izumih.flowreply.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.izumih.flowreply.ui.screens.OnboardingScreenKt;
import com.izumih.flowreply.ui.screens.SplashScreenKt;
import com.izumih.flowreply.util.PreferencesManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u008e\u0002"}, d2 = {"FlowReplyApp", "", "prefsManager", "Lcom/izumih/flowreply/util/PreferencesManager;", "onStartFloatingService", "Lkotlin/Function0;", "(Lcom/izumih/flowreply/util/PreferencesManager;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release", "currentScreen", "Lcom/izumih/flowreply/ui/Screen;"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MainActivityKt {

    /* compiled from: MainActivity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Screen.values().length];
            try {
                iArr[Screen.Splash.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Screen.Onboarding.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Screen.FloatingBubble.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void FlowReplyApp(final PreferencesManager prefsManager, final Function0<Unit> onStartFloatingService, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(prefsManager, "prefsManager");
        Intrinsics.checkNotNullParameter(onStartFloatingService, "onStartFloatingService");
        Composer startRestartGroup = composer.startRestartGroup(-1755422393);
        ComposerKt.sourceInformation(startRestartGroup, "C(FlowReplyApp)P(1)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1755422393, i, -1, "com.izumih.flowreply.ui.FlowReplyApp (MainActivity.kt:97)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Screen.Splash, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        int i2 = WhenMappings.$EnumSwitchMapping$0[FlowReplyApp$lambda$1(mutableState).ordinal()];
        if (i2 == 1) {
            startRestartGroup.startReplaceableGroup(1440374071);
            SplashScreenKt.SplashScreen(new Function0<Unit>() { // from class: com.izumih.flowreply.ui.MainActivityKt$FlowReplyApp$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    mutableState.setValue(PreferencesManager.this.isOnboardingCompleted() ? Screen.FloatingBubble : Screen.Onboarding);
                }
            }, startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
        } else if (i2 == 2) {
            startRestartGroup.startReplaceableGroup(1440374441);
            OnboardingScreenKt.OnboardingScreen(new Function0<Unit>() { // from class: com.izumih.flowreply.ui.MainActivityKt$FlowReplyApp$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    PreferencesManager.this.setOnboardingCompleted(true);
                    onStartFloatingService.invoke();
                }
            }, startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
        } else if (i2 != 3) {
            startRestartGroup.startReplaceableGroup(1440374802);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(1440374695);
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed(onStartFloatingService);
            MainActivityKt$FlowReplyApp$3$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new MainActivityKt$FlowReplyApp$3$1(onStartFloatingService, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 70);
            startRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.MainActivityKt$FlowReplyApp$4
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
                MainActivityKt.FlowReplyApp(PreferencesManager.this, onStartFloatingService, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    private static final Screen FlowReplyApp$lambda$1(MutableState<Screen> mutableState) {
        return mutableState.getValue();
    }
}
