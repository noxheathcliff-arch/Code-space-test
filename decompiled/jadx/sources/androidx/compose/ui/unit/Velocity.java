package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: Velocity.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 22\u00020\u0001:\u00012B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b\u0012\u0010\u000bJ'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001b\u0010#\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b'\u0010%J\u001e\u0010(\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010\u0019J\u001e\u0010*\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010\u0019J\u000f\u0010,\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"Landroidx/compose/ui/unit/Velocity;", "", "packedValue", "", "constructor-impl", "(J)J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-OhffZ5M", "(JFF)J", "div", "operand", "div-adjELrA", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "minus", "minus-AH228Gc", "(JJ)J", "plus", "plus-AH228Gc", "rem", "rem-adjELrA", "times", "times-adjELrA", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-9UxMQ8M", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class Velocity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = VelocityKt.Velocity(0.0f, 0.0f);
    private final long packedValue;

    /* compiled from: Velocity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\t"}, d2 = {"Landroidx/compose/ui/unit/Velocity$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/unit/Velocity;", "getZero-9UxMQ8M$annotations", "getZero-9UxMQ8M", "()J", "J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-9UxMQ8M$annotations, reason: not valid java name */
        public static /* synthetic */ void m6042getZero9UxMQ8M$annotations() {
        }

        /* renamed from: getZero-9UxMQ8M, reason: not valid java name */
        public final long m6043getZero9UxMQ8M() {
            return Velocity.Zero;
        }
    }

    private /* synthetic */ Velocity(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Velocity m6023boximpl(long j) {
        return new Velocity(j);
    }

    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m6024component1impl(long j) {
        return m6032getXimpl(j);
    }

    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m6025component2impl(long j) {
        return m6033getYimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m6026constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-OhffZ5M, reason: not valid java name */
    public static final long m6027copyOhffZ5M(long j, float f, float f2) {
        return VelocityKt.Velocity(f, f2);
    }

    /* renamed from: copy-OhffZ5M$default, reason: not valid java name */
    public static /* synthetic */ long m6028copyOhffZ5M$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m6032getXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m6033getYimpl(j);
        }
        return m6027copyOhffZ5M(j, f, f2);
    }

    /* renamed from: div-adjELrA, reason: not valid java name */
    public static final long m6029divadjELrA(long j, float f) {
        return VelocityKt.Velocity(m6032getXimpl(j) / f, m6033getYimpl(j) / f);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m6030equalsimpl(long j, Object obj) {
        return (obj instanceof Velocity) && j == ((Velocity) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6031equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getX$annotations() {
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final float m6032getXimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final float m6033getYimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m6034hashCodeimpl(long j) {
        return UByte$$ExternalSyntheticBackport0.m(j);
    }

    /* renamed from: minus-AH228Gc, reason: not valid java name */
    public static final long m6035minusAH228Gc(long j, long j2) {
        return VelocityKt.Velocity(m6032getXimpl(j) - m6032getXimpl(j2), m6033getYimpl(j) - m6033getYimpl(j2));
    }

    /* renamed from: plus-AH228Gc, reason: not valid java name */
    public static final long m6036plusAH228Gc(long j, long j2) {
        return VelocityKt.Velocity(m6032getXimpl(j) + m6032getXimpl(j2), m6033getYimpl(j) + m6033getYimpl(j2));
    }

    /* renamed from: rem-adjELrA, reason: not valid java name */
    public static final long m6037remadjELrA(long j, float f) {
        return VelocityKt.Velocity(m6032getXimpl(j) % f, m6033getYimpl(j) % f);
    }

    /* renamed from: times-adjELrA, reason: not valid java name */
    public static final long m6038timesadjELrA(long j, float f) {
        return VelocityKt.Velocity(m6032getXimpl(j) * f, m6033getYimpl(j) * f);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m6039toStringimpl(long j) {
        return "(" + m6032getXimpl(j) + ", " + m6033getYimpl(j) + ") px/sec";
    }

    /* renamed from: unaryMinus-9UxMQ8M, reason: not valid java name */
    public static final long m6040unaryMinus9UxMQ8M(long j) {
        return VelocityKt.Velocity(-m6032getXimpl(j), -m6033getYimpl(j));
    }

    public boolean equals(Object obj) {
        return m6030equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m6034hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m6039toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }
}
