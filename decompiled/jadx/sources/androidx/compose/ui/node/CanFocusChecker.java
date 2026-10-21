package androidx.compose.ui.node;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: NodeKind.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u000eR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/node/CanFocusChecker;", "Landroidx/compose/ui/focus/FocusProperties;", "()V", "value", "", "canFocus", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "canFocusValue", "Ljava/lang/Boolean;", "isCanFocusSet", "reset", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class CanFocusChecker implements FocusProperties {
    public static final CanFocusChecker INSTANCE = new CanFocusChecker();
    private static Boolean canFocusValue;

    private CanFocusChecker() {
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public boolean getCanFocus() {
        Boolean bool = canFocusValue;
        if (bool != null) {
            return bool.booleanValue();
        }
        throw new IllegalStateException("canFocus is read before it is written".toString());
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getDown() {
        FocusRequester focusRequester;
        focusRequester = FocusRequester.INSTANCE.getDefault();
        return focusRequester;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getEnd() {
        FocusRequester focusRequester;
        focusRequester = FocusRequester.INSTANCE.getDefault();
        return focusRequester;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ Function1 getEnter() {
        Function1 function1;
        function1 = new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusProperties$enter$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
                return m3133invoke3ESFkO8(focusDirection.getValue());
            }

            /* renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m3133invoke3ESFkO8(int i) {
                return FocusRequester.INSTANCE.getDefault();
            }
        };
        return function1;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ Function1 getExit() {
        Function1 function1;
        function1 = new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusProperties$exit$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
                return m3134invoke3ESFkO8(focusDirection.getValue());
            }

            /* renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m3134invoke3ESFkO8(int i) {
                return FocusRequester.INSTANCE.getDefault();
            }
        };
        return function1;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getLeft() {
        FocusRequester focusRequester;
        focusRequester = FocusRequester.INSTANCE.getDefault();
        return focusRequester;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getNext() {
        FocusRequester focusRequester;
        focusRequester = FocusRequester.INSTANCE.getDefault();
        return focusRequester;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getPrevious() {
        FocusRequester focusRequester;
        focusRequester = FocusRequester.INSTANCE.getDefault();
        return focusRequester;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getRight() {
        FocusRequester focusRequester;
        focusRequester = FocusRequester.INSTANCE.getDefault();
        return focusRequester;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getStart() {
        FocusRequester focusRequester;
        focusRequester = FocusRequester.INSTANCE.getDefault();
        return focusRequester;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getUp() {
        FocusRequester focusRequester;
        focusRequester = FocusRequester.INSTANCE.getDefault();
        return focusRequester;
    }

    public final boolean isCanFocusSet() {
        return canFocusValue != null;
    }

    public final void reset() {
        canFocusValue = null;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setCanFocus(boolean z) {
        canFocusValue = Boolean.valueOf(z);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setDown(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setDown(this, focusRequester);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setEnd(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setEnd(this, focusRequester);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setEnter(Function1 function1) {
        FocusProperties.CC.$default$setEnter(this, function1);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setExit(Function1 function1) {
        FocusProperties.CC.$default$setExit(this, function1);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setLeft(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setLeft(this, focusRequester);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setNext(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setNext(this, focusRequester);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setPrevious(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setPrevious(this, focusRequester);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setRight(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setRight(this, focusRequester);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setStart(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setStart(this, focusRequester);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setUp(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setUp(this, focusRequester);
    }
}
