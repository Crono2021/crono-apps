.class public Lorg/drinkless/tdlib/TdApi$PremiumSourceStoryFeature;
.super Lorg/drinkless/tdlib/TdApi$PremiumSource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PremiumSourceStoryFeature"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3d6fce94


# instance fields
.field public feature:Lorg/drinkless/tdlib/TdApi$PremiumStoryFeature;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17916
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PremiumSource;-><init>()V

    .line 17917
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PremiumStoryFeature;)V
    .locals 0
    .param p1, "premiumStoryFeature"    # Lorg/drinkless/tdlib/TdApi$PremiumStoryFeature;

    .line 17907
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PremiumSource;-><init>()V

    .line 17908
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PremiumSourceStoryFeature;->feature:Lorg/drinkless/tdlib/TdApi$PremiumStoryFeature;

    .line 17909
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17913
    const v0, -0x3d6fce94

    return v0
.end method
