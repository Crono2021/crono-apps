.class public Lorg/drinkless/tdlib/TdApi$ViewPremiumFeature;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ViewPremiumFeature"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xb8031b2


# instance fields
.field public feature:Lorg/drinkless/tdlib/TdApi$PremiumFeature;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22610
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22611
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PremiumFeature;)V
    .locals 0
    .param p1, "premiumFeature"    # Lorg/drinkless/tdlib/TdApi$PremiumFeature;

    .line 22601
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22602
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ViewPremiumFeature;->feature:Lorg/drinkless/tdlib/TdApi$PremiumFeature;

    .line 22603
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22607
    const v0, 0xb8031b2

    return v0
.end method
