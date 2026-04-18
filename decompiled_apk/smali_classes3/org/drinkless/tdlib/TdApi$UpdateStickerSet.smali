.class public Lorg/drinkless/tdlib/TdApi$UpdateStickerSet;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateStickerSet"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x70035dcc


# instance fields
.field public stickerSet:Lorg/drinkless/tdlib/TdApi$StickerSet;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22142
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22143
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StickerSet;)V
    .locals 0
    .param p1, "stickerSet"    # Lorg/drinkless/tdlib/TdApi$StickerSet;

    .line 22133
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22134
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateStickerSet;->stickerSet:Lorg/drinkless/tdlib/TdApi$StickerSet;

    .line 22135
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22139
    const v0, 0x70035dcc

    return v0
.end method
