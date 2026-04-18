.class public Lorg/drinkless/tdlib/TdApi$PremiumFeatureChatBoost;
.super Lorg/drinkless/tdlib/TdApi$PremiumFeature;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PremiumFeatureChatBoost"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5df89f1b


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 4954
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PremiumFeature;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 4959
    const v0, 0x5df89f1b

    return v0
.end method
