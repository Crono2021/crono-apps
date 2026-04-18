.class public Lorg/drinkless/tdlib/TdApi$TMeUrlTypeStickerSet;
.super Lorg/drinkless/tdlib/TdApi$TMeUrlType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TMeUrlTypeStickerSet"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5f83ccec


# instance fields
.field public stickerSetId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20760
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TMeUrlType;-><init>()V

    .line 20761
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 20751
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TMeUrlType;-><init>()V

    .line 20752
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$TMeUrlTypeStickerSet;->stickerSetId:J

    .line 20753
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20757
    const v0, 0x5f83ccec

    return v0
.end method
