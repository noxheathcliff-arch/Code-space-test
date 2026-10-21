package androidx.compose.runtime;

import androidx.compose.runtime.MutableDoubleState;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapshotDoubleState.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001!B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0015\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u0018H\u0096\u0002J\"\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R$\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Landroidx/compose/runtime/SnapshotMutableDoubleStateImpl;", "Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/MutableDoubleState;", "Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "", "value", "(D)V", "doubleValue", "getDoubleValue", "()D", "setDoubleValue", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "next", "Landroidx/compose/runtime/SnapshotMutableDoubleStateImpl$DoubleStateStateRecord;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "component1", "()Ljava/lang/Double;", "component2", "Lkotlin/Function1;", "", "mergeRecords", "previous", "current", "applied", "prependStateRecord", "toString", "", "DoubleStateStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class SnapshotMutableDoubleStateImpl extends StateObjectImpl implements MutableDoubleState, SnapshotMutableState<Double> {
    public static final int $stable = 0;
    private DoubleStateStateRecord next;

    /* compiled from: SnapshotDoubleState.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\b\u0010\n\u001a\u00020\u0001H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000b"}, d2 = {"Landroidx/compose/runtime/SnapshotMutableDoubleStateImpl$DoubleStateStateRecord;", "Landroidx/compose/runtime/snapshots/StateRecord;", "value", "", "(D)V", "getValue", "()D", "setValue", "assign", "", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class DoubleStateStateRecord extends StateRecord {
        private double value;

        public DoubleStateStateRecord(double d) {
            this.value = d;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
            this.value = ((DoubleStateStateRecord) value).value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new DoubleStateStateRecord(this.value);
        }

        public final double getValue() {
            return this.value;
        }

        public final void setValue(double d) {
            this.value = d;
        }
    }

    public SnapshotMutableDoubleStateImpl(double d) {
        this.next = new DoubleStateStateRecord(d);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.MutableState
    public Double component1() {
        return Double.valueOf(getDoubleValue());
    }

    @Override // androidx.compose.runtime.MutableState
    public Function1<Double, Unit> component2() {
        return new Function1<Double, Unit>() { // from class: androidx.compose.runtime.SnapshotMutableDoubleStateImpl$component2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Double d) {
                invoke(d.doubleValue());
                return Unit.INSTANCE;
            }

            public final void invoke(double d) {
                SnapshotMutableDoubleStateImpl.this.setDoubleValue(d);
            }
        };
    }

    @Override // androidx.compose.runtime.MutableDoubleState, androidx.compose.runtime.DoubleState
    public double getDoubleValue() {
        return ((DoubleStateStateRecord) SnapshotKt.readable(this.next, this)).getValue();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public SnapshotMutationPolicy<Double> getPolicy() {
        return SnapshotStateKt.structuralEqualityPolicy();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.MutableDoubleState, androidx.compose.runtime.DoubleState, androidx.compose.runtime.State
    public /* synthetic */ Double getValue() {
        return MutableDoubleState.CC.$default$getValue((MutableDoubleState) this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Double, java.lang.Object] */
    @Override // androidx.compose.runtime.State
    public /* bridge */ /* synthetic */ Double getValue() {
        ?? value;
        value = getValue();
        return value;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        if ((r0 == r2) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0020, code lost:
    
        if (r0 == r2) goto L18;
     */
    @Override // androidx.compose.runtime.snapshots.StateObjectImpl, androidx.compose.runtime.snapshots.StateObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.runtime.snapshots.StateRecord mergeRecords(androidx.compose.runtime.snapshots.StateRecord r7, androidx.compose.runtime.snapshots.StateRecord r8, androidx.compose.runtime.snapshots.StateRecord r9) {
        /*
            r6 = this;
            java.lang.String r7 = "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r7)
            r0 = r8
            androidx.compose.runtime.SnapshotMutableDoubleStateImpl$DoubleStateStateRecord r0 = (androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord) r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r7)
            androidx.compose.runtime.SnapshotMutableDoubleStateImpl$DoubleStateStateRecord r9 = (androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord) r9
            double r0 = r0.getValue()
            double r2 = r9.getValue()
            int r7 = android.os.Build.VERSION.SDK_INT
            r9 = 23
            r4 = 1
            r5 = 0
            if (r7 < r9) goto L23
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 != 0) goto L39
            goto L3a
        L23:
            boolean r7 = androidx.compose.runtime.internal.FloatingPointEquality_androidKt.isNan(r0)
            if (r7 != 0) goto L39
            boolean r7 = androidx.compose.runtime.internal.FloatingPointEquality_androidKt.isNan(r2)
            if (r7 != 0) goto L39
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 != 0) goto L35
            r7 = 1
            goto L36
        L35:
            r7 = 0
        L36:
            if (r7 == 0) goto L39
            goto L3a
        L39:
            r4 = 0
        L3a:
            if (r4 == 0) goto L3d
            goto L3e
        L3d:
            r8 = 0
        L3e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotMutableDoubleStateImpl.mergeRecords(androidx.compose.runtime.snapshots.StateRecord, androidx.compose.runtime.snapshots.StateRecord, androidx.compose.runtime.snapshots.StateRecord):androidx.compose.runtime.snapshots.StateRecord");
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
        this.next = (DoubleStateStateRecord) value;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x002e, code lost:
    
        if ((r1 == r8) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0018, code lost:
    
        if (r1 == r8) goto L18;
     */
    @Override // androidx.compose.runtime.MutableDoubleState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setDoubleValue(double r8) {
        /*
            r7 = this;
            androidx.compose.runtime.SnapshotMutableDoubleStateImpl$DoubleStateStateRecord r0 = r7.next
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.current(r0)
            androidx.compose.runtime.SnapshotMutableDoubleStateImpl$DoubleStateStateRecord r0 = (androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord) r0
            double r1 = r0.getValue()
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 23
            r5 = 1
            r6 = 0
            if (r3 < r4) goto L1b
            int r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r3 != 0) goto L31
            goto L32
        L1b:
            boolean r3 = androidx.compose.runtime.internal.FloatingPointEquality_androidKt.isNan(r1)
            if (r3 != 0) goto L31
            boolean r3 = androidx.compose.runtime.internal.FloatingPointEquality_androidKt.isNan(r8)
            if (r3 != 0) goto L31
            int r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r3 != 0) goto L2d
            r1 = 1
            goto L2e
        L2d:
            r1 = 0
        L2e:
            if (r1 == 0) goto L31
            goto L32
        L31:
            r5 = 0
        L32:
            if (r5 != 0) goto L61
            androidx.compose.runtime.SnapshotMutableDoubleStateImpl$DoubleStateStateRecord r1 = r7.next
            androidx.compose.runtime.snapshots.StateRecord r1 = (androidx.compose.runtime.snapshots.StateRecord) r1
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r2 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r2)
            androidx.compose.runtime.snapshots.Snapshot$Companion r3 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L5e
            androidx.compose.runtime.snapshots.Snapshot r3 = r3.getCurrent()     // Catch: java.lang.Throwable -> L5e
            r4 = r7
            androidx.compose.runtime.snapshots.StateObject r4 = (androidx.compose.runtime.snapshots.StateObject) r4     // Catch: java.lang.Throwable -> L5e
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch: java.lang.Throwable -> L5e
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.overwritableRecord(r1, r4, r3, r0)     // Catch: java.lang.Throwable -> L5e
            androidx.compose.runtime.SnapshotMutableDoubleStateImpl$DoubleStateStateRecord r0 = (androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord) r0     // Catch: java.lang.Throwable -> L5e
            r0.setValue(r8)     // Catch: java.lang.Throwable -> L5e
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L5e
            monitor-exit(r2)
            r8 = r7
            androidx.compose.runtime.snapshots.StateObject r8 = (androidx.compose.runtime.snapshots.StateObject) r8
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r3, r8)
            goto L61
        L5e:
            r8 = move-exception
            monitor-exit(r2)
            throw r8
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotMutableDoubleStateImpl.setDoubleValue(double):void");
    }

    @Override // androidx.compose.runtime.MutableDoubleState
    public /* synthetic */ void setValue(double d) {
        setDoubleValue(d);
    }

    @Override // androidx.compose.runtime.MutableState
    public /* bridge */ /* synthetic */ void setValue(Double d) {
        setValue(d.doubleValue());
    }

    public String toString() {
        return "MutableDoubleState(value=" + ((DoubleStateStateRecord) SnapshotKt.current(this.next)).getValue() + ")@" + hashCode();
    }
}
