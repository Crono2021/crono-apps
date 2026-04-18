.class public Lorg/drinkless/tdlib/TdApi$ToggleSupergroupCanHaveSponsoredMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleSupergroupCanHaveSponsoredMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4175448e


# instance fields
.field public canHaveSponsoredMessages:Z

.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33388
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33389
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33378
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33379
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupCanHaveSponsoredMessages;->supergroupId:J

    .line 33380
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupCanHaveSponsoredMessages;->canHaveSponsoredMessages:Z

    .line 33381
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33385
    const v0, -0x4175448e

    return v0
.end method
