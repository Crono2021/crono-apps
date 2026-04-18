.class public Lorg/drinkless/tdlib/TdApi$SearchInstalledStickerSets;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchInstalledStickerSets"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StickerSets;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7e5e7fa4


# instance fields
.field public limit:I

.field public query:Ljava/lang/String;

.field public stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39844
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39845
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StickerType;Ljava/lang/String;I)V
    .locals 0
    .param p1, "stickerType"    # Lorg/drinkless/tdlib/TdApi$StickerType;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "i9"    # I

    .line 39833
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39834
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchInstalledStickerSets;->stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;

    .line 39835
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SearchInstalledStickerSets;->query:Ljava/lang/String;

    .line 39836
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$SearchInstalledStickerSets;->limit:I

    .line 39837
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39841
    const v0, 0x7e5e7fa4

    return v0
.end method
