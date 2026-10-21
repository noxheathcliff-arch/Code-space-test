package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BeyondBoundsLayout.kt */
@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aA\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006¢\u0006\u0002\b\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"searchBeyondBounds", "T", "Landroidx/compose/ui/focus/FocusTargetNode;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BeyondBoundsLayoutKt {
    /* renamed from: searchBeyondBounds--OM-vw8, reason: not valid java name */
    public static final <T> T m3109searchBeyondBoundsOMvw8(FocusTargetNode focusTargetNode, int i, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> function1) {
        Modifier.Node node;
        BeyondBoundsLayout beyondBoundsLayoutParent;
        int m4709getBeforehoxUOeE;
        NodeChain nodes;
        FocusTargetNode focusTargetNode2 = focusTargetNode;
        int m4934constructorimpl = NodeKind.m4934constructorimpl(1024);
        if (!focusTargetNode2.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent = focusTargetNode2.getNode().getParent();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
        loop0: while (true) {
            if (requireLayoutNode == null) {
                node = null;
                break;
            }
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m4934constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & m4934constructorimpl) != 0) {
                        node = parent;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if (((node.getKindSet() & m4934constructorimpl) != 0) && (node instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & m4934constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        FocusTargetNode focusTargetNode3 = (FocusTargetNode) node;
        if ((focusTargetNode3 != null && Intrinsics.areEqual(focusTargetNode3.getBeyondBoundsLayoutParent(), focusTargetNode.getBeyondBoundsLayoutParent())) || (beyondBoundsLayoutParent = focusTargetNode.getBeyondBoundsLayoutParent()) == null) {
            return null;
        }
        if (FocusDirection.m3113equalsimpl0(i, FocusDirection.INSTANCE.m3126getUpdhqQ8s())) {
            m4709getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m4707getAbovehoxUOeE();
        } else if (FocusDirection.m3113equalsimpl0(i, FocusDirection.INSTANCE.m3119getDowndhqQ8s())) {
            m4709getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m4710getBelowhoxUOeE();
        } else if (FocusDirection.m3113equalsimpl0(i, FocusDirection.INSTANCE.m3122getLeftdhqQ8s())) {
            m4709getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m4711getLefthoxUOeE();
        } else if (FocusDirection.m3113equalsimpl0(i, FocusDirection.INSTANCE.m3125getRightdhqQ8s())) {
            m4709getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m4712getRighthoxUOeE();
        } else if (FocusDirection.m3113equalsimpl0(i, FocusDirection.INSTANCE.m3123getNextdhqQ8s())) {
            m4709getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m4708getAfterhoxUOeE();
        } else {
            if (!FocusDirection.m3113equalsimpl0(i, FocusDirection.INSTANCE.m3124getPreviousdhqQ8s())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
            }
            m4709getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m4709getBeforehoxUOeE();
        }
        return (T) beyondBoundsLayoutParent.mo729layouto7g1Pn8(m4709getBeforehoxUOeE, function1);
    }
}
