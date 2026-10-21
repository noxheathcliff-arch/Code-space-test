package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

/* compiled from: UInt.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 {2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001{B\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0005J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u000fJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000bJ\u001b\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0016J\u001a\u0010\u001f\u001a\u00020 2\b\u0010\t\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010\u000fJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010\u000bJ\u001b\u0010$\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u001dJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0016J\u0010\u0010)\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b*\u0010\u0005J\u0016\u0010+\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010\u0005J\u0016\u0010-\u001a\u00020\u0000H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010\u0005J\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b0\u0010\u000fJ\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u000bJ\u001b\u0010/\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u001dJ\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u0016J\u001b\u00104\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b8\u0010\u001dJ\u001b\u00104\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b>\u0010\u000fJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u001dJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0016J\u001b\u0010B\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001b\u0010F\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bG\u0010EJ\u001b\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010\u000fJ\u001b\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bJ\u0010\u000bJ\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bK\u0010\u001dJ\u001b\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u0016J\u001e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0003H\u0087\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010\u000bJ\u001e\u0010P\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0003H\u0087\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bQ\u0010\u000bJ\u001b\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\bS\u0010\u000fJ\u001b\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bT\u0010\u000bJ\u001b\u0010R\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bU\u0010\u001dJ\u001b\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bV\u0010\u0016J\u0010\u0010W\u001a\u00020XH\u0087\b¢\u0006\u0004\bY\u0010ZJ\u0010\u0010[\u001a\u00020\\H\u0087\b¢\u0006\u0004\b]\u0010^J\u0010\u0010_\u001a\u00020`H\u0087\b¢\u0006\u0004\ba\u0010bJ\u0010\u0010c\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bd\u0010\u0005J\u0010\u0010e\u001a\u00020fH\u0087\b¢\u0006\u0004\bg\u0010hJ\u0010\u0010i\u001a\u00020jH\u0087\b¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020nH\u0016¢\u0006\u0004\bo\u0010pJ\u0016\u0010q\u001a\u00020\rH\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\br\u0010ZJ\u0016\u0010s\u001a\u00020\u0000H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bt\u0010\u0005J\u0016\u0010u\u001a\u00020\u0011H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bv\u0010hJ\u0016\u0010w\u001a\u00020\u0014H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bx\u0010lJ\u001b\u0010y\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bz\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006|"}, d2 = {"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "and", "other", "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-pVg5ArA", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "inc", "inc-pVg5ArA", "inv", "inv-pVg5ArA", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(IB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(IS)S", "or", "or-WZ4Q5Ns", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-WZ4Q5Ns", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class UInt implements Comparable<UInt> {
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int data;

    private /* synthetic */ UInt(int i) {
        this.data = i;
    }

    /* renamed from: and-WZ4Q5Ns, reason: not valid java name */
    private static final int m6209andWZ4Q5Ns(int i, int i2) {
        return m6216constructorimpl(i & i2);
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UInt m6210boximpl(int i) {
        return new UInt(i);
    }

    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m6211compareTo7apg3OU(int i, byte b) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, m6216constructorimpl(b & UByte.MAX_VALUE) ^ Integer.MIN_VALUE);
        return compare;
    }

    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m6212compareToVKZWuLQ(int i, long j) {
        int compare;
        compare = Long.compare(ULong.m6295constructorimpl(i & 4294967295L) ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        return compare;
    }

    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private int m6213compareToWZ4Q5Ns(int i) {
        return UnsignedKt.uintCompare(getData(), i);
    }

    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static int m6214compareToWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2);
    }

    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m6215compareToxj2QHRw(int i, short s) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, m6216constructorimpl(s & UShort.MAX_VALUE) ^ Integer.MIN_VALUE);
        return compare;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m6216constructorimpl(int i) {
        return i;
    }

    /* renamed from: dec-pVg5ArA, reason: not valid java name */
    private static final int m6217decpVg5ArA(int i) {
        return m6216constructorimpl(i - 1);
    }

    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m6218div7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, m6216constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m6219divVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m6295constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m6220divWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m6472uintDivideJ1ME1BU(i, i2);
    }

    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m6221divxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, m6216constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m6222equalsimpl(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).getData();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6223equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m6224floorDiv7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, m6216constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m6225floorDivVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m6295constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m6226floorDivWZ4Q5Ns(int i, int i2) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, i2);
    }

    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m6227floorDivxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, m6216constructorimpl(s & UShort.MAX_VALUE));
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m6228hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: inc-pVg5ArA, reason: not valid java name */
    private static final int m6229incpVg5ArA(int i) {
        return m6216constructorimpl(i + 1);
    }

    /* renamed from: inv-pVg5ArA, reason: not valid java name */
    private static final int m6230invpVg5ArA(int i) {
        return m6216constructorimpl(~i);
    }

    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m6231minus7apg3OU(int i, byte b) {
        return m6216constructorimpl(i - m6216constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m6232minusVKZWuLQ(int i, long j) {
        return ULong.m6295constructorimpl(ULong.m6295constructorimpl(i & 4294967295L) - j);
    }

    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m6233minusWZ4Q5Ns(int i, int i2) {
        return m6216constructorimpl(i - i2);
    }

    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m6234minusxj2QHRw(int i, short s) {
        return m6216constructorimpl(i - m6216constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m6235mod7apg3OU(int i, byte b) {
        return UByte.m6138constructorimpl((byte) UByte$$ExternalSyntheticBackport0.m(i, m6216constructorimpl(b & UByte.MAX_VALUE)));
    }

    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m6236modVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m6189m(ULong.m6295constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m6237modWZ4Q5Ns(int i, int i2) {
        return UByte$$ExternalSyntheticBackport0.m(i, i2);
    }

    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m6238modxj2QHRw(int i, short s) {
        return UShort.m6402constructorimpl((short) UByte$$ExternalSyntheticBackport0.m(i, m6216constructorimpl(s & UShort.MAX_VALUE)));
    }

    /* renamed from: or-WZ4Q5Ns, reason: not valid java name */
    private static final int m6239orWZ4Q5Ns(int i, int i2) {
        return m6216constructorimpl(i | i2);
    }

    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m6240plus7apg3OU(int i, byte b) {
        return m6216constructorimpl(i + m6216constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m6241plusVKZWuLQ(int i, long j) {
        return ULong.m6295constructorimpl(ULong.m6295constructorimpl(i & 4294967295L) + j);
    }

    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m6242plusWZ4Q5Ns(int i, int i2) {
        return m6216constructorimpl(i + i2);
    }

    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m6243plusxj2QHRw(int i, short s) {
        return m6216constructorimpl(i + m6216constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: rangeTo-WZ4Q5Ns, reason: not valid java name */
    private static final UIntRange m6244rangeToWZ4Q5Ns(int i, int i2) {
        return new UIntRange(i, i2, null);
    }

    /* renamed from: rangeUntil-WZ4Q5Ns, reason: not valid java name */
    private static final UIntRange m6245rangeUntilWZ4Q5Ns(int i, int i2) {
        return URangesKt.m7389untilJ1ME1BU(i, i2);
    }

    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m6246rem7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport0.m(i, m6216constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m6247remVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m6189m(ULong.m6295constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m6248remWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m6473uintRemainderJ1ME1BU(i, i2);
    }

    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m6249remxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport0.m(i, m6216constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: shl-pVg5ArA, reason: not valid java name */
    private static final int m6250shlpVg5ArA(int i, int i2) {
        return m6216constructorimpl(i << i2);
    }

    /* renamed from: shr-pVg5ArA, reason: not valid java name */
    private static final int m6251shrpVg5ArA(int i, int i2) {
        return m6216constructorimpl(i >>> i2);
    }

    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m6252times7apg3OU(int i, byte b) {
        return m6216constructorimpl(i * m6216constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m6253timesVKZWuLQ(int i, long j) {
        return ULong.m6295constructorimpl(ULong.m6295constructorimpl(i & 4294967295L) * j);
    }

    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m6254timesWZ4Q5Ns(int i, int i2) {
        return m6216constructorimpl(i * i2);
    }

    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m6255timesxj2QHRw(int i, short s) {
        return m6216constructorimpl(i * m6216constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m6256toByteimpl(int i) {
        return (byte) i;
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m6257toDoubleimpl(int i) {
        return UnsignedKt.uintToDouble(i);
    }

    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m6258toFloatimpl(int i) {
        return (float) UnsignedKt.uintToDouble(i);
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m6259toIntimpl(int i) {
        return i;
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m6260toLongimpl(int i) {
        return i & 4294967295L;
    }

    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m6261toShortimpl(int i) {
        return (short) i;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m6262toStringimpl(int i) {
        return String.valueOf(i & 4294967295L);
    }

    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m6263toUBytew2LRezQ(int i) {
        return UByte.m6138constructorimpl((byte) i);
    }

    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m6264toUIntpVg5ArA(int i) {
        return i;
    }

    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m6265toULongsVKNKU(int i) {
        return ULong.m6295constructorimpl(i & 4294967295L);
    }

    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m6266toUShortMh2AYeg(int i) {
        return UShort.m6402constructorimpl((short) i);
    }

    /* renamed from: xor-WZ4Q5Ns, reason: not valid java name */
    private static final int m6267xorWZ4Q5Ns(int i, int i2) {
        return m6216constructorimpl(i ^ i2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt uInt) {
        return UnsignedKt.uintCompare(getData(), uInt.getData());
    }

    public boolean equals(Object obj) {
        return m6222equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m6228hashCodeimpl(this.data);
    }

    public String toString() {
        return m6262toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getData() {
        return this.data;
    }
}
