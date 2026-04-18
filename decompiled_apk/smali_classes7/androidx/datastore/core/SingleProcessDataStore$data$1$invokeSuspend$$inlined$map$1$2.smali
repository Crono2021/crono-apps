.class public final Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2;
.super Ljava/lang/Object;
.source "Collect.kt"

# interfaces
.implements Lkotlinx/coroutines/flow/FlowCollector;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1;->collect(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lkotlinx/coroutines/flow/FlowCollector<",
        "Landroidx/datastore/core/State<",
        "TT;>;>;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 SingleProcessDataStore.kt\nandroidx/datastore/core/SingleProcessDataStore$data$1\n*L\n1#1,134:1\n53#2:135\n48#3:136\n131#4,6:137\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0005*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\u0008\u0019\u00a8\u0006\u0006\u00b8\u0006\u0008"
    }
    d2 = {
        "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3",
        "Lkotlinx/coroutines/flow/FlowCollector;",
        "emit",
        "",
        "value",
        "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;",
        "kotlinx-coroutines-core",
        "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1",
        "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"
    }
    k = 0x1
    mv = {
        0x1,
        0x5,
        0x1
    }
    xi = 0x30
.end annotation


# instance fields
.field final synthetic $this_unsafeFlow$inlined:Lkotlinx/coroutines/flow/FlowCollector;


