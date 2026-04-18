.class public Lorg/drinkless/tdlib/TdApi$EditUserStarSubscription;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditUserStarSubscription"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x51b16e89


# instance fields
.field public isCanceled:Z

.field public telegramPaymentChargeId:Ljava/lang/String;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36872
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36873
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Z)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "z8"    # Z

    .line 36861
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36862
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$EditUserStarSubscription;->userId:J

    .line 36863
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$EditUserStarSubscription;->telegramPaymentChargeId:Ljava/lang/String;

    .line 36864
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$EditUserStarSubscription;->isCanceled:Z

    .line 36865
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36869
    const v0, 0x51b16e89

    return v0
.end method
