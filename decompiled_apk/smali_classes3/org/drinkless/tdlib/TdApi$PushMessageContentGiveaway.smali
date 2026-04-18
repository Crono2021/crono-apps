.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentGiveaway;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentGiveaway"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x29c18072


# instance fields
.field public isPinned:Z

.field public prize:Lorg/drinkless/tdlib/TdApi$GiveawayPrize;

.field public winnerCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39250
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 39251
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$GiveawayPrize;Z)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "giveawayPrize"    # Lorg/drinkless/tdlib/TdApi$GiveawayPrize;
    .param p3, "z8"    # Z

    .line 39239
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 39240
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentGiveaway;->winnerCount:I

    .line 39241
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentGiveaway;->prize:Lorg/drinkless/tdlib/TdApi$GiveawayPrize;

    .line 39242
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentGiveaway;->isPinned:Z

    .line 39243
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39247
    const v0, -0x29c18072

    return v0
.end method
