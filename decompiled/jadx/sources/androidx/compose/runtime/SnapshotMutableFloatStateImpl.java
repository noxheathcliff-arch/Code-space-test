package androidx.compose.runtime;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapshotFloatState.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001!B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0015\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u0018H\u0096\u0002J\"\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0006R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Landroidx/compose/runtime/SnapshotMutableFloatStateImpl;", "Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/MutableFloatState;", "Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "", "value", "(F)V", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "floatValue", "getFloatValue", "()F", "setFloatValue", "next", "Landroidx/compose/runtime/SnapshotMutableFloatStateImpl$FloatStateStateRecord;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "component1", "()Ljava/lang/Float;", "component2", "Lkotlin/Function1;", "", "mergeRecords", "previous", "current", "applied", "prependStateRecord", "toString", "", "FloatStateStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class SnapshotMutableFloatStateImpl extends StateObjectImpl implements MutableFloatState, SnapshotMutableState<Float> {
    public static final int $stable = 0;
    private FloatStateStateRecord next;

    /* compiled from: SnapshotFloatState.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\b\u0010\n\u001a\u00020\u0001H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000b"}, d2 = {"Landroidx/compose/runtime/SnapshotMutableFloatStateImpl$FloatStateStateRecord;", "Landroidx/compose/runtime/snapshots/StateRecord;", "value", "", "(F)V", "getValue", "()F", "setValue", "assign", "", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class FloatStateStateRecord extends StateRecord {
        private float value;

        public FloatStateStateRecord(float f) {
            this.value = f;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
            this.value = ((FloatStateStateRecord) value).value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new FloatStateStateRecord(this.value);
        }

        public final float getValue() {
            return this.value;
        }

        public final void setValue(float f) {
            this.value = f;
        }
    }

    public SnapshotMutableFloatStateImpl(float f) {
        this.next = new FloatStateStateRecord(f);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.MutableState
    public Float component1() {
        return Float.valueOf(getFloatValue());
    }

    @Override // androidx.compose.runtime.MutableState
    public Function1<Float, Unit> component2() {
        return new Function1<Float, Unit>() { // from class: androidx.compose.runtime.SnapshotMutableFloatStateImpl$component2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                invoke(f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f) {
                SnapshotMutableFloatStateImpl.this.setFloatValue(f);
            }
        };
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.MutableFloatState, androidx.compose.runtime.FloatState
    public float getFloatValue() {
        return ((FloatStateStateRecord) SnapshotKt.readable(this.next, this)).getValue();
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public SnapshotMutationPolicy<Float> getPolicy() {
        return SnapshotStateKt.structuralEqualityPolicy();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.MutableFloatState, androidx.compose.runtime.FloatState, androidx.compose.runtime.State
    public /* synthetic */ Float getValue() {
        return MutableFloatState.CC.$default$getValue((MutableFloatState) this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Float, java.lang.Object] */
    @Override // androidx.compose.runtime.State
    public /* bridge */ /* synthetic */ Float getValue() {
        ?? value;
        value = getValue();
        return value;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        if ((r5 == r7) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0020, code lost:
    
        if (r5 == r7) goto L18;
     */
    @Override // androidx.compose.runtime.snapshots.StateObjectImpl, androidx.compose.runtime.snapshots.StateObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.runtime.snapshots.StateRecord mergeRecords(androidx.compose.runtime.snapshots.StateRecord r5, androidx.compose.runtime.snapshots.StateRecord r6, androidx.compose.runtime.snapshots.StateRecord r7) {
        /*
            r4 = this;
            java.lang.String r5 = "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r5)
            r0 = r6
            androidx.compose.runtime.SnapshotMutableFloatStateImpl$FloatStateStateRecord r0 = (androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord) r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r5)
            androidx.compose.runtime.SnapshotMutableFloatStateImpl$FloatStateStateRecord r7 = (androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord) r7
            float r5 = r0.getValue()
            float r7 = r7.getValue()
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            r2 = 1
            r3 = 0
            if (r0 < r1) goto L23
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L39
            goto L3a
        L23:
            boolean r0 = androidx.compose.runtime.internal.FloatingPointEquality_androidKt.isNan(r5)
            if (r0 != 0) goto L39
            boolean r0 = androidx.compose.runtime.internal.FloatingPointEquality_androidKt.isNan(r7)
            if (r0 != 0) goto L39
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L35
            r5 = 1
            goto L36
        L35:
            r5 = 0
        L36:
            if (r5 == 0) goto L39
            goto L3a
        L39:
            r2 = 0
        L3a:
            if (r2 == 0) goto L3d
            goto L3e
        L3d:
            r6 = 0
        L3e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotMutableFloatStateImpl.mergeRecords(androidx.compose.runtime.snapshots.StateRecord, androidx.compose.runtime.snapshots.StateRecord, androidx.compose.runtime.snapshots.StateRecord):androidx.compose.runtime.snapshots.StateRecord");
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        this.next = (FloatStateStateRecord) value;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x002e, code lost:
    
        if ((r1 == r7) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0018, code lost:
    
        if (r1 == r7) goto L18;
     */
    @Override // androidx.compose.runtime.MutableFloatState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setFloatValue(float r7) {
        /*
            r6 = this;
            androidx.compose.runtime.SnapshotMutableFloatStateImpl$FloatStateStateRecord r0 = r6.next
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.current(r0)
            androidx.compose.runtime.SnapshotMutableFloatStateImpl$FloatStateStateRecord r0 = (androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord) r0
            float r1 = r0.getValue()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            r4 = 1
            r5 = 0
            if (r2 < r3) goto L1b
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 != 0) goto L31
            goto L32
        L1b:
            boolean r2 = androidx.compose.runtime.internal.FloatingPointEquality_androidKt.isNan(r1)
            if (r2 != 0) goto L31
            boolean r2 = androidx.compose.runtime.internal.FloatingPointEquality_androidKt.isNan(r7)
            if (r2 != 0) goto L31
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 != 0) goto L2d
            r1 = 1
            goto L2e
        L2d:
            r1 = 0
        L2e:
            if (r1 == 0) goto L31
            goto L32
        L31:
            r4 = 0
        L32:
            if (r4 != 0) goto L61
            androidx.compose.runtime.SnapshotMutableFloatStateImpl$FloatStateStateRecord r1 = r6.next
            androidx.compose.runtime.snapshots.StateRecord r1 = (androidx.compose.runtime.snapshots.StateRecord) r1
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r2 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r2)
            androidx.compose.runtime.snapshots.Snapshot$Companion r3 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L5e
            androidx.compose.runtime.snapshots.Snapshot r3 = r3.getCurrent()     // Catch: java.lang.Throwable -> L5e
            r4 = r6
            androidx.compose.runtime.snapshots.StateObject r4 = (androidx.compose.runtime.snapshots.StateObject) r4     // Catch: java.lang.Throwable -> L5e
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch: java.lang.Throwable -> L5e
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.overwritableRecord(r1, r4, r3, r0)     // Catch: java.lang.Throwable -> L5e
            androidx.compose.runtime.SnapshotMutableFloatStateImpl$FloatStateStateRecord r0 = (androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord) r0     // Catch: java.lang.Throwable -> L5e
            r0.setValue(r7)     // Catch: java.lang.Throwable -> L5e
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L5e
            monitor-exit(r2)
            r7 = r6
            androidx.compose.runtime.snapshots.StateObject r7 = (androidx.compose.runtime.snapshots.StateObject) r7
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r3, r7)
            goto L61
        L5e:
            r7 = move-exception
            monitor-exit(r2)
            throw r7
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotMutableFloatStateImpl.setFloatValue(float):void");
    }

    @Override // androidx.compose.runtime.MutableFloatState
    public /* synthetic */ void setValue(float f) {
        setFloatValue(f);
    }

    @Override // androidx.compose.runtime.MutableState
    public /* bridge */ /* synthetic */ void setValue(Float f) {
        setValue(f.floatValue());
    }

    public String toString() {
        return "MutableFloatState(value=" + ((FloatStateStateRecord) SnapshotKt.current(this.next)).getValue() + ")@" + hashCode();
    }
}
