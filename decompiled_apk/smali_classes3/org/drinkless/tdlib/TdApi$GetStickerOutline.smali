.class public Lorg/drinkless/tdlib/TdApi$GetStickerOutline;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetStickerOutline"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Outline;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5c6ad25b


# instance fields
.field public forAnimatedEmoji:Z

.field public forClickedAnimatedEmojiMessage:Z

.field public stickerFileId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37512
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37513
    return-void
.end method

.method public constructor <init>(IZZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z

    .line 37501
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37502
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GetStickerOutline;->stickerFileId:I

    .line 37503
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$GetStickerOutline;->forAnimatedEmoji:Z

    .line 37504
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$GetStickerOutline;->forClickedAnimatedEmojiMessage:Z

    .line 37505
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37509
    const v0, -0x5c6ad25b

    return v0
.end method
