.class public Lorg/drinkless/tdlib/TdApi$GetPremiumGiveawayPaymentOptions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetPremiumGiveawayPaymentOptions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PremiumGiveawayPaymentOptions;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x48d8ce09


# instance fields
.field public boostedChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13290
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13291
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 13281
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13282
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetPremiumGiveawayPaymentOptions;->boostedChatId:J

    .line 13283
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13287
    const v0, 0x48d8ce09

    return v0
.end method
