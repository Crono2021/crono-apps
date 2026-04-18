.class public Lorg/drinkless/tdlib/TdApi$ClickChatSponsoredMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ClickChatSponsoredMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x39ef7a17


# instance fields
.field public chatId:J

.field public fromFullscreen:Z

.field public isMediaClick:Z

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42918
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42919
    return-void
.end method

.method public constructor <init>(JJZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "z8"    # Z
    .param p6, "z9"    # Z

    .line 42906
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42907
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ClickChatSponsoredMessage;->chatId:J

    .line 42908
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ClickChatSponsoredMessage;->messageId:J

    .line 42909
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$ClickChatSponsoredMessage;->isMediaClick:Z

    .line 42910
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$ClickChatSponsoredMessage;->fromFullscreen:Z

    .line 42911
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42915
    const v0, 0x39ef7a17

    return v0
.end method
