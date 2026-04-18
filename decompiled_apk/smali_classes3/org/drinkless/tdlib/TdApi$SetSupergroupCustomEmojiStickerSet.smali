.class public Lorg/drinkless/tdlib/TdApi$SetSupergroupCustomEmojiStickerSet;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetSupergroupCustomEmojiStickerSet"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4f3552af


# instance fields
.field public customEmojiStickerSetId:J

.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32028
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32029
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 32018
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32019
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetSupergroupCustomEmojiStickerSet;->supergroupId:J

    .line 32020
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$SetSupergroupCustomEmojiStickerSet;->customEmojiStickerSetId:J

    .line 32021
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32025
    const v0, 0x4f3552af

    return v0
.end method
