package com.izumih.flowreply.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeminiRequest.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/izumih/flowreply/data/Tool;", "", "googleSearchRetrieval", "Lcom/izumih/flowreply/data/GoogleSearchRetrieval;", "googleSearch", "Lcom/izumih/flowreply/data/GoogleSearch;", "(Lcom/izumih/flowreply/data/GoogleSearchRetrieval;Lcom/izumih/flowreply/data/GoogleSearch;)V", "getGoogleSearch", "()Lcom/izumih/flowreply/data/GoogleSearch;", "getGoogleSearchRetrieval", "()Lcom/izumih/flowreply/data/GoogleSearchRetrieval;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Tool {
    public static final int $stable = 0;
    private final GoogleSearch googleSearch;
    private final GoogleSearchRetrieval googleSearchRetrieval;

    /* JADX WARN: Multi-variable type inference failed */
    public Tool() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public Tool(GoogleSearchRetrieval googleSearchRetrieval, GoogleSearch googleSearch) {
        this.googleSearchRetrieval = googleSearchRetrieval;
        this.googleSearch = googleSearch;
    }

    public /* synthetic */ Tool(GoogleSearchRetrieval googleSearchRetrieval, GoogleSearch googleSearch, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : googleSearchRetrieval, (i & 2) != 0 ? null : googleSearch);
    }

    public static /* synthetic */ Tool copy$default(Tool tool, GoogleSearchRetrieval googleSearchRetrieval, GoogleSearch googleSearch, int i, Object obj) {
        if ((i & 1) != 0) {
            googleSearchRetrieval = tool.googleSearchRetrieval;
        }
        if ((i & 2) != 0) {
            googleSearch = tool.googleSearch;
        }
        return tool.copy(googleSearchRetrieval, googleSearch);
    }

    /* renamed from: component1, reason: from getter */
    public final GoogleSearchRetrieval getGoogleSearchRetrieval() {
        return this.googleSearchRetrieval;
    }

    /* renamed from: component2, reason: from getter */
    public final GoogleSearch getGoogleSearch() {
        return this.googleSearch;
    }

    public final Tool copy(GoogleSearchRetrieval googleSearchRetrieval, GoogleSearch googleSearch) {
        return new Tool(googleSearchRetrieval, googleSearch);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tool)) {
            return false;
        }
        Tool tool = (Tool) other;
        return Intrinsics.areEqual(this.googleSearchRetrieval, tool.googleSearchRetrieval) && Intrinsics.areEqual(this.googleSearch, tool.googleSearch);
    }

    public final GoogleSearch getGoogleSearch() {
        return this.googleSearch;
    }

    public final GoogleSearchRetrieval getGoogleSearchRetrieval() {
        return this.googleSearchRetrieval;
    }

    public int hashCode() {
        GoogleSearchRetrieval googleSearchRetrieval = this.googleSearchRetrieval;
        int hashCode = (googleSearchRetrieval == null ? 0 : googleSearchRetrieval.hashCode()) * 31;
        GoogleSearch googleSearch = this.googleSearch;
        return hashCode + (googleSearch != null ? googleSearch.hashCode() : 0);
    }

    public String toString() {
        return "Tool(googleSearchRetrieval=" + this.googleSearchRetrieval + ", googleSearch=" + this.googleSearch + ")";
    }
}
