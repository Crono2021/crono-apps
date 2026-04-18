.class public Lorg/drinkless/tdlib/TdApi$GetMessageLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetMessageLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$MessageLink;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3aa91086


# instance fields
.field public chatId:J

.field public forAlbum:Z

.field public inMessageThread:Z

.field public mediaTimestamp:I

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47514
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47515
    return-void
.end method

.method public constructor <init>(JJIZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I
    .param p6, "z8"    # Z
    .param p7, "z9"    # Z

    .line 47501
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47502
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetMessageLink;->chatId:J

    .line 47503
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetMessageLink;->messageId:J

    .line 47504
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$GetMessageLink;->mediaTimestamp:I

    .line 47505
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$GetMessageLink;->forAlbum:Z

    .line 47506
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$GetMessageLink;->inMessageThread:Z

    .line 47507
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47511
    const v0, -0x3aa91086

    return v0
.end method
