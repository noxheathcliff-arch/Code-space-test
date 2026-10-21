package com.izumih.flowreply.util;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.gson.Gson;
import com.izumih.flowreply.data.Configuration;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PreferencesManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.izumih.flowreply.util.PreferencesManager$saveConfiguration$2", f = "PreferencesManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class PreferencesManager$saveConfiguration$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Configuration $configuration;
    int label;
    final /* synthetic */ PreferencesManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PreferencesManager$saveConfiguration$2(Configuration configuration, PreferencesManager preferencesManager, Continuation<? super PreferencesManager$saveConfiguration$2> continuation) {
        super(2, continuation);
        this.$configuration = configuration;
        this.this$0 = preferencesManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreferencesManager$saveConfiguration$2(this.$configuration, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((PreferencesManager$saveConfiguration$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Boolean boxBoolean;
        List cleanAndValidatePrompts;
        Gson gson;
        SharedPreferences sharedPreferences;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Log.d("PrefsManager", "========================================");
        Log.d("PrefsManager", "DÉBUT SAUVEGARDE CONFIGURATION");
        Log.d("PrefsManager", "========================================");
        try {
            try {
                Log.d("PrefsManager", "Configuration reçue:");
                Log.d("PrefsManager", "  - Nombre de prompts: " + this.$configuration.getPrompts().size());
                Log.d("PrefsManager", "  - Tonalité: '" + this.$configuration.getTonality() + "'");
                cleanAndValidatePrompts = this.this$0.cleanAndValidatePrompts(this.$configuration.getPrompts());
                Log.d("PrefsManager", "Prompts nettoyés: " + cleanAndValidatePrompts.size());
                if (cleanAndValidatePrompts.isEmpty()) {
                    Log.w("PrefsManager", "⚠️ Aucun prompt valide - sauvegarde vide");
                }
                Configuration configuration = new Configuration(cleanAndValidatePrompts, this.$configuration.getTonality());
                gson = this.this$0.gson;
                String json = gson.toJson(configuration);
                Log.d("PrefsManager", "JSON sérialisé: " + json.length() + " caractères");
                sharedPreferences = this.this$0.prefs;
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("config_tonality", configuration.getTonality());
                edit.putString("config_prompts", json);
                edit.putLong("config_save_timestamp", System.currentTimeMillis());
                boolean commit = edit.commit();
                Log.d("PrefsManager", "Sauvegarde atomique: " + (commit));
                if (commit) {
                    Log.d("PrefsManager", "✅ Sauvegarde réussie!");
                    Log.d("PrefsManager", "Vérification immédiate...");
                    Configuration configuration2 = this.this$0.getConfiguration();
                    Log.d("PrefsManager", "Configuration rechargée:");
                    Log.d("PrefsManager", "  - Prompts: " + configuration2.getPrompts().size());
                    Log.d("PrefsManager", "  - Tonalité: '" + configuration2.getTonality() + "'");
                    if (configuration2.getPrompts().size() == cleanAndValidatePrompts.size()) {
                        Log.d("PrefsManager", "✅ Vérification réussie - sauvegarde confirmée");
                        boxBoolean = Boxing.boxBoolean(true);
                    } else {
                        Log.e("PrefsManager", "❌ Échec vérification - count mismatch");
                        boxBoolean = Boxing.boxBoolean(false);
                    }
                } else {
                    Log.e("PrefsManager", "❌ Échec de l'écriture atomique");
                    boxBoolean = Boxing.boxBoolean(false);
                }
            } catch (Exception e) {
                Log.e("PrefsManager", "❌ Exception lors de la sauvegarde: " + e.getMessage(), e);
                Log.e("PrefsManager", "Stack trace: " + ExceptionsKt.stackTraceToString(e));
                boxBoolean = Boxing.boxBoolean(false);
            }
            return boxBoolean;
        } finally {
            Log.d("PrefsManager", "========================================");
            Log.d("PrefsManager", "FIN SAUVEGARDE CONFIGURATION");
            Log.d("PrefsManager", "========================================");
        }
    }
}
