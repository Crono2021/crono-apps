.class public Lorg/drinkless/tdlib/TdApi$ToggleSupergroupIsAllHistoryAvailable;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleSupergroupIsAllHistoryAvailable"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x44d9964e


# instance fields
.field public isAllHistoryAvailable:Z

.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33468
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33469
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33458
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33459
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupIsAllHistoryAvailable;->supergroupId:J

    .line 33460
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupIsAllHistoryAvailable;->isAllHistoryAvailable:Z

    .line 33461
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33465
    const v0, 0x44d9964e

    return v0
.end method
