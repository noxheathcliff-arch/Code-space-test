package com.izumih.flowreply.ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/izumih/flowreply/ui/Screen;", "", "(Ljava/lang/String;I)V", "Splash", "Onboarding", "FloatingBubble", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Screen {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Screen[] $VALUES;
    public static final Screen Splash = new Screen("Splash", 0);
    public static final Screen Onboarding = new Screen("Onboarding", 1);
    public static final Screen FloatingBubble = new Screen("FloatingBubble", 2);

    private static final /* synthetic */ Screen[] $values() {
        return new Screen[]{Splash, Onboarding, FloatingBubble};
    }

    static {
        Screen[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private Screen(String str, int i) {
    }

    public static EnumEntries<Screen> getEntries() {
        return $ENTRIES;
    }

    public static Screen valueOf(String str) {
        return (Screen) Enum.valueOf(Screen.class, str);
    }

    public static Screen[] values() {
        return (Screen[]) $VALUES.clone();
    }
}
