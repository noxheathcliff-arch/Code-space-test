package kotlin;

/* compiled from: UNumbers.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0004\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0007\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\n\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\r\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0004\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0007\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\n\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\r\u001a\u001f\u0010\u0018\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u0018\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001f\u0010\u0018\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010\u0018\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001f\u0010\"\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b#\u0010\u001b\u001a\u001f\u0010\"\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b$\u0010\u001d\u001a\u001f\u0010\"\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010\u001f\u001a\u001f\u0010\"\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010!\u001a\u0017\u0010'\u001a\u00020\u0002*\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0017\u0010'\u001a\u00020\u0005*\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0007\u001a\u0017\u0010'\u001a\u00020\b*\u00020\bH\u0087\bø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u0017\u0010'\u001a\u00020\u000b*\u00020\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0017\u0010/\u001a\u00020\u0002*\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b0\u0010)\u001a\u0017\u0010/\u001a\u00020\u0005*\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b1\u0010\u0007\u001a\u0017\u0010/\u001a\u00020\b*\u00020\bH\u0087\bø\u0001\u0000¢\u0006\u0004\b2\u0010,\u001a\u0017\u0010/\u001a\u00020\u000b*\u00020\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b3\u0010.\u0082\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"countLeadingZeroBits", "", "Lkotlin/UByte;", "countLeadingZeroBits-7apg3OU", "(B)I", "Lkotlin/UInt;", "countLeadingZeroBits-WZ4Q5Ns", "(I)I", "Lkotlin/ULong;", "countLeadingZeroBits-VKZWuLQ", "(J)I", "Lkotlin/UShort;", "countLeadingZeroBits-xj2QHRw", "(S)I", "countOneBits", "countOneBits-7apg3OU", "countOneBits-WZ4Q5Ns", "countOneBits-VKZWuLQ", "countOneBits-xj2QHRw", "countTrailingZeroBits", "countTrailingZeroBits-7apg3OU", "countTrailingZeroBits-WZ4Q5Ns", "countTrailingZeroBits-VKZWuLQ", "countTrailingZeroBits-xj2QHRw", "rotateLeft", "bitCount", "rotateLeft-LxnNnR4", "(BI)B", "rotateLeft-V7xB4Y4", "(II)I", "rotateLeft-JSWoG40", "(JI)J", "rotateLeft-olVBNx4", "(SI)S", "rotateRight", "rotateRight-LxnNnR4", "rotateRight-V7xB4Y4", "rotateRight-JSWoG40", "rotateRight-olVBNx4", "takeHighestOneBit", "takeHighestOneBit-7apg3OU", "(B)B", "takeHighestOneBit-WZ4Q5Ns", "takeHighestOneBit-VKZWuLQ", "(J)J", "takeHighestOneBit-xj2QHRw", "(S)S", "takeLowestOneBit", "takeLowestOneBit-7apg3OU", "takeLowestOneBit-WZ4Q5Ns", "takeLowestOneBit-VKZWuLQ", "takeLowestOneBit-xj2QHRw", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UNumbersKt {
    /* renamed from: countLeadingZeroBits-7apg3OU, reason: not valid java name */
    private static final int m6367countLeadingZeroBits7apg3OU(byte b) {
        return Integer.numberOfLeadingZeros(b & UByte.MAX_VALUE) - 24;
    }

    /* renamed from: countLeadingZeroBits-VKZWuLQ, reason: not valid java name */
    private static final int m6368countLeadingZeroBitsVKZWuLQ(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    /* renamed from: countLeadingZeroBits-WZ4Q5Ns, reason: not valid java name */
    private static final int m6369countLeadingZeroBitsWZ4Q5Ns(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    /* renamed from: countLeadingZeroBits-xj2QHRw, reason: not valid java name */
    private static final int m6370countLeadingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.MAX_VALUE) - 16;
    }

    /* renamed from: countOneBits-7apg3OU, reason: not valid java name */
    private static final int m6371countOneBits7apg3OU(byte b) {
        return Integer.bitCount(UInt.m6216constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: countOneBits-VKZWuLQ, reason: not valid java name */
    private static final int m6372countOneBitsVKZWuLQ(long j) {
        return Long.bitCount(j);
    }

    /* renamed from: countOneBits-WZ4Q5Ns, reason: not valid java name */
    private static final int m6373countOneBitsWZ4Q5Ns(int i) {
        return Integer.bitCount(i);
    }

    /* renamed from: countOneBits-xj2QHRw, reason: not valid java name */
    private static final int m6374countOneBitsxj2QHRw(short s) {
        return Integer.bitCount(UInt.m6216constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: countTrailingZeroBits-7apg3OU, reason: not valid java name */
    private static final int m6375countTrailingZeroBits7apg3OU(byte b) {
        return Integer.numberOfTrailingZeros(b | UByte.MIN_VALUE);
    }

    /* renamed from: countTrailingZeroBits-VKZWuLQ, reason: not valid java name */
    private static final int m6376countTrailingZeroBitsVKZWuLQ(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    /* renamed from: countTrailingZeroBits-WZ4Q5Ns, reason: not valid java name */
    private static final int m6377countTrailingZeroBitsWZ4Q5Ns(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    /* renamed from: countTrailingZeroBits-xj2QHRw, reason: not valid java name */
    private static final int m6378countTrailingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfTrailingZeros(s | UShort.MIN_VALUE);
    }

    /* renamed from: rotateLeft-JSWoG40, reason: not valid java name */
    private static final long m6379rotateLeftJSWoG40(long j, int i) {
        return ULong.m6295constructorimpl(Long.rotateLeft(j, i));
    }

    /* renamed from: rotateLeft-LxnNnR4, reason: not valid java name */
    private static final byte m6380rotateLeftLxnNnR4(byte b, int i) {
        return UByte.m6138constructorimpl(NumbersKt.rotateLeft(b, i));
    }

    /* renamed from: rotateLeft-V7xB4Y4, reason: not valid java name */
    private static final int m6381rotateLeftV7xB4Y4(int i, int i2) {
        return UInt.m6216constructorimpl(Integer.rotateLeft(i, i2));
    }

    /* renamed from: rotateLeft-olVBNx4, reason: not valid java name */
    private static final short m6382rotateLeftolVBNx4(short s, int i) {
        return UShort.m6402constructorimpl(NumbersKt.rotateLeft(s, i));
    }

    /* renamed from: rotateRight-JSWoG40, reason: not valid java name */
    private static final long m6383rotateRightJSWoG40(long j, int i) {
        return ULong.m6295constructorimpl(Long.rotateRight(j, i));
    }

    /* renamed from: rotateRight-LxnNnR4, reason: not valid java name */
    private static final byte m6384rotateRightLxnNnR4(byte b, int i) {
        return UByte.m6138constructorimpl(NumbersKt.rotateRight(b, i));
    }

    /* renamed from: rotateRight-V7xB4Y4, reason: not valid java name */
    private static final int m6385rotateRightV7xB4Y4(int i, int i2) {
        return UInt.m6216constructorimpl(Integer.rotateRight(i, i2));
    }

    /* renamed from: rotateRight-olVBNx4, reason: not valid java name */
    private static final short m6386rotateRightolVBNx4(short s, int i) {
        return UShort.m6402constructorimpl(NumbersKt.rotateRight(s, i));
    }

    /* renamed from: takeHighestOneBit-7apg3OU, reason: not valid java name */
    private static final byte m6387takeHighestOneBit7apg3OU(byte b) {
        return UByte.m6138constructorimpl((byte) Integer.highestOneBit(b & UByte.MAX_VALUE));
    }

    /* renamed from: takeHighestOneBit-VKZWuLQ, reason: not valid java name */
    private static final long m6388takeHighestOneBitVKZWuLQ(long j) {
        return ULong.m6295constructorimpl(Long.highestOneBit(j));
    }

    /* renamed from: takeHighestOneBit-WZ4Q5Ns, reason: not valid java name */
    private static final int m6389takeHighestOneBitWZ4Q5Ns(int i) {
        return UInt.m6216constructorimpl(Integer.highestOneBit(i));
    }

    /* renamed from: takeHighestOneBit-xj2QHRw, reason: not valid java name */
    private static final short m6390takeHighestOneBitxj2QHRw(short s) {
        return UShort.m6402constructorimpl((short) Integer.highestOneBit(s & UShort.MAX_VALUE));
    }

    /* renamed from: takeLowestOneBit-7apg3OU, reason: not valid java name */
    private static final byte m6391takeLowestOneBit7apg3OU(byte b) {
        return UByte.m6138constructorimpl((byte) Integer.lowestOneBit(b & UByte.MAX_VALUE));
    }

    /* renamed from: takeLowestOneBit-VKZWuLQ, reason: not valid java name */
    private static final long m6392takeLowestOneBitVKZWuLQ(long j) {
        return ULong.m6295constructorimpl(Long.lowestOneBit(j));
    }

    /* renamed from: takeLowestOneBit-WZ4Q5Ns, reason: not valid java name */
    private static final int m6393takeLowestOneBitWZ4Q5Ns(int i) {
        return UInt.m6216constructorimpl(Integer.lowestOneBit(i));
    }

    /* renamed from: takeLowestOneBit-xj2QHRw, reason: not valid java name */
    private static final short m6394takeLowestOneBitxj2QHRw(short s) {
        return UShort.m6402constructorimpl((short) Integer.lowestOneBit(s & UShort.MAX_VALUE));
    }
}
