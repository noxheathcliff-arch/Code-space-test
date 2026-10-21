package androidx.navigation;

import android.os.Bundle;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavAction.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Landroidx/navigation/NavAction;", "", "destinationId", "", "navOptions", "Landroidx/navigation/NavOptions;", "defaultArguments", "Landroid/os/Bundle;", "(ILandroidx/navigation/NavOptions;Landroid/os/Bundle;)V", "getDefaultArguments", "()Landroid/os/Bundle;", "setDefaultArguments", "(Landroid/os/Bundle;)V", "getDestinationId", "()I", "getNavOptions", "()Landroidx/navigation/NavOptions;", "setNavOptions", "(Landroidx/navigation/NavOptions;)V", "equals", "", "other", "hashCode", "toString", "", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NavAction {
    private Bundle defaultArguments;
    private final int destinationId;
    private NavOptions navOptions;

    public NavAction(int i) {
        this(i, null, null, 6, null);
    }

    public NavAction(int i, NavOptions navOptions) {
        this(i, navOptions, null, 4, null);
    }

    public NavAction(int i, NavOptions navOptions, Bundle bundle) {
        this.destinationId = i;
        this.navOptions = navOptions;
        this.defaultArguments = bundle;
    }

    public /* synthetic */ NavAction(int i, NavOptions navOptions, Bundle bundle, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : navOptions, (i2 & 4) != 0 ? null : bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r7 != r8) goto L4
            return r0
        L4:
            r1 = 0
            if (r8 == 0) goto L78
            boolean r2 = r8 instanceof androidx.navigation.NavAction
            if (r2 != 0) goto Ld
            goto L78
        Ld:
            int r2 = r7.destinationId
            androidx.navigation.NavAction r8 = (androidx.navigation.NavAction) r8
            int r3 = r8.destinationId
            if (r2 != r3) goto L76
            androidx.navigation.NavOptions r2 = r7.navOptions
            androidx.navigation.NavOptions r3 = r8.navOptions
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 == 0) goto L76
            android.os.Bundle r2 = r7.defaultArguments
            android.os.Bundle r3 = r8.defaultArguments
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto L77
            android.os.Bundle r2 = r7.defaultArguments
            if (r2 == 0) goto L72
            java.util.Set r2 = r2.keySet()
            if (r2 == 0) goto L72
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            boolean r3 = r2 instanceof java.util.Collection
            if (r3 == 0) goto L44
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L44
        L42:
            r8 = 1
            goto L6e
        L44:
            java.util.Iterator r2 = r2.iterator()
        L48:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L42
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            android.os.Bundle r4 = r7.defaultArguments
            r5 = 0
            if (r4 == 0) goto L5e
            java.lang.Object r4 = r4.get(r3)
            goto L5f
        L5e:
            r4 = r5
        L5f:
            android.os.Bundle r6 = r8.defaultArguments
            if (r6 == 0) goto L67
            java.lang.Object r5 = r6.get(r3)
        L67:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r3 != 0) goto L48
            r8 = 0
        L6e:
            if (r8 != r0) goto L72
            r8 = 1
            goto L73
        L72:
            r8 = 0
        L73:
            if (r8 == 0) goto L76
            goto L77
        L76:
            r0 = 0
        L77:
            return r0
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavAction.equals(java.lang.Object):boolean");
    }

    public final Bundle getDefaultArguments() {
        return this.defaultArguments;
    }

    public final int getDestinationId() {
        return this.destinationId;
    }

    public final NavOptions getNavOptions() {
        return this.navOptions;
    }

    public int hashCode() {
        Set<String> keySet;
        int i = this.destinationId * 31;
        NavOptions navOptions = this.navOptions;
        int hashCode = i + (navOptions != null ? navOptions.hashCode() : 0);
        Bundle bundle = this.defaultArguments;
        if (bundle != null && (keySet = bundle.keySet()) != null) {
            for (String str : keySet) {
                int i2 = hashCode * 31;
                Bundle bundle2 = this.defaultArguments;
                Object obj = bundle2 != null ? bundle2.get(str) : null;
                hashCode = i2 + (obj != null ? obj.hashCode() : 0);
            }
        }
        return hashCode;
    }

    public final void setDefaultArguments(Bundle bundle) {
        this.defaultArguments = bundle;
    }

    public final void setNavOptions(NavOptions navOptions) {
        this.navOptions = navOptions;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(0x");
        sb.append(Integer.toHexString(this.destinationId));
        sb.append(")");
        if (this.navOptions != null) {
            sb.append(" navOptions=");
            sb.append(this.navOptions);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
