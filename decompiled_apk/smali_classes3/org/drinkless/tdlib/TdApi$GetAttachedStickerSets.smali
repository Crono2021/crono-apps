.class public Lorg/drinkless/tdlib/TdApi$GetAttachedStickerSets;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetAttachedStickerSets"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StickerSets;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4d9d930d


# instance fields
.field public fileId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12030
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12031
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 12021
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12022
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GetAttachedStickerSets;->fileId:I

    .line 12023
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12027
    const v0, 0x4d9d930d    # 3.304575E8f

    return v0
.end method
