.class public Lorg/drinkless/tdlib/TdApi$RevenueWithdrawalStateSucceeded;
.super Lorg/drinkless/tdlib/TdApi$RevenueWithdrawalState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RevenueWithdrawalStateSucceeded"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xfd14e0a


# instance fields
.field public date:I

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30388
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RevenueWithdrawalState;-><init>()V

    .line 30389
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;

    .line 30378
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RevenueWithdrawalState;-><init>()V

    .line 30379
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$RevenueWithdrawalStateSucceeded;->date:I

    .line 30380
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$RevenueWithdrawalStateSucceeded;->url:Ljava/lang/String;

    .line 30381
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30385
    const v0, 0xfd14e0a

    return v0
.end method
