.class public Lorg/drinkless/tdlib/TdApi$PremiumSourceBusinessFeature;
.super Lorg/drinkless/tdlib/TdApi$PremiumSource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PremiumSourceBusinessFeature"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x58fc8da4


# instance fields
.field public feature:Lorg/drinkless/tdlib/TdApi$BusinessFeature;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17844
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PremiumSource;-><init>()V

    .line 17845
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BusinessFeature;)V
    .locals 0
    .param p1, "businessFeature"    # Lorg/drinkless/tdlib/TdApi$BusinessFeature;

    .line 17835
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PremiumSource;-><init>()V

    .line 17836
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PremiumSourceBusinessFeature;->feature:Lorg/drinkless/tdlib/TdApi$BusinessFeature;

    .line 17837
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17841
    const v0, -0x58fc8da4

    return v0
.end method
