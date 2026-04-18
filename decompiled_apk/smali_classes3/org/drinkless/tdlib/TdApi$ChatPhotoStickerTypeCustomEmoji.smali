.class public Lorg/drinkless/tdlib/TdApi$ChatPhotoStickerTypeCustomEmoji;
.super Lorg/drinkless/tdlib/TdApi$ChatPhotoStickerType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatPhotoStickerTypeCustomEmoji"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xfde452f


# instance fields
.field public customEmojiId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10320
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatPhotoStickerType;-><init>()V

    .line 10321
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 10311
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatPhotoStickerType;-><init>()V

    .line 10312
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatPhotoStickerTypeCustomEmoji;->customEmojiId:J

    .line 10313
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10317
    const v0, -0xfde452f

    return v0
.end method
