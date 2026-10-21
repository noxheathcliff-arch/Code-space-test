package com.izumih.flowreply.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.gson.Gson;
import com.izumih.flowreply.data.Configuration;
import com.izumih.flowreply.data.Prompt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: PreferencesManager.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0019\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/izumih/flowreply/util/PreferencesManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "gson", "Lcom/google/gson/Gson;", "prefs", "Landroid/content/SharedPreferences;", "cleanAndValidatePrompts", "", "Lcom/izumih/flowreply/data/Prompt;", "prompts", "clearConfiguration", "", "getConfiguration", "Lcom/izumih/flowreply/data/Configuration;", "hasConfiguration", "", "isOnboardingCompleted", "saveConfiguration", "configuration", "(Lcom/izumih/flowreply/data/Configuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setOnboardingCompleted", "completed", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PreferencesManager {
    private static final String KEY_ONBOARDING = "onboarding_completed";
    private static final String KEY_PROMPTS = "config_prompts";
    private static final String KEY_SAVE_TIMESTAMP = "config_save_timestamp";
    private static final String KEY_TONALITY = "config_tonality";
    private static final String TAG = "PrefsManager";
    private final Gson gson;
    private final SharedPreferences prefs;
    public static final int $stable = 8;

    public PreferencesManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("flowreply_prefs", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.prefs = sharedPreferences;
        this.gson = new Gson();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c A[Catch: Exception -> 0x00c7, TryCatch #0 {Exception -> 0x00c7, blocks: (B:9:0x0027, B:11:0x0030, B:16:0x003c, B:17:0x0049, B:22:0x006a, B:24:0x007a, B:25:0x0083, B:28:0x007f, B:29:0x00af, B:31:0x0045), top: B:8:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006a A[Catch: Exception -> 0x00c7, TRY_ENTER, TryCatch #0 {Exception -> 0x00c7, blocks: (B:9:0x0027, B:11:0x0030, B:16:0x003c, B:17:0x0049, B:22:0x006a, B:24:0x007a, B:25:0x0083, B:28:0x007f, B:29:0x00af, B:31:0x0045), top: B:8:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00af A[Catch: Exception -> 0x00c7, TRY_LEAVE, TryCatch #0 {Exception -> 0x00c7, blocks: (B:9:0x0027, B:11:0x0030, B:16:0x003c, B:17:0x0049, B:22:0x006a, B:24:0x007a, B:25:0x0083, B:28:0x007f, B:29:0x00af, B:31:0x0045), top: B:8:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0045 A[Catch: Exception -> 0x00c7, TryCatch #0 {Exception -> 0x00c7, blocks: (B:9:0x0027, B:11:0x0030, B:16:0x003c, B:17:0x0049, B:22:0x006a, B:24:0x007a, B:25:0x0083, B:28:0x007f, B:29:0x00af, B:31:0x0045), top: B:8:0x0027 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.izumih.flowreply.data.Prompt> cleanAndValidatePrompts(java.util.List<com.izumih.flowreply.data.Prompt> r19) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.izumih.flowreply.util.PreferencesManager.cleanAndValidatePrompts(java.util.List):java.util.List");
    }

    public final void clearConfiguration() {
        this.prefs.edit().remove(KEY_TONALITY).remove(KEY_PROMPTS).remove(KEY_SAVE_TIMESTAMP).commit();
        Log.d(TAG, "Configuration effacée");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008c A[Catch: Exception -> 0x015b, all -> 0x015d, TRY_LEAVE, TryCatch #2 {Exception -> 0x015b, blocks: (B:9:0x0037, B:11:0x0054, B:12:0x006c, B:14:0x0080, B:19:0x008c, B:25:0x00b1, B:27:0x010c, B:28:0x0111, B:33:0x013d), top: B:8:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.izumih.flowreply.data.Configuration getConfiguration() {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.izumih.flowreply.util.PreferencesManager.getConfiguration():com.izumih.flowreply.data.Configuration");
    }

    public final boolean hasConfiguration() {
        try {
            List<Prompt> prompts = getConfiguration().getPrompts();
            if ((prompts instanceof Collection) && prompts.isEmpty()) {
                return false;
            }
            Iterator<T> it = prompts.iterator();
            while (it.hasNext()) {
                if (StringsKt.trim((CharSequence) ((Prompt) it.next()).getContent()).toString().length() > 0) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            Log.e(TAG, "Erreur vérification configuration", e);
            return false;
        }
    }

    public final boolean isOnboardingCompleted() {
        return this.prefs.getBoolean(KEY_ONBOARDING, false);
    }

    public final Object saveConfiguration(Configuration configuration, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PreferencesManager$saveConfiguration$2(configuration, this, null), continuation);
    }

    public final void setOnboardingCompleted(boolean completed) {
        this.prefs.edit().putBoolean(KEY_ONBOARDING, completed).commit();
        Log.d(TAG, "Onboarding completed: " + completed);
    }
}
