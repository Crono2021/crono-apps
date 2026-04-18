.class public Lorg/drinkless/tdlib/TdApi$GetChatSimilarChatCount;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatSimilarChatCount"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Count;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x463e968e


# instance fields
.field public chatId:J

.field public returnLocal:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25924
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25925
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 25914
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25915
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatSimilarChatCount;->chatId:J

    .line 25916
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$GetChatSimilarChatCount;->returnLocal:Z

    .line 25917
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25921
    const v0, 0x463e968e

    return v0
.end method
