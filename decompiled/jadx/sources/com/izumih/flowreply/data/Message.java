package com.izumih.flowreply.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Message.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/izumih/flowreply/data/Message;", "", "sender", "", "content", "timestamp", "", "isFromUser", "", "(Ljava/lang/String;Ljava/lang/String;JZ)V", "getContent", "()Ljava/lang/String;", "()Z", "getSender", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Message {
    public static final int $stable = 0;
    private final String content;
    private final boolean isFromUser;
    private final String sender;
    private final long timestamp;

    public Message(String sender, String content, long j, boolean z) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(content, "content");
        this.sender = sender;
        this.content = content;
        this.timestamp = j;
        this.isFromUser = z;
    }

    public /* synthetic */ Message(String str, String str2, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, (i & 8) != 0 ? false : z);
    }

    public static /* synthetic */ Message copy$default(Message message, String str, String str2, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = message.sender;
        }
        if ((i & 2) != 0) {
            str2 = message.content;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            j = message.timestamp;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            z = message.isFromUser;
        }
        return message.copy(str, str3, j2, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSender() {
        return this.sender;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsFromUser() {
        return this.isFromUser;
    }

    public final Message copy(String sender, String content, long timestamp, boolean isFromUser) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(content, "content");
        return new Message(sender, content, timestamp, isFromUser);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Message)) {
            return false;
        }
        Message message = (Message) other;
        return Intrinsics.areEqual(this.sender, message.sender) && Intrinsics.areEqual(this.content, message.content) && this.timestamp == message.timestamp && this.isFromUser == message.isFromUser;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getSender() {
        return this.sender;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.sender.hashCode() * 31) + this.content.hashCode()) * 31) + ConversationContext$$ExternalSyntheticBackport0.m(this.timestamp)) * 31;
        boolean z = this.isFromUser;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final boolean isFromUser() {
        return this.isFromUser;
    }

    public String toString() {
        return "Message(sender=" + this.sender + ", content=" + this.content + ", timestamp=" + this.timestamp + ", isFromUser=" + this.isFromUser + ")";
    }
}
