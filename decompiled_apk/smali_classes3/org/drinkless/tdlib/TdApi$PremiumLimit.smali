.class public Lorg/drinkless/tdlib/TdApi$PremiumLimit;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PremiumLimit"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7ed372e6


# instance fields
.field public defaultValue:I

.field public premiumValue:I

.field public type:Lorg/drinkless/tdlib/TdApi$PremiumLimitType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38986
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38987
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PremiumLimitType;II)V
    .locals 0
    .param p1, "premiumLimitType"    # Lorg/drinkless/tdlib/TdApi$PremiumLimitType;
    .param p2, "i9"    # I
    .param p3, "i10"    # I

    .line 38975
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38976
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PremiumLimit;->type:Lorg/drinkless/tdlib/TdApi$PremiumLimitType;

    .line 38977
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$PremiumLimit;->defaultValue:I

    .line 38978
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$PremiumLimit;->premiumValue:I

    .line 38979
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38983
    const v0, 0x7ed372e6

    return v0
.end method
