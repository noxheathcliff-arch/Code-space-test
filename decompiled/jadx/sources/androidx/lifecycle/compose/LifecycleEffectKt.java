package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SpreadBuilder;

/* compiled from: LifecycleEffect.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a:\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001aD\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0013\u001aN\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001aH\u0010\t\u001a\u00020\u00012\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\u0017\"\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001a6\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u000e2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0003¢\u0006\u0002\u0010\u001b\u001a:\u0010\u001c\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001aD\u0010\u001c\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0013\u001aN\u0010\u001c\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001aH\u0010\u001c\u001a\u00020\u00012\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\u0017\"\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001a6\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001d2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\r¢\u0006\u0002\b\u0010H\u0003¢\u0006\u0002\u0010 ¨\u0006!²\u0006\u0010\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007X\u008a\u0084\u0002"}, d2 = {"LifecycleEventEffect", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onEvent", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle$Event;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "LifecycleResumeEffect", "key1", "", "effects", "Lkotlin/Function1;", "Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;", "Landroidx/lifecycle/compose/LifecyclePauseOrDisposeEffectResult;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "keys", "", "([Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LifecycleResumeEffectImpl", "scope", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LifecycleStartEffect", "Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;", "Landroidx/lifecycle/compose/LifecycleStopOrDisposeEffectResult;", "LifecycleStartEffectImpl", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "lifecycle-runtime-compose_release", "currentOnEvent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LifecycleEffectKt {
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        if (r2 != 0) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleEventEffect(final androidx.lifecycle.Lifecycle.Event r8, androidx.lifecycle.LifecycleOwner r9, final kotlin.jvm.functions.Function0<kotlin.Unit> r10, androidx.compose.runtime.Composer r11, final int r12, final int r13) {
        /*
            r0 = -709389590(0xffffffffd5b792ea, float:-2.5230202E13)
            androidx.compose.runtime.Composer r11 = r11.startRestartGroup(r0)
            java.lang.String r0 = "C(LifecycleEventEffect)56@2466L7,66@2897L29,67@2931L332:LifecycleEffect.kt#2vxrgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r0 = r13 & 1
            r1 = 2
            if (r0 == 0) goto L14
            r0 = r12 | 6
            goto L24
        L14:
            r0 = r12 & 14
            if (r0 != 0) goto L23
            boolean r0 = r11.changed(r8)
            if (r0 == 0) goto L20
            r0 = 4
            goto L21
        L20:
            r0 = 2
        L21:
            r0 = r0 | r12
            goto L24
        L23:
            r0 = r12
        L24:
            r2 = r13 & 2
            if (r2 == 0) goto L2a
            r0 = r0 | 16
        L2a:
            r3 = r13 & 4
            if (r3 == 0) goto L31
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L41
        L31:
            r3 = r12 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L41
            boolean r3 = r11.changed(r10)
            if (r3 == 0) goto L3e
            r3 = 256(0x100, float:3.59E-43)
            goto L40
        L3e:
            r3 = 128(0x80, float:1.8E-43)
        L40:
            r0 = r0 | r3
        L41:
            if (r2 != r1) goto L55
            r1 = r0 & 731(0x2db, float:1.024E-42)
            r3 = 146(0x92, float:2.05E-43)
            if (r1 != r3) goto L55
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L50
            goto L55
        L50:
            r11.skipToGroupEnd()
        L53:
            r4 = r9
            goto La0
        L55:
            r11.startDefaults()
            r1 = r12 & 1
            if (r1 == 0) goto L69
            boolean r1 = r11.getDefaultsInvalid()
            if (r1 == 0) goto L63
            goto L69
        L63:
            r11.skipToGroupEnd()
            if (r2 == 0) goto L84
            goto L82
        L69:
            if (r2 == 0) goto L84
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r1 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r2 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r2)
            java.lang.Object r9 = r11.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.lifecycle.LifecycleOwner r9 = (androidx.lifecycle.LifecycleOwner) r9
        L82:
            r0 = r0 & (-113(0xffffffffffffff8f, float:NaN))
        L84:
            r11.endDefaults()
            androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY
            if (r8 == r1) goto Lb6
            int r0 = r0 >> 6
            r0 = r0 & 14
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r10, r11, r0)
            androidx.lifecycle.compose.LifecycleEffectKt$LifecycleEventEffect$1 r1 = new androidx.lifecycle.compose.LifecycleEffectKt$LifecycleEventEffect$1
            r1.<init>(r9, r8, r0)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r0 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect(r9, r1, r11, r0)
            goto L53
        La0:
            androidx.compose.runtime.ScopeUpdateScope r9 = r11.endRestartGroup()
            if (r9 == 0) goto Lb5
            androidx.lifecycle.compose.LifecycleEffectKt$LifecycleEventEffect$2 r11 = new androidx.lifecycle.compose.LifecycleEffectKt$LifecycleEventEffect$2
            r2 = r11
            r3 = r8
            r5 = r10
            r6 = r12
            r7 = r13
            r2.<init>()
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r9.updateScope(r11)
        Lb5:
            return
        Lb6:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "LifecycleEventEffect cannot be used to listen for Lifecycle.Event.ON_DESTROY, since Compose disposes of the composition before ON_DESTROY observers are invoked."
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleEventEffect(androidx.lifecycle.Lifecycle$Event, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> LifecycleEventEffect$lambda$0(State<? extends Function0<Unit>> state) {
        return state.getValue();
    }

    public static final void LifecycleResumeEffect(final Object obj, LifecycleOwner lifecycleOwner, final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, Composer composer, final int i, final int i2) {
        final LifecycleOwner lifecycleOwner2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1220373486);
        ComposerKt.sourceInformation(startRestartGroup, "C(LifecycleResumeEffect)P(1,2)446@20254L7,449@20396L104,452@20505L83:LifecycleEffect.kt#2vxrgp");
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            i3 = i & (-113);
            lifecycleOwner2 = (LifecycleOwner) consume;
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i3 = i;
        }
        startRestartGroup.startReplaceableGroup(-3686552);
        ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean changed = startRestartGroup.changed(obj) | startRestartGroup.changed(lifecycleOwner2);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new LifecycleResumePauseEffectScope(lifecycleOwner2.getLifecycle());
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        LifecycleResumeEffectImpl(lifecycleOwner2, (LifecycleResumePauseEffectScope) rememberedValue, function1, startRestartGroup, (i3 & 896) | 72);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    LifecycleEffectKt.LifecycleResumeEffect(obj, lifecycleOwner2, function1, composer2, i | 1, i2);
                }
            });
        }
    }

    public static final void LifecycleResumeEffect(final Object obj, final Object obj2, LifecycleOwner lifecycleOwner, final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, Composer composer, final int i, final int i2) {
        final LifecycleOwner lifecycleOwner2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(752680142);
        ComposerKt.sourceInformation(startRestartGroup, "C(LifecycleResumeEffect)P(1,2,3)509@23336L7,512@23478L110,515@23593L83:LifecycleEffect.kt#2vxrgp");
        if ((i2 & 4) != 0) {
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            i3 = i & (-897);
            lifecycleOwner2 = (LifecycleOwner) consume;
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i3 = i;
        }
        startRestartGroup.startReplaceableGroup(-3686095);
        ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = startRestartGroup.changed(obj) | startRestartGroup.changed(obj2) | startRestartGroup.changed(lifecycleOwner2);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new LifecycleResumePauseEffectScope(lifecycleOwner2.getLifecycle());
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        LifecycleResumeEffectImpl(lifecycleOwner2, (LifecycleResumePauseEffectScope) rememberedValue, function1, startRestartGroup, ((i3 >> 3) & 896) | 72);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    LifecycleEffectKt.LifecycleResumeEffect(obj, obj2, lifecycleOwner2, function1, composer2, i | 1, i2);
                }
            });
        }
    }

    public static final void LifecycleResumeEffect(final Object obj, final Object obj2, final Object obj3, LifecycleOwner lifecycleOwner, final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, Composer composer, final int i, final int i2) {
        final LifecycleOwner lifecycleOwner2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-485941842);
        ComposerKt.sourceInformation(startRestartGroup, "C(LifecycleResumeEffect)P(1,2,3,4)574@26517L7,577@26659L116,580@26780L83:LifecycleEffect.kt#2vxrgp");
        if ((i2 & 8) != 0) {
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            i3 = i & (-7169);
            lifecycleOwner2 = (LifecycleOwner) consume;
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i3 = i;
        }
        int i4 = 0;
        Object[] objArr = {obj, obj2, obj3, lifecycleOwner2};
        startRestartGroup.startReplaceableGroup(-3685570);
        ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
        boolean z = false;
        while (i4 < 4) {
            Object obj4 = objArr[i4];
            i4++;
            z |= startRestartGroup.changed(obj4);
        }
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new LifecycleResumePauseEffectScope(lifecycleOwner2.getLifecycle());
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        LifecycleResumeEffectImpl(lifecycleOwner2, (LifecycleResumePauseEffectScope) rememberedValue, function1, startRestartGroup, ((i3 >> 6) & 896) | 72);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    LifecycleEffectKt.LifecycleResumeEffect(obj, obj2, obj3, lifecycleOwner2, function1, composer2, i | 1, i2);
                }
            });
        }
    }

    public static final void LifecycleResumeEffect(final Object[] objArr, LifecycleOwner lifecycleOwner, final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, Composer composer, final int i, final int i2) {
        final LifecycleOwner lifecycleOwner2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-781756895);
        ComposerKt.sourceInformation(startRestartGroup, "C(LifecycleResumeEffect)P(1,2)635@29529L7,638@29671L105,641@29781L83:LifecycleEffect.kt#2vxrgp");
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            i3 = i & (-113);
            lifecycleOwner2 = (LifecycleOwner) consume;
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i3 = i;
        }
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.addSpread(objArr);
        spreadBuilder.add(lifecycleOwner2);
        Object[] array = spreadBuilder.toArray(new Object[spreadBuilder.size()]);
        startRestartGroup.startReplaceableGroup(-3685570);
        ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
        int length = array.length;
        int i4 = 0;
        boolean z = false;
        while (i4 < length) {
            Object obj = array[i4];
            i4++;
            z |= startRestartGroup.changed(obj);
        }
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new LifecycleResumePauseEffectScope(lifecycleOwner2.getLifecycle());
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        LifecycleResumeEffectImpl(lifecycleOwner2, (LifecycleResumePauseEffectScope) rememberedValue, function1, startRestartGroup, (i3 & 896) | 72);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    Object[] objArr2 = objArr;
                    LifecycleEffectKt.LifecycleResumeEffect(Arrays.copyOf(objArr2, objArr2.length), lifecycleOwner2, (Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult>) function1, composer2, i | 1, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LifecycleResumeEffectImpl(final LifecycleOwner lifecycleOwner, final LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(912823238);
        ComposerKt.sourceInformation(startRestartGroup, "C(LifecycleResumeEffectImpl)P(1,2)650@30094L668:LifecycleEffect.kt#2vxrgp");
        EffectsKt.DisposableEffect(lifecycleOwner, lifecycleResumePauseEffectScope, new LifecycleEffectKt$LifecycleResumeEffectImpl$1(lifecycleOwner, lifecycleResumePauseEffectScope, function1), startRestartGroup, 72);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffectImpl$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    LifecycleEffectKt.LifecycleResumeEffectImpl(LifecycleOwner.this, lifecycleResumePauseEffectScope, function1, composer2, i | 1);
                }
            });
        }
    }

    public static final void LifecycleStartEffect(final Object obj, LifecycleOwner lifecycleOwner, final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, Composer composer, final int i, final int i2) {
        final LifecycleOwner lifecycleOwner2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1408314671);
        ComposerKt.sourceInformation(startRestartGroup, "C(LifecycleStartEffect)P(1,2)134@5886L7,137@6023L102,140@6130L80:LifecycleEffect.kt#2vxrgp");
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            i3 = i & (-113);
            lifecycleOwner2 = (LifecycleOwner) consume;
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i3 = i;
        }
        startRestartGroup.startReplaceableGroup(-3686552);
        ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean changed = startRestartGroup.changed(obj) | startRestartGroup.changed(lifecycleOwner2);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new LifecycleStartStopEffectScope(lifecycleOwner2.getLifecycle());
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        LifecycleStartEffectImpl(lifecycleOwner2, (LifecycleStartStopEffectScope) rememberedValue, function1, startRestartGroup, (i3 & 896) | 72);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    LifecycleEffectKt.LifecycleStartEffect(obj, lifecycleOwner2, function1, composer2, i | 1, i2);
                }
            });
        }
    }

    public static final void LifecycleStartEffect(final Object obj, final Object obj2, LifecycleOwner lifecycleOwner, final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, Composer composer, final int i, final int i2) {
        final LifecycleOwner lifecycleOwner2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(696924721);
        ComposerKt.sourceInformation(startRestartGroup, "C(LifecycleStartEffect)P(1,2,3)197@8922L7,200@9059L108,203@9172L80:LifecycleEffect.kt#2vxrgp");
        if ((i2 & 4) != 0) {
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            i3 = i & (-897);
            lifecycleOwner2 = (LifecycleOwner) consume;
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i3 = i;
        }
        startRestartGroup.startReplaceableGroup(-3686095);
        ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = startRestartGroup.changed(obj) | startRestartGroup.changed(obj2) | startRestartGroup.changed(lifecycleOwner2);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new LifecycleStartStopEffectScope(lifecycleOwner2.getLifecycle());
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        LifecycleStartEffectImpl(lifecycleOwner2, (LifecycleStartStopEffectScope) rememberedValue, function1, startRestartGroup, ((i3 >> 3) & 896) | 72);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    LifecycleEffectKt.LifecycleStartEffect(obj, obj2, lifecycleOwner2, function1, composer2, i | 1, i2);
                }
            });
        }
    }

    public static final void LifecycleStartEffect(final Object obj, final Object obj2, final Object obj3, LifecycleOwner lifecycleOwner, final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, Composer composer, final int i, final int i2) {
        final LifecycleOwner lifecycleOwner2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(574812561);
        ComposerKt.sourceInformation(startRestartGroup, "C(LifecycleStartEffect)P(1,2,3,4)262@12063L7,265@12200L114,268@12319L80:LifecycleEffect.kt#2vxrgp");
        if ((i2 & 8) != 0) {
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            i3 = i & (-7169);
            lifecycleOwner2 = (LifecycleOwner) consume;
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i3 = i;
        }
        int i4 = 0;
        Object[] objArr = {obj, obj2, obj3, lifecycleOwner2};
        startRestartGroup.startReplaceableGroup(-3685570);
        ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
        boolean z = false;
        while (i4 < 4) {
            Object obj4 = objArr[i4];
            i4++;
            z |= startRestartGroup.changed(obj4);
        }
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new LifecycleStartStopEffectScope(lifecycleOwner2.getLifecycle());
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        LifecycleStartEffectImpl(lifecycleOwner2, (LifecycleStartStopEffectScope) rememberedValue, function1, startRestartGroup, ((i3 >> 6) & 896) | 72);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    LifecycleEffectKt.LifecycleStartEffect(obj, obj2, obj3, lifecycleOwner2, function1, composer2, i | 1, i2);
                }
            });
        }
    }

    public static final void LifecycleStartEffect(final Object[] objArr, LifecycleOwner lifecycleOwner, final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, Composer composer, final int i, final int i2) {
        final LifecycleOwner lifecycleOwner2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1510305724);
        ComposerKt.sourceInformation(startRestartGroup, "C(LifecycleStartEffect)P(1,2)323@15029L7,326@15166L103,329@15274L80:LifecycleEffect.kt#2vxrgp");
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            i3 = i & (-113);
            lifecycleOwner2 = (LifecycleOwner) consume;
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i3 = i;
        }
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.addSpread(objArr);
        spreadBuilder.add(lifecycleOwner2);
        Object[] array = spreadBuilder.toArray(new Object[spreadBuilder.size()]);
        startRestartGroup.startReplaceableGroup(-3685570);
        ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
        int length = array.length;
        int i4 = 0;
        boolean z = false;
        while (i4 < length) {
            Object obj = array[i4];
            i4++;
            z |= startRestartGroup.changed(obj);
        }
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new LifecycleStartStopEffectScope(lifecycleOwner2.getLifecycle());
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        LifecycleStartEffectImpl(lifecycleOwner2, (LifecycleStartStopEffectScope) rememberedValue, function1, startRestartGroup, (i3 & 896) | 72);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    Object[] objArr2 = objArr;
                    LifecycleEffectKt.LifecycleStartEffect(Arrays.copyOf(objArr2, objArr2.length), lifecycleOwner2, (Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult>) function1, composer2, i | 1, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LifecycleStartEffectImpl(final LifecycleOwner lifecycleOwner, final LifecycleStartStopEffectScope lifecycleStartStopEffectScope, final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(228371534);
        ComposerKt.sourceInformation(startRestartGroup, "C(LifecycleStartEffectImpl)P(1,2)338@15578L659:LifecycleEffect.kt#2vxrgp");
        EffectsKt.DisposableEffect(lifecycleOwner, lifecycleStartStopEffectScope, new LifecycleEffectKt$LifecycleStartEffectImpl$1(lifecycleOwner, lifecycleStartStopEffectScope, function1), startRestartGroup, 72);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffectImpl$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    LifecycleEffectKt.LifecycleStartEffectImpl(LifecycleOwner.this, lifecycleStartStopEffectScope, function1, composer2, i | 1);
                }
            });
        }
    }
}
