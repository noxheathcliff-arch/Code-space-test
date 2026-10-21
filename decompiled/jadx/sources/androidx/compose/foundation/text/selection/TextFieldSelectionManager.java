package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: TextFieldSelectionManager.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010n\u001a\u00020B2\u0006\u0010o\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\bp\u0010qJ\u0017\u0010r\u001a\u00020B2\b\b\u0002\u0010s\u001a\u00020!H\u0000¢\u0006\u0002\btJ\"\u0010u\u001a\u00020?2\u0006\u0010v\u001a\u00020[2\u0006\u0010w\u001a\u00020xH\u0002ø\u0001\u0000¢\u0006\u0004\by\u0010zJ\r\u0010{\u001a\u00020WH\u0000¢\u0006\u0002\b|J\r\u0010}\u001a\u00020BH\u0000¢\u0006\u0002\b~J\u001d\u0010\u007f\u001a\u00020B2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\fH\u0000ø\u0001\u0000¢\u0006\u0003\b\u0080\u0001J\u001a\u0010\u0081\u0001\u001a\u00020B2\t\b\u0002\u0010\u0082\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b\u0083\u0001J\u000f\u0010\u0084\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u0085\u0001J\n\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0002J\"\u0010\u0088\u0001\u001a\u00020\f2\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J!\u0010\u008d\u0001\u001a\u00020\f2\u0007\u0010\u008e\u0001\u001a\u00020!H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0018\u0010\u0091\u0001\u001a\u00020W2\u0007\u0010\u008e\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b\u0092\u0001J\u000f\u0010\u0093\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u0094\u0001J\u000f\u0010\u0095\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b\u0096\u0001J\u000f\u0010\u0097\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u0098\u0001J\u000f\u0010\u0099\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u009a\u0001J\u0013\u0010\u009b\u0001\u001a\u00020B2\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0002J\u000f\u0010\u009e\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u009f\u0001J\u0012\u0010 \u0001\u001a\u00020B2\u0007\u0010¡\u0001\u001a\u00020!H\u0002JK\u0010¢\u0001\u001a\u00020x2\u0006\u0010b\u001a\u00020?2\u0007\u0010£\u0001\u001a\u00020\f2\u0007\u0010¤\u0001\u001a\u00020!2\u0007\u0010\u008e\u0001\u001a\u00020!2\b\u0010¥\u0001\u001a\u00030¦\u00012\u0007\u0010§\u0001\u001a\u00020!H\u0002ø\u0001\u0000¢\u0006\u0006\b¨\u0001\u0010©\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR5\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R/\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001a8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0013\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR+\u0010\"\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0013\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00104\u001a\u000205X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010@\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020B0AX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u000e\u0010G\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010J\u001a\u0004\u0018\u00010KX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010V\u001a\u00020WX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u001c\u0010Z\u001a\u0004\u0018\u00010[8@X\u0080\u0004¢\u0006\f\u0012\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR+\u0010b\u001a\u00020?2\u0006\u0010\u000b\u001a\u00020?8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bg\u0010\u0013\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001a\u0010h\u001a\u00020iX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010m\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006ª\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "(Landroidx/compose/foundation/text/UndoManager;)V", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager$foundation_release", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager$foundation_release", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "Landroidx/compose/runtime/MutableState;", "dragBeginOffsetInText", "", "Ljava/lang/Integer;", "dragBeginPosition", "J", "dragTotalDistance", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "", "editable", "getEditable", "()Z", "setEditable", "(Z)V", "editable$delegate", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping$foundation_release", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping$foundation_release", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "oldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "", "getOnValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "previousRawDragOffset", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "state", "Landroidx/compose/foundation/text/TextFieldState;", "getState$foundation_release", "()Landroidx/compose/foundation/text/TextFieldState;", "setState$foundation_release", "(Landroidx/compose/foundation/text/TextFieldState;)V", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "touchSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getTouchSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/TextDragObserver;", "transformedText", "Landroidx/compose/ui/text/AnnotatedString;", "getTransformedText$foundation_release$annotations", "()V", "getTransformedText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "value", "getValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "value$delegate", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation$foundation_release", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setVisualTransformation$foundation_release", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "contextMenuOpenAdjustment", "position", "contextMenuOpenAdjustment-k-4lQ0M", "(J)V", "copy", "cancelSelection", "copy$foundation_release", "createTextFieldValue", "annotatedString", "selection", "Landroidx/compose/ui/text/TextRange;", "createTextFieldValue-FDrldGo", "(Landroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/input/TextFieldValue;", "cursorDragObserver", "cursorDragObserver$foundation_release", "cut", "cut$foundation_release", "deselect", "deselect-_kEHs6E$foundation_release", "enterSelectionMode", "showFloatingToolbar", "enterSelectionMode$foundation_release", "exitSelectionMode", "exitSelectionMode$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorPosition", "density", "Landroidx/compose/ui/unit/Density;", "getCursorPosition-tuRUvjQ$foundation_release", "(Landroidx/compose/ui/unit/Density;)J", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ$foundation_release", "(Z)J", "handleDragObserver", "handleDragObserver$foundation_release", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "isTextChanged", "isTextChanged$foundation_release", "paste", "paste$foundation_release", "selectAll", "selectAll$foundation_release", "setHandleState", "handleState", "Landroidx/compose/foundation/text/HandleState;", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "updateFloatingToolbar", "show", "updateSelection", "currentPosition", "isStartOfSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "isTouchBasedSelection", "updateSelection-8UEBfa8", "(Landroidx/compose/ui/text/input/TextFieldValue;JZZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldSelectionManager {
    public static final int $stable = 8;
    private ClipboardManager clipboardManager;

    /* renamed from: currentDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState currentDragPosition;
    private Integer dragBeginOffsetInText;
    private long dragBeginPosition;
    private long dragTotalDistance;

    /* renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle;

    /* renamed from: editable$delegate, reason: from kotlin metadata */
    private final MutableState editable;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final MouseSelectionObserver mouseSelectionObserver;
    private OffsetMapping offsetMapping;
    private TextFieldValue oldValue;
    private Function1<? super TextFieldValue, Unit> onValueChange;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;
    private TextFieldState state;
    private TextToolbar textToolbar;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableState value;
    private VisualTransformation visualTransformation;

    /* JADX WARN: Multi-variable type inference failed */
    public TextFieldSelectionManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public TextFieldSelectionManager(UndoManager undoManager) {
        this.undoManager = undoManager;
        this.offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
        this.onValueChange = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$onValueChange$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                invoke2(textFieldValue);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldValue textFieldValue) {
            }
        };
        this.value = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null), null, 2, null);
        this.visualTransformation = VisualTransformation.INSTANCE.getNone();
        this.editable = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.dragBeginPosition = Offset.INSTANCE.m3209getZeroF1C5BW0();
        this.dragTotalDistance = Offset.INSTANCE.m3209getZeroF1C5BW0();
        this.draggingHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.previousRawDragOffset = -1;
        this.oldValue = new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null);
        this.touchSelectionObserver = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo919onDownk4lQ0M(long point) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo920onDragk4lQ0M(long delta) {
                long j;
                TextLayoutResultProxy layoutResult;
                long j2;
                long j3;
                Integer num;
                Integer num2;
                long j4;
                int m953getOffsetForPosition3MmeM6k;
                Integer num3;
                long m1074updateSelection8UEBfa8;
                long j5;
                if (TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m3198plusMKHz9U(j, delta);
                TextFieldState state = TextFieldSelectionManager.this.getState();
                if (state != null && (layoutResult = state.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                    j2 = textFieldSelectionManager2.dragBeginPosition;
                    j3 = textFieldSelectionManager2.dragTotalDistance;
                    textFieldSelectionManager2.m1073setCurrentDragPosition_kEHs6E(Offset.m3182boximpl(Offset.m3198plusMKHz9U(j2, j3)));
                    num = textFieldSelectionManager2.dragBeginOffsetInText;
                    if (num == null) {
                        Offset m1077getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m1077getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(m1077getCurrentDragPosition_m7T9E);
                        if (!layoutResult.m954isPositionOnTextk4lQ0M(m1077getCurrentDragPosition_m7T9E.getPackedValue())) {
                            OffsetMapping offsetMapping = textFieldSelectionManager2.getOffsetMapping();
                            j5 = textFieldSelectionManager2.dragBeginPosition;
                            int transformedToOriginal = offsetMapping.transformedToOriginal(TextLayoutResultProxy.m952getOffsetForPosition3MmeM6k$default(layoutResult, j5, false, 2, null));
                            OffsetMapping offsetMapping2 = textFieldSelectionManager2.getOffsetMapping();
                            Offset m1077getCurrentDragPosition_m7T9E2 = textFieldSelectionManager2.m1077getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(m1077getCurrentDragPosition_m7T9E2);
                            SelectionAdjustment none = transformedToOriginal == offsetMapping2.transformedToOriginal(TextLayoutResultProxy.m952getOffsetForPosition3MmeM6k$default(layoutResult, m1077getCurrentDragPosition_m7T9E2.getPackedValue(), false, 2, null)) ? SelectionAdjustment.INSTANCE.getNone() : SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate();
                            TextFieldValue value$foundation_release = textFieldSelectionManager2.getValue$foundation_release();
                            Offset m1077getCurrentDragPosition_m7T9E3 = textFieldSelectionManager2.m1077getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(m1077getCurrentDragPosition_m7T9E3);
                            m1074updateSelection8UEBfa8 = textFieldSelectionManager2.m1074updateSelection8UEBfa8(value$foundation_release, m1077getCurrentDragPosition_m7T9E3.getPackedValue(), false, false, none, true);
                            TextRange.m5268boximpl(m1074updateSelection8UEBfa8);
                        }
                    }
                    num2 = textFieldSelectionManager2.dragBeginOffsetInText;
                    if (num2 != null) {
                        m953getOffsetForPosition3MmeM6k = num2.intValue();
                    } else {
                        j4 = textFieldSelectionManager2.dragBeginPosition;
                        m953getOffsetForPosition3MmeM6k = layoutResult.m953getOffsetForPosition3MmeM6k(j4, false);
                    }
                    Offset m1077getCurrentDragPosition_m7T9E4 = textFieldSelectionManager2.m1077getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(m1077getCurrentDragPosition_m7T9E4);
                    int m953getOffsetForPosition3MmeM6k2 = layoutResult.m953getOffsetForPosition3MmeM6k(m1077getCurrentDragPosition_m7T9E4.getPackedValue(), false);
                    num3 = textFieldSelectionManager2.dragBeginOffsetInText;
                    if (num3 == null && m953getOffsetForPosition3MmeM6k == m953getOffsetForPosition3MmeM6k2) {
                        return;
                    }
                    TextFieldValue value$foundation_release2 = textFieldSelectionManager2.getValue$foundation_release();
                    Offset m1077getCurrentDragPosition_m7T9E5 = textFieldSelectionManager2.m1077getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(m1077getCurrentDragPosition_m7T9E5);
                    m1074updateSelection8UEBfa8 = textFieldSelectionManager2.m1074updateSelection8UEBfa8(value$foundation_release2, m1077getCurrentDragPosition_m7T9E5.getPackedValue(), false, false, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), true);
                    TextRange.m5268boximpl(m1074updateSelection8UEBfa8);
                }
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo921onStartk4lQ0M(long startPoint) {
                long m1074updateSelection8UEBfa8;
                long j;
                TextLayoutResultProxy layoutResult;
                TextFieldValue m1071createTextFieldValueFDrldGo;
                TextLayoutResultProxy layoutResult2;
                if (TextFieldSelectionManager.this.getDraggingHandle() != null) {
                    return;
                }
                TextFieldSelectionManager.this.setDraggingHandle(Handle.SelectionEnd);
                TextFieldSelectionManager.this.previousRawDragOffset = -1;
                TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                TextFieldState state = TextFieldSelectionManager.this.getState();
                if ((state == null || (layoutResult2 = state.getLayoutResult()) == null || !layoutResult2.m954isPositionOnTextk4lQ0M(startPoint)) ? false : true) {
                    if (TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) {
                        return;
                    }
                    TextFieldSelectionManager.this.enterSelectionMode$foundation_release(false);
                    TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                    m1074updateSelection8UEBfa8 = textFieldSelectionManager.m1074updateSelection8UEBfa8(TextFieldValue.m5517copy3r_uNRQ$default(textFieldSelectionManager.getValue$foundation_release(), (AnnotatedString) null, TextRange.INSTANCE.m5285getZerod9O1mEE(), (TextRange) null, 5, (Object) null), startPoint, true, false, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), true);
                    TextFieldSelectionManager.this.dragBeginOffsetInText = Integer.valueOf(TextRange.m5280getStartimpl(m1074updateSelection8UEBfa8));
                } else {
                    TextFieldState state2 = TextFieldSelectionManager.this.getState();
                    if (state2 != null && (layoutResult = state2.getLayoutResult()) != null) {
                        TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                        int transformedToOriginal = textFieldSelectionManager2.getOffsetMapping().transformedToOriginal(TextLayoutResultProxy.m952getOffsetForPosition3MmeM6k$default(layoutResult, startPoint, false, 2, null));
                        m1071createTextFieldValueFDrldGo = textFieldSelectionManager2.m1071createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal));
                        textFieldSelectionManager2.enterSelectionMode$foundation_release(false);
                        textFieldSelectionManager2.setHandleState(HandleState.Cursor);
                        HapticFeedback hapticFeedBack = textFieldSelectionManager2.getHapticFeedBack();
                        if (hapticFeedBack != null) {
                            hapticFeedBack.mo4118performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4127getTextHandleMove5zf0vsI());
                        }
                        textFieldSelectionManager2.getOnValueChange$foundation_release().invoke(m1071createTextFieldValueFDrldGo);
                    }
                }
                TextFieldSelectionManager.this.dragBeginPosition = startPoint;
                TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                j = textFieldSelectionManager3.dragBeginPosition;
                textFieldSelectionManager3.m1073setCurrentDragPosition_kEHs6E(Offset.m3182boximpl(j));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.INSTANCE.m3209getZeroF1C5BW0();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1073setCurrentDragPosition_kEHs6E(null);
                TextFieldSelectionManager.this.updateFloatingToolbar(true);
                TextFieldSelectionManager.this.dragBeginOffsetInText = null;
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
            }
        };
        this.mouseSelectionObserver = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$mouseSelectionObserver$1
            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onDrag-3MmeM6k */
            public boolean mo992onDrag3MmeM6k(long dragPosition, SelectionAdjustment adjustment) {
                TextFieldState state;
                if ((TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) || (state = TextFieldSelectionManager.this.getState()) == null || state.getLayoutResult() == null) {
                    return false;
                }
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                textFieldSelectionManager.m1074updateSelection8UEBfa8(textFieldSelectionManager.getValue$foundation_release(), dragPosition, false, false, adjustment, false);
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public void onDragDone() {
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtend-k-4lQ0M */
            public boolean mo993onExtendk4lQ0M(long downPosition) {
                TextFieldState state = TextFieldSelectionManager.this.getState();
                if (state == null || state.getLayoutResult() == null) {
                    return false;
                }
                TextFieldSelectionManager.this.previousRawDragOffset = -1;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                textFieldSelectionManager.m1074updateSelection8UEBfa8(textFieldSelectionManager.getValue$foundation_release(), downPosition, false, false, SelectionAdjustment.INSTANCE.getNone(), false);
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtendDrag-k-4lQ0M */
            public boolean mo994onExtendDragk4lQ0M(long dragPosition) {
                TextFieldState state;
                if ((TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) || (state = TextFieldSelectionManager.this.getState()) == null || state.getLayoutResult() == null) {
                    return false;
                }
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                textFieldSelectionManager.m1074updateSelection8UEBfa8(textFieldSelectionManager.getValue$foundation_release(), dragPosition, false, false, SelectionAdjustment.INSTANCE.getNone(), false);
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onStart-3MmeM6k */
            public boolean mo995onStart3MmeM6k(long downPosition, SelectionAdjustment adjustment) {
                TextFieldState state;
                long j;
                if ((TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) || (state = TextFieldSelectionManager.this.getState()) == null || state.getLayoutResult() == null) {
                    return false;
                }
                FocusRequester focusRequester = TextFieldSelectionManager.this.getFocusRequester();
                if (focusRequester != null) {
                    focusRequester.requestFocus();
                }
                TextFieldSelectionManager.this.dragBeginPosition = downPosition;
                TextFieldSelectionManager.this.previousRawDragOffset = -1;
                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                TextFieldValue value$foundation_release = textFieldSelectionManager.getValue$foundation_release();
                j = TextFieldSelectionManager.this.dragBeginPosition;
                textFieldSelectionManager.m1074updateSelection8UEBfa8(value$foundation_release, j, true, false, adjustment, false);
                return true;
            }
        };
    }

    public /* synthetic */ TextFieldSelectionManager(UndoManager undoManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : undoManager);
    }

    public static /* synthetic */ void copy$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionManager.copy$foundation_release(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createTextFieldValue-FDrldGo, reason: not valid java name */
    public final TextFieldValue m1071createTextFieldValueFDrldGo(AnnotatedString annotatedString, long selection) {
        return new TextFieldValue(annotatedString, selection, (TextRange) null, 4, (DefaultConstructorMarker) null);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release$default, reason: not valid java name */
    public static /* synthetic */ void m1072deselect_kEHs6E$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i, Object obj) {
        if ((i & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.m1076deselect_kEHs6E$foundation_release(offset);
    }

    public static /* synthetic */ void enterSelectionMode$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionManager.enterSelectionMode$foundation_release(z);
    }

    private final Rect getContentRect() {
        float f;
        LayoutCoordinates layoutCoordinates;
        TextLayoutResult value;
        Rect cursorRect;
        LayoutCoordinates layoutCoordinates2;
        TextLayoutResult value2;
        Rect cursorRect2;
        LayoutCoordinates layoutCoordinates3;
        LayoutCoordinates layoutCoordinates4;
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            if (!(!textFieldState.getIsLayoutResultStale())) {
                textFieldState = null;
            }
            if (textFieldState != null) {
                int originalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m5280getStartimpl(getValue$foundation_release().getSelection()));
                int originalToTransformed2 = this.offsetMapping.originalToTransformed(TextRange.m5275getEndimpl(getValue$foundation_release().getSelection()));
                TextFieldState textFieldState2 = this.state;
                long m3209getZeroF1C5BW0 = (textFieldState2 == null || (layoutCoordinates4 = textFieldState2.getLayoutCoordinates()) == null) ? Offset.INSTANCE.m3209getZeroF1C5BW0() : layoutCoordinates4.mo4732localToRootMKHz9U(m1079getHandlePositiontuRUvjQ$foundation_release(true));
                TextFieldState textFieldState3 = this.state;
                long m3209getZeroF1C5BW02 = (textFieldState3 == null || (layoutCoordinates3 = textFieldState3.getLayoutCoordinates()) == null) ? Offset.INSTANCE.m3209getZeroF1C5BW0() : layoutCoordinates3.mo4732localToRootMKHz9U(m1079getHandlePositiontuRUvjQ$foundation_release(false));
                TextFieldState textFieldState4 = this.state;
                float f2 = 0.0f;
                if (textFieldState4 == null || (layoutCoordinates2 = textFieldState4.getLayoutCoordinates()) == null) {
                    f = 0.0f;
                } else {
                    TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                    f = Offset.m3194getYimpl(layoutCoordinates2.mo4732localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult == null || (value2 = layoutResult.getValue()) == null || (cursorRect2 = value2.getCursorRect(originalToTransformed)) == null) ? 0.0f : cursorRect2.getTop())));
                }
                TextFieldState textFieldState5 = this.state;
                if (textFieldState5 != null && (layoutCoordinates = textFieldState5.getLayoutCoordinates()) != null) {
                    TextLayoutResultProxy layoutResult2 = textFieldState.getLayoutResult();
                    f2 = Offset.m3194getYimpl(layoutCoordinates.mo4732localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult2 == null || (value = layoutResult2.getValue()) == null || (cursorRect = value.getCursorRect(originalToTransformed2)) == null) ? 0.0f : cursorRect.getTop())));
                }
                return new Rect(Math.min(Offset.m3193getXimpl(m3209getZeroF1C5BW0), Offset.m3193getXimpl(m3209getZeroF1C5BW02)), Math.min(f, f2), Math.max(Offset.m3193getXimpl(m3209getZeroF1C5BW0), Offset.m3193getXimpl(m3209getZeroF1C5BW02)), Math.max(Offset.m3194getYimpl(m3209getZeroF1C5BW0), Offset.m3194getYimpl(m3209getZeroF1C5BW02)) + (Dp.m5793constructorimpl(25) * textFieldState.getTextDelegate().getDensity().getDensity()));
            }
        }
        return Rect.INSTANCE.getZero();
    }

    public static /* synthetic */ void getTransformedText$foundation_release$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m1073setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle.setValue(handle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHandleState(HandleState handleState) {
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            if (textFieldState.getHandleState() == handleState) {
                textFieldState = null;
            }
            if (textFieldState != null) {
                textFieldState.setHandleState(handleState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFloatingToolbar(boolean show) {
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textFieldState.setShowFloatingToolbar(show);
        }
        if (show) {
            showSelectionToolbar$foundation_release();
        } else {
            hideSelectionToolbar$foundation_release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateSelection-8UEBfa8, reason: not valid java name */
    public final long m1074updateSelection8UEBfa8(TextFieldValue value, long currentPosition, boolean isStartOfSelection, boolean isStartHandle, SelectionAdjustment adjustment, boolean isTouchBasedSelection) {
        TextLayoutResultProxy layoutResult;
        HapticFeedback hapticFeedback;
        int i;
        TextFieldState textFieldState = this.state;
        if (textFieldState == null || (layoutResult = textFieldState.getLayoutResult()) == null) {
            return TextRange.INSTANCE.m5285getZerod9O1mEE();
        }
        long TextRange = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.m5280getStartimpl(value.getSelection())), this.offsetMapping.originalToTransformed(TextRange.m5275getEndimpl(value.getSelection())));
        int m953getOffsetForPosition3MmeM6k = layoutResult.m953getOffsetForPosition3MmeM6k(currentPosition, false);
        int m5280getStartimpl = (isStartHandle || isStartOfSelection) ? m953getOffsetForPosition3MmeM6k : TextRange.m5280getStartimpl(TextRange);
        int m5275getEndimpl = (!isStartHandle || isStartOfSelection) ? m953getOffsetForPosition3MmeM6k : TextRange.m5275getEndimpl(TextRange);
        SelectionLayout selectionLayout = this.previousSelectionLayout;
        int i2 = -1;
        if (!isStartOfSelection && selectionLayout != null && (i = this.previousRawDragOffset) != -1) {
            i2 = i;
        }
        SelectionLayout m1022getTextFieldSelectionLayoutRcvTLA = SelectionLayoutKt.m1022getTextFieldSelectionLayoutRcvTLA(layoutResult.getValue(), m5280getStartimpl, m5275getEndimpl, i2, TextRange, isStartOfSelection, isStartHandle);
        if (!m1022getTextFieldSelectionLayoutRcvTLA.shouldRecomputeSelection(selectionLayout)) {
            return value.getSelection();
        }
        this.previousSelectionLayout = m1022getTextFieldSelectionLayoutRcvTLA;
        this.previousRawDragOffset = m953getOffsetForPosition3MmeM6k;
        Selection adjust = adjustment.adjust(m1022getTextFieldSelectionLayoutRcvTLA);
        long TextRange2 = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(adjust.getStart().getOffset()), this.offsetMapping.transformedToOriginal(adjust.getEnd().getOffset()));
        if (TextRange.m5273equalsimpl0(TextRange2, value.getSelection())) {
            return value.getSelection();
        }
        boolean z = TextRange.m5279getReversedimpl(TextRange2) != TextRange.m5279getReversedimpl(value.getSelection()) && TextRange.m5273equalsimpl0(TextRangeKt.TextRange(TextRange.m5275getEndimpl(TextRange2), TextRange.m5280getStartimpl(TextRange2)), value.getSelection());
        boolean z2 = TextRange.m5274getCollapsedimpl(TextRange2) && TextRange.m5274getCollapsedimpl(value.getSelection());
        if (isTouchBasedSelection) {
            if ((value.getText().length() > 0) && !z && !z2 && (hapticFeedback = this.hapticFeedBack) != null) {
                hapticFeedback.mo4118performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4127getTextHandleMove5zf0vsI());
            }
        }
        TextFieldValue m1071createTextFieldValueFDrldGo = m1071createTextFieldValueFDrldGo(value.getAnnotatedString(), TextRange2);
        this.onValueChange.invoke(m1071createTextFieldValueFDrldGo);
        setHandleState(TextRange.m5274getCollapsedimpl(m1071createTextFieldValueFDrldGo.getSelection()) ? HandleState.Cursor : HandleState.Selection);
        TextFieldState textFieldState2 = this.state;
        if (textFieldState2 != null) {
            textFieldState2.setInTouchMode(isTouchBasedSelection);
        }
        TextFieldState textFieldState3 = this.state;
        if (textFieldState3 != null) {
            textFieldState3.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true));
        }
        TextFieldState textFieldState4 = this.state;
        if (textFieldState4 != null) {
            textFieldState4.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, false));
        }
        return TextRange2;
    }

    /* renamed from: contextMenuOpenAdjustment-k-4lQ0M, reason: not valid java name */
    public final void m1075contextMenuOpenAdjustmentk4lQ0M(long position) {
        TextLayoutResultProxy layoutResult;
        TextFieldState textFieldState = this.state;
        if (textFieldState == null || (layoutResult = textFieldState.getLayoutResult()) == null) {
            return;
        }
        if (TextRange.m5271containsimpl(getValue$foundation_release().getSelection(), TextLayoutResultProxy.m952getOffsetForPosition3MmeM6k$default(layoutResult, position, false, 2, null))) {
            return;
        }
        this.previousRawDragOffset = -1;
        m1074updateSelection8UEBfa8(getValue$foundation_release(), position, true, false, SelectionAdjustment.INSTANCE.getWord(), false);
    }

    public final void copy$foundation_release(boolean cancelSelection) {
        if (TextRange.m5274getCollapsedimpl(getValue$foundation_release().getSelection())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        if (cancelSelection) {
            int m5277getMaximpl = TextRange.m5277getMaximpl(getValue$foundation_release().getSelection());
            this.onValueChange.invoke(m1071createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(m5277getMaximpl, m5277getMaximpl)));
            setHandleState(HandleState.None);
        }
    }

    public final TextDragObserver cursorDragObserver$foundation_release() {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$cursorDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo919onDownk4lQ0M(long point) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo920onDragk4lQ0M(long delta) {
                long j;
                TextLayoutResultProxy layoutResult;
                long j2;
                long j3;
                TextFieldValue m1071createTextFieldValueFDrldGo;
                HapticFeedback hapticFeedBack;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m3198plusMKHz9U(j, delta);
                TextFieldState state = TextFieldSelectionManager.this.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                j2 = textFieldSelectionManager2.dragBeginPosition;
                j3 = textFieldSelectionManager2.dragTotalDistance;
                textFieldSelectionManager2.m1073setCurrentDragPosition_kEHs6E(Offset.m3182boximpl(Offset.m3198plusMKHz9U(j2, j3)));
                OffsetMapping offsetMapping = textFieldSelectionManager2.getOffsetMapping();
                Offset m1077getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m1077getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(m1077getCurrentDragPosition_m7T9E);
                int transformedToOriginal = offsetMapping.transformedToOriginal(TextLayoutResultProxy.m952getOffsetForPosition3MmeM6k$default(layoutResult, m1077getCurrentDragPosition_m7T9E.getPackedValue(), false, 2, null));
                long TextRange = TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal);
                if (TextRange.m5273equalsimpl0(TextRange, textFieldSelectionManager2.getValue$foundation_release().getSelection())) {
                    return;
                }
                TextFieldState state2 = textFieldSelectionManager2.getState();
                boolean z = false;
                if (state2 != null && !state2.isInTouchMode()) {
                    z = true;
                }
                if (!z && (hapticFeedBack = textFieldSelectionManager2.getHapticFeedBack()) != null) {
                    hapticFeedBack.mo4118performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4127getTextHandleMove5zf0vsI());
                }
                Function1<TextFieldValue, Unit> onValueChange$foundation_release = textFieldSelectionManager2.getOnValueChange$foundation_release();
                m1071createTextFieldValueFDrldGo = textFieldSelectionManager2.m1071createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation_release().getAnnotatedString(), TextRange);
                onValueChange$foundation_release.invoke(m1071createTextFieldValueFDrldGo);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo921onStartk4lQ0M(long startPoint) {
                TextLayoutResultProxy layoutResult;
                long m1019getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m1019getAdjustedCoordinatesk4lQ0M(TextFieldSelectionManager.this.m1079getHandlePositiontuRUvjQ$foundation_release(true));
                TextFieldState state = TextFieldSelectionManager.this.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                long m956translateInnerToDecorationCoordinatesMKHz9U$foundation_release = layoutResult.m956translateInnerToDecorationCoordinatesMKHz9U$foundation_release(m1019getAdjustedCoordinatesk4lQ0M);
                TextFieldSelectionManager.this.dragBeginPosition = m956translateInnerToDecorationCoordinatesMKHz9U$foundation_release;
                TextFieldSelectionManager.this.m1073setCurrentDragPosition_kEHs6E(Offset.m3182boximpl(m956translateInnerToDecorationCoordinatesMKHz9U$foundation_release));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.INSTANCE.m3209getZeroF1C5BW0();
                TextFieldSelectionManager.this.setDraggingHandle(Handle.Cursor);
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1073setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1073setCurrentDragPosition_kEHs6E(null);
            }
        };
    }

    public final void cut$foundation_release() {
        if (TextRange.m5274getCollapsedimpl(getValue$foundation_release().getSelection())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        AnnotatedString plus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
        int m5278getMinimpl = TextRange.m5278getMinimpl(getValue$foundation_release().getSelection());
        this.onValueChange.invoke(m1071createTextFieldValueFDrldGo(plus, TextRangeKt.TextRange(m5278getMinimpl, m5278getMinimpl)));
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
    }

    /* renamed from: deselect-_kEHs6E$foundation_release, reason: not valid java name */
    public final void m1076deselect_kEHs6E$foundation_release(Offset position) {
        HandleState handleState;
        if (!TextRange.m5274getCollapsedimpl(getValue$foundation_release().getSelection())) {
            TextFieldState textFieldState = this.state;
            TextLayoutResultProxy layoutResult = textFieldState != null ? textFieldState.getLayoutResult() : null;
            this.onValueChange.invoke(TextFieldValue.m5517copy3r_uNRQ$default(getValue$foundation_release(), (AnnotatedString) null, TextRangeKt.TextRange((position == null || layoutResult == null) ? TextRange.m5277getMaximpl(getValue$foundation_release().getSelection()) : this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.m952getOffsetForPosition3MmeM6k$default(layoutResult, position.getPackedValue(), false, 2, null))), (TextRange) null, 5, (Object) null));
        }
        if (position != null) {
            if (getValue$foundation_release().getText().length() > 0) {
                handleState = HandleState.Cursor;
                setHandleState(handleState);
                updateFloatingToolbar(false);
            }
        }
        handleState = HandleState.None;
        setHandleState(handleState);
        updateFloatingToolbar(false);
    }

    public final void enterSelectionMode$foundation_release(boolean showFloatingToolbar) {
        FocusRequester focusRequester;
        TextFieldState textFieldState = this.state;
        boolean z = false;
        if (textFieldState != null && !textFieldState.getHasFocus()) {
            z = true;
        }
        if (z && (focusRequester = this.focusRequester) != null) {
            focusRequester.requestFocus();
        }
        this.oldValue = getValue$foundation_release();
        updateFloatingToolbar(showFloatingToolbar);
        setHandleState(HandleState.Selection);
    }

    public final void exitSelectionMode$foundation_release() {
        updateFloatingToolbar(false);
        setHandleState(HandleState.None);
    }

    /* renamed from: getClipboardManager$foundation_release, reason: from getter */
    public final ClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m1077getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition.getValue();
    }

    /* renamed from: getCursorPosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m1078getCursorPositiontuRUvjQ$foundation_release(Density density) {
        int originalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m5280getStartimpl(getValue$foundation_release().getSelection()));
        TextFieldState textFieldState = this.state;
        TextLayoutResultProxy layoutResult = textFieldState != null ? textFieldState.getLayoutResult() : null;
        Intrinsics.checkNotNull(layoutResult);
        TextLayoutResult value = layoutResult.getValue();
        Rect cursorRect = value.getCursorRect(RangesKt.coerceIn(originalToTransformed, 0, value.getLayoutInput().getText().length()));
        return OffsetKt.Offset(cursorRect.getLeft() + (density.mo316toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness()) / 2), cursorRect.getBottom());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getEditable() {
        return ((Boolean) this.editable.getValue()).booleanValue();
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    /* renamed from: getHandlePosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m1079getHandlePositiontuRUvjQ$foundation_release(boolean isStartHandle) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        TextFieldState textFieldState = this.state;
        if (textFieldState == null || (layoutResult = textFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return Offset.INSTANCE.m3208getUnspecifiedF1C5BW0();
        }
        AnnotatedString transformedText$foundation_release = getTransformedText$foundation_release();
        if (transformedText$foundation_release == null) {
            return Offset.INSTANCE.m3208getUnspecifiedF1C5BW0();
        }
        if (!Intrinsics.areEqual(transformedText$foundation_release.getText(), value.getLayoutInput().getText().getText())) {
            return Offset.INSTANCE.m3208getUnspecifiedF1C5BW0();
        }
        long selection = getValue$foundation_release().getSelection();
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(value, this.offsetMapping.originalToTransformed(isStartHandle ? TextRange.m5280getStartimpl(selection) : TextRange.m5275getEndimpl(selection)), isStartHandle, TextRange.m5279getReversedimpl(getValue$foundation_release().getSelection()));
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    /* renamed from: getMouseSelectionObserver$foundation_release, reason: from getter */
    public final MouseSelectionObserver getMouseSelectionObserver() {
        return this.mouseSelectionObserver;
    }

    /* renamed from: getOffsetMapping$foundation_release, reason: from getter */
    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange$foundation_release() {
        return this.onValueChange;
    }

    /* renamed from: getState$foundation_release, reason: from getter */
    public final TextFieldState getState() {
        return this.state;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    /* renamed from: getTouchSelectionObserver$foundation_release, reason: from getter */
    public final TextDragObserver getTouchSelectionObserver() {
        return this.touchSelectionObserver;
    }

    public final AnnotatedString getTransformedText$foundation_release() {
        TextDelegate textDelegate;
        TextFieldState textFieldState = this.state;
        if (textFieldState == null || (textDelegate = textFieldState.getTextDelegate()) == null) {
            return null;
        }
        return textDelegate.getText();
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextFieldValue getValue$foundation_release() {
        return (TextFieldValue) this.value.getValue();
    }

    /* renamed from: getVisualTransformation$foundation_release, reason: from getter */
    public final VisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public final TextDragObserver handleDragObserver$foundation_release(final boolean isStartHandle) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$handleDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo919onDownk4lQ0M(long point) {
                TextLayoutResultProxy layoutResult;
                TextFieldSelectionManager.this.setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
                long m1019getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m1019getAdjustedCoordinatesk4lQ0M(TextFieldSelectionManager.this.m1079getHandlePositiontuRUvjQ$foundation_release(isStartHandle));
                TextFieldState state = TextFieldSelectionManager.this.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                long m956translateInnerToDecorationCoordinatesMKHz9U$foundation_release = layoutResult.m956translateInnerToDecorationCoordinatesMKHz9U$foundation_release(m1019getAdjustedCoordinatesk4lQ0M);
                TextFieldSelectionManager.this.dragBeginPosition = m956translateInnerToDecorationCoordinatesMKHz9U$foundation_release;
                TextFieldSelectionManager.this.m1073setCurrentDragPosition_kEHs6E(Offset.m3182boximpl(m956translateInnerToDecorationCoordinatesMKHz9U$foundation_release));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.INSTANCE.m3209getZeroF1C5BW0();
                TextFieldSelectionManager.this.previousRawDragOffset = -1;
                TextFieldState state2 = TextFieldSelectionManager.this.getState();
                if (state2 != null) {
                    state2.setInTouchMode(true);
                }
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo920onDragk4lQ0M(long delta) {
                long j;
                long j2;
                long j3;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m3198plusMKHz9U(j, delta);
                TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                j2 = textFieldSelectionManager2.dragBeginPosition;
                j3 = TextFieldSelectionManager.this.dragTotalDistance;
                textFieldSelectionManager2.m1073setCurrentDragPosition_kEHs6E(Offset.m3182boximpl(Offset.m3198plusMKHz9U(j2, j3)));
                TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                TextFieldValue value$foundation_release = textFieldSelectionManager3.getValue$foundation_release();
                Offset m1077getCurrentDragPosition_m7T9E = TextFieldSelectionManager.this.m1077getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(m1077getCurrentDragPosition_m7T9E);
                textFieldSelectionManager3.m1074updateSelection8UEBfa8(value$foundation_release, m1077getCurrentDragPosition_m7T9E.getPackedValue(), false, isStartHandle, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), true);
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo921onStartk4lQ0M(long startPoint) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1073setCurrentDragPosition_kEHs6E(null);
                TextFieldSelectionManager.this.updateFloatingToolbar(true);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1073setCurrentDragPosition_kEHs6E(null);
                TextFieldSelectionManager.this.updateFloatingToolbar(true);
            }
        };
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    public final boolean isTextChanged$foundation_release() {
        return !Intrinsics.areEqual(this.oldValue.getText(), getValue$foundation_release().getText());
    }

    public final void paste$foundation_release() {
        AnnotatedString text;
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager == null || (text = clipboardManager.getText()) == null) {
            return;
        }
        AnnotatedString plus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(text).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
        int m5278getMinimpl = TextRange.m5278getMinimpl(getValue$foundation_release().getSelection()) + text.length();
        this.onValueChange.invoke(m1071createTextFieldValueFDrldGo(plus, TextRangeKt.TextRange(m5278getMinimpl, m5278getMinimpl)));
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
    }

    public final void selectAll$foundation_release() {
        TextFieldValue m1071createTextFieldValueFDrldGo = m1071createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(0, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(m1071createTextFieldValueFDrldGo);
        this.oldValue = TextFieldValue.m5517copy3r_uNRQ$default(this.oldValue, (AnnotatedString) null, m1071createTextFieldValueFDrldGo.getSelection(), (TextRange) null, 5, (Object) null);
        enterSelectionMode$foundation_release(true);
    }

    public final void setClipboardManager$foundation_release(ClipboardManager clipboardManager) {
        this.clipboardManager = clipboardManager;
    }

    public final void setEditable(boolean z) {
        this.editable.setValue(Boolean.valueOf(z));
    }

    public final void setFocusRequester(FocusRequester focusRequester) {
        this.focusRequester = focusRequester;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final void setOffsetMapping$foundation_release(OffsetMapping offsetMapping) {
        this.offsetMapping = offsetMapping;
    }

    public final void setOnValueChange$foundation_release(Function1<? super TextFieldValue, Unit> function1) {
        this.onValueChange = function1;
    }

    public final void setState$foundation_release(TextFieldState textFieldState) {
        this.state = textFieldState;
    }

    public final void setTextToolbar(TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    public final void setValue$foundation_release(TextFieldValue textFieldValue) {
        this.value.setValue(textFieldValue);
    }

    public final void setVisualTransformation$foundation_release(VisualTransformation visualTransformation) {
        this.visualTransformation = visualTransformation;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void showSelectionToolbar$foundation_release() {
        /*
            r11 = this;
            androidx.compose.foundation.text.TextFieldState r0 = r11.state
            r1 = 1
            r2 = 0
            if (r0 == 0) goto Le
            boolean r0 = r0.isInTouchMode()
            if (r0 != 0) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            if (r0 == 0) goto L12
            return
        L12:
            androidx.compose.ui.text.input.VisualTransformation r0 = r11.visualTransformation
            boolean r0 = r0 instanceof androidx.compose.ui.text.input.PasswordVisualTransformation
            androidx.compose.ui.text.input.TextFieldValue r3 = r11.getValue$foundation_release()
            long r3 = r3.getSelection()
            boolean r3 = androidx.compose.ui.text.TextRange.m5274getCollapsedimpl(r3)
            r4 = 0
            if (r3 != 0) goto L30
            if (r0 != 0) goto L30
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1 r3 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1
            r3.<init>()
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r7 = r3
            goto L31
        L30:
            r7 = r4
        L31:
            androidx.compose.ui.text.input.TextFieldValue r3 = r11.getValue$foundation_release()
            long r5 = r3.getSelection()
            boolean r3 = androidx.compose.ui.text.TextRange.m5274getCollapsedimpl(r5)
            if (r3 != 0) goto L50
            boolean r3 = r11.getEditable()
            if (r3 == 0) goto L50
            if (r0 != 0) goto L50
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1 r0 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1
            r0.<init>()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r9 = r0
            goto L51
        L50:
            r9 = r4
        L51:
            boolean r0 = r11.getEditable()
            if (r0 == 0) goto L6e
            androidx.compose.ui.platform.ClipboardManager r0 = r11.clipboardManager
            if (r0 == 0) goto L62
            boolean r0 = r0.hasText()
            if (r0 != r1) goto L62
            goto L63
        L62:
            r1 = 0
        L63:
            if (r1 == 0) goto L6e
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1 r0 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1
            r0.<init>()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r8 = r0
            goto L6f
        L6e:
            r8 = r4
        L6f:
            androidx.compose.ui.text.input.TextFieldValue r0 = r11.getValue$foundation_release()
            long r0 = r0.getSelection()
            int r0 = androidx.compose.ui.text.TextRange.m5276getLengthimpl(r0)
            androidx.compose.ui.text.input.TextFieldValue r1 = r11.getValue$foundation_release()
            java.lang.String r1 = r1.getText()
            int r1 = r1.length()
            if (r0 == r1) goto L91
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1 r0 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1
            r0.<init>()
            r4 = r0
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
        L91:
            r10 = r4
            androidx.compose.ui.platform.TextToolbar r5 = r11.textToolbar
            if (r5 == 0) goto L9d
            androidx.compose.ui.geometry.Rect r6 = r11.getContentRect()
            r5.showMenu(r6, r7, r8, r9, r10)
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager.showSelectionToolbar$foundation_release():void");
    }
}
