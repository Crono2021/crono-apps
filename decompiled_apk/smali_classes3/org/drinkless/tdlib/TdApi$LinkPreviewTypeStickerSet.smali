.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeStickerSet;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeStickerSet"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x8b32770


# instance fields
.field public stickers:[Lorg/drinkless/tdlib/TdApi$Sticker;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15990
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15991
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "stickerArr"    # [Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 15981
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15982
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeStickerSet;->stickers:[Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 15983
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15987
    const v0, -0x8b32770

    return v0
.end method
