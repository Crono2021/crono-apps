.class public Lorg/drinkless/tdlib/TdApi$CanSendMessageToUser;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CanSendMessageToUser"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$CanSendMessageToUserResult;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5b2a2836


# instance fields
.field public onlyLocal:Z

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23504
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 23505
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 23494
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 23495
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CanSendMessageToUser;->userId:J

    .line 23496
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$CanSendMessageToUser;->onlyLocal:Z

    .line 23497
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23501
    const v0, 0x5b2a2836

    return v0
.end method
