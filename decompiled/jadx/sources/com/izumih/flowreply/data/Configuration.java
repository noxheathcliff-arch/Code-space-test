package com.izumih.flowreply.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Configuration.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/izumih/flowreply/data/Configuration;", "", "prompts", "", "Lcom/izumih/flowreply/data/Prompt;", "tonality", "", "(Ljava/util/List;Ljava/lang/String;)V", "getPrompts", "()Ljava/util/List;", "getTonality", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Configuration {
    public static final int $stable = 8;
    private final List<Prompt> prompts;
    private final String tonality;

    /* JADX WARN: Multi-variable type inference failed */
    public Configuration() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public Configuration(List<Prompt> prompts, String tonality) {
        Intrinsics.checkNotNullParameter(prompts, "prompts");
        Intrinsics.checkNotNullParameter(tonality, "tonality");
        this.prompts = prompts;
        this.tonality = tonality;
    }

    public /* synthetic */ Configuration(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? "" : str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Configuration copy$default(Configuration configuration, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = configuration.prompts;
        }
        if ((i & 2) != 0) {
            str = configuration.tonality;
        }
        return configuration.copy(list, str);
    }

    public final List<Prompt> component1() {
        return this.prompts;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTonality() {
        return this.tonality;
    }

    public final Configuration copy(List<Prompt> prompts, String tonality) {
        Intrinsics.checkNotNullParameter(prompts, "prompts");
        Intrinsics.checkNotNullParameter(tonality, "tonality");
        return new Configuration(prompts, tonality);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) other;
        return Intrinsics.areEqual(this.prompts, configuration.prompts) && Intrinsics.areEqual(this.tonality, configuration.tonality);
    }

    public final List<Prompt> getPrompts() {
        return this.prompts;
    }

    public final String getTonality() {
        return this.tonality;
    }

    public int hashCode() {
        return (this.prompts.hashCode() * 31) + this.tonality.hashCode();
    }

    public String toString() {
        return "Configuration(prompts=" + this.prompts + ", tonality=" + this.tonality + ")";
    }
}
