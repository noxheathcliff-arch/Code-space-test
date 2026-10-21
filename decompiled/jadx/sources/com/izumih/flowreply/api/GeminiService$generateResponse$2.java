package com.izumih.flowreply.api;

import com.izumih.flowreply.data.ConversationContext;
import com.izumih.flowreply.data.Prompt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: GeminiService.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.izumih.flowreply.api.GeminiService$generateResponse$2", f = "GeminiService.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {127, 133, 179}, m = "invokeSuspend", n = {"$this$withContext", "lastException", "usedApiKeys", "errorMsg", "attempt", "$this$withContext", "lastException", "usedApiKeys", "attempt", "$this$withContext", "lastException", "usedApiKeys"}, s = {"L$0", "L$1", "L$2", "L$7", "I$2", "L$0", "L$1", "L$2", "I$2", "L$0", "L$1", "L$2"})
/* loaded from: classes2.dex */
final class GeminiService$generateResponse$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ ConversationContext $context;
    final /* synthetic */ List<Prompt> $prompts;
    final /* synthetic */ String $tonality;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ GeminiService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GeminiService$generateResponse$2(List<Prompt> list, String str, GeminiService geminiService, ConversationContext conversationContext, Continuation<? super GeminiService$generateResponse$2> continuation) {
        super(2, continuation);
        this.$prompts = list;
        this.$tonality = str;
        this.this$0 = geminiService;
        this.$context = conversationContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GeminiService$generateResponse$2 geminiService$generateResponse$2 = new GeminiService$generateResponse$2(this.$prompts, this.$tonality, this.this$0, this.$context, continuation);
        geminiService$generateResponse$2.L$0 = obj;
        return geminiService$generateResponse$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((GeminiService$generateResponse$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:(1:101)|102|103|104|105|106|107|108|109|110|111|112|(1:114)(6:115|116|117|118|8|(0)(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:143|144|145|146|147|148|149|150|151|152|153|154|155|156|(1:158)(6:159|160|161|162|8|(4:10|(1:12)|13|14)(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(21:(1:16)|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:200|201|202)(1:34)|35|36|(15:87|88|(1:90)(1:196)|91|92|(1:195)(1:96)|97|(11:137|138|139|(4:179|180|181|(4:183|(1:185)(1:188)|186|187)(2:189|190))(15:143|144|145|146|147|148|149|150|151|152|153|154|155|156|(1:158)(6:159|160|161|162|8|(4:10|(1:12)|13|14)(0)))|169|78|79|(2:81|(1:83)(1:84))(2:85|86)|7|8|(0)(0))(13:101|102|103|104|105|106|107|108|109|110|111|112|(1:114)(6:115|116|117|118|8|(0)(0)))|125|78|79|(0)(0)|7|8|(0)(0))(5:38|39|40|(1:74)(1:44)|(4:48|49|50|(2:68|69)(2:62|(2:64|65)(2:66|67)))(2:46|47))) */
    /* JADX WARN: Can't wrap try/catch for region: R(21:16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:200|201|202)(1:34)|35|36|(15:87|88|(1:90)(1:196)|91|92|(1:195)(1:96)|97|(11:137|138|139|(4:179|180|181|(4:183|(1:185)(1:188)|186|187)(2:189|190))(15:143|144|145|146|147|148|149|150|151|152|153|154|155|156|(1:158)(6:159|160|161|162|8|(4:10|(1:12)|13|14)(0)))|169|78|79|(2:81|(1:83)(1:84))(2:85|86)|7|8|(0)(0))(13:101|102|103|104|105|106|107|108|109|110|111|112|(1:114)(6:115|116|117|118|8|(0)(0)))|125|78|79|(0)(0)|7|8|(0)(0))(5:38|39|40|(1:74)(1:44)|(4:48|49|50|(2:68|69)(2:62|(2:64|65)(2:66|67)))(2:46|47))) */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x030a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x030b, code lost:
    
        r1 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x030f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0310, code lost:
    
        r1 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0510, code lost:
    
        r2 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0314, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0315, code lost:
    
        r1 = r35;
        r2 = r18;
        r11 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x03a6, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03b4, code lost:
    
        r1 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x03a8, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x03b2, code lost:
    
        r3 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x03aa, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x03ab, code lost:
    
        r3 = r20;
        r2 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x03b0, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x03b1, code lost:
    
        r2 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x04ef, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x04f0, code lost:
    
        r1 = r35;
        r2 = r18;
        r8 = r20;
        r12 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0502, code lost:
    
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x04fa, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x04fb, code lost:
    
        r1 = r35;
        r2 = r18;
        r8 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0505, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0506, code lost:
    
        r1 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0509, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x050a, code lost:
    
        r1 = r35;
        r19 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0514, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0515, code lost:
    
        r1 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x051a, code lost:
    
        r19 = r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0592  */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v61 */
    /* JADX WARN: Type inference failed for: r1v8, types: [T, java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.Exception] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:117:0x02fe -> B:8:0x059a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:161:0x0393 -> B:8:0x059a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r35) {
        /*
            Method dump skipped, instructions count: 1487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.izumih.flowreply.api.GeminiService$generateResponse$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
