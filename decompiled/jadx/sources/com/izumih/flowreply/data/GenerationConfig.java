package com.izumih.flowreply.data;

import androidx.compose.runtime.ComposerKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeminiRequest.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/izumih/flowreply/data/GenerationConfig;", "", "temperature", "", "topK", "", "topP", "maxOutputTokens", "stopSequences", "", "", "(DIDILjava/util/List;)V", "getMaxOutputTokens", "()I", "getStopSequences", "()Ljava/util/List;", "getTemperature", "()D", "getTopK", "getTopP", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class GenerationConfig {
    public static final int $stable = 8;
    private final int maxOutputTokens;
    private final List<String> stopSequences;
    private final double temperature;
    private final int topK;
    private final double topP;

    public GenerationConfig() {
        this(0.0d, 0, 0.0d, 0, null, 31, null);
    }

    public GenerationConfig(double d, int i, double d2, int i2, List<String> list) {
        this.temperature = d;
        this.topK = i;
        this.topP = d2;
        this.maxOutputTokens = i2;
        this.stopSequences = list;
    }

    public /* synthetic */ GenerationConfig(double d, int i, double d2, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.7d : d, (i3 & 2) != 0 ? 40 : i, (i3 & 4) != 0 ? 0.95d : d2, (i3 & 8) != 0 ? ComposerKt.invocationKey : i2, (i3 & 16) != 0 ? null : list);
    }

    /* renamed from: component1, reason: from getter */
    public final double getTemperature() {
        return this.temperature;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTopK() {
        return this.topK;
    }

    /* renamed from: component3, reason: from getter */
    public final double getTopP() {
        return this.topP;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMaxOutputTokens() {
        return this.maxOutputTokens;
    }

    public final List<String> component5() {
        return this.stopSequences;
    }

    public final GenerationConfig copy(double temperature, int topK, double topP, int maxOutputTokens, List<String> stopSequences) {
        return new GenerationConfig(temperature, topK, topP, maxOutputTokens, stopSequences);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GenerationConfig)) {
            return false;
        }
        GenerationConfig generationConfig = (GenerationConfig) other;
        return Double.compare(this.temperature, generationConfig.temperature) == 0 && this.topK == generationConfig.topK && Double.compare(this.topP, generationConfig.topP) == 0 && this.maxOutputTokens == generationConfig.maxOutputTokens && Intrinsics.areEqual(this.stopSequences, generationConfig.stopSequences);
    }

    public final int getMaxOutputTokens() {
        return this.maxOutputTokens;
    }

    public final List<String> getStopSequences() {
        return this.stopSequences;
    }

    public final double getTemperature() {
        return this.temperature;
    }

    public final int getTopK() {
        return this.topK;
    }

    public final double getTopP() {
        return this.topP;
    }

    public int hashCode() {
        int m = ((((((ConversationContext$$ExternalSyntheticBackport0.m(this.temperature) * 31) + this.topK) * 31) + ConversationContext$$ExternalSyntheticBackport0.m(this.topP)) * 31) + this.maxOutputTokens) * 31;
        List<String> list = this.stopSequences;
        return m + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "GenerationConfig(temperature=" + this.temperature + ", topK=" + this.topK + ", topP=" + this.topP + ", maxOutputTokens=" + this.maxOutputTokens + ", stopSequences=" + this.stopSequences + ")";
    }
}
