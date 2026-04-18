.class public Lorg/drinkless/tdlib/TdApi$GetTrendingStickerSets;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetTrendingStickerSets"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$TrendingStickerSets;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1fa7baa2


# instance fields
.field public limit:I

.field public offset:I

.field public stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37600
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37601
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StickerType;II)V
    .locals 0
    .param p1, "stickerType"    # Lorg/drinkless/tdlib/TdApi$StickerType;
    .param p2, "i9"    # I
    .param p3, "i10"    # I

    .line 37589
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37590
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetTrendingStickerSets;->stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;

    .line 37591
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$GetTrendingStickerSets;->offset:I

    .line 37592
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetTrendingStickerSets;->limit:I

    .line 37593
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37597
    const v0, -0x1fa7baa2

    return v0
.end method
