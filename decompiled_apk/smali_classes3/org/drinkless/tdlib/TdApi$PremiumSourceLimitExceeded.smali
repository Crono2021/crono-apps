.class public Lorg/drinkless/tdlib/TdApi$PremiumSourceLimitExceeded;
.super Lorg/drinkless/tdlib/TdApi$PremiumSource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PremiumSourceLimitExceeded"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7a5178fe


# instance fields
.field public limitType:Lorg/drinkless/tdlib/TdApi$PremiumLimitType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17880
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PremiumSource;-><init>()V

    .line 17881
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PremiumLimitType;)V
    .locals 0
    .param p1, "premiumLimitType"    # Lorg/drinkless/tdlib/TdApi$PremiumLimitType;

    .line 17871
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PremiumSource;-><init>()V

    .line 17872
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PremiumSourceLimitExceeded;->limitType:Lorg/drinkless/tdlib/TdApi$PremiumLimitType;

    .line 17873
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17877
    const v0, -0x7a5178fe

    return v0
.end method
