.class public Lorg/drinkless/tdlib/TdApi$ChatPhotoSticker;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatPhotoSticker"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x56fc7c5d


# instance fields
.field public backgroundFill:Lorg/drinkless/tdlib/TdApi$BackgroundFill;

.field public type:Lorg/drinkless/tdlib/TdApi$ChatPhotoStickerType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24324
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24325
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatPhotoStickerType;Lorg/drinkless/tdlib/TdApi$BackgroundFill;)V
    .locals 0
    .param p1, "chatPhotoStickerType"    # Lorg/drinkless/tdlib/TdApi$ChatPhotoStickerType;
    .param p2, "backgroundFill"    # Lorg/drinkless/tdlib/TdApi$BackgroundFill;

    .line 24314
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24315
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatPhotoSticker;->type:Lorg/drinkless/tdlib/TdApi$ChatPhotoStickerType;

    .line 24316
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatPhotoSticker;->backgroundFill:Lorg/drinkless/tdlib/TdApi$BackgroundFill;

    .line 24317
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24321
    const v0, -0x56fc7c5d

    return v0
.end method
