.class public Lorg/drinkless/tdlib/TdApi$GetNetworkStatistics;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetNetworkStatistics"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$NetworkStatistics;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3ac8a7e2


# instance fields
.field public onlyCurrent:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13182
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13183
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 13173
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13174
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$GetNetworkStatistics;->onlyCurrent:Z

    .line 13175
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13179
    const v0, -0x3ac8a7e2

    return v0
.end method
