.class public Lorg/drinkless/tdlib/TdApi$InputChatPhotoSticker;
.super Lorg/drinkless/tdlib/TdApi$InputChatPhoto;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputChatPhotoSticker"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4e6e735d


# instance fields
.field public sticker:Lorg/drinkless/tdlib/TdApi$ChatPhotoSticker;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14514
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputChatPhoto;-><init>()V

    .line 14515
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatPhotoSticker;)V
    .locals 0
    .param p1, "chatPhotoSticker"    # Lorg/drinkless/tdlib/TdApi$ChatPhotoSticker;

    .line 14505
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputChatPhoto;-><init>()V

    .line 14506
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputChatPhotoSticker;->sticker:Lorg/drinkless/tdlib/TdApi$ChatPhotoSticker;

    .line 14507
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14511
    const v0, 0x4e6e735d    # 1.00013446E9f

    return v0
.end method
