.class public Lorg/drinkless/tdlib/TdApi$SetSupergroupStickerSet;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetSupergroupStickerSet"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7a915297


# instance fields
.field public stickerSetId:J

.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32068
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32069
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 32058
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32059
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetSupergroupStickerSet;->supergroupId:J

    .line 32060
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$SetSupergroupStickerSet;->stickerSetId:J

    .line 32061
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32065
    const v0, -0x7a915297

    return v0
.end method
