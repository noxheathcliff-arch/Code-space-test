package androidx.compose.foundation.text;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoreTextField.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aî\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u000123\b\u0002\u0010\u001e\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00030\u001f¢\u0006\u0002\b ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\b H\u0001¢\u0006\u0002\u0010$\u001a0\u0010%\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010&\u001a\u00020'2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00030\u001f¢\u0006\u0002\b H\u0003¢\u0006\u0002\u0010)\u001a\u001d\u0010*\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010,\u001a\u0015\u0010-\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\u0010.\u001a\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u000201H\u0002\u001a\u0010\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u000204H\u0000\u001a \u00105\u001a\u00020\u00032\u0006\u00100\u001a\u0002012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u000207H\u0002\u001a0\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020:2\u0006\u00100\u001a\u0002012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00106\u001a\u000207H\u0002\u001a \u0010;\u001a\u00020\u00032\u0006\u00100\u001a\u0002012\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0001H\u0002\u001a2\u0010?\u001a\u00020\u0003*\u00020@2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u000f2\u0006\u00106\u001a\u000207H\u0080@¢\u0006\u0002\u0010D\u001a\u001c\u0010E\u001a\u00020\t*\u00020\t2\u0006\u00100\u001a\u0002012\u0006\u0010&\u001a\u00020'H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006F²\u0006\n\u0010G\u001a\u00020\u0001X\u008a\u0084\u0002"}, d2 = {"USE_WINDOW_FOCUS_ENABLED", "", "CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "endInputSession", "state", "Landroidx/compose/foundation/text/TextFieldState;", "isWindowFocusedBehindFlag", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "notifyFocusedRect", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewKeyEventToDeselectOnBack", "foundation_release", "writeable"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CoreTextFieldKt {
    public static final boolean USE_WINDOW_FOCUS_ENABLED = false;

    /* JADX WARN: Removed duplicated region for block: B:103:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0572  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x05fd  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x062f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0671  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0737 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0781  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x07d3  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x07ec  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x085a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x07f5  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0784  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x087f  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03ed A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x046f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void CoreTextField(final androidx.compose.ui.text.input.TextFieldValue r49, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r50, androidx.compose.ui.Modifier r51, androidx.compose.ui.text.TextStyle r52, androidx.compose.ui.text.input.VisualTransformation r53, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r54, androidx.compose.foundation.interaction.MutableInteractionSource r55, androidx.compose.ui.graphics.Brush r56, boolean r57, int r58, int r59, androidx.compose.ui.text.input.ImeOptions r60, androidx.compose.foundation.text.KeyboardActions r61, boolean r62, boolean r63, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r64, androidx.compose.runtime.Composer r65, final int r66, final int r67, final int r68) {
        /*
            Method dump skipped, instructions count: 2204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, boolean, int, int, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.text.KeyboardActions, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CoreTextField$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CoreTextFieldRootBox(final Modifier modifier, final TextFieldSelectionManager textFieldSelectionManager, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-20551815);
        ComposerKt.sourceInformation(startRestartGroup, "C(CoreTextFieldRootBox)P(2,1)747@33830L95:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-20551815, i, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:746)");
        }
        int i2 = (i & 14) | 384;
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        int i3 = i2 >> 3;
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, startRestartGroup, (i3 & 112) | (i3 & 14));
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
        int i4 = ((((i2 << 3) & 112) << 9) & 7168) | 6;
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        Composer m2963constructorimpl = Updater.m2963constructorimpl(startRestartGroup);
        Updater.m2970setimpl(m2963constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2970setimpl(m2963constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m2963constructorimpl.getInserting() || !Intrinsics.areEqual(m2963constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m2963constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m2963constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m2954boximpl(SkippableUpdater.m2955constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i4 >> 3) & 112));
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1087268483, "C748@33886L33:CoreTextField.kt#423gt5");
        startRestartGroup.startReplaceableGroup(-1985516685);
        ComposerKt.sourceInformation(startRestartGroup, "CC(ContextMenuArea)P(1)29@1062L9:ContextMenu.android.kt#423gt5");
        function2.invoke(startRestartGroup, Integer.valueOf(((((i >> 3) & 112) | 8) >> 3) & 14));
        startRestartGroup.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextFieldRootBox$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    CoreTextFieldKt.CoreTextFieldRootBox(Modifier.this, textFieldSelectionManager, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectionToolbarAndHandles(final TextFieldSelectionManager textFieldSelectionManager, final boolean z, Composer composer, final int i) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer startRestartGroup = composer.startRestartGroup(626339208);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionToolbarAndHandles)1101@48253L202:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(626339208, i, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1082)");
        }
        if (z) {
            TextFieldState state = textFieldSelectionManager.getState();
            TextLayoutResult textLayoutResult = null;
            if (state != null && (layoutResult = state.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                if (!(textFieldSelectionManager.getState() != null ? r3.getIsLayoutResultStale() : true)) {
                    textLayoutResult = value;
                }
            }
            if (textLayoutResult != null) {
                if (!TextRange.m5274getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().getSelection())) {
                    int originalToTransformed = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m5280getStartimpl(textFieldSelectionManager.getValue$foundation_release().getSelection()));
                    int originalToTransformed2 = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m5275getEndimpl(textFieldSelectionManager.getValue$foundation_release().getSelection()));
                    ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(originalToTransformed);
                    ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(originalToTransformed2 - 1, 0));
                    startRestartGroup.startReplaceableGroup(-498386751);
                    ComposerKt.sourceInformation(startRestartGroup, "1094@47930L203");
                    TextFieldState state2 = textFieldSelectionManager.getState();
                    if (state2 != null && state2.getShowSelectionHandleStart()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, startRestartGroup, 518);
                    }
                    startRestartGroup.endReplaceableGroup();
                    TextFieldState state3 = textFieldSelectionManager.getState();
                    if (state3 != null && state3.getShowSelectionHandleEnd()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, startRestartGroup, 518);
                    }
                }
                TextFieldState state4 = textFieldSelectionManager.getState();
                if (state4 != null) {
                    if (textFieldSelectionManager.isTextChanged$foundation_release()) {
                        state4.setShowFloatingToolbar(false);
                    }
                    if (state4.getHasFocus()) {
                        if (state4.getShowFloatingToolbar()) {
                            textFieldSelectionManager.showSelectionToolbar$foundation_release();
                        } else {
                            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                        }
                    }
                }
            }
        } else {
            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$SelectionToolbarAndHandles$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    CoreTextFieldKt.SelectionToolbarAndHandles(TextFieldSelectionManager.this, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TextFieldCursorHandle(final androidx.compose.foundation.text.selection.TextFieldSelectionManager r8, androidx.compose.runtime.Composer r9, final int r10) {
        /*
            r0 = -1436003720(0xffffffffaa685278, float:-2.0634351E-13)
            androidx.compose.runtime.Composer r9 = r9.startRestartGroup(r0)
            java.lang.String r1 = "C(TextFieldCursorHandle)1127@49347L50,1128@49460L7,1129@49477L1101:CoreTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L19
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1125)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r10, r1, r2)
        L19:
            androidx.compose.foundation.text.TextFieldState r0 = r8.getState()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L29
            boolean r0 = r0.getShowCursorHandle()
            if (r0 != r1) goto L29
            r0 = 1
            goto L2a
        L29:
            r0 = 0
        L2a:
            if (r0 == 0) goto Lcd
            androidx.compose.ui.text.AnnotatedString r0 = r8.getTransformedText$foundation_release()
            if (r0 == 0) goto L41
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L3c
            r0 = 1
            goto L3d
        L3c:
            r0 = 0
        L3d:
            if (r0 != r1) goto L41
            r0 = 1
            goto L42
        L41:
            r0 = 0
        L42:
            if (r0 == 0) goto Lcd
            r0 = 1157296644(0x44faf204, float:2007.563)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            boolean r0 = r9.changed(r8)
            java.lang.Object r3 = r9.rememberedValue()
            if (r0 != 0) goto L61
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.INSTANCE
            java.lang.Object r0 = r0.getEmpty()
            if (r3 != r0) goto L68
        L61:
            androidx.compose.foundation.text.TextDragObserver r3 = r8.cursorDragObserver$foundation_release()
            r9.updateRememberedValue(r3)
        L68:
            r9.endReplaceableGroup()
            androidx.compose.foundation.text.TextDragObserver r3 = (androidx.compose.foundation.text.TextDragObserver) r3
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r4, r5)
            java.lang.Object r0 = r9.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            long r4 = r8.m1078getCursorPositiontuRUvjQ$foundation_release(r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.INSTANCE
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1 r6 = new androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1
            r7 = 0
            r6.<init>(r3, r8, r7)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput(r0, r3, r6)
            r3 = -272875135(0xffffffffefbc4181, float:-1.1652474E29)
            r9.startReplaceableGroup(r3)
            boolean r3 = r9.changed(r4)
            java.lang.Object r6 = r9.rememberedValue()
            if (r3 != 0) goto Lb0
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.INSTANCE
            java.lang.Object r3 = r3.getEmpty()
            if (r6 != r3) goto Lbb
        Lb0:
            androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1 r3 = new androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1
            r3.<init>()
            r6 = r3
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r9.updateRememberedValue(r6)
        Lbb:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r9.endReplaceableGroup()
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r0, r2, r6, r1, r7)
            r0 = 0
            r6 = 384(0x180, float:5.38E-43)
            r1 = r4
            r4 = r0
            r5 = r9
            androidx.compose.foundation.text.AndroidCursorHandle_androidKt.m850CursorHandleULxng0E(r1, r3, r4, r5, r6)
        Lcd:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto Ld6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        Ld6:
            androidx.compose.runtime.ScopeUpdateScope r9 = r9.endRestartGroup()
            if (r9 == 0) goto Le6
            androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$3 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$3
            r0.<init>()
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        Le6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.TextFieldCursorHandle(androidx.compose.foundation.text.selection.TextFieldSelectionManager, androidx.compose.runtime.Composer, int):void");
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
        int originalToTransformed = offsetMapping.originalToTransformed(TextRange.m5277getMaximpl(textFieldValue.getSelection()));
        Object bringIntoView = bringIntoViewRequester.bringIntoView(originalToTransformed < textLayoutResult.getLayoutInput().getText().length() ? textLayoutResult.getBoundingBox(originalToTransformed) : originalToTransformed != 0 ? textLayoutResult.getBoundingBox(originalToTransformed - 1) : new Rect(0.0f, 0.0f, 1.0f, IntSize.m5966getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null))), continuation);
        return bringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bringIntoView : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endInputSession(TextFieldState textFieldState) {
        TextInputSession inputSession = textFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.INSTANCE.onBlur$foundation_release(inputSession, textFieldState.getProcessor(), textFieldState.getOnValueChange());
        }
        textFieldState.setInputSession(null);
    }

    public static final boolean isWindowFocusedBehindFlag(WindowInfo windowInfo) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyFocusedRect(TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        Snapshot createNonObservableSnapshot = Snapshot.INSTANCE.createNonObservableSnapshot();
        try {
            Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
            try {
                TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                if (layoutResult == null) {
                    return;
                }
                TextInputSession inputSession = textFieldState.getInputSession();
                if (inputSession == null) {
                    return;
                }
                LayoutCoordinates layoutCoordinates = textFieldState.getLayoutCoordinates();
                if (layoutCoordinates == null) {
                    return;
                }
                TextFieldDelegate.INSTANCE.notifyFocusedRect$foundation_release(textFieldValue, textFieldState.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, textFieldState.getHasFocus(), offsetMapping);
                Unit unit = Unit.INSTANCE;
            } finally {
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
            }
        } finally {
            createNonObservableSnapshot.dispose();
        }
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, final TextFieldState textFieldState, final TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$previewKeyEventToDeselectOnBack$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m872invokeZmokQxo(keyEvent.m4444unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m872invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z;
                if (TextFieldState.this.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m874cancelsTextSelectionZmokQxo(keyEvent)) {
                    z = true;
                    TextFieldSelectionManager.m1072deselect_kEHs6E$foundation_release$default(textFieldSelectionManager, null, 1, null);
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startInputSession(TextInputService textInputService, TextFieldState textFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        textFieldState.setInputSession(TextFieldDelegate.INSTANCE.onFocus$foundation_release(textInputService, textFieldValue, textFieldState.getProcessor(), imeOptions, textFieldState.getOnValueChange(), textFieldState.getOnImeActionPerformed()));
        notifyFocusedRect(textFieldState, textFieldValue, offsetMapping);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tapToFocus(TextFieldState textFieldState, FocusRequester focusRequester, boolean z) {
        SoftwareKeyboardController keyboardController;
        if (!textFieldState.getHasFocus()) {
            focusRequester.requestFocus();
        } else {
            if (!z || (keyboardController = textFieldState.getKeyboardController()) == null) {
                return;
            }
            keyboardController.show();
        }
    }
}
