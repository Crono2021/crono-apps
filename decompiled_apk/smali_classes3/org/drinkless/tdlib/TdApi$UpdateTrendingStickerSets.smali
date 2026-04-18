.class public Lorg/drinkless/tdlib/TdApi$UpdateTrendingStickerSets;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateTrendingStickerSets"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4b7a50a7


# instance fields
.field public stickerSets:Lorg/drinkless/tdlib/TdApi$TrendingStickerSets;

.field public stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35068
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 35069
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StickerType;Lorg/drinkless/tdlib/TdApi$TrendingStickerSets;)V
    .locals 0
    .param p1, "stickerType"    # Lorg/drinkless/tdlib/TdApi$StickerType;
    .param p2, "trendingStickerSets"    # Lorg/drinkless/tdlib/TdApi$TrendingStickerSets;

    .line 35058
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 35059
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateTrendingStickerSets;->stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;

    .line 35060
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateTrendingStickerSets;->stickerSets:Lorg/drinkless/tdlib/TdApi$TrendingStickerSets;

    .line 35061
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35065
    const v0, 0x4b7a50a7    # 1.6404647E7f

    return v0
.end method
