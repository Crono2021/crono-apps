.class public Lorg/drinkless/tdlib/TdApi$GetStarGiftPaymentOptions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetStarGiftPaymentOptions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StarPaymentOptions;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1dd89f1d


# instance fields
.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13614
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13615
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 13605
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13606
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetStarGiftPaymentOptions;->userId:J

    .line 13607
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13611
    const v0, -0x1dd89f1d

    return v0
.end method
