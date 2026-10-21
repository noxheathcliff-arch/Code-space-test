package androidx.compose.ui.draganddrop;

import androidx.autofill.HintConstants;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: DragAndDropNode.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 (2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001(B*\u0012#\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J;\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00160\u0005¢\u0006\u0002\b\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "onDragAndDropStart", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "(Lkotlin/jvm/functions/Function1;)V", "lastChildDragAndDropModifierNode", "thisDragAndDropTarget", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "acceptDragAndDropTransfer", "", "startEvent", "drag", "", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "drag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)V", "onChanged", "onDetach", "onDrop", "onEnded", "onEntered", "onExited", "onMoved", "onStarted", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DragAndDropNode extends Modifier.Node implements TraversableNode, DragAndDropModifierNode {
    private DragAndDropModifierNode lastChildDragAndDropModifierNode;
    private final Function1<DragAndDropEvent, DragAndDropTarget> onDragAndDropStart;
    private DragAndDropTarget thisDragAndDropTarget;
    private final Object traverseKey = Companion.DragAndDropTraversableKey.INSTANCE;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DragAndDropNode.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u00042\u0014\b\u0004\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0082\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropNode$Companion;", "", "()V", "firstChildOrNull", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "predicate", "Lkotlin/Function1;", "", "DragAndDropTraversableKey", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        /* compiled from: DragAndDropNode.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropNode$Companion$DragAndDropTraversableKey;", "", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        private static final class DragAndDropTraversableKey {
            public static final DragAndDropTraversableKey INSTANCE = new DragAndDropTraversableKey();

            private DragAndDropTraversableKey() {
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final DragAndDropModifierNode firstChildOrNull(DragAndDropModifierNode dragAndDropModifierNode, final Function1<? super DragAndDropModifierNode, Boolean> function1) {
            if (!dragAndDropModifierNode.getNode().getIsAttached()) {
                return null;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            TraversableNodeKt.traverseDescendants(dragAndDropModifierNode, DragAndDropTraversableKey.INSTANCE, new Function1<TraversableNode, TraversableNode.Companion.TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$Companion$firstChildOrNull$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final TraversableNode.Companion.TraverseDescendantsAction invoke(TraversableNode traversableNode) {
                    if (!(traversableNode instanceof DragAndDropModifierNode) || !function1.invoke(traversableNode).booleanValue()) {
                        return TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                    }
                    objectRef.element = traversableNode;
                    return TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal;
                }
            });
            return (DragAndDropModifierNode) objectRef.element;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DragAndDropNode(Function1<? super DragAndDropEvent, ? extends DragAndDropTarget> function1) {
        this.onDragAndDropStart = function1;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropModifierNode
    public boolean acceptDragAndDropTransfer(final DragAndDropEvent startEvent) {
        if (!getIsAttached()) {
            return false;
        }
        if (!(this.thisDragAndDropTarget == null)) {
            throw new IllegalStateException("DragAndDropTarget self reference must be null at the start of a drag and drop session".toString());
        }
        this.thisDragAndDropTarget = this.onDragAndDropStart.invoke(startEvent);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        TraversableNodeKt.traverseChildren(this, new Function1<DragAndDropNode, Boolean>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$acceptDragAndDropTransfer$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(DragAndDropNode dragAndDropNode) {
                Ref.BooleanRef booleanRef2 = Ref.BooleanRef.this;
                boolean z = booleanRef2.element;
                boolean acceptDragAndDropTransfer = dragAndDropNode.acceptDragAndDropTransfer(startEvent);
                DragAndDropNode dragAndDropNode2 = this;
                if (acceptDragAndDropTransfer) {
                    DelegatableNodeKt.requireOwner(dragAndDropNode2).getDragAndDropManager().registerNodeInterest(dragAndDropNode);
                }
                Unit unit = Unit.INSTANCE;
                booleanRef2.element = z | acceptDragAndDropTransfer;
                return true;
            }
        });
        return booleanRef.element || this.thisDragAndDropTarget != null;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropModifierNode
    /* renamed from: drag-12SF9DM */
    public void mo3083drag12SF9DM(DragAndDropTransferData transferData, long decorationSize, Function1<? super DrawScope, Unit> drawDragDecoration) {
        DelegatableNodeKt.requireOwner(this).getDragAndDropManager().mo3082drag12SF9DM(transferData, decorationSize, drawDragDecoration);
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onChanged(DragAndDropEvent event) {
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget != null) {
            dragAndDropTarget.onChanged(event);
            return;
        }
        DragAndDropModifierNode dragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
        if (dragAndDropModifierNode != null) {
            dragAndDropModifierNode.onChanged(event);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.thisDragAndDropTarget = null;
        this.lastChildDragAndDropModifierNode = null;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public boolean onDrop(DragAndDropEvent event) {
        DragAndDropModifierNode dragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
        if (dragAndDropModifierNode != null) {
            return dragAndDropModifierNode.onDrop(event);
        }
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget != null) {
            return dragAndDropTarget.onDrop(event);
        }
        return false;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onEnded(final DragAndDropEvent event) {
        if (getNode().getIsAttached()) {
            TraversableNodeKt.traverseChildren(this, new Function1<DragAndDropNode, Boolean>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$onEnded$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(DragAndDropNode dragAndDropNode) {
                    dragAndDropNode.onEnded(DragAndDropEvent.this);
                    return true;
                }
            });
            DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
            if (dragAndDropTarget != null) {
                dragAndDropTarget.onEnded(event);
            }
            this.thisDragAndDropTarget = null;
            this.lastChildDragAndDropModifierNode = null;
        }
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onEntered(DragAndDropEvent event) {
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget != null) {
            dragAndDropTarget.onEntered(event);
            return;
        }
        DragAndDropModifierNode dragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
        if (dragAndDropModifierNode != null) {
            dragAndDropModifierNode.onEntered(event);
        }
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onExited(DragAndDropEvent event) {
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget != null) {
            dragAndDropTarget.onExited(event);
        }
        DragAndDropModifierNode dragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
        if (dragAndDropModifierNode != null) {
            dragAndDropModifierNode.onExited(event);
        }
        this.lastChildDragAndDropModifierNode = null;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onMoved(final DragAndDropEvent event) {
        DragAndDropModifierNode dragAndDropModifierNode;
        boolean m3085containsUv8p0NA;
        DragAndDropModifierNode dragAndDropModifierNode2 = this.lastChildDragAndDropModifierNode;
        boolean z = false;
        if (dragAndDropModifierNode2 != null) {
            m3085containsUv8p0NA = DragAndDropNodeKt.m3085containsUv8p0NA(dragAndDropModifierNode2, DragAndDrop_androidKt.getPositionInRoot(event));
            if (m3085containsUv8p0NA) {
                z = true;
            }
        }
        if (z) {
            dragAndDropModifierNode = dragAndDropModifierNode2;
        } else {
            DragAndDropNode dragAndDropNode = this;
            if (dragAndDropNode.getNode().getIsAttached()) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                TraversableNodeKt.traverseDescendants(dragAndDropNode, Companion.DragAndDropTraversableKey.INSTANCE, new Function1<TraversableNode, TraversableNode.Companion.TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$onMoved$$inlined$firstChildOrNull$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final androidx.compose.ui.node.TraversableNode.Companion.TraverseDescendantsAction invoke(androidx.compose.ui.node.TraversableNode r4) {
                        /*
                            r3 = this;
                            boolean r0 = r4 instanceof androidx.compose.ui.draganddrop.DragAndDropModifierNode
                            if (r0 == 0) goto L31
                            r0 = r4
                            androidx.compose.ui.draganddrop.DragAndDropModifierNode r0 = (androidx.compose.ui.draganddrop.DragAndDropModifierNode) r0
                            androidx.compose.ui.draganddrop.DragAndDropNode r1 = r2
                            androidx.compose.ui.node.DelegatableNode r1 = (androidx.compose.ui.node.DelegatableNode) r1
                            androidx.compose.ui.node.Owner r1 = androidx.compose.ui.node.DelegatableNodeKt.requireOwner(r1)
                            androidx.compose.ui.draganddrop.DragAndDropManager r1 = r1.getDragAndDropManager()
                            boolean r1 = r1.isInterestedNode(r0)
                            if (r1 == 0) goto L27
                            androidx.compose.ui.draganddrop.DragAndDropEvent r1 = r3
                            long r1 = androidx.compose.ui.draganddrop.DragAndDrop_androidKt.getPositionInRoot(r1)
                            boolean r0 = androidx.compose.ui.draganddrop.DragAndDropNodeKt.m3084access$containsUv8p0NA(r0, r1)
                            if (r0 == 0) goto L27
                            r0 = 1
                            goto L28
                        L27:
                            r0 = 0
                        L28:
                            if (r0 == 0) goto L31
                            kotlin.jvm.internal.Ref$ObjectRef r0 = kotlin.jvm.internal.Ref.ObjectRef.this
                            r0.element = r4
                            androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction r4 = androidx.compose.ui.node.TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal
                            return r4
                        L31:
                            androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction r4 = androidx.compose.ui.node.TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.draganddrop.DragAndDropNode$onMoved$$inlined$firstChildOrNull$1.invoke(androidx.compose.ui.node.TraversableNode):androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction");
                    }
                });
                dragAndDropModifierNode = (DragAndDropModifierNode) objectRef.element;
            } else {
                dragAndDropModifierNode = null;
            }
        }
        if (dragAndDropModifierNode != null && dragAndDropModifierNode2 == null) {
            DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
            if (dragAndDropTarget != null) {
                dragAndDropTarget.onExited(event);
            }
            DragAndDropNodeKt.dispatchEntered(dragAndDropModifierNode, event);
        } else if (dragAndDropModifierNode == null && dragAndDropModifierNode2 != null) {
            dragAndDropModifierNode2.onExited(event);
            DragAndDropTarget dragAndDropTarget2 = this.thisDragAndDropTarget;
            if (dragAndDropTarget2 != null) {
                DragAndDropNodeKt.dispatchEntered(dragAndDropTarget2, event);
            }
        } else if (!Intrinsics.areEqual(dragAndDropModifierNode, dragAndDropModifierNode2)) {
            if (dragAndDropModifierNode2 != null) {
                dragAndDropModifierNode2.onExited(event);
            }
            if (dragAndDropModifierNode != null) {
                DragAndDropNodeKt.dispatchEntered(dragAndDropModifierNode, event);
            }
        } else if (dragAndDropModifierNode != null) {
            dragAndDropModifierNode.onMoved(event);
        } else {
            DragAndDropTarget dragAndDropTarget3 = this.thisDragAndDropTarget;
            if (dragAndDropTarget3 != null) {
                dragAndDropTarget3.onMoved(event);
            }
        }
        this.lastChildDragAndDropModifierNode = dragAndDropModifierNode;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onStarted(DragAndDropEvent event) {
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget != null) {
            dragAndDropTarget.onStarted(event);
            return;
        }
        DragAndDropModifierNode dragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
        if (dragAndDropModifierNode != null) {
            dragAndDropModifierNode.onStarted(event);
        }
    }
}
