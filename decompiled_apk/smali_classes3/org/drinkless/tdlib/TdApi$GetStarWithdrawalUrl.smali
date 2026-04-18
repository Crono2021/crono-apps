.class public Lorg/drinkless/tdlib/TdApi$GetStarWithdrawalUrl;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetStarWithdrawalUrl"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$HttpUrl;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x562dc8ee


# instance fields
.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public password:Ljava/lang/String;

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37466
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37467
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;JLjava/lang/String;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "j5"    # J
    .param p4, "str"    # Ljava/lang/String;

    .line 37455
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37456
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetStarWithdrawalUrl;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 37457
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$GetStarWithdrawalUrl;->starCount:J

    .line 37458
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$GetStarWithdrawalUrl;->password:Ljava/lang/String;

    .line 37459
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37463
    const v0, -0x562dc8ee

    return v0
.end method
