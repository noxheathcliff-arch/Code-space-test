package com.izumih.flowreply.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeminiRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/izumih/flowreply/data/Part;", "", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Part {
    public static final int $stable = 0;
    private final String text;

    public Part(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
    }

    public static /* synthetic */ Part copy$default(Part part, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = part.text;
        }
        return part.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final Part copy(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new Part(text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Part) && Intrinsics.areEqual(this.text, ((Part) other).text);
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return this.text.hashCode();
    }

    public String toString() {
        return "Part(text=" + this.text + ")";
    }
}
