package com.izumih.flowreply.api;

import android.util.Log;
import com.google.gson.Gson;
import com.izumih.flowreply.data.ConversationContext;
import com.izumih.flowreply.data.Message;
import com.izumih.flowreply.data.Prompt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.OkHttpClient;

/* compiled from: GeminiService.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001e\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J/\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0006\u0010\u0010\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/izumih/flowreply/api/GeminiService;", "", "()V", "apiKeys", "", "", "client", "Lokhttp3/OkHttpClient;", "gson", "Lcom/google/gson/Gson;", "buildConversationText", "context", "Lcom/izumih/flowreply/data/ConversationContext;", "buildSystemPrompt", "prompts", "Lcom/izumih/flowreply/data/Prompt;", "tonality", "calculateBackoffTime", "", "attempt", "", "generateResponse", "(Lcom/izumih/flowreply/data/ConversationContext;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRandomApiKey", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GeminiService {
    private static final int MAX_RETRIES = 3;
    private static final long RETRY_DELAY_MS = 1000;
    private static final String TAG = "GeminiService";
    private final List<String> apiKeys = CollectionsKt.listOf((Object[]) new String[]{"<REDACTED_GEMINI_API_KEY>", "<REDACTED_GEMINI_API_KEY>", "<REDACTED_GEMINI_API_KEY>", "<REDACTED_GEMINI_API_KEY>", "<REDACTED_GEMINI_API_KEY>"});
    private final OkHttpClient client = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build();
    private final Gson gson = new Gson();
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildConversationText(ConversationContext context) {
        return context.getMessages().isEmpty() ? "Aucun message" : CollectionsKt.joinToString$default(CollectionsKt.takeLast(context.getMessages(), 5), "\n", null, null, 0, null, new Function1<Message, CharSequence>() { // from class: com.izumih.flowreply.api.GeminiService$buildConversationText$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Message message) {
                String str;
                Intrinsics.checkNotNullParameter(message, "message");
                if (message.isFromUser()) {
                    str = "Moi:";
                } else {
                    str = message.getSender() + ":";
                }
                return str + " " + message.getContent();
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildSystemPrompt(List<Prompt> prompts, String tonality) {
        String str;
        ArrayList arrayList = new ArrayList();
        for (Object obj : prompts) {
            if (((Prompt) obj).isEnabled()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        Log.d(TAG, "Construction prompt système: " + arrayList2.size() + "/" + prompts.size() + " prompts activés");
        if (!arrayList2.isEmpty()) {
            Iterator it = arrayList2.iterator();
            str = "Tu es un assistant qui génère des réponses courtes et précises.\n\nRÈGLES À RESPECTER:";
            while (it.hasNext()) {
                str = ((Object) str) + "\n- " + ((Prompt) it.next()).getContent();
            }
            Log.d(TAG, "✓ " + arrayList2.size() + " prompts ajoutés");
        } else {
            Log.w(TAG, "ATTENTION: Aucun prompt activé!");
            str = "Tu es un assistant qui génère des réponses courtes et précises.";
        }
        if (!(!StringsKt.isBlank(tonality))) {
            Log.d(TAG, "Aucune tonalité définie");
            return str;
        }
        String str2 = ((Object) str) + "\n\nTONALITÉ À ADOPTER: " + tonality;
        Log.d(TAG, "✓ Tonalité ajoutée");
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long calculateBackoffTime(int attempt) {
        return ((1 << attempt) * 1000) + ((long) (Math.random() * 1000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getRandomApiKey() {
        return this.apiKeys.get(Random.INSTANCE.nextInt(this.apiKeys.size()));
    }

    public final Object generateResponse(ConversationContext conversationContext, List<Prompt> list, String str, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GeminiService$generateResponse$2(list, str, this, conversationContext, null), continuation);
    }
}
