.class public Lorg/drinkless/tdlib/TdApi$DeleteChatReplyMarkup;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteChatReplyMarkup"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5ff9b5b


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25044
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25045
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 25034
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25035
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteChatReplyMarkup;->chatId:J

    .line 25036
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$DeleteChatReplyMarkup;->messageId:J

    .line 25037
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25041
    const v0, 0x5ff9b5b

    return v0
.end method
