package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* compiled from: DateInput.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012J.\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u00060 j\u0002`!ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/material3/DateInputValidator;", "", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "dateInputFormat", "Landroidx/compose/material3/DateInputFormat;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "errorDatePattern", "", "errorDateOutOfYearRange", "errorInvalidNotAllowed", "errorInvalidRangeInput", "currentStartDateMillis", "", "currentEndDateMillis", "(Lkotlin/ranges/IntRange;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DateInputFormat;Landroidx/compose/material3/DatePickerFormatter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getCurrentEndDateMillis$material3_release", "()Ljava/lang/Long;", "setCurrentEndDateMillis$material3_release", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCurrentStartDateMillis$material3_release", "setCurrentStartDateMillis$material3_release", "validate", "dateToValidate", "Landroidx/compose/material3/CalendarDate;", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "validate-XivgLIo", "(Landroidx/compose/material3/CalendarDate;ILjava/util/Locale;)Ljava/lang/String;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DateInputValidator {
    public static final int $stable = 0;
    private Long currentEndDateMillis;
    private Long currentStartDateMillis;
    private final DatePickerFormatter dateFormatter;
    private final DateInputFormat dateInputFormat;
    private final String errorDateOutOfYearRange;
    private final String errorDatePattern;
    private final String errorInvalidNotAllowed;
    private final String errorInvalidRangeInput;
    private final SelectableDates selectableDates;
    private final IntRange yearRange;

    public DateInputValidator(IntRange intRange, SelectableDates selectableDates, DateInputFormat dateInputFormat, DatePickerFormatter datePickerFormatter, String str, String str2, String str3, String str4, Long l, Long l2) {
        this.yearRange = intRange;
        this.selectableDates = selectableDates;
        this.dateInputFormat = dateInputFormat;
        this.dateFormatter = datePickerFormatter;
        this.errorDatePattern = str;
        this.errorDateOutOfYearRange = str2;
        this.errorInvalidNotAllowed = str3;
        this.errorInvalidRangeInput = str4;
        this.currentStartDateMillis = l;
        this.currentEndDateMillis = l2;
    }

    public /* synthetic */ DateInputValidator(IntRange intRange, SelectableDates selectableDates, DateInputFormat dateInputFormat, DatePickerFormatter datePickerFormatter, String str, String str2, String str3, String str4, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(intRange, selectableDates, dateInputFormat, datePickerFormatter, str, str2, str3, str4, (i & 256) != 0 ? null : l, (i & 512) != 0 ? null : l2);
    }

    /* renamed from: getCurrentEndDateMillis$material3_release, reason: from getter */
    public final Long getCurrentEndDateMillis() {
        return this.currentEndDateMillis;
    }

    /* renamed from: getCurrentStartDateMillis$material3_release, reason: from getter */
    public final Long getCurrentStartDateMillis() {
        return this.currentStartDateMillis;
    }

    public final void setCurrentEndDateMillis$material3_release(Long l) {
        this.currentEndDateMillis = l;
    }

    public final void setCurrentStartDateMillis$material3_release(Long l) {
        this.currentStartDateMillis = l;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x009f, code lost:
    
        if (r0 < (r13 != null ? r13.longValue() : Long.MAX_VALUE)) goto L23;
     */
    /* renamed from: validate-XivgLIo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m1462validateXivgLIo(androidx.compose.material3.CalendarDate r11, int r12, java.util.Locale r13) {
        /*
            r10 = this;
            java.lang.String r0 = "format(this, *args)"
            r1 = 0
            r2 = 1
            if (r11 != 0) goto L2b
            java.lang.String r11 = r10.errorDatePattern
            java.lang.Object[] r12 = new java.lang.Object[r2]
            androidx.compose.material3.DateInputFormat r13 = r10.dateInputFormat
            java.lang.String r13 = r13.getPatternWithDelimiters()
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r13 = r13.toUpperCase(r3)
            java.lang.String r3 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r3)
            r12[r1] = r13
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r2)
            java.lang.String r11 = java.lang.String.format(r11, r12)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            return r11
        L2b:
            kotlin.ranges.IntRange r3 = r10.yearRange
            int r4 = r11.getYear()
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L68
            java.lang.String r11 = r10.errorDateOutOfYearRange
            r12 = 2
            java.lang.Object[] r13 = new java.lang.Object[r12]
            kotlin.ranges.IntRange r3 = r10.yearRange
            int r4 = r3.getFirst()
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 7
            r9 = 0
            java.lang.String r3 = androidx.compose.material3.ActualJvm_jvmKt.toLocalString$default(r4, r5, r6, r7, r8, r9)
            r13[r1] = r3
            kotlin.ranges.IntRange r1 = r10.yearRange
            int r3 = r1.getLast()
            r4 = 0
            r7 = 7
            r8 = 0
            java.lang.String r1 = androidx.compose.material3.ActualJvm_jvmKt.toLocalString$default(r3, r4, r5, r6, r7, r8)
            r13[r2] = r1
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r13, r12)
            java.lang.String r11 = java.lang.String.format(r11, r12)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            return r11
        L68:
            androidx.compose.material3.SelectableDates r3 = r10.selectableDates
            int r4 = r11.getYear()
            boolean r4 = r3.isSelectableYear(r4)
            if (r4 == 0) goto Lc6
            long r4 = r11.getUtcTimeMillis()
            boolean r3 = r3.isSelectableDate(r4)
            if (r3 != 0) goto L7f
            goto Lc6
        L7f:
            androidx.compose.material3.InputIdentifier$Companion r13 = androidx.compose.material3.InputIdentifier.INSTANCE
            int r13 = r13.m1636getStartDateInputJ2x2o4M()
            boolean r13 = androidx.compose.material3.InputIdentifier.m1630equalsimpl0(r12, r13)
            if (r13 == 0) goto La1
            long r0 = r11.getUtcTimeMillis()
            java.lang.Long r13 = r10.currentEndDateMillis
            if (r13 == 0) goto L98
            long r2 = r13.longValue()
            goto L9d
        L98:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L9d:
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 >= 0) goto Lc0
        La1:
            androidx.compose.material3.InputIdentifier$Companion r13 = androidx.compose.material3.InputIdentifier.INSTANCE
            int r13 = r13.m1634getEndDateInputJ2x2o4M()
            boolean r12 = androidx.compose.material3.InputIdentifier.m1630equalsimpl0(r12, r13)
            if (r12 == 0) goto Lc3
            long r11 = r11.getUtcTimeMillis()
            java.lang.Long r13 = r10.currentStartDateMillis
            if (r13 == 0) goto Lba
            long r0 = r13.longValue()
            goto Lbc
        Lba:
            r0 = -9223372036854775808
        Lbc:
            int r13 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r13 >= 0) goto Lc3
        Lc0:
            java.lang.String r11 = r10.errorInvalidRangeInput
            return r11
        Lc3:
            java.lang.String r11 = ""
            return r11
        Lc6:
            java.lang.String r12 = r10.errorInvalidNotAllowed
            java.lang.Object[] r3 = new java.lang.Object[r2]
            androidx.compose.material3.DatePickerFormatter r4 = r10.dateFormatter
            long r5 = r11.getUtcTimeMillis()
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r7 = 0
            r8 = 4
            r9 = 0
            r6 = r13
            java.lang.String r11 = androidx.compose.material3.DatePickerFormatter.CC.formatDate$default(r4, r5, r6, r7, r8, r9)
            r3[r1] = r11
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r3, r2)
            java.lang.String r11 = java.lang.String.format(r12, r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateInputValidator.m1462validateXivgLIo(androidx.compose.material3.CalendarDate, int, java.util.Locale):java.lang.String");
    }
}
