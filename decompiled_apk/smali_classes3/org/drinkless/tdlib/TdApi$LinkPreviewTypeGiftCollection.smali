.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeGiftCollection;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeGiftCollection"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xdb9a649


# instance fields
.field public icons:[Lorg/drinkless/tdlib/TdApi$Sticker;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15936
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15937
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "stickerArr"    # [Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 15927
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15928
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeGiftCollection;->icons:[Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 15929
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15933
    const v0, 0xdb9a649

    return v0
.end method
