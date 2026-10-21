package com.izumih.flowreply.data;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class ConversationContext$$ExternalSyntheticBackport0 {
    public static /* synthetic */ int m(double d) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public static /* synthetic */ int m(long j) {
        return (int) (j ^ (j >>> 32));
    }
}