# direct methods
.method public constructor <init>(Lkotlinx/coroutines/flow/FlowCollector;)V
    .locals 0

    iput-object p1, p0, Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2;->$this_unsafeFlow$inlined:Lkotlinx/coroutines/flow/FlowCollector;

    .line 72
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 16

    move-object/from16 v0, p2

    instance-of v1, v0, Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1;

    if-eqz v1, :cond_0

    move-object v1, v0

    check-cast v1, Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1;

    iget v2, v1, Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1;->label:I

    const/high16 v3, -0x80000000

    and-int/2addr v2, v3

    if-eqz v2, :cond_0

    iget v0, v1, Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1;->label:I

    sub-int/2addr v0, v3

    iput v0, v1, Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1;->label:I

    move-object v0, v1

    move-object/from16 v2, p0

    goto :goto_0

    :cond_0
    new-instance v1, Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1;

    move-object/from16 v2, p0

    invoke-direct {v1, v2, v0}, Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1;-><init>(Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2;Lkotlin/coroutines/Continuation;)V

    move-object v0, v1

    .local v0, "$continuation":Lkotlin/coroutines/Continuation;
    :goto_0
    iget-object v1, v0, Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1;->result:Ljava/lang/Object;

    .local v1, "$result":Ljava/lang/Object;
    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v3

    .line 0
    iget v4, v0, Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1;->label:I

    packed-switch v4, :pswitch_data_0

    move-object/from16 p2, v1

    .line 137
    .end local v0    # "$continuation":Lkotlin/coroutines/Continuation;
    .end local v1    # "$result":Ljava/lang/Object;
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 0
    .restart local v0    # "$continuation":Lkotlin/coroutines/Continuation;
    .restart local v1    # "$result":Ljava/lang/Object;
    :pswitch_0
    const/4 v3, 0x0

    move v4, v3

    .local v3, "$i$a$-collect-FlowKt__EmittersKt$unsafeTransform$1$1":I
    .local v4, "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1":I
    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static {v1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object/from16 p2, v1

    goto :goto_1

    .end local v3    # "$i$a$-collect-FlowKt__EmittersKt$unsafeTransform$1$1":I
    .end local v4    # "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1":I
    :pswitch_1
    invoke-static {v1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object/from16 v4, p0

    .local v4, "this":Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2;
    move-object/from16 v5, p1

    .line 73
    .local v5, "value":Ljava/lang/Object;
    move-object v6, v0

    .local v6, "$completion":Lkotlin/coroutines/Continuation;
    move-object v7, v5

    .local v7, "value":Ljava/lang/Object;
    const/4 v8, 0x0

    .line 135
    .local v8, "$i$a$-collect-FlowKt__EmittersKt$unsafeTransform$1$1":I
    iget-object v9, v4, Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2;->$this_unsafeFlow$inlined:Lkotlinx/coroutines/flow/FlowCollector;

    .local v9, "$this$map_u24lambda_u2d4":Lkotlinx/coroutines/flow/FlowCollector;
    move-object v10, v0

    .local v10, "$completion":Lkotlin/coroutines/Continuation;
    move-object v11, v7

    .local v11, "value":Ljava/lang/Object;
    const/4 v12, 0x0

    .line 136
    .local v12, "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1":I
    move-object v13, v0

    check-cast v13, Lkotlin/coroutines/Continuation;

    .local v13, "$completion":Lkotlin/coroutines/Continuation;
    move-object v14, v11

    check-cast v14, Landroidx/datastore/core/State;

    .local v14, "it":Landroidx/datastore/core/State;
    const/4 v15, 0x0

    .line 137
    .local v15, "$i$a$-map-SingleProcessDataStore$data$1$2":I
    nop

    .line 138
    move-object/from16 p2, v1

    .end local v1    # "$result":Ljava/lang/Object;
    .local p2, "$result":Ljava/lang/Object;
    instance-of v1, v14, Landroidx/datastore/core/ReadException;

    if-nez v1, :cond_5

    .line 139
    instance-of v1, v14, Landroidx/datastore/core/Final;

    if-nez v1, :cond_4

    .line 140
    instance-of v1, v14, Landroidx/datastore/core/Data;

    if-eqz v1, :cond_2

    move-object v1, v14

    check-cast v1, Landroidx/datastore/core/Data;

    invoke-virtual {v1}, Landroidx/datastore/core/Data;->getValue()Ljava/lang/Object;

    move-result-object v1

    .line 137
    nop

    .end local v6    # "$completion":Lkotlin/coroutines/Continuation;
    .end local v10    # "$completion":Lkotlin/coroutines/Continuation;
    .end local v13    # "$completion":Lkotlin/coroutines/Continuation;
    .end local v14    # "it":Landroidx/datastore/core/State;
    .end local v15    # "$i$a$-map-SingleProcessDataStore$data$1$2":I
    const/4 v6, 0x1

    iput v6, v0, Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1;->label:I

    invoke-interface {v9, v1, v0}, Lkotlinx/coroutines/flow/FlowCollector;->emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v1

    .end local v4    # "this":Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2;
    .end local v5    # "value":Ljava/lang/Object;
    .end local v7    # "value":Ljava/lang/Object;
    .end local v9    # "$this$map_u24lambda_u2d4":Lkotlinx/coroutines/flow/FlowCollector;
    .end local v11    # "value":Ljava/lang/Object;
    if-ne v1, v3, :cond_1

    .line 0
    return-object v3

    .line 137
    :cond_1
    move v3, v8

    move v4, v12

    .end local v8    # "$i$a$-collect-FlowKt__EmittersKt$unsafeTransform$1$1":I
    .end local v12    # "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1":I
    .restart local v3    # "$i$a$-collect-FlowKt__EmittersKt$unsafeTransform$1$1":I
    .local v4, "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1":I
    :goto_1
    sget-object v1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    .end local v3    # "$i$a$-collect-FlowKt__EmittersKt$unsafeTransform$1$1":I
    .end local v4    # "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1":I
    return-object v1

    .line 141
    .local v4, "this":Landroidx/datastore/core/SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2;
    .restart local v5    # "value":Ljava/lang/Object;
    .restart local v6    # "$completion":Lkotlin/coroutines/Continuation;
    .restart local v7    # "value":Ljava/lang/Object;
    .restart local v8    # "$i$a$-collect-FlowKt__EmittersKt$unsafeTransform$1$1":I
    .restart local v9    # "$this$map_u24lambda_u2d4":Lkotlinx/coroutines/flow/FlowCollector;
    .restart local v10    # "$completion":Lkotlin/coroutines/Continuation;
    .restart local v11    # "value":Ljava/lang/Object;
    .restart local v12    # "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1":I
    .restart local v13    # "$completion":Lkotlin/coroutines/Continuation;
    .restart local v14    # "it":Landroidx/datastore/core/State;
    .restart local v15    # "$i$a$-map-SingleProcessDataStore$data$1$2":I
    :cond_2
    instance-of v1, v14, Landroidx/datastore/core/UnInitialized;

    if-eqz v1, :cond_3

    .line 142
    nop

    .line 141
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v3, "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    check-cast v1, Ljava/lang/Throwable;

    throw v1

    :cond_3
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;

    invoke-direct {v1}, Lkotlin/NoWhenBranchMatchedException;-><init>()V

    throw v1

    .line 139
    :cond_4
    move-object v1, v14

    check-cast v1, Landroidx/datastore/core/Final;

    invoke-virtual {v1}, Landroidx/datastore/core/Final;->getFinalException()Ljava/lang/Throwable;

    move-result-object v1

    throw v1

    .line 138
    :cond_5
    move-object v1, v14

    check-cast v1, Landroidx/datastore/core/ReadException;

    invoke-virtual {v1}, Landroidx/datastore/core/ReadException;->getReadException()Ljava/lang/Throwable;

    move-result-object v1

    throw v1

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
