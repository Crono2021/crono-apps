.class public Lorg/drinkless/tdlib/TdApi$AffiliateInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AffiliateInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4e3e2306


# instance fields
.field public affiliateChatId:J

.field public commissionPerMille:I

.field public starAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35574
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35575
    return-void
.end method

.method public constructor <init>(IJLorg/drinkless/tdlib/TdApi$StarAmount;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J
    .param p4, "starAmount"    # Lorg/drinkless/tdlib/TdApi$StarAmount;

    .line 35563
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35564
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$AffiliateInfo;->commissionPerMille:I

    .line 35565
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$AffiliateInfo;->affiliateChatId:J

    .line 35566
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$AffiliateInfo;->starAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

    .line 35567
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35571
    const v0, -0x4e3e2306

    return v0
.end method
