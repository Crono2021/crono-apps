.class public Lorg/drinkless/tdlib/TdApi$MessageSchedulingStateSendAtDate;
.super Lorg/drinkless/tdlib/TdApi$MessageSchedulingState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageSchedulingStateSendAtDate"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x588c0019


# instance fields
.field public sendDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16674
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageSchedulingState;-><init>()V

    .line 16675
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 16665
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageSchedulingState;-><init>()V

    .line 16666
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessageSchedulingStateSendAtDate;->sendDate:I

    .line 16667
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16671
    const v0, -0x588c0019

    return v0
.end method
