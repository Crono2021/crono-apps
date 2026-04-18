.class public Lorg/drinkless/tdlib/TdApi$CreateNewStickerSet;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateNewStickerSet"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StickerSet;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1cac7aff


# instance fields
.field public name:Ljava/lang/String;

.field public needsRepainting:Z

.field public source:Ljava/lang/String;

.field public stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;

.field public stickers:[Lorg/drinkless/tdlib/TdApi$InputSticker;

.field public title:Ljava/lang/String;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51194
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 51195
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$StickerType;Z[Lorg/drinkless/tdlib/TdApi$InputSticker;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;
    .param p5, "stickerType"    # Lorg/drinkless/tdlib/TdApi$StickerType;
    .param p6, "z8"    # Z
    .param p7, "inputStickerArr"    # [Lorg/drinkless/tdlib/TdApi$InputSticker;
    .param p8, "str3"    # Ljava/lang/String;

    .line 51179
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 51180
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CreateNewStickerSet;->userId:J

    .line 51181
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CreateNewStickerSet;->title:Ljava/lang/String;

    .line 51182
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$CreateNewStickerSet;->name:Ljava/lang/String;

    .line 51183
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$CreateNewStickerSet;->stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;

    .line 51184
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$CreateNewStickerSet;->needsRepainting:Z

    .line 51185
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$CreateNewStickerSet;->stickers:[Lorg/drinkless/tdlib/TdApi$InputSticker;

    .line 51186
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$CreateNewStickerSet;->source:Ljava/lang/String;

    .line 51187
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51191
    const v0, -0x1cac7aff

    return v0
.end method
