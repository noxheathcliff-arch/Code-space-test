package com.izumih.flowreply.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeminiRequest.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JD\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/izumih/flowreply/data/Candidate;", "", "content", "Lcom/izumih/flowreply/data/Content;", "finishReason", "", "index", "", "safetyRatings", "", "Lcom/izumih/flowreply/data/SafetyRating;", "(Lcom/izumih/flowreply/data/Content;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getContent", "()Lcom/izumih/flowreply/data/Content;", "getFinishReason", "()Ljava/lang/String;", "getIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSafetyRatings", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Lcom/izumih/flowreply/data/Content;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/izumih/flowreply/data/Candidate;", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Candidate {
    public static final int $stable = 8;
    private final Content content;
    private final String finishReason;
    private final Integer index;
    private final List<SafetyRating> safetyRatings;

    public Candidate(Content content, String str, Integer num, List<SafetyRating> list) {
        this.content = content;
        this.finishReason = str;
        this.index = num;
        this.safetyRatings = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Candidate copy$default(Candidate candidate, Content content, String str, Integer num, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            content = candidate.content;
        }
        if ((i & 2) != 0) {
            str = candidate.finishReason;
        }
        if ((i & 4) != 0) {
            num = candidate.index;
        }
        if ((i & 8) != 0) {
            list = candidate.safetyRatings;
        }
        return candidate.copy(content, str, num, list);
    }

    /* renamed from: component1, reason: from getter */
    public final Content getContent() {
        return this.content;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFinishReason() {
        return this.finishReason;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getIndex() {
        return this.index;
    }

    public final List<SafetyRating> component4() {
        return this.safetyRatings;
    }

    public final Candidate copy(Content content, String finishReason, Integer index, List<SafetyRating> safetyRatings) {
        return new Candidate(content, finishReason, index, safetyRatings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Candidate)) {
            return false;
        }
        Candidate candidate = (Candidate) other;
        return Intrinsics.areEqual(this.content, candidate.content) && Intrinsics.areEqual(this.finishReason, candidate.finishReason) && Intrinsics.areEqual(this.index, candidate.index) && Intrinsics.areEqual(this.safetyRatings, candidate.safetyRatings);
    }

    public final Content getContent() {
        return this.content;
    }

    public final String getFinishReason() {
        return this.finishReason;
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final List<SafetyRating> getSafetyRatings() {
        return this.safetyRatings;
    }

    public int hashCode() {
        Content content = this.content;
        int hashCode = (content == null ? 0 : content.hashCode()) * 31;
        String str = this.finishReason;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.index;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        List<SafetyRating> list = this.safetyRatings;
        return hashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "Candidate(content=" + this.content + ", finishReason=" + this.finishReason + ", index=" + this.index + ", safetyRatings=" + this.safetyRatings + ")";
    }
}
