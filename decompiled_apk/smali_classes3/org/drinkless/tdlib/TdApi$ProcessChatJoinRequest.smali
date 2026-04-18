.class public Lorg/drinkless/tdlib/TdApi$ProcessChatJoinRequest;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ProcessChatJoinRequest"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3be534a3


# instance fields
.field public approve:Z

.field public chatId:J

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39030
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39031
    return-void
.end method

.method public constructor <init>(JJZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "z8"    # Z

    .line 39019
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39020
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ProcessChatJoinRequest;->chatId:J

    .line 39021
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ProcessChatJoinRequest;->userId:J

    .line 39022
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$ProcessChatJoinRequest;->approve:Z

    .line 39023
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39027
    const v0, 0x3be534a3

    return v0
.end method
