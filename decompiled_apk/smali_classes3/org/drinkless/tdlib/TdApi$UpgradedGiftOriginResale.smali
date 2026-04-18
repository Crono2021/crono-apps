.class public Lorg/drinkless/tdlib/TdApi$UpgradedGiftOriginResale;
.super Lorg/drinkless/tdlib/TdApi$UpgradedGiftOrigin;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradedGiftOriginResale"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3af341db


# instance fields
.field public price:Lorg/drinkless/tdlib/TdApi$GiftResalePrice;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22358
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UpgradedGiftOrigin;-><init>()V

    .line 22359
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$GiftResalePrice;)V
    .locals 0
    .param p1, "giftResalePrice"    # Lorg/drinkless/tdlib/TdApi$GiftResalePrice;

    .line 22349
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UpgradedGiftOrigin;-><init>()V

    .line 22350
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftOriginResale;->price:Lorg/drinkless/tdlib/TdApi$GiftResalePrice;

    .line 22351
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22355
    const v0, -0x3af341db

    return v0
.end method
