.class public Lorg/drinkless/tdlib/TdApi$BusinessFeaturePromotionAnimation;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessFeaturePromotionAnimation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7a05680a


# instance fields
.field public animation:Lorg/drinkless/tdlib/TdApi$Animation;

.field public feature:Lorg/drinkless/tdlib/TdApi$BusinessFeature;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23344
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23345
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BusinessFeature;Lorg/drinkless/tdlib/TdApi$Animation;)V
    .locals 0
    .param p1, "businessFeature"    # Lorg/drinkless/tdlib/TdApi$BusinessFeature;
    .param p2, "animation"    # Lorg/drinkless/tdlib/TdApi$Animation;

    .line 23334
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23335
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessFeaturePromotionAnimation;->feature:Lorg/drinkless/tdlib/TdApi$BusinessFeature;

    .line 23336
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$BusinessFeaturePromotionAnimation;->animation:Lorg/drinkless/tdlib/TdApi$Animation;

    .line 23337
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23341
    const v0, 0x7a05680a

    return v0
.end method
