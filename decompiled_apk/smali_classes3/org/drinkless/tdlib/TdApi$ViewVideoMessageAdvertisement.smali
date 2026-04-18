.class public Lorg/drinkless/tdlib/TdApi$ViewVideoMessageAdvertisement;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ViewVideoMessageAdvertisement"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3031b13e


# instance fields
.field public advertisementUniqueId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22664
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22665
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 22655
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22656
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ViewVideoMessageAdvertisement;->advertisementUniqueId:J

    .line 22657
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22661
    const v0, -0x3031b13e

    return v0
.end method
