.class public Lorg/drinkless/tdlib/TdApi$GiftResaleResultPriceIncreased;
.super Lorg/drinkless/tdlib/TdApi$GiftResaleResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiftResaleResultPriceIncreased"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x74813173


# instance fields
.field public price:Lorg/drinkless/tdlib/TdApi$GiftResalePrice;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14082
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$GiftResaleResult;-><init>()V

    .line 14083
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$GiftResalePrice;)V
    .locals 0
    .param p1, "giftResalePrice"    # Lorg/drinkless/tdlib/TdApi$GiftResalePrice;

    .line 14073
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$GiftResaleResult;-><init>()V

    .line 14074
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GiftResaleResultPriceIncreased;->price:Lorg/drinkless/tdlib/TdApi$GiftResalePrice;

    .line 14075
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14079
    const v0, -0x74813173

    return v0
.end method
