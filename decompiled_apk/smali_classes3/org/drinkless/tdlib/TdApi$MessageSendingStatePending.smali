.class public Lorg/drinkless/tdlib/TdApi$MessageSendingStatePending;
.super Lorg/drinkless/tdlib/TdApi$MessageSendingState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageSendingStatePending"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xcd49c4c


# instance fields
.field public sendingId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16764
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageSendingState;-><init>()V

    .line 16765
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 16755
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageSendingState;-><init>()V

    .line 16756
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessageSendingStatePending;->sendingId:I

    .line 16757
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16761
    const v0, -0xcd49c4c

    return v0
.end method
