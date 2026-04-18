.class public Lorg/drinkless/tdlib/TdApi$StarSubscription;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarSubscription"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3a3811f5


# instance fields
.field public chatId:J

.field public expirationDate:I

.field public id:Ljava/lang/String;

.field public isCanceled:Z

.field public isExpiring:Z

.field public pricing:Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;

.field public type:Lorg/drinkless/tdlib/TdApi$StarSubscriptionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51794
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51795
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JIZZLorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;Lorg/drinkless/tdlib/TdApi$StarSubscriptionType;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "i9"    # I
    .param p5, "z8"    # Z
    .param p6, "z9"    # Z
    .param p7, "starSubscriptionPricing"    # Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;
    .param p8, "starSubscriptionType"    # Lorg/drinkless/tdlib/TdApi$StarSubscriptionType;

    .line 51779
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51780
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StarSubscription;->id:Ljava/lang/String;

    .line 51781
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$StarSubscription;->chatId:J

    .line 51782
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$StarSubscription;->expirationDate:I

    .line 51783
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$StarSubscription;->isCanceled:Z

    .line 51784
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$StarSubscription;->isExpiring:Z

    .line 51785
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$StarSubscription;->pricing:Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;

    .line 51786
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$StarSubscription;->type:Lorg/drinkless/tdlib/TdApi$StarSubscriptionType;

    .line 51787
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51791
    const v0, 0x3a3811f5

    return v0
.end method
