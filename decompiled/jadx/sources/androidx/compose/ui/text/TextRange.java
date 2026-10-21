package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TextRange.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b#\u0010\rJ\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010\u001bJ\u000f\u0010&\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u0011\u0010\u0016\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\r\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Landroidx/compose/ui/text/TextRange;", "", "packedValue", "", "constructor-impl", "(J)J", "collapsed", "", "getCollapsed-impl", "(J)Z", "end", "", "getEnd-impl", "(J)I", "length", "getLength-impl", "max", "getMax-impl", "min", "getMin-impl", "reversed", "getReversed-impl", "start", "getStart-impl", "contains", "other", "contains-5zc-tL8", "(JJ)Z", "offset", "contains-impl", "(JI)Z", "equals", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "intersects", "intersects-5zc-tL8", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class TextRange {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = TextRangeKt.TextRange(0);
    private final long packedValue;

    /* compiled from: TextRange.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/TextRange$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/text/TextRange;", "getZero-d9O1mEE", "()J", "J", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-d9O1mEE, reason: not valid java name */
        public final long m5285getZerod9O1mEE() {
            return TextRange.Zero;
        }
    }

    private /* synthetic */ TextRange(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextRange m5268boximpl(long j) {
        return new TextRange(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m5269constructorimpl(long j) {
        return j;
    }

    /* renamed from: contains-5zc-tL8, reason: not valid java name */
    public static final boolean m5270contains5zctL8(long j, long j2) {
        return m5278getMinimpl(j) <= m5278getMinimpl(j2) && m5277getMaximpl(j2) <= m5277getMaximpl(j);
    }

    /* renamed from: contains-impl, reason: not valid java name */
    public static final boolean m5271containsimpl(long j, int i) {
        return i < m5277getMaximpl(j) && m5278getMinimpl(j) <= i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5272equalsimpl(long j, Object obj) {
        return (obj instanceof TextRange) && j == ((TextRange) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5273equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getCollapsed-impl, reason: not valid java name */
    public static final boolean m5274getCollapsedimpl(long j) {
        return m5280getStartimpl(j) == m5275getEndimpl(j);
    }

    /* renamed from: getEnd-impl, reason: not valid java name */
    public static final int m5275getEndimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: getLength-impl, reason: not valid java name */
    public static final int m5276getLengthimpl(long j) {
        return m5277getMaximpl(j) - m5278getMinimpl(j);
    }

    /* renamed from: getMax-impl, reason: not valid java name */
    public static final int m5277getMaximpl(long j) {
        return m5280getStartimpl(j) > m5275getEndimpl(j) ? m5280getStartimpl(j) : m5275getEndimpl(j);
    }

    /* renamed from: getMin-impl, reason: not valid java name */
    public static final int m5278getMinimpl(long j) {
        return m5280getStartimpl(j) > m5275getEndimpl(j) ? m5275getEndimpl(j) : m5280getStartimpl(j);
    }

    /* renamed from: getReversed-impl, reason: not valid java name */
    public static final boolean m5279getReversedimpl(long j) {
        return m5280getStartimpl(j) > m5275getEndimpl(j);
    }

    /* renamed from: getStart-impl, reason: not valid java name */
    public static final int m5280getStartimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5281hashCodeimpl(long j) {
        return UByte$$ExternalSyntheticBackport0.m(j);
    }

    /* renamed from: intersects-5zc-tL8, reason: not valid java name */
    public static final boolean m5282intersects5zctL8(long j, long j2) {
        return m5278getMinimpl(j) < m5277getMaximpl(j2) && m5278getMinimpl(j2) < m5277getMaximpl(j);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5283toStringimpl(long j) {
        return "TextRange(" + m5280getStartimpl(j) + ", " + m5275getEndimpl(j) + ')';
    }

    public boolean equals(Object obj) {
        return m5272equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5281hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m5283toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }
}
