package com.izumih.flowreply.ui.components;

import android.util.Log;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CancelKt;
import androidx.compose.material.icons.filled.CheckCircleKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.OutlinedTextFieldDefaults;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
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
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import com.izumih.flowreply.data.Configuration;
import com.izumih.flowreply.data.Prompt;
import com.izumih.flowreply.ui.theme.ColorKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ConfigDialog.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a7\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\f\u001a7\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0010\u001a?\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\f\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0006X\u008a\u008e\u0002"}, d2 = {"AddPromptDialog", "", "onDismiss", "Lkotlin/Function0;", "onAdd", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ConfigDialog", "configuration", "Lcom/izumih/flowreply/data/Configuration;", "onSave", "(Lcom/izumih/flowreply/data/Configuration;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "EditPromptDialog", "prompt", "Lcom/izumih/flowreply/data/Prompt;", "(Lcom/izumih/flowreply/data/Prompt;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "PromptItem", "onEdit", "onDelete", "onToggle", "(Lcom/izumih/flowreply/data/Prompt;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release", "tonality", "showAddPromptDialog", "", "editingPrompt", "promptText"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConfigDialogKt {
    public static final void AddPromptDialog(final Function0<Unit> onDismiss, final Function1<? super String, Unit> onAdd, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onAdd, "onAdd");
        Composer startRestartGroup = composer.startRestartGroup(-1272904761);
        ComposerKt.sourceInformation(startRestartGroup, "C(AddPromptDialog)P(1)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(onDismiss) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(onAdd) ? 32 : 16;
        }
        final int i3 = i2;
        if ((i3 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1272904761, i3, -1, "com.izumih.flowreply.ui.components.AddPromptDialog (ConfigDialog.kt:322)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState = (MutableState) rememberedValue;
            composer2 = startRestartGroup;
            AndroidAlertDialog_androidKt.m1240AlertDialogOix01E0(onDismiss, ComposableLambdaKt.composableLambda(startRestartGroup, -208402417, true, new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$AddPromptDialog$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    String AddPromptDialog$lambda$16;
                    if ((i4 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-208402417, i4, -1, "com.izumih.flowreply.ui.components.AddPromptDialog.<anonymous> (ConfigDialog.kt:338)");
                    }
                    final MutableState<String> mutableState2 = mutableState;
                    final Function1<String, Unit> function1 = onAdd;
                    composer3.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    boolean changed = composer3.changed(mutableState2) | composer3.changed(function1);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$AddPromptDialog$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                String AddPromptDialog$lambda$162;
                                String AddPromptDialog$lambda$163;
                                AddPromptDialog$lambda$162 = ConfigDialogKt.AddPromptDialog$lambda$16(mutableState2);
                                if (!StringsKt.isBlank(AddPromptDialog$lambda$162)) {
                                    Function1<String, Unit> function12 = function1;
                                    AddPromptDialog$lambda$163 = ConfigDialogKt.AddPromptDialog$lambda$16(mutableState2);
                                    function12.invoke(AddPromptDialog$lambda$163);
                                }
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    AddPromptDialog$lambda$16 = ConfigDialogKt.AddPromptDialog$lambda$16(mutableState);
                    ButtonKt.TextButton((Function0) rememberedValue2, null, !StringsKt.isBlank(AddPromptDialog$lambda$16), null, null, null, null, null, null, ComposableSingletons$ConfigDialogKt.INSTANCE.m6108getLambda7$app_release(), composer3, 805306368, 506);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), null, ComposableLambdaKt.composableLambda(startRestartGroup, 653431185, true, new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$AddPromptDialog$2
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
                    if ((i4 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(653431185, i4, -1, "com.izumih.flowreply.ui.components.AddPromptDialog.<anonymous> (ConfigDialog.kt:350)");
                    }
                    ButtonKt.TextButton(onDismiss, null, false, null, null, null, null, null, null, ComposableSingletons$ConfigDialogKt.INSTANCE.m6109getLambda8$app_release(), composer3, (i3 & 14) | 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), null, ComposableSingletons$ConfigDialogKt.INSTANCE.m6110getLambda9$app_release(), ComposableLambdaKt.composableLambda(startRestartGroup, 1946181588, true, new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$AddPromptDialog$3
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
                    String AddPromptDialog$lambda$16;
                    if ((i4 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1946181588, i4, -1, "com.izumih.flowreply.ui.components.AddPromptDialog.<anonymous> (ConfigDialog.kt:329)");
                    }
                    AddPromptDialog$lambda$16 = ConfigDialogKt.AddPromptDialog$lambda$16(mutableState);
                    final MutableState<String> mutableState2 = mutableState;
                    composer3.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean changed = composer3.changed(mutableState2);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = (Function1) new Function1<String, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$AddPromptDialog$3$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                invoke2(str);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                mutableState2.setValue(it);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    OutlinedTextFieldKt.OutlinedTextField(AddPromptDialog$lambda$16, (Function1<? super String, Unit>) rememberedValue2, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ConfigDialogKt.INSTANCE.m6099getLambda10$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 3, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer3, 12583296, 805306368, 0, 7864184);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, (i3 & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$AddPromptDialog$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i4) {
                ConfigDialogKt.AddPromptDialog(onDismiss, onAdd, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AddPromptDialog$lambda$16(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    public static final void ConfigDialog(final Configuration configuration, final Function0<Unit> onDismiss, final Function1<? super Configuration, Unit> onSave, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onSave, "onSave");
        Composer startRestartGroup = composer.startRestartGroup(265787972);
        ComposerKt.sourceInformation(startRestartGroup, "C(ConfigDialog)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(265787972, i, -1, "com.izumih.flowreply.ui.components.ConfigDialog (ConfigDialog.kt:31)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt.toMutableStateList(configuration.getPrompts());
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(configuration.getTonality(), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue2;
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState2 = (MutableState) rememberedValue3;
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue4);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState3 = (MutableState) rememberedValue4;
        AndroidDialog_androidKt.Dialog(onDismiss, null, ComposableLambdaKt.composableLambda(startRestartGroup, -203214437, true, new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$1
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
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-203214437, i2, -1, "com.izumih.flowreply.ui.components.ConfigDialog.<anonymous> (ConfigDialog.kt:38)");
                }
                Modifier fillMaxHeight = SizeKt.fillMaxHeight(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.9f);
                RoundedCornerShape m847RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m847RoundedCornerShape0680j_4(Dp.m5793constructorimpl(16));
                CardColors m1303cardColorsro_MJ88 = CardDefaults.INSTANCE.m1303cardColorsro_MJ88(ColorKt.getBackgroundLight(), 0L, 0L, 0L, composer2, ((CardDefaults.$stable | 0) << 12) | 6, 14);
                final MutableState<Boolean> mutableState4 = mutableState2;
                final SnapshotStateList<Prompt> snapshotStateList2 = snapshotStateList;
                final MutableState<Prompt> mutableState5 = mutableState3;
                final MutableState<String> mutableState6 = mutableState;
                final Function1<Configuration, Unit> function1 = onSave;
                final int i3 = i;
                final Function0<Unit> function0 = onDismiss;
                CardKt.Card(fillMaxHeight, m847RoundedCornerShape0680j_4, m1303cardColorsro_MJ88, null, null, ComposableLambdaKt.composableLambda(composer2, -350232435, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                        invoke(columnScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ColumnScope Card, Composer composer3, int i4) {
                        String ConfigDialog$lambda$2;
                        Intrinsics.checkNotNullParameter(Card, "$this$Card");
                        if ((i4 & 81) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350232435, i4, -1, "com.izumih.flowreply.ui.components.ConfigDialog.<anonymous>.<anonymous> (ConfigDialog.kt:45)");
                        }
                        float f = 20;
                        Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5793constructorimpl(f));
                        final MutableState<Boolean> mutableState7 = mutableState4;
                        final SnapshotStateList<Prompt> snapshotStateList3 = snapshotStateList2;
                        final MutableState<Prompt> mutableState8 = mutableState5;
                        final MutableState<String> mutableState9 = mutableState6;
                        final Function1<Configuration, Unit> function12 = function1;
                        int i5 = i3;
                        Function0<Unit> function02 = function0;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2963constructorimpl = Updater.m2963constructorimpl(composer3);
                        Updater.m2970setimpl(m2963constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2970setimpl(m2963constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2963constructorimpl.getInserting() || !Intrinsics.areEqual(m2963constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m2963constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m2963constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m2954boximpl(SkippableUpdater.m2955constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer3, 54);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor2);
                        } else {
                            composer3.useNode();
                        }
                        Composer m2963constructorimpl2 = Updater.m2963constructorimpl(composer3);
                        Updater.m2970setimpl(m2963constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2970setimpl(m2963constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m2963constructorimpl2.getInserting() || !Intrinsics.areEqual(m2963constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m2963constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m2963constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        modifierMaterializerOf2.invoke(SkippableUpdater.m2954boximpl(SkippableUpdater.m2955constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        TextKt.m2141Text4IGK_g("Configuration", (Modifier) null, ColorKt.getTextPrimary(), TextUnitKt.getSp(24), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 200070, 0, 131026);
                        IconButtonKt.IconButton(function02, null, false, null, null, ComposableSingletons$ConfigDialogKt.INSTANCE.m6098getLambda1$app_release(), composer3, ((i5 >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        float f2 = 16;
                        SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(f2)), composer3, 6);
                        TextKt.m2141Text4IGK_g("Prompts système", (Modifier) null, ColorKt.getTextPrimary(), TextUnitKt.getSp(18), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 200070, 0, 131026);
                        float f3 = 12;
                        SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(f3)), composer3, 6);
                        composer3.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean changed = composer3.changed(mutableState7);
                        Object rememberedValue5 = composer3.rememberedValue();
                        if (changed || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue5 = (Function0) new Function0<Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$1$1$1$2$1
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
                                    ConfigDialogKt.ConfigDialog$lambda$6(mutableState7, true);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue5);
                        }
                        composer3.endReplaceableGroup();
                        ButtonKt.Button((Function0) rememberedValue5, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, ButtonDefaults.INSTANCE.m1282buttonColorsro_MJ88(Color.INSTANCE.m3470getTransparent0d7_KjU(), 0L, 0L, 0L, composer3, ((ButtonDefaults.$stable | 0) << 12) | 6, 14), null, null, PaddingKt.m564PaddingValuesYgX7TsA$default(0.0f, 0.0f, 3, null), null, ComposableSingletons$ConfigDialogKt.INSTANCE.m6103getLambda2$app_release(), composer3, 817889328, 364);
                        SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(f3)), composer3, 6);
                        Modifier weight$default = ColumnScope.CC.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                        float f4 = 8;
                        Arrangement.HorizontalOrVertical m475spacedBy0680j_4 = Arrangement.INSTANCE.m475spacedBy0680j_4(Dp.m5793constructorimpl(f4));
                        composer3.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        boolean changed2 = composer3.changed(snapshotStateList3) | composer3.changed(mutableState8);
                        Object rememberedValue6 = composer3.rememberedValue();
                        if (changed2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue6 = (Function1) new Function1<LazyListScope, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$1$1$1$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyColumn) {
                                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                    final SnapshotStateList<Prompt> snapshotStateList4 = snapshotStateList3;
                                    final SnapshotStateList<Prompt> snapshotStateList5 = snapshotStateList4;
                                    final MutableState<Prompt> mutableState10 = mutableState8;
                                    final ConfigDialogKt$ConfigDialog$1$1$1$3$1$invoke$$inlined$items$default$1 configDialogKt$ConfigDialog$1$1$1$3$1$invoke$$inlined$items$default$1 = new Function1() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$1$1$1$3$1$invoke$$inlined$items$default$1
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            return invoke((Prompt) obj);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Void invoke(Prompt prompt) {
                                            return null;
                                        }
                                    };
                                    LazyColumn.items(snapshotStateList5.size(), null, new Function1<Integer, Object>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$1$1$1$3$1$invoke$$inlined$items$default$3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        public final Object invoke(int i6) {
                                            return Function1.this.invoke(snapshotStateList5.get(i6));
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                            return invoke(num.intValue());
                                        }
                                    }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$1$1$1$3$1$invoke$$inlined$items$default$4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer4, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer4, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope lazyItemScope, int i6, Composer composer4, int i7) {
                                            int i8;
                                            ComposerKt.sourceInformation(composer4, "C148@6730L22:LazyDsl.kt#428nma");
                                            if ((i7 & 14) == 0) {
                                                i8 = (composer4.changed(lazyItemScope) ? 4 : 2) | i7;
                                            } else {
                                                i8 = i7;
                                            }
                                            if ((i7 & 112) == 0) {
                                                i8 |= composer4.changed(i6) ? 32 : 16;
                                            }
                                            if ((i8 & 731) == 146 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-632812321, i8, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:148)");
                                            }
                                            int i9 = i8 & 14;
                                            final Prompt prompt = (Prompt) snapshotStateList5.get(i6);
                                            composer4.startReplaceableGroup(511388516);
                                            ComposerKt.sourceInformation(composer4, "CC(remember)P(1,2):Composables.kt#9igjgp");
                                            boolean changed3 = composer4.changed(mutableState10) | composer4.changed(prompt);
                                            Object rememberedValue7 = composer4.rememberedValue();
                                            if (changed3 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                final MutableState mutableState11 = mutableState10;
                                                rememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$1$1$1$3$1$1$1$1
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
                                                        mutableState11.setValue(Prompt.this);
                                                    }
                                                };
                                                composer4.updateRememberedValue(rememberedValue7);
                                            }
                                            composer4.endReplaceableGroup();
                                            Function0 function03 = (Function0) rememberedValue7;
                                            composer4.startReplaceableGroup(511388516);
                                            ComposerKt.sourceInformation(composer4, "CC(remember)P(1,2):Composables.kt#9igjgp");
                                            boolean changed4 = composer4.changed(snapshotStateList4) | composer4.changed(prompt);
                                            Object rememberedValue8 = composer4.rememberedValue();
                                            if (changed4 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                                final SnapshotStateList snapshotStateList6 = snapshotStateList4;
                                                rememberedValue8 = (Function0) new Function0<Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$1$1$1$3$1$1$2$1
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
                                                        SnapshotStateList<Prompt> snapshotStateList7 = snapshotStateList6;
                                                        final Prompt prompt2 = prompt;
                                                        CollectionsKt.removeAll((List) snapshotStateList7, (Function1) new Function1<Prompt, Boolean>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$1$1$1$3$1$1$2$1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Boolean invoke(Prompt it) {
                                                                Intrinsics.checkNotNullParameter(it, "it");
                                                                return Boolean.valueOf(Intrinsics.areEqual(it.getId(), Prompt.this.getId()));
                                                            }
                                                        });
                                                    }
                                                };
                                                composer4.updateRememberedValue(rememberedValue8);
                                            }
                                            composer4.endReplaceableGroup();
                                            Function0 function04 = (Function0) rememberedValue8;
                                            composer4.startReplaceableGroup(511388516);
                                            ComposerKt.sourceInformation(composer4, "CC(remember)P(1,2):Composables.kt#9igjgp");
                                            boolean changed5 = composer4.changed(snapshotStateList4) | composer4.changed(prompt);
                                            Object rememberedValue9 = composer4.rememberedValue();
                                            if (changed5 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                                final SnapshotStateList snapshotStateList7 = snapshotStateList4;
                                                rememberedValue9 = (Function0) new Function0<Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$1$1$1$3$1$1$3$1
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
                                                        SnapshotStateList<Prompt> snapshotStateList8 = snapshotStateList7;
                                                        Prompt prompt2 = prompt;
                                                        Iterator<Prompt> it = snapshotStateList8.iterator();
                                                        int i10 = 0;
                                                        while (true) {
                                                            if (!it.hasNext()) {
                                                                i10 = -1;
                                                                break;
                                                            } else if (Intrinsics.areEqual(it.next().getId(), prompt2.getId())) {
                                                                break;
                                                            } else {
                                                                i10++;
                                                            }
                                                        }
                                                        if (i10 != -1) {
                                                            SnapshotStateList<Prompt> snapshotStateList9 = snapshotStateList7;
                                                            snapshotStateList9.set(i10, Prompt.copy$default(snapshotStateList9.get(i10), null, null, !snapshotStateList7.get(i10).isEnabled(), 0L, 11, null));
                                                        }
                                                    }
                                                };
                                                composer4.updateRememberedValue(rememberedValue9);
                                            }
                                            composer4.endReplaceableGroup();
                                            ConfigDialogKt.PromptItem(prompt, function03, function04, (Function0) rememberedValue9, composer4, (i9 >> 3) & 14);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }));
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue6);
                        }
                        composer3.endReplaceableGroup();
                        LazyDslKt.LazyColumn(weight$default, null, null, false, m475spacedBy0680j_4, null, null, false, (Function1) rememberedValue6, composer3, 24576, 238);
                        SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(f2)), composer3, 6);
                        TextKt.m2141Text4IGK_g("Tonalité (facultatif)", (Modifier) null, ColorKt.getTextPrimary(), TextUnitKt.getSp(18), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 200070, 0, 131026);
                        SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(f4)), composer3, 6);
                        ConfigDialog$lambda$2 = ConfigDialogKt.ConfigDialog$lambda$2(mutableState9);
                        composer3.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean changed3 = composer3.changed(mutableState9);
                        Object rememberedValue7 = composer3.rememberedValue();
                        if (changed3 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue7 = (Function1) new Function1<String, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$1$1$1$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                    invoke2(str);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(String it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    mutableState9.setValue(it);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue7);
                        }
                        composer3.endReplaceableGroup();
                        OutlinedTextFieldKt.OutlinedTextField(ConfigDialog$lambda$2, (Function1<? super String, Unit>) rememberedValue7, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ConfigDialogKt.INSTANCE.m6104getLambda3$app_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, OutlinedTextFieldDefaults.INSTANCE.m1743colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, ColorKt.getPrimaryGreen(), ColorKt.getDivider(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer3, 0, 432, 0, 0, 3072, 2147477503, 4095), composer3, 12583296, 0, 0, 4194168);
                        SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(f)), composer3, 6);
                        composer3.startReplaceableGroup(1618982084);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
                        boolean changed4 = composer3.changed(snapshotStateList3) | composer3.changed(mutableState9) | composer3.changed(function12);
                        Object rememberedValue8 = composer3.rememberedValue();
                        if (changed4 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue8 = (Function0) new Function0<Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$1$1$1$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
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
                                    String ConfigDialog$lambda$22;
                                    String ConfigDialog$lambda$23;
                                    Log.d("ConfigDialog", "========================================");
                                    Log.d("ConfigDialog", "BOUTON SAUVEGARDER CLIQUÉ");
                                    Log.d("ConfigDialog", "========================================");
                                    Log.d("ConfigDialog", "Nombre de prompts en mémoire: " + snapshotStateList3.size());
                                    ConfigDialog$lambda$22 = ConfigDialogKt.ConfigDialog$lambda$2(mutableState9);
                                    Log.d("ConfigDialog", "Tonalité en mémoire: '" + ConfigDialog$lambda$22 + "'");
                                    int i6 = 0;
                                    for (Prompt prompt : snapshotStateList3) {
                                        int i7 = i6 + 1;
                                        if (i6 < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        Prompt prompt2 = prompt;
                                        Log.d("ConfigDialog", "Prompt " + i6 + " avant sauvegarde: id=" + prompt2.getId() + ", enabled=" + prompt2.isEnabled() + ", content='" + prompt2.getContent() + "'");
                                        i6 = i7;
                                    }
                                    List<Prompt> list = snapshotStateList3.toList();
                                    ConfigDialog$lambda$23 = ConfigDialogKt.ConfigDialog$lambda$2(mutableState9);
                                    Configuration configuration2 = new Configuration(list, ConfigDialog$lambda$23);
                                    Log.d("ConfigDialog", "Configuration créée avec " + configuration2.getPrompts().size() + " prompts");
                                    Log.d("ConfigDialog", "Appel de onSave()...");
                                    function12.invoke(configuration2);
                                    Log.d("ConfigDialog", "onSave() terminé");
                                    Log.d("ConfigDialog", "========================================");
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue8);
                        }
                        composer3.endReplaceableGroup();
                        ButtonKt.Button((Function0) rememberedValue8, SizeKt.m604height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5793constructorimpl(56)), false, null, ButtonDefaults.INSTANCE.m1282buttonColorsro_MJ88(Color.INSTANCE.m3470getTransparent0d7_KjU(), 0L, 0L, 0L, composer3, ((ButtonDefaults.$stable | 0) << 12) | 6, 14), null, null, PaddingKt.m564PaddingValuesYgX7TsA$default(0.0f, 0.0f, 3, null), null, ComposableSingletons$ConfigDialogKt.INSTANCE.m6105getLambda4$app_release(), composer3, 817889328, 364);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 196614, 24);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, ((i >> 3) & 14) | 384, 2);
        startRestartGroup.startReplaceableGroup(38437527);
        if (ConfigDialog$lambda$5(mutableState2)) {
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed(mutableState2);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = (Function0) new Function0<Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$2$1
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
                        ConfigDialogKt.ConfigDialog$lambda$6(mutableState2, false);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceableGroup();
            Function0 function0 = (Function0) rememberedValue5;
            startRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(snapshotStateList) | startRestartGroup.changed(mutableState2);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = (Function1) new Function1<String, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String content) {
                        Intrinsics.checkNotNullParameter(content, "content");
                        Prompt prompt = new Prompt(null, StringsKt.trim((CharSequence) content).toString(), true, 0L, 9, null);
                        Log.d("ConfigDialog", "Nouveau prompt créé: id=" + prompt.getId() + ", content='" + prompt.getContent() + "'");
                        snapshotStateList.add(prompt);
                        ConfigDialogKt.ConfigDialog$lambda$6(mutableState2, false);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceableGroup();
            AddPromptDialog(function0, (Function1) rememberedValue6, startRestartGroup, 0);
        }
        startRestartGroup.endReplaceableGroup();
        final Prompt ConfigDialog$lambda$8 = ConfigDialog$lambda$8(mutableState3);
        if (ConfigDialog$lambda$8 != null) {
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed3 = startRestartGroup.changed(mutableState3);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$4$1$1
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
                        mutableState3.setValue(null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            startRestartGroup.endReplaceableGroup();
            Function0 function02 = (Function0) rememberedValue7;
            startRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean changed4 = startRestartGroup.changed(snapshotStateList) | startRestartGroup.changed(ConfigDialog$lambda$8) | startRestartGroup.changed(mutableState3);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (changed4 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = (Function1) new Function1<String, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$4$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String newContent) {
                        Intrinsics.checkNotNullParameter(newContent, "newContent");
                        SnapshotStateList<Prompt> snapshotStateList2 = snapshotStateList;
                        Prompt prompt = ConfigDialog$lambda$8;
                        Iterator<Prompt> it = snapshotStateList2.iterator();
                        int i2 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i2 = -1;
                                break;
                            } else if (Intrinsics.areEqual(it.next().getId(), prompt.getId())) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (i2 != -1) {
                            SnapshotStateList<Prompt> snapshotStateList3 = snapshotStateList;
                            snapshotStateList3.set(i2, Prompt.copy$default(snapshotStateList3.get(i2), null, newContent, false, 0L, 13, null));
                        }
                        mutableState3.setValue(null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            startRestartGroup.endReplaceableGroup();
            EditPromptDialog(ConfigDialog$lambda$8, function02, (Function1) rememberedValue8, startRestartGroup, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$ConfigDialog$5
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
                ConfigDialogKt.ConfigDialog(Configuration.this, onDismiss, onSave, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ConfigDialog$lambda$2(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ConfigDialog$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ConfigDialog$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Prompt ConfigDialog$lambda$8(MutableState<Prompt> mutableState) {
        return mutableState.getValue();
    }

    public static final void EditPromptDialog(final Prompt prompt, final Function0<Unit> onDismiss, final Function1<? super String, Unit> onSave, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onSave, "onSave");
        Composer startRestartGroup = composer.startRestartGroup(-1158504830);
        ComposerKt.sourceInformation(startRestartGroup, "C(EditPromptDialog)P(2)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(prompt) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(onSave) ? 256 : 128;
        }
        final int i3 = i2;
        if ((i3 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1158504830, i3, -1, "com.izumih.flowreply.ui.components.EditPromptDialog (ConfigDialog.kt:362)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(prompt.getContent(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState = (MutableState) rememberedValue;
            composer2 = startRestartGroup;
            AndroidAlertDialog_androidKt.m1240AlertDialogOix01E0(onDismiss, ComposableLambdaKt.composableLambda(startRestartGroup, -1671374134, true, new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$EditPromptDialog$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    String EditPromptDialog$lambda$19;
                    if ((i4 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1671374134, i4, -1, "com.izumih.flowreply.ui.components.EditPromptDialog.<anonymous> (ConfigDialog.kt:377)");
                    }
                    final MutableState<String> mutableState2 = mutableState;
                    final Function1<String, Unit> function1 = onSave;
                    composer3.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    boolean changed = composer3.changed(mutableState2) | composer3.changed(function1);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$EditPromptDialog$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                String EditPromptDialog$lambda$192;
                                String EditPromptDialog$lambda$193;
                                EditPromptDialog$lambda$192 = ConfigDialogKt.EditPromptDialog$lambda$19(mutableState2);
                                if (!StringsKt.isBlank(EditPromptDialog$lambda$192)) {
                                    Function1<String, Unit> function12 = function1;
                                    EditPromptDialog$lambda$193 = ConfigDialogKt.EditPromptDialog$lambda$19(mutableState2);
                                    function12.invoke(EditPromptDialog$lambda$193);
                                }
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    EditPromptDialog$lambda$19 = ConfigDialogKt.EditPromptDialog$lambda$19(mutableState);
                    ButtonKt.TextButton((Function0) rememberedValue2, null, !StringsKt.isBlank(EditPromptDialog$lambda$19), null, null, null, null, null, null, ComposableSingletons$ConfigDialogKt.INSTANCE.m6100getLambda11$app_release(), composer3, 805306368, 506);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), null, ComposableLambdaKt.composableLambda(startRestartGroup, 2078720588, true, new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$EditPromptDialog$2
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
                    if ((i4 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2078720588, i4, -1, "com.izumih.flowreply.ui.components.EditPromptDialog.<anonymous> (ConfigDialog.kt:389)");
                    }
                    ButtonKt.TextButton(onDismiss, null, false, null, null, null, null, null, null, ComposableSingletons$ConfigDialogKt.INSTANCE.m6101getLambda12$app_release(), composer3, ((i3 >> 3) & 14) | 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), null, ComposableSingletons$ConfigDialogKt.INSTANCE.m6102getLambda13$app_release(), ComposableLambdaKt.composableLambda(startRestartGroup, 1261411727, true, new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$EditPromptDialog$3
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
                    String EditPromptDialog$lambda$19;
                    if ((i4 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1261411727, i4, -1, "com.izumih.flowreply.ui.components.EditPromptDialog.<anonymous> (ConfigDialog.kt:369)");
                    }
                    EditPromptDialog$lambda$19 = ConfigDialogKt.EditPromptDialog$lambda$19(mutableState);
                    final MutableState<String> mutableState2 = mutableState;
                    composer3.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean changed = composer3.changed(mutableState2);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = (Function1) new Function1<String, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$EditPromptDialog$3$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                invoke2(str);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                mutableState2.setValue(it);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    OutlinedTextFieldKt.OutlinedTextField(EditPromptDialog$lambda$19, (Function1<? super String, Unit>) rememberedValue2, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 3, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer3, 384, 805306368, 0, 7864312);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, ((i3 >> 3) & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$EditPromptDialog$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i4) {
                ConfigDialogKt.EditPromptDialog(Prompt.this, onDismiss, onSave, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String EditPromptDialog$lambda$19(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    public static final void PromptItem(final Prompt prompt, final Function0<Unit> onEdit, final Function0<Unit> onDelete, final Function0<Unit> onToggle, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(onEdit, "onEdit");
        Intrinsics.checkNotNullParameter(onDelete, "onDelete");
        Intrinsics.checkNotNullParameter(onToggle, "onToggle");
        Composer startRestartGroup = composer.startRestartGroup(-557370184);
        ComposerKt.sourceInformation(startRestartGroup, "C(PromptItem)P(3,1)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(prompt) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(onEdit) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(onDelete) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changedInstance(onToggle) ? 2048 : 1024;
        }
        final int i3 = i2;
        if ((i3 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-557370184, i3, -1, "com.izumih.flowreply.ui.components.PromptItem (ConfigDialog.kt:254)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            CardColors m1303cardColorsro_MJ88 = CardDefaults.INSTANCE.m1303cardColorsro_MJ88(prompt.isEnabled() ? ColorKt.getWhite() : Color.m3434copywmQWz5c$default(Color.INSTANCE.m3467getLightGray0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, startRestartGroup, (CardDefaults.$stable | 0) << 12, 14);
            composer2 = startRestartGroup;
            CardKt.Card(fillMaxWidth$default, RoundedCornerShapeKt.m847RoundedCornerShape0680j_4(Dp.m5793constructorimpl(12)), m1303cardColorsro_MJ88, CardDefaults.INSTANCE.m1304cardElevationaqJV_2Y(Dp.m5793constructorimpl(2), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, ((CardDefaults.$stable | 0) << 18) | 6, 62), null, ComposableLambdaKt.composableLambda(startRestartGroup, -70497786, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$PromptItem$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope Card, Composer composer3, int i4) {
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    if ((i4 & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-70497786, i4, -1, "com.izumih.flowreply.ui.components.PromptItem.<anonymous> (ConfigDialog.kt:263)");
                    }
                    Modifier m569padding3ABfNKs = PaddingKt.m569padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5793constructorimpl(12));
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    final Prompt prompt2 = Prompt.this;
                    Function0<Unit> function0 = onToggle;
                    int i5 = i3;
                    Function0<Unit> function02 = onEdit;
                    Function0<Unit> function03 = onDelete;
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m569padding3ABfNKs);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2963constructorimpl = Updater.m2963constructorimpl(composer3);
                    Updater.m2970setimpl(m2963constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2970setimpl(m2963constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2963constructorimpl.getInserting() || !Intrinsics.areEqual(m2963constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m2963constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m2963constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m2954boximpl(SkippableUpdater.m2955constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    Modifier weight$default = RowScope.CC.weight$default(RowScopeInstance.INSTANCE, Modifier.INSTANCE, 1.0f, false, 2, null);
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(weight$default);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor2);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2963constructorimpl2 = Updater.m2963constructorimpl(composer3);
                    Updater.m2970setimpl(m2963constructorimpl2, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2970setimpl(m2963constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2963constructorimpl2.getInserting() || !Intrinsics.areEqual(m2963constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m2963constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m2963constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    modifierMaterializerOf2.invoke(SkippableUpdater.m2954boximpl(SkippableUpdater.m2955constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    TextKt.m2141Text4IGK_g(prompt2.getContent(), (Modifier) null, prompt2.isEnabled() ? ColorKt.getTextPrimary() : ColorKt.getTextSecondary(), TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(20), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3072, 6, 130034);
                    SpacerKt.Spacer(SizeKt.m604height3ABfNKs(Modifier.INSTANCE, Dp.m5793constructorimpl(4)), composer3, 6);
                    TextKt.m2141Text4IGK_g(prompt2.isEnabled() ? "Activé" : "Désactivé", (Modifier) null, prompt2.isEnabled() ? ColorKt.getSuccessColor() : ColorKt.getTextSecondary(), TextUnitKt.getSp(12), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199680, 0, 131026);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor3);
                    } else {
                        composer3.useNode();
                    }
                    Composer m2963constructorimpl3 = Updater.m2963constructorimpl(composer3);
                    Updater.m2970setimpl(m2963constructorimpl3, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2970setimpl(m2963constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m2963constructorimpl3.getInserting() || !Intrinsics.areEqual(m2963constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m2963constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m2963constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    modifierMaterializerOf3.invoke(SkippableUpdater.m2954boximpl(SkippableUpdater.m2955constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    IconButtonKt.IconButton(function0, null, false, null, null, ComposableLambdaKt.composableLambda(composer3, 1257644161, true, new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$PromptItem$1$1$2$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i6) {
                            if ((i6 & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1257644161, i6, -1, "com.izumih.flowreply.ui.components.PromptItem.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ConfigDialog.kt:291)");
                            }
                            IconKt.m1613Iconww6aTOc(Prompt.this.isEnabled() ? CheckCircleKt.getCheckCircle(Icons.INSTANCE.getDefault()) : CancelKt.getCancel(Icons.INSTANCE.getDefault()), Prompt.this.isEnabled() ? "Désactiver" : "Activer", (Modifier) null, Prompt.this.isEnabled() ? ColorKt.getSuccessColor() : ColorKt.getTextSecondary(), composer4, 0, 4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer3, ((i5 >> 9) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                    IconButtonKt.IconButton(function02, null, false, null, null, ComposableSingletons$ConfigDialogKt.INSTANCE.m6106getLambda5$app_release(), composer3, ((i5 >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                    IconButtonKt.IconButton(function03, null, false, null, null, ComposableSingletons$ConfigDialogKt.INSTANCE.m6107getLambda6$app_release(), composer3, ((i5 >> 6) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer2, 196614, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.components.ConfigDialogKt$PromptItem$2
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
                ConfigDialogKt.PromptItem(Prompt.this, onEdit, onDelete, onToggle, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }
}
