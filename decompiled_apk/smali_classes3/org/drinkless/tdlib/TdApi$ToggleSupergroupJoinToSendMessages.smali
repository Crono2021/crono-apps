.class public Lorg/drinkless/tdlib/TdApi$ToggleSupergroupJoinToSendMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleSupergroupJoinToSendMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xad971f2


# instance fields
.field public joinToSendMessages:Z

.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33508
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33509
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33498
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33499
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupJoinToSendMessages;->supergroupId:J

    .line 33500
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupJoinToSendMessages;->joinToSendMessages:Z

    .line 33501
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33505
    const v0, -0xad971f2

    return v0
.end method
