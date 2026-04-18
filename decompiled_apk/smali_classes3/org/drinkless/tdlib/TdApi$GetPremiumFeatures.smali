.class public Lorg/drinkless/tdlib/TdApi$GetPremiumFeatures;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetPremiumFeatures"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PremiumFeatures;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4b23d9b7


# instance fields
.field public source:Lorg/drinkless/tdlib/TdApi$PremiumSource;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13272
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13273
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PremiumSource;)V
    .locals 0
    .param p1, "premiumSource"    # Lorg/drinkless/tdlib/TdApi$PremiumSource;

    .line 13263
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13264
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetPremiumFeatures;->source:Lorg/drinkless/tdlib/TdApi$PremiumSource;

    .line 13265
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13269
    const v0, -0x4b23d9b7

    return v0
.end method
