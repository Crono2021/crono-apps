.class public Lorg/drinkless/tdlib/TdApi$ReportChatSponsoredMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReportChatSponsoredMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ReportSponsoredResult;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3a6961b4


# instance fields
.field public chatId:J

.field public messageId:J

.field public optionId:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39602
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39603
    return-void
.end method

.method public constructor <init>(JJ[B)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "bArr"    # [B

    .line 39591
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39592
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ReportChatSponsoredMessage;->chatId:J

    .line 39593
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ReportChatSponsoredMessage;->messageId:J

    .line 39594
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$ReportChatSponsoredMessage;->optionId:[B

    .line 39595
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39599
    const v0, -0x3a6961b4

    return v0
.end method
