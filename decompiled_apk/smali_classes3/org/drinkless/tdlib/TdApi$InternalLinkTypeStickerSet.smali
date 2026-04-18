.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeStickerSet;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeStickerSet"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5eb9b05e


# instance fields
.field public expectCustomEmoji:Z

.field public stickerSetName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27764
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27765
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 27754
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27755
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeStickerSet;->stickerSetName:Ljava/lang/String;

    .line 27756
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeStickerSet;->expectCustomEmoji:Z

    .line 27757
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27761
    const v0, -0x5eb9b05e

    return v0
.end method
