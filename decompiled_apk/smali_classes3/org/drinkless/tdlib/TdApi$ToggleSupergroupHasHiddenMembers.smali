.class public Lorg/drinkless/tdlib/TdApi$ToggleSupergroupHasHiddenMembers;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleSupergroupHasHiddenMembers"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5baa6236


# instance fields
.field public hasHiddenMembers:Z

.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33448
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33449
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33438
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33439
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupHasHiddenMembers;->supergroupId:J

    .line 33440
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupHasHiddenMembers;->hasHiddenMembers:Z

    .line 33441
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33445
    const v0, -0x5baa6236

    return v0
.end method
