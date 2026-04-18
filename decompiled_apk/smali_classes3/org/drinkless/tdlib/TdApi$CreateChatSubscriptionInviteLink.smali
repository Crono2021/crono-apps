.class public Lorg/drinkless/tdlib/TdApi$CreateChatSubscriptionInviteLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateChatSubscriptionInviteLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatInviteLink;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x226b65


# instance fields
.field public chatId:J

.field public name:Ljava/lang/String;

.field public subscriptionPricing:Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36432
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36433
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "starSubscriptionPricing"    # Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;

    .line 36421
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36422
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CreateChatSubscriptionInviteLink;->chatId:J

    .line 36423
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CreateChatSubscriptionInviteLink;->name:Ljava/lang/String;

    .line 36424
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$CreateChatSubscriptionInviteLink;->subscriptionPricing:Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;

    .line 36425
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36429
    const v0, 0x226b65

    return v0
.end method
