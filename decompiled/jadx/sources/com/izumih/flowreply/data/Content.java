package com.izumih.flowreply.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeminiRequest.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/izumih/flowreply/data/Content;", "", "parts", "", "Lcom/izumih/flowreply/data/Part;", "role", "", "(Ljava/util/List;Ljava/lang/String;)V", "getParts", "()Ljava/util/List;", "getRole", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Content {
    public static final int $stable = 8;
    private final List<Part> parts;
    private final String role;

    public Content(List<Part> parts, String role) {
        Intrinsics.checkNotNullParameter(parts, "parts");
        Intrinsics.checkNotNullParameter(role, "role");
        this.parts = parts;
        this.role = role;
    }

    public /* synthetic */ Content(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? "user" : str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Content copy$default(Content content, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = content.parts;
        }
        if ((i & 2) != 0) {
            str = content.role;
        }
        return content.copy(list, str);
    }

    public final List<Part> component1() {
        return this.parts;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    public final Content copy(List<Part> parts, String role) {
        Intrinsics.checkNotNullParameter(parts, "parts");
        Intrinsics.checkNotNullParameter(role, "role");
        return new Content(parts, role);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Content)) {
            return false;
        }
        Content content = (Content) other;
        return Intrinsics.areEqual(this.parts, content.parts) && Intrinsics.areEqual(this.role, content.role);
    }

    public final List<Part> getParts() {
        return this.parts;
    }

    public final String getRole() {
        return this.role;
    }

    public int hashCode() {
        return (this.parts.hashCode() * 31) + this.role.hashCode();
    }

    public String toString() {
        return "Content(parts=" + this.parts + ", role=" + this.role + ")";
    }
}
