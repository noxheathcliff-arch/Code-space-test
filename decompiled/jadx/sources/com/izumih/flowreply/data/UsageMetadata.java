package com.izumih.flowreply.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeminiRequest.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ2\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/izumih/flowreply/data/UsageMetadata;", "", "promptTokenCount", "", "candidatesTokenCount", "totalTokenCount", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCandidatesTokenCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPromptTokenCount", "getTotalTokenCount", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/izumih/flowreply/data/UsageMetadata;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class UsageMetadata {
    public static final int $stable = 0;
    private final Integer candidatesTokenCount;
    private final Integer promptTokenCount;
    private final Integer totalTokenCount;

    public UsageMetadata(Integer num, Integer num2, Integer num3) {
        this.promptTokenCount = num;
        this.candidatesTokenCount = num2;
        this.totalTokenCount = num3;
    }

    public static /* synthetic */ UsageMetadata copy$default(UsageMetadata usageMetadata, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = usageMetadata.promptTokenCount;
        }
        if ((i & 2) != 0) {
            num2 = usageMetadata.candidatesTokenCount;
        }
        if ((i & 4) != 0) {
            num3 = usageMetadata.totalTokenCount;
        }
        return usageMetadata.copy(num, num2, num3);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getPromptTokenCount() {
        return this.promptTokenCount;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getCandidatesTokenCount() {
        return this.candidatesTokenCount;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getTotalTokenCount() {
        return this.totalTokenCount;
    }

    public final UsageMetadata copy(Integer promptTokenCount, Integer candidatesTokenCount, Integer totalTokenCount) {
        return new UsageMetadata(promptTokenCount, candidatesTokenCount, totalTokenCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UsageMetadata)) {
            return false;
        }
        UsageMetadata usageMetadata = (UsageMetadata) other;
        return Intrinsics.areEqual(this.promptTokenCount, usageMetadata.promptTokenCount) && Intrinsics.areEqual(this.candidatesTokenCount, usageMetadata.candidatesTokenCount) && Intrinsics.areEqual(this.totalTokenCount, usageMetadata.totalTokenCount);
    }

    public final Integer getCandidatesTokenCount() {
        return this.candidatesTokenCount;
    }

    public final Integer getPromptTokenCount() {
        return this.promptTokenCount;
    }

    public final Integer getTotalTokenCount() {
        return this.totalTokenCount;
    }

    public int hashCode() {
        Integer num = this.promptTokenCount;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.candidatesTokenCount;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.totalTokenCount;
        return hashCode2 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        return "UsageMetadata(promptTokenCount=" + this.promptTokenCount + ", candidatesTokenCount=" + this.candidatesTokenCount + ", totalTokenCount=" + this.totalTokenCount + ")";
    }
}
