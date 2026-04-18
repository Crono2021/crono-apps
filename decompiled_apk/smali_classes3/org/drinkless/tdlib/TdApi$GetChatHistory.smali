.class public Lorg/drinkless/tdlib/TdApi$GetChatHistory;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatHistory"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Messages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2fae6d83


# instance fields
.field public chatId:J

.field public fromMessageId:J

.field public limit:I

.field public offset:I

.field public onlyLocal:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47306
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47307
    return-void
.end method

.method public constructor <init>(JJIIZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I
    .param p6, "i10"    # I
    .param p7, "z8"    # Z

    .line 47293
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47294
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatHistory;->chatId:J

    .line 47295
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetChatHistory;->fromMessageId:J

    .line 47296
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$GetChatHistory;->offset:I

    .line 47297
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$GetChatHistory;->limit:I

    .line 47298
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$GetChatHistory;->onlyLocal:Z

    .line 47299
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47303
    const v0, -0x2fae6d83

    return v0
.end method
