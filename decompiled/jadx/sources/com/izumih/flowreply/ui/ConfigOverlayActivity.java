package com.izumih.flowreply.ui;

import android.R;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.izumih.flowreply.data.Configuration;
import com.izumih.flowreply.data.Prompt;
import com.izumih.flowreply.ui.components.ConfigDialogKt;
import com.izumih.flowreply.ui.theme.ThemeKt;
import com.izumih.flowreply.util.PreferencesManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ConfigOverlayActivity.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010\r\u001a\u00020\fX\u008a\u008e\u0002"}, d2 = {"Lcom/izumih/flowreply/ui/ConfigOverlayActivity;", "Landroidx/activity/ComponentActivity;", "()V", "prefsManager", "Lcom/izumih/flowreply/util/PreferencesManager;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_release", "isVisible", "", "isSaving"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConfigOverlayActivity extends ComponentActivity {
    public static final int $stable = 8;
    private PreferencesManager prefsManager;

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.prefsManager = new PreferencesManager(this);
            Window window = getWindow();
            window.setLayout(-1, -1);
            window.setBackgroundDrawableResource(R.color.transparent);
            window.addFlags(Integer.MIN_VALUE);
            window.addFlags(2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(1273928799, true, new Function2<Composer, Integer, Unit>() { // from class: com.izumih.flowreply.ui.ConfigOverlayActivity$onCreate$2

                /* compiled from: ConfigOverlayActivity.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
                /* renamed from: com.izumih.flowreply.ui.ConfigOverlayActivity$onCreate$2$1, reason: invalid class name */
                static final class AnonymousClass1 extends Lambda implements Function2<Composer, Integer, Unit> {
                    final /* synthetic */ ConfigOverlayActivity this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(ConfigOverlayActivity configOverlayActivity) {
                        super(2);
                        this.this$0 = configOverlayActivity;
                    }

                    private static final boolean invoke$lambda$1(MutableState<Boolean> mutableState) {
                        return mutableState.getValue().booleanValue();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void invoke$lambda$2(MutableState<Boolean> mutableState, boolean z) {
                        mutableState.setValue(Boolean.valueOf(z));
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final boolean invoke$lambda$4(MutableState<Boolean> mutableState) {
                        return mutableState.getValue().booleanValue();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void invoke$lambda$5(MutableState<Boolean> mutableState, boolean z) {
                        mutableState.setValue(Boolean.valueOf(z));
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        PreferencesManager preferencesManager;
                        if ((i & 11) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(682822085, i, -1, "com.izumih.flowreply.ui.ConfigOverlayActivity.onCreate.<anonymous>.<anonymous> (ConfigOverlayActivity.kt:44)");
                        }
                        composer.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                        Object rememberedValue = composer.rememberedValue();
                        PreferencesManager preferencesManager2 = null;
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                            composer.updateRememberedValue(rememberedValue);
                        }
                        composer.endReplaceableGroup();
                        final MutableState mutableState = (MutableState) rememberedValue;
                        composer.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                        Object rememberedValue2 = composer.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composer.updateRememberedValue(rememberedValue2);
                        }
                        composer.endReplaceableGroup();
                        final MutableState mutableState2 = (MutableState) rememberedValue2;
                        if (invoke$lambda$1(mutableState)) {
                            preferencesManager = this.this$0.prefsManager;
                            if (preferencesManager == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("prefsManager");
                            } else {
                                preferencesManager2 = preferencesManager;
                            }
                            Configuration configuration = preferencesManager2.getConfiguration();
                            final ConfigOverlayActivity configOverlayActivity = this.this$0;
                            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.izumih.flowreply.ui.ConfigOverlayActivity.onCreate.2.1.1
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
                                    if (AnonymousClass1.invoke$lambda$4(mutableState2)) {
                                        return;
                                    }
                                    AnonymousClass1.invoke$lambda$2(mutableState, false);
                                    ConfigOverlayActivity.this.finish();
                                }
                            };
                            final ConfigOverlayActivity configOverlayActivity2 = this.this$0;
                            ConfigDialogKt.ConfigDialog(configuration, function0, new Function1<Configuration, Unit>() { // from class: com.izumih.flowreply.ui.ConfigOverlayActivity.onCreate.2.1.2

                                /* compiled from: ConfigOverlayActivity.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
                                @DebugMetadata(c = "com.izumih.flowreply.ui.ConfigOverlayActivity$onCreate$2$1$2$1", f = "ConfigOverlayActivity.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
                                /* renamed from: com.izumih.flowreply.ui.ConfigOverlayActivity$onCreate$2$1$2$1, reason: invalid class name and collision with other inner class name */
                                static final class C00601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ Configuration $config;
                                    final /* synthetic */ MutableState<Boolean> $isSaving$delegate;
                                    final /* synthetic */ MutableState<Boolean> $isVisible$delegate;
                                    int label;
                                    final /* synthetic */ ConfigOverlayActivity this$0;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    C00601(Configuration configuration, ConfigOverlayActivity configOverlayActivity, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super C00601> continuation) {
                                        super(2, continuation);
                                        this.$config = configuration;
                                        this.this$0 = configOverlayActivity;
                                        this.$isSaving$delegate = mutableState;
                                        this.$isVisible$delegate = mutableState2;
                                    }

                                    /* JADX INFO: Access modifiers changed from: private */
                                    public static final void invokeSuspend$lambda$2(ConfigOverlayActivity configOverlayActivity, MutableState mutableState) {
                                        AnonymousClass1.invoke$lambda$2(mutableState, false);
                                        configOverlayActivity.finish();
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C00601(this.$config, this.this$0, this.$isSaving$delegate, this.$isVisible$delegate, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((C00601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        PreferencesManager preferencesManager;
                                        Object saveConfiguration;
                                        PreferencesManager preferencesManager2;
                                        PreferencesManager preferencesManager3;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        try {
                                            try {
                                                if (i == 0) {
                                                    ResultKt.throwOnFailure(obj);
                                                    AnonymousClass1.invoke$lambda$5(this.$isSaving$delegate, true);
                                                    Log.d("ConfigOverlayActivity", "========================================");
                                                    Log.d("ConfigOverlayActivity", "RÉCEPTION CONFIGURATION À SAUVEGARDER");
                                                    Log.d("ConfigOverlayActivity", "========================================");
                                                    Log.d("ConfigOverlayActivity", "Nombre de prompts: " + this.$config.getPrompts().size());
                                                    Log.d("ConfigOverlayActivity", "Tonalité (" + this.$config.getTonality().length() + " car): '" + this.$config.getTonality() + "'");
                                                    Iterator it = this.$config.getPrompts().iterator();
                                                    int i2 = 0;
                                                    while (it.hasNext()) {
                                                        Object next = it.next();
                                                        int i3 = i2 + 1;
                                                        if (i2 < 0) {
                                                            CollectionsKt.throwIndexOverflow();
                                                        }
                                                        Prompt prompt = (Prompt) next;
                                                        Log.d("ConfigOverlayActivity", "Prompt " + i2 + ": id=" + prompt.getId() + ", enabled=" + prompt.isEnabled() + ", content='" + prompt.getContent() + "'");
                                                        it = it;
                                                        i2 = i3;
                                                    }
                                                    Log.d("ConfigOverlayActivity", "Appel prefsManager.saveConfiguration()...");
                                                    preferencesManager = this.this$0.prefsManager;
                                                    if (preferencesManager == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("prefsManager");
                                                        preferencesManager = null;
                                                    }
                                                    this.label = 1;
                                                    saveConfiguration = preferencesManager.saveConfiguration(this.$config, this);
                                                    if (saveConfiguration == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                } else {
                                                    if (i != 1) {
                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                    }
                                                    ResultKt.throwOnFailure(obj);
                                                    saveConfiguration = obj;
                                                }
                                                if (((Boolean) saveConfiguration).booleanValue()) {
                                                    Log.d("ConfigOverlayActivity", "✅ Sauvegarde réussie");
                                                    preferencesManager2 = this.this$0.prefsManager;
                                                    if (preferencesManager2 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("prefsManager");
                                                        preferencesManager3 = null;
                                                    } else {
                                                        preferencesManager3 = preferencesManager2;
                                                    }
                                                    Configuration configuration = preferencesManager3.getConfiguration();
                                                    Log.d("ConfigOverlayActivity", "✅ Vérification: " + configuration.getPrompts().size() + " prompts rechargés");
                                                    int i4 = 0;
                                                    for (Object obj2 : configuration.getPrompts()) {
                                                        int i5 = i4 + 1;
                                                        if (i4 < 0) {
                                                            CollectionsKt.throwIndexOverflow();
                                                        }
                                                        Prompt prompt2 = (Prompt) obj2;
                                                        Log.d("ConfigOverlayActivity", "✅ Prompt rechargé " + i4 + ": id=" + prompt2.getId() + ", enabled=" + prompt2.isEnabled() + ", content='" + prompt2.getContent() + "'");
                                                        i4 = i5;
                                                    }
                                                    Toast.makeText(this.this$0, "Configuration sauvegardée avec succès! (" + configuration.getPrompts().size() + " prompts)", 0).show();
                                                    View decorView = this.this$0.getWindow().getDecorView();
                                                    final ConfigOverlayActivity configOverlayActivity = this.this$0;
                                                    final MutableState<Boolean> mutableState = this.$isVisible$delegate;
                                                    decorView.postDelayed(
                                                    /*  JADX ERROR: Method code generation error
                                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01dc: INVOKE 
                                                          (r0v44 'decorView' android.view.View)
                                                          (wrap:java.lang.Runnable:0x01d7: CONSTRUCTOR 
                                                          (r2v27 'configOverlayActivity' com.izumih.flowreply.ui.ConfigOverlayActivity A[DONT_INLINE])
                                                          (r3v13 'mutableState' androidx.compose.runtime.MutableState<java.lang.Boolean> A[DONT_INLINE])
                                                         A[Catch: all -> 0x0026, Exception -> 0x0029, MD:(com.izumih.flowreply.ui.ConfigOverlayActivity, androidx.compose.runtime.MutableState):void (m), WRAPPED] call: com.izumih.flowreply.ui.ConfigOverlayActivity$onCreate$2$1$2$1$$ExternalSyntheticLambda0.<init>(com.izumih.flowreply.ui.ConfigOverlayActivity, androidx.compose.runtime.MutableState):void type: CONSTRUCTOR)
                                                          (800 long)
                                                         VIRTUAL call: android.view.View.postDelayed(java.lang.Runnable, long):boolean A[Catch: all -> 0x0026, Exception -> 0x0029, MD:(java.lang.Runnable, long):boolean (c)] in method: com.izumih.flowreply.ui.ConfigOverlayActivity.onCreate.2.1.2.1.invokeSuspend(java.lang.Object):java.lang.Object, file: classes2.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:317)
                                                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:317)
                                                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.izumih.flowreply.ui.ConfigOverlayActivity$onCreate$2$1$2$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:305)
                                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                        	... 33 more
                                                        */
                                                    /*
                                                        Method dump skipped, instructions count: 595
                                                        To view this dump add '--comments-level debug' option
                                                    */
                                                    throw new UnsupportedOperationException("Method not decompiled: com.izumih.flowreply.ui.ConfigOverlayActivity$onCreate$2.AnonymousClass1.AnonymousClass2.C00601.invokeSuspend(java.lang.Object):java.lang.Object");
                                                }
                                            }

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Configuration configuration2) {
                                                invoke2(configuration2);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(Configuration config) {
                                                Intrinsics.checkNotNullParameter(config, "config");
                                                if (AnonymousClass1.invoke$lambda$4(mutableState2)) {
                                                    Log.d("ConfigOverlayActivity", "⚠️ Sauvegarde déjà en cours - ignorer");
                                                } else {
                                                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ConfigOverlayActivity.this), null, null, new C00601(config, ConfigOverlayActivity.this, mutableState2, mutableState, null), 3, null);
                                                }
                                            }
                                        }, composer, 8);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }

                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                if ((i & 11) == 2 && composer.getSkipping()) {
                                    composer.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1273928799, i, -1, "com.izumih.flowreply.ui.ConfigOverlayActivity.onCreate.<anonymous> (ConfigOverlayActivity.kt:43)");
                                }
                                ThemeKt.FlowReplyTheme(ComposableLambdaKt.composableLambda(composer, 682822085, true, new AnonymousClass1(ConfigOverlayActivity.this)), composer, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 1, null);
                    } catch (Exception e) {
                        Toast.makeText(this, "Erreur lors de l'ouverture de la configuration: " + e.getMessage(), 0).show();
                        finish();
                    }
                }

                @Override // android.app.Activity
                protected void onDestroy() {
                    super.onDestroy();
                    try {
                        getWindow().clearFlags(2);
                    } catch (Exception unused) {
                    }
                }
            }
