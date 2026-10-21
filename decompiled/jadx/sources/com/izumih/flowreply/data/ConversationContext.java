package com.izumih.flowreply.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Message.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/izumih/flowreply/data/ConversationContext;", "", "messages", "", "Lcom/izumih/flowreply/data/Message;", "appPackage", "", "timestamp", "", "(Ljava/util/List;Ljava/lang/String;J)V", "getAppPackage", "()Ljava/lang/String;", "getMessages", "()Ljava/util/List;", "getTimestamp", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ConversationContext {
    public static final int $stable = 8;
    private final String appPackage;
    private final List<Message> messages;
    private final long timestamp;

    public ConversationContext(List<Message> messages, String appPackage, long j) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        Intrinsics.checkNotNullParameter(appPackage, "appPackage");
        this.messages = messages;
        this.appPackage = appPackage;
        this.timestamp = j;
    }

    public /* synthetic */ ConversationContext(List list, String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, (i & 4) != 0 ? System.currentTimeMillis() : j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConversationContext copy$default(ConversationContext conversationContext, List list, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list = conversationContext.messages;
        }
        if ((i & 2) != 0) {
            str = conversationContext.appPackage;
        }
        if ((i & 4) != 0) {
            j = conversationContext.timestamp;
        }
        return conversationContext.copy(list, str, j);
    }

    public final List<Message> component1() {
        return this.messages;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppPackage() {
        return this.appPackage;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final ConversationContext copy(List<Message> messages, String appPackage, long timestamp) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        Intrinsics.checkNotNullParameter(appPackage, "appPackage");
        return new ConversationContext(messages, appPackage, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationContext)) {
            return false;
        }
        ConversationContext conversationContext = (ConversationContext) other;
        return Intrinsics.areEqual(this.messages, conversationContext.messages) && Intrinsics.areEqual(this.appPackage, conversationContext.appPackage) && this.timestamp == conversationContext.timestamp;
    }

    public final String getAppPackage() {
        return this.appPackage;
    }

    public final List<Message> getMessages() {
        return this.messages;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((this.messages.hashCode() * 31) + this.appPackage.hashCode()) * 31) + ConversationContext$$ExternalSyntheticBackport0.m(this.timestamp);
    }

    public String toString() {
        return "ConversationContext(messages=" + this.messages + ", appPackage=" + this.appPackage + ", timestamp=" + this.timestamp + ")";
    }
}
