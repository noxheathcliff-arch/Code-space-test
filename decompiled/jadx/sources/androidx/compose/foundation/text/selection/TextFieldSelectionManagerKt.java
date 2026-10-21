package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: TextFieldSelectionManager.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\"\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"TextFieldSelectionHandle", "", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "(ZLandroidx/compose/ui/text/style/ResolvedTextDirection;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;J)J", "isSelectionHandleInVisibleBound", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldSelectionManagerKt {

    /* compiled from: TextFieldSelectionManager.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.Cursor.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Handle.SelectionStart.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Handle.SelectionEnd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void TextFieldSelectionHandle(final boolean z, final ResolvedTextDirection resolvedTextDirection, final TextFieldSelectionManager textFieldSelectionManager, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1344558920);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldSelectionHandle)P(1)958@37140L90,962@37236L346:TextFieldSelectionManager.kt#eksfi3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1344558920, i, -1, "androidx.compose.foundation.text.selection.TextFieldSelectionHandle (TextFieldSelectionManager.kt:957)");
        }
        Boolean valueOf = Boolean.valueOf(z);
        startRestartGroup.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean changed = startRestartGroup.changed(valueOf) | startRestartGroup.changed(textFieldSelectionManager);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = textFieldSelectionManager.handleDragObserver$foundation_release(z);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
        OffsetProvider offsetProvider = new OffsetProvider() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$1
            @Override // androidx.compose.foundation.text.selection.OffsetProvider
            /* renamed from: provide-F1C5BW0 */
            public final long mo851provideF1C5BW0() {
                return TextFieldSelectionManager.this.m1079getHandlePositiontuRUvjQ$foundation_release(z);
            }
        };
        boolean m5279getReversedimpl = TextRange.m5279getReversedimpl(textFieldSelectionManager.getValue$foundation_release().getSelection());
        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, textDragObserver, new TextFieldSelectionManagerKt$TextFieldSelectionHandle$2(textDragObserver, null));
        int i2 = i << 3;
        AndroidSelectionHandles_androidKt.SelectionHandle(offsetProvider, z, resolvedTextDirection, m5279getReversedimpl, pointerInput, startRestartGroup, (i2 & 112) | (i2 & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    TextFieldSelectionManagerKt.TextFieldSelectionHandle(z, resolvedTextDirection, textFieldSelectionManager, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
    /* renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long m1080calculateSelectionMagnifierCenterAndroidO0kMr_c(androidx.compose.foundation.text.selection.TextFieldSelectionManager r7, long r8) {
        /*
            androidx.compose.ui.geometry.Offset r0 = r7.m1077getCurrentDragPosition_m7T9E()
            if (r0 == 0) goto Lf5
            long r0 = r0.getPackedValue()
            androidx.compose.ui.text.AnnotatedString r2 = r7.getTransformedText$foundation_release()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L21
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L1c
            r2 = 1
            goto L1d
        L1c:
            r2 = 0
        L1d:
            if (r2 != 0) goto L21
            r2 = 1
            goto L22
        L21:
            r2 = 0
        L22:
            if (r2 != 0) goto L2b
            androidx.compose.ui.geometry.Offset$Companion r7 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r7 = r7.m3208getUnspecifiedF1C5BW0()
            return r7
        L2b:
            androidx.compose.foundation.text.Handle r2 = r7.getDraggingHandle()
            r5 = -1
            if (r2 != 0) goto L34
            r2 = -1
            goto L3c
        L34:
            int[] r6 = androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r6[r2]
        L3c:
            if (r2 == r5) goto Lee
            r5 = 2
            if (r2 == r3) goto L59
            if (r2 == r5) goto L59
            r3 = 3
            if (r2 != r3) goto L53
            androidx.compose.ui.text.input.TextFieldValue r2 = r7.getValue$foundation_release()
            long r2 = r2.getSelection()
            int r2 = androidx.compose.ui.text.TextRange.m5275getEndimpl(r2)
            goto L65
        L53:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L59:
            androidx.compose.ui.text.input.TextFieldValue r2 = r7.getValue$foundation_release()
            long r2 = r2.getSelection()
            int r2 = androidx.compose.ui.text.TextRange.m5280getStartimpl(r2)
        L65:
            androidx.compose.foundation.text.TextFieldState r3 = r7.getState()
            if (r3 == 0) goto Le7
            androidx.compose.foundation.text.TextLayoutResultProxy r3 = r3.getLayoutResult()
            if (r3 != 0) goto L72
            goto Le7
        L72:
            androidx.compose.foundation.text.TextFieldState r6 = r7.getState()
            if (r6 == 0) goto Le0
            androidx.compose.foundation.text.TextDelegate r6 = r6.getTextDelegate()
            if (r6 == 0) goto Le0
            androidx.compose.ui.text.AnnotatedString r6 = r6.getText()
            if (r6 != 0) goto L85
            goto Le0
        L85:
            androidx.compose.ui.text.input.OffsetMapping r7 = r7.getOffsetMapping()
            int r7 = r7.originalToTransformed(r2)
            int r2 = r6.length()
            int r7 = kotlin.ranges.RangesKt.coerceIn(r7, r4, r2)
            long r0 = r3.m955translateDecorationToInnerCoordinatesMKHz9U$foundation_release(r0)
            float r0 = androidx.compose.ui.geometry.Offset.m3193getXimpl(r0)
            androidx.compose.ui.text.TextLayoutResult r1 = r3.getValue()
            int r7 = r1.getLineForOffset(r7)
            float r2 = r1.getLineLeft(r7)
            float r3 = r1.getLineRight(r7)
            float r4 = java.lang.Math.min(r2, r3)
            float r2 = java.lang.Math.max(r2, r3)
            float r2 = kotlin.ranges.RangesKt.coerceIn(r0, r4, r2)
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            int r8 = androidx.compose.ui.unit.IntSize.m5967getWidthimpl(r8)
            int r8 = r8 / r5
            float r8 = (float) r8
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r8 <= 0) goto Lcf
            androidx.compose.ui.geometry.Offset$Companion r7 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r7 = r7.m3208getUnspecifiedF1C5BW0()
            return r7
        Lcf:
            float r8 = r1.getLineTop(r7)
            float r7 = r1.getLineBottom(r7)
            float r7 = r7 - r8
            float r9 = (float) r5
            float r7 = r7 / r9
            float r7 = r7 + r8
            long r7 = androidx.compose.ui.geometry.OffsetKt.Offset(r2, r7)
            return r7
        Le0:
            androidx.compose.ui.geometry.Offset$Companion r7 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r7 = r7.m3208getUnspecifiedF1C5BW0()
            return r7
        Le7:
            androidx.compose.ui.geometry.Offset$Companion r7 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r7 = r7.m3208getUnspecifiedF1C5BW0()
            return r7
        Lee:
            androidx.compose.ui.geometry.Offset$Companion r7 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r7 = r7.m3208getUnspecifiedF1C5BW0()
            return r7
        Lf5:
            androidx.compose.ui.geometry.Offset$Companion r7 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r7 = r7.m3208getUnspecifiedF1C5BW0()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt.m1080calculateSelectionMagnifierCenterAndroidO0kMr_c(androidx.compose.foundation.text.selection.TextFieldSelectionManager, long):long");
    }

    public static final boolean isSelectionHandleInVisibleBound(TextFieldSelectionManager textFieldSelectionManager, boolean z) {
        LayoutCoordinates layoutCoordinates;
        Rect visibleBounds;
        TextFieldState state = textFieldSelectionManager.getState();
        if (state == null || (layoutCoordinates = state.getLayoutCoordinates()) == null || (visibleBounds = SelectionManagerKt.visibleBounds(layoutCoordinates)) == null) {
            return false;
        }
        return SelectionManagerKt.m1056containsInclusiveUv8p0NA(visibleBounds, textFieldSelectionManager.m1079getHandlePositiontuRUvjQ$foundation_release(z));
    }
}
