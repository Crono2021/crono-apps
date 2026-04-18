.class public Lorg/drinkless/tdlib/TdApi$CallStateDiscarded;
.super Lorg/drinkless/tdlib/TdApi$CallState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallStateDiscarded"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x531b7c45


# instance fields
.field public needDebugInformation:Z

.field public needLog:Z

.field public needRating:Z

.field public reason:Lorg/drinkless/tdlib/TdApi$CallDiscardReason;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42654
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallState;-><init>()V

    .line 42655
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$CallDiscardReason;ZZZ)V
    .locals 0
    .param p1, "callDiscardReason"    # Lorg/drinkless/tdlib/TdApi$CallDiscardReason;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z
    .param p4, "z10"    # Z

    .line 42642
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallState;-><init>()V

    .line 42643
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CallStateDiscarded;->reason:Lorg/drinkless/tdlib/TdApi$CallDiscardReason;

    .line 42644
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$CallStateDiscarded;->needRating:Z

    .line 42645
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$CallStateDiscarded;->needDebugInformation:Z

    .line 42646
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$CallStateDiscarded;->needLog:Z

    .line 42647
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42651
    const v0, 0x531b7c45

    return v0
.end method
