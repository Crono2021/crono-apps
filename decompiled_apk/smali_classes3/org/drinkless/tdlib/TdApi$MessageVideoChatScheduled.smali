.class public Lorg/drinkless/tdlib/TdApi$MessageVideoChatScheduled;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageVideoChatScheduled"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6e93e249


# instance fields
.field public groupCallId:I

.field public startDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28744
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28745
    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I

    .line 28734
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28735
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessageVideoChatScheduled;->groupCallId:I

    .line 28736
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$MessageVideoChatScheduled;->startDate:I

    .line 28737
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28741
    const v0, -0x6e93e249

    return v0
.end method
