package com.izumih.flowreply.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Prompt.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/izumih/flowreply/data/Prompt;", "", "id", "", "content", "isEnabled", "", "createdAt", "", "(Ljava/lang/String;Ljava/lang/String;ZJ)V", "getContent", "()Ljava/lang/String;", "getCreatedAt", "()J", "getId", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Prompt {
    public static final int $stable = 0;
    private final String content;
    private final long createdAt;
    private final String id;
    private final boolean isEnabled;

    public Prompt(String id, String content, boolean z, long j) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(content, "content");
        this.id = id;
        this.content = content;
        this.isEnabled = z;
        this.createdAt = j;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ Prompt(java.lang.String r7, java.lang.String r8, boolean r9, long r10, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 1
            if (r13 == 0) goto L11
            java.util.UUID r7 = java.util.UUID.randomUUID()
            java.lang.String r7 = r7.toString()
            java.lang.String r13 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r13)
        L11:
            r1 = r7
            r7 = r12 & 4
            if (r7 == 0) goto L19
            r9 = 1
            r3 = 1
            goto L1a
        L19:
            r3 = r9
        L1a:
            r7 = r12 & 8
            if (r7 == 0) goto L22
            long r10 = java.lang.System.currentTimeMillis()
        L22:
            r4 = r10
            r0 = r6
            r2 = r8
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.izumih.flowreply.data.Prompt.<init>(java.lang.String, java.lang.String, boolean, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ Prompt copy$default(Prompt prompt, String str, String str2, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = prompt.id;
        }
        if ((i & 2) != 0) {
            str2 = prompt.content;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z = prompt.isEnabled;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            j = prompt.createdAt;
        }
        return prompt.copy(str, str3, z2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final Prompt copy(String id, String content, boolean isEnabled, long createdAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(content, "content");
        return new Prompt(id, content, isEnabled, createdAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Prompt)) {
            return false;
        }
        Prompt prompt = (Prompt) other;
        return Intrinsics.areEqual(this.id, prompt.id) && Intrinsics.areEqual(this.content, prompt.content) && this.isEnabled == prompt.isEnabled && this.createdAt == prompt.createdAt;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getId() {
        return this.id;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.id.hashCode() * 31) + this.content.hashCode()) * 31;
        boolean z = this.isEnabled;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((hashCode + i) * 31) + ConversationContext$$ExternalSyntheticBackport0.m(this.createdAt);
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public String toString() {
        return "Prompt(id=" + this.id + ", content=" + this.content + ", isEnabled=" + this.isEnabled + ", createdAt=" + this.createdAt + ")";
    }
}
