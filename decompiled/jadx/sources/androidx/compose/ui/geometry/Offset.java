package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: Offset.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 92\u00020\u0001:\u00019B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b\u0012\u0010\u000bJ'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b \u0010\u000bJ\u000f\u0010!\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\"\u0010\u000bJ\u0010\u0010#\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u001bH\u0007¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b+\u0010,J\u001b\u0010-\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b.\u0010,J\u001e\u0010/\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u0010\u0019J\u001e\u00101\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u0010\u0019J\u000f\u00103\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u0016\u00107\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006:"}, d2 = {"Landroidx/compose/ui/geometry/Offset;", "", "packedValue", "", "constructor-impl", "(J)J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-dBAh8RU", "(JFF)J", "div", "operand", "div-tuRUvjQ", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "getDistance", "getDistance-impl", "getDistanceSquared", "getDistanceSquared-impl", "hashCode", "", "hashCode-impl", "(J)I", "isValid", "isValid-impl", "(J)Z", "minus", "minus-MK-Hz9U", "(JJ)J", "plus", "plus-MK-Hz9U", "rem", "rem-tuRUvjQ", "times", "times-tuRUvjQ", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-F1C5BW0", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class Offset {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = OffsetKt.Offset(0.0f, 0.0f);
    private static final long Infinite = OffsetKt.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    private static final long Unspecified = OffsetKt.Offset(Float.NaN, Float.NaN);

    /* compiled from: Offset.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R$\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/geometry/Offset$Companion;", "", "()V", "Infinite", "Landroidx/compose/ui/geometry/Offset;", "getInfinite-F1C5BW0$annotations", "getInfinite-F1C5BW0", "()J", "J", "Unspecified", "getUnspecified-F1C5BW0$annotations", "getUnspecified-F1C5BW0", "Zero", "getZero-F1C5BW0$annotations", "getZero-F1C5BW0", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getInfinite-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m3204getInfiniteF1C5BW0$annotations() {
        }

        /* renamed from: getUnspecified-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m3205getUnspecifiedF1C5BW0$annotations() {
        }

        /* renamed from: getZero-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m3206getZeroF1C5BW0$annotations() {
        }

        /* renamed from: getInfinite-F1C5BW0, reason: not valid java name */
        public final long m3207getInfiniteF1C5BW0() {
            return Offset.Infinite;
        }

        /* renamed from: getUnspecified-F1C5BW0, reason: not valid java name */
        public final long m3208getUnspecifiedF1C5BW0() {
            return Offset.Unspecified;
        }

        /* renamed from: getZero-F1C5BW0, reason: not valid java name */
        public final long m3209getZeroF1C5BW0() {
            return Offset.Zero;
        }
    }

    private /* synthetic */ Offset(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Offset m3182boximpl(long j) {
        return new Offset(j);
    }

    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m3183component1impl(long j) {
        return m3193getXimpl(j);
    }

    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m3184component2impl(long j) {
        return m3194getYimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m3185constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-dBAh8RU, reason: not valid java name */
    public static final long m3186copydBAh8RU(long j, float f, float f2) {
        return OffsetKt.Offset(f, f2);
    }

    /* renamed from: copy-dBAh8RU$default, reason: not valid java name */
    public static /* synthetic */ long m3187copydBAh8RU$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m3193getXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m3194getYimpl(j);
        }
        return m3186copydBAh8RU(j, f, f2);
    }

    /* renamed from: div-tuRUvjQ, reason: not valid java name */
    public static final long m3188divtuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m3193getXimpl(j) / f, m3194getYimpl(j) / f);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3189equalsimpl(long j, Object obj) {
        return (obj instanceof Offset) && j == ((Offset) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3190equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getDistance-impl, reason: not valid java name */
    public static final float m3191getDistanceimpl(long j) {
        return (float) Math.sqrt((m3193getXimpl(j) * m3193getXimpl(j)) + (m3194getYimpl(j) * m3194getYimpl(j)));
    }

    /* renamed from: getDistanceSquared-impl, reason: not valid java name */
    public static final float m3192getDistanceSquaredimpl(long j) {
        return (m3193getXimpl(j) * m3193getXimpl(j)) + (m3194getYimpl(j) * m3194getYimpl(j));
    }

    public static /* synthetic */ void getX$annotations() {
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final float m3193getXimpl(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("Offset is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final float m3194getYimpl(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("Offset is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3195hashCodeimpl(long j) {
        return UByte$$ExternalSyntheticBackport0.m(j);
    }

    /* renamed from: isValid-impl, reason: not valid java name */
    public static final boolean m3196isValidimpl(long j) {
        if ((Float.isNaN(m3193getXimpl(j)) || Float.isNaN(m3194getYimpl(j))) ? false : true) {
            return true;
        }
        throw new IllegalStateException("Offset argument contained a NaN value.".toString());
    }

    /* renamed from: minus-MK-Hz9U, reason: not valid java name */
    public static final long m3197minusMKHz9U(long j, long j2) {
        return OffsetKt.Offset(m3193getXimpl(j) - m3193getXimpl(j2), m3194getYimpl(j) - m3194getYimpl(j2));
    }

    /* renamed from: plus-MK-Hz9U, reason: not valid java name */
    public static final long m3198plusMKHz9U(long j, long j2) {
        return OffsetKt.Offset(m3193getXimpl(j) + m3193getXimpl(j2), m3194getYimpl(j) + m3194getYimpl(j2));
    }

    /* renamed from: rem-tuRUvjQ, reason: not valid java name */
    public static final long m3199remtuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m3193getXimpl(j) % f, m3194getYimpl(j) % f);
    }

    /* renamed from: times-tuRUvjQ, reason: not valid java name */
    public static final long m3200timestuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m3193getXimpl(j) * f, m3194getYimpl(j) * f);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3201toStringimpl(long j) {
        if (!OffsetKt.m3212isSpecifiedk4lQ0M(j)) {
            return "Offset.Unspecified";
        }
        return "Offset(" + GeometryUtilsKt.toStringAsFixed(m3193getXimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m3194getYimpl(j), 1) + ')';
    }

    /* renamed from: unaryMinus-F1C5BW0, reason: not valid java name */
    public static final long m3202unaryMinusF1C5BW0(long j) {
        return OffsetKt.Offset(-m3193getXimpl(j), -m3194getYimpl(j));
    }

    public boolean equals(Object obj) {
        return m3189equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3195hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m3201toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }
}
