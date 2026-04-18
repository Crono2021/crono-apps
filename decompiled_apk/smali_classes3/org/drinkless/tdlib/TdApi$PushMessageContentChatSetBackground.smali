.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentChatSetBackground;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentChatSetBackground"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x58d4a91d


# instance fields
.field public isSame:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18042
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18043
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 18033
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18034
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentChatSetBackground;->isSame:Z

    .line 18035
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18039
    const v0, -0x58d4a91d

    return v0
.end method
