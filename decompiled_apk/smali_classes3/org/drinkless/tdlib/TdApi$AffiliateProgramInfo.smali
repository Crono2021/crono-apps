.class public Lorg/drinkless/tdlib/TdApi$AffiliateProgramInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AffiliateProgramInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6903174b


# instance fields
.field public dailyRevenuePerUserAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

.field public endDate:I

.field public parameters:Lorg/drinkless/tdlib/TdApi$AffiliateProgramParameters;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35596
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35597
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$AffiliateProgramParameters;ILorg/drinkless/tdlib/TdApi$StarAmount;)V
    .locals 0
    .param p1, "affiliateProgramParameters"    # Lorg/drinkless/tdlib/TdApi$AffiliateProgramParameters;
    .param p2, "i9"    # I
    .param p3, "starAmount"    # Lorg/drinkless/tdlib/TdApi$StarAmount;

    .line 35585
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35586
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AffiliateProgramInfo;->parameters:Lorg/drinkless/tdlib/TdApi$AffiliateProgramParameters;

    .line 35587
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$AffiliateProgramInfo;->endDate:I

    .line 35588
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AffiliateProgramInfo;->dailyRevenuePerUserAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

    .line 35589
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35593
    const v0, -0x6903174b

    return v0
.end method
