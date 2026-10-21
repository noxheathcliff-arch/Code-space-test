package com.izumih.flowreply.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeminiRequest.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/izumih/flowreply/data/DynamicRetrievalConfig;", "", "mode", "", "dynamicThreshold", "", "(Ljava/lang/String;D)V", "getDynamicThreshold", "()D", "getMode", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DynamicRetrievalConfig {
    public static final int $stable = 0;
    private final double dynamicThreshold;
    private final String mode;

    public DynamicRetrievalConfig() {
        this(null, 0.0d, 3, null);
    }

    public DynamicRetrievalConfig(String mode, double d) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.mode = mode;
        this.dynamicThreshold = d;
    }

    public /* synthetic */ DynamicRetrievalConfig(String str, double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "MODE_DYNAMIC" : str, (i & 2) != 0 ? 0.7d : d);
    }

    public static /* synthetic */ DynamicRetrievalConfig copy$default(DynamicRetrievalConfig dynamicRetrievalConfig, String str, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dynamicRetrievalConfig.mode;
        }
        if ((i & 2) != 0) {
            d = dynamicRetrievalConfig.dynamicThreshold;
        }
        return dynamicRetrievalConfig.copy(str, d);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* renamed from: component2, reason: from getter */
    public final double getDynamicThreshold() {
        return this.dynamicThreshold;
    }

    public final DynamicRetrievalConfig copy(String mode, double dynamicThreshold) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        return new DynamicRetrievalConfig(mode, dynamicThreshold);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DynamicRetrievalConfig)) {
            return false;
        }
        DynamicRetrievalConfig dynamicRetrievalConfig = (DynamicRetrievalConfig) other;
        return Intrinsics.areEqual(this.mode, dynamicRetrievalConfig.mode) && Double.compare(this.dynamicThreshold, dynamicRetrievalConfig.dynamicThreshold) == 0;
    }

    public final double getDynamicThreshold() {
        return this.dynamicThreshold;
    }

    public final String getMode() {
        return this.mode;
    }

    public int hashCode() {
        return (this.mode.hashCode() * 31) + ConversationContext$$ExternalSyntheticBackport0.m(this.dynamicThreshold);
    }

    public String toString() {
        return "DynamicRetrievalConfig(mode=" + this.mode + ", dynamicThreshold=" + this.dynamicThreshold + ")";
    }
}
