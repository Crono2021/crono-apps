.class public Lorg/drinkless/tdlib/TdApi$GetInstalledStickerSets;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetInstalledStickerSets"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StickerSets;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x612ef6f6


# instance fields
.field public stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12948
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12949
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StickerType;)V
    .locals 0
    .param p1, "stickerType"    # Lorg/drinkless/tdlib/TdApi$StickerType;

    .line 12939
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12940
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetInstalledStickerSets;->stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;

    .line 12941
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12945
    const v0, 0x612ef6f6

    return v0
.end method
