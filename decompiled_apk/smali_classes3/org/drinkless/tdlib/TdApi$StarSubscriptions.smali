.class public Lorg/drinkless/tdlib/TdApi$StarSubscriptions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarSubscriptions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x902a973


# instance fields
.field public nextOffset:Ljava/lang/String;

.field public requiredStarCount:J

.field public starAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

.field public subscriptions:[Lorg/drinkless/tdlib/TdApi$StarSubscription;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45390
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45391
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StarAmount;[Lorg/drinkless/tdlib/TdApi$StarSubscription;JLjava/lang/String;)V
    .locals 0
    .param p1, "starAmount"    # Lorg/drinkless/tdlib/TdApi$StarAmount;
    .param p2, "starSubscriptionArr"    # [Lorg/drinkless/tdlib/TdApi$StarSubscription;
    .param p3, "j5"    # J
    .param p5, "str"    # Ljava/lang/String;

    .line 45378
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45379
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StarSubscriptions;->starAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

    .line 45380
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StarSubscriptions;->subscriptions:[Lorg/drinkless/tdlib/TdApi$StarSubscription;

    .line 45381
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$StarSubscriptions;->requiredStarCount:J

    .line 45382
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$StarSubscriptions;->nextOffset:Ljava/lang/String;

    .line 45383
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45387
    const v0, 0x902a973

    return v0
.end method
