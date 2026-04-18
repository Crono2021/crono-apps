.class public Lorg/drinkless/tdlib/TdApi$GetPremiumLimit;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetPremiumLimit"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PremiumLimit;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4017fcea


# instance fields
.field public limitType:Lorg/drinkless/tdlib/TdApi$PremiumLimitType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13326
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13327
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PremiumLimitType;)V
    .locals 0
    .param p1, "premiumLimitType"    # Lorg/drinkless/tdlib/TdApi$PremiumLimitType;

    .line 13317
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13318
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetPremiumLimit;->limitType:Lorg/drinkless/tdlib/TdApi$PremiumLimitType;

    .line 13319
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13323
    const v0, 0x4017fcea

    return v0
.end method
