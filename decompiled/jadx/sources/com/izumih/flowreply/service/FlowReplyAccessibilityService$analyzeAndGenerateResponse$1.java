package com.izumih.flowreply.service;

import android.widget.Toast;
import com.izumih.flowreply.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FlowReplyAccessibilityService.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.izumih.flowreply.service.FlowReplyAccessibilityService$analyzeAndGenerateResponse$1", f = "FlowReplyAccessibilityService.kt", i = {}, l = {59, 73, 98, 118, 130, 140}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class FlowReplyAccessibilityService$analyzeAndGenerateResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FlowReplyAccessibilityService this$0;

    /* compiled from: FlowReplyAccessibilityService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.izumih.flowreply.service.FlowReplyAccessibilityService$analyzeAndGenerateResponse$1$1", f = "FlowReplyAccessibilityService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.izumih.flowreply.service.FlowReplyAccessibilityService$analyzeAndGenerateResponse$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FlowReplyAccessibilityService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FlowReplyAccessibilityService flowReplyAccessibilityService, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = flowReplyAccessibilityService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Toast.makeText(this.this$0, "Impossible d'accéder à l'écran actuel", 0).show();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: FlowReplyAccessibilityService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.izumih.flowreply.service.FlowReplyAccessibilityService$analyzeAndGenerateResponse$1$2", f = "FlowReplyAccessibilityService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.izumih.flowreply.service.FlowReplyAccessibilityService$analyzeAndGenerateResponse$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FlowReplyAccessibilityService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(FlowReplyAccessibilityService flowReplyAccessibilityService, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = flowReplyAccessibilityService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FlowReplyAccessibilityService flowReplyAccessibilityService = this.this$0;
            Toast.makeText(flowReplyAccessibilityService, flowReplyAccessibilityService.getString(R.string.toast_no_messages), 0).show();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: FlowReplyAccessibilityService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.izumih.flowreply.service.FlowReplyAccessibilityService$analyzeAndGenerateResponse$1$4", f = "FlowReplyAccessibilityService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.izumih.flowreply.service.FlowReplyAccessibilityService$analyzeAndGenerateResponse$1$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FlowReplyAccessibilityService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(FlowReplyAccessibilityService flowReplyAccessibilityService, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.this$0 = flowReplyAccessibilityService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Toast.makeText(this.this$0, "Aucun prompt activé dans la configuration", 0).show();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: FlowReplyAccessibilityService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.izumih.flowreply.service.FlowReplyAccessibilityService$analyzeAndGenerateResponse$1$5", f = "FlowReplyAccessibilityService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.izumih.flowreply.service.FlowReplyAccessibilityService$analyzeAndGenerateResponse$1$5, reason: invalid class name */
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FlowReplyAccessibilityService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(FlowReplyAccessibilityService flowReplyAccessibilityService, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.this$0 = flowReplyAccessibilityService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass5(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FlowReplyAccessibilityService flowReplyAccessibilityService = this.this$0;
            Toast.makeText(flowReplyAccessibilityService, flowReplyAccessibilityService.getString(R.string.toast_response_generated), 0).show();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: FlowReplyAccessibilityService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.izumih.flowreply.service.FlowReplyAccessibilityService$analyzeAndGenerateResponse$1$6", f = "FlowReplyAccessibilityService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.izumih.flowreply.service.FlowReplyAccessibilityService$analyzeAndGenerateResponse$1$6, reason: invalid class name */
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Exception $e;
        int label;
        final /* synthetic */ FlowReplyAccessibilityService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(FlowReplyAccessibilityService flowReplyAccessibilityService, Exception exc, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.this$0 = flowReplyAccessibilityService;
            this.$e = exc;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass6(this.this$0, this.$e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FlowReplyAccessibilityService flowReplyAccessibilityService = this.this$0;
            String message = this.$e.getMessage();
            if (message == null) {
                message = this.this$0.getString(R.string.toast_error);
                Intrinsics.checkNotNullExpressionValue(message, "getString(...)");
            }
            Toast.makeText(flowReplyAccessibilityService, "Erreur: " + message, 1).show();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowReplyAccessibilityService$analyzeAndGenerateResponse$1(FlowReplyAccessibilityService flowReplyAccessibilityService, Continuation<? super FlowReplyAccessibilityService$analyzeAndGenerateResponse$1> continuation) {
        super(2, continuation);
        this.this$0 = flowReplyAccessibilityService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FlowReplyAccessibilityService$analyzeAndGenerateResponse$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FlowReplyAccessibilityService$analyzeAndGenerateResponse$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0284 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.izumih.flowreply.service.FlowReplyAccessibilityService$analyzeAndGenerateResponse$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
