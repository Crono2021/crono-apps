.class public Lorg/drinkless/tdlib/TdApi$MessageVideoChatStarted;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageVideoChatStarted"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1f114559


# instance fields
.field public groupCallId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16944
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16945
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 16935
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16936
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessageVideoChatStarted;->groupCallId:I

    .line 16937
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16941
    const v0, 0x1f114559

    return v0
.end method
