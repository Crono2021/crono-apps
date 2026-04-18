.class public Lorg/drinkless/tdlib/TdApi$PremiumSourceFeature;
.super Lorg/drinkless/tdlib/TdApi$PremiumSource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PremiumSourceFeature"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1a929325


# instance fields
.field public feature:Lorg/drinkless/tdlib/TdApi$PremiumFeature;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17862
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PremiumSource;-><init>()V

    .line 17863
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PremiumFeature;)V
    .locals 0
    .param p1, "premiumFeature"    # Lorg/drinkless/tdlib/TdApi$PremiumFeature;

    .line 17853
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PremiumSource;-><init>()V

    .line 17854
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PremiumSourceFeature;->feature:Lorg/drinkless/tdlib/TdApi$PremiumFeature;

    .line 17855
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17859
    const v0, 0x1a929325

    return v0
.end method
