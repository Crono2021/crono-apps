.class public Lorg/drinkless/tdlib/TdApi$ReorderInstalledStickerSets;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReorderInstalledStickerSets"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x40121a1e


# instance fields
.field public stickerSetIds:[J

.field public stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30088
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30089
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StickerType;[J)V
    .locals 0
    .param p1, "stickerType"    # Lorg/drinkless/tdlib/TdApi$StickerType;
    .param p2, "jArr"    # [J

    .line 30078
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30079
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReorderInstalledStickerSets;->stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;

    .line 30080
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ReorderInstalledStickerSets;->stickerSetIds:[J

    .line 30081
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30085
    const v0, 0x40121a1e

    return v0
.end method
