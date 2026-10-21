package com.izumih.flowreply.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeminiRequest.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/izumih/flowreply/data/GeminiResponse;", "", "candidates", "", "Lcom/izumih/flowreply/data/Candidate;", "usageMetadata", "Lcom/izumih/flowreply/data/UsageMetadata;", "(Ljava/util/List;Lcom/izumih/flowreply/data/UsageMetadata;)V", "getCandidates", "()Ljava/util/List;", "getUsageMetadata", "()Lcom/izumih/flowreply/data/UsageMetadata;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class GeminiResponse {
    public static final int $stable = 8;
    private final List<Candidate> candidates;
    private final UsageMetadata usageMetadata;

    public GeminiResponse(List<Candidate> list, UsageMetadata usageMetadata) {
        this.candidates = list;
        this.usageMetadata = usageMetadata;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GeminiResponse copy$default(GeminiResponse geminiResponse, List list, UsageMetadata usageMetadata, int i, Object obj) {
        if ((i & 1) != 0) {
            list = geminiResponse.candidates;
        }
        if ((i & 2) != 0) {
            usageMetadata = geminiResponse.usageMetadata;
        }
        return geminiResponse.copy(list, usageMetadata);
    }

    public final List<Candidate> component1() {
        return this.candidates;
    }

    /* renamed from: component2, reason: from getter */
    public final UsageMetadata getUsageMetadata() {
        return this.usageMetadata;
    }

    public final GeminiResponse copy(List<Candidate> candidates, UsageMetadata usageMetadata) {
        return new GeminiResponse(candidates, usageMetadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GeminiResponse)) {
            return false;
        }
        GeminiResponse geminiResponse = (GeminiResponse) other;
        return Intrinsics.areEqual(this.candidates, geminiResponse.candidates) && Intrinsics.areEqual(this.usageMetadata, geminiResponse.usageMetadata);
    }

    public final List<Candidate> getCandidates() {
        return this.candidates;
    }

    public final UsageMetadata getUsageMetadata() {
        return this.usageMetadata;
    }

    public int hashCode() {
        List<Candidate> list = this.candidates;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        UsageMetadata usageMetadata = this.usageMetadata;
        return hashCode + (usageMetadata != null ? usageMetadata.hashCode() : 0);
    }

    public String toString() {
        return "GeminiResponse(candidates=" + this.candidates + ", usageMetadata=" + this.usageMetadata + ")";
    }
}
