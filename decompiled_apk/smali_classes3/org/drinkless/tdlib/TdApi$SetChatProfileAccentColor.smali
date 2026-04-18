.class public Lorg/drinkless/tdlib/TdApi$SetChatProfileAccentColor;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatProfileAccentColor"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4227ae7a


# instance fields
.field public chatId:J

.field public profileAccentColorId:I

.field public profileBackgroundCustomEmojiId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40262
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40263
    return-void
.end method

.method public constructor <init>(JIJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "j9"    # J

    .line 40251
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40252
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatProfileAccentColor;->chatId:J

    .line 40253
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatProfileAccentColor;->profileAccentColorId:I

    .line 40254
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$SetChatProfileAccentColor;->profileBackgroundCustomEmojiId:J

    .line 40255
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40259
    const v0, 0x4227ae7a

    return v0
.end method
