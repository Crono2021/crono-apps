.class public Lorg/drinkless/tdlib/TdApi$ToggleSupergroupIsBroadcastGroup;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleSupergroupIsBroadcastGroup"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x34b22215


# instance fields
.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21404
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 21405
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 21395
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 21396
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupIsBroadcastGroup;->supergroupId:J

    .line 21397
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21401
    const v0, 0x34b22215

    return v0
.end method
