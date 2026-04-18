.class public Lorg/drinkless/tdlib/TdApi$CheckAuthenticationPremiumPurchase;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CheckAuthenticationPremiumPurchase"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5eb59abe


# instance fields
.field public amount:J

.field public currency:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24524
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24525
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;J)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J

    .line 24514
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24515
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CheckAuthenticationPremiumPurchase;->currency:Ljava/lang/String;

    .line 24516
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$CheckAuthenticationPremiumPurchase;->amount:J

    .line 24517
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24521
    const v0, 0x5eb59abe

    return v0
.end method
