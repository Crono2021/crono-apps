.class public Lorg/drinkless/tdlib/TdApi$MessageSchedulingStateSendWhenVideoProcessed;
.super Lorg/drinkless/tdlib/TdApi$MessageSchedulingState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageSchedulingStateSendWhenVideoProcessed"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7d438bee


# instance fields
.field public sendDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16692
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageSchedulingState;-><init>()V

    .line 16693
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 16683
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageSchedulingState;-><init>()V

    .line 16684
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessageSchedulingStateSendWhenVideoProcessed;->sendDate:I

    .line 16685
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16689
    const v0, 0x7d438bee

    return v0
.end method
