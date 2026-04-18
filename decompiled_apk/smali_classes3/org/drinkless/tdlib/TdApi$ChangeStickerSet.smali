.class public Lorg/drinkless/tdlib/TdApi$ChangeStickerSet;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChangeStickerSet"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1ac8a5ed


# instance fields
.field public isArchived:Z

.field public isInstalled:Z

.field public setId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35970
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35971
    return-void
.end method

.method public constructor <init>(JZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z

    .line 35959
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35960
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChangeStickerSet;->setId:J

    .line 35961
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ChangeStickerSet;->isInstalled:Z

    .line 35962
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ChangeStickerSet;->isArchived:Z

    .line 35963
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35967
    const v0, 0x1ac8a5ed

    return v0
.end method
