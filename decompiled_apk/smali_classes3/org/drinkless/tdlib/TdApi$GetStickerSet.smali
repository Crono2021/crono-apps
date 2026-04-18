.class public Lorg/drinkless/tdlib/TdApi$GetStickerSet;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetStickerSet"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StickerSet;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3eb91bc3


# instance fields
.field public setId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13650
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13651
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 13641
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13642
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetStickerSet;->setId:J

    .line 13643
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13647
    const v0, 0x3eb91bc3

    return v0
.end method
