package com.izumih.flowreply.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeminiRequest.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/izumih/flowreply/data/GeminiRequest;", "", "contents", "", "Lcom/izumih/flowreply/data/Content;", "generationConfig", "Lcom/izumih/flowreply/data/GenerationConfig;", "tools", "Lcom/izumih/flowreply/data/Tool;", "(Ljava/util/List;Lcom/izumih/flowreply/data/GenerationConfig;Ljava/util/List;)V", "getContents", "()Ljava/util/List;", "getGenerationConfig", "()Lcom/izumih/flowreply/data/GenerationConfig;", "getTools", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class GeminiRequest {
    public static final int $stable = 8;
    private final List<Content> contents;
    private final GenerationConfig generationConfig;
    private final List<Tool> tools;

    public GeminiRequest(List<Content> contents, GenerationConfig generationConfig, List<Tool> list) {
        Intrinsics.checkNotNullParameter(contents, "contents");
        this.contents = contents;
        this.generationConfig = generationConfig;
        this.tools = list;
    }

    public /* synthetic */ GeminiRequest(List list, GenerationConfig generationConfig, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : generationConfig, (i & 4) != 0 ? null : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GeminiRequest copy$default(GeminiRequest geminiRequest, List list, GenerationConfig generationConfig, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = geminiRequest.contents;
        }
        if ((i & 2) != 0) {
            generationConfig = geminiRequest.generationConfig;
        }
        if ((i & 4) != 0) {
            list2 = geminiRequest.tools;
        }
        return geminiRequest.copy(list, generationConfig, list2);
    }

    public final List<Content> component1() {
        return this.contents;
    }

    /* renamed from: component2, reason: from getter */
    public final GenerationConfig getGenerationConfig() {
        return this.generationConfig;
    }

    public final List<Tool> component3() {
        return this.tools;
    }

    public final GeminiRequest copy(List<Content> contents, GenerationConfig generationConfig, List<Tool> tools) {
        Intrinsics.checkNotNullParameter(contents, "contents");
        return new GeminiRequest(contents, generationConfig, tools);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GeminiRequest)) {
            return false;
        }
        GeminiRequest geminiRequest = (GeminiRequest) other;
        return Intrinsics.areEqual(this.contents, geminiRequest.contents) && Intrinsics.areEqual(this.generationConfig, geminiRequest.generationConfig) && Intrinsics.areEqual(this.tools, geminiRequest.tools);
    }

    public final List<Content> getContents() {
        return this.contents;
    }

    public final GenerationConfig getGenerationConfig() {
        return this.generationConfig;
    }

    public final List<Tool> getTools() {
        return this.tools;
    }

    public int hashCode() {
        int hashCode = this.contents.hashCode() * 31;
        GenerationConfig generationConfig = this.generationConfig;
        int hashCode2 = (hashCode + (generationConfig == null ? 0 : generationConfig.hashCode())) * 31;
        List<Tool> list = this.tools;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "GeminiRequest(contents=" + this.contents + ", generationConfig=" + this.generationConfig + ", tools=" + this.tools + ")";
    }
}
