.class public Lorg/drinkless/tdlib/TdApi$SetChatMessageAutoDeleteTime;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatMessageAutoDeleteTime"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x59be4b01


# instance fields
.field public chatId:J

.field public messageAutoDeleteTime:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31288
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31289
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 31278
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31279
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatMessageAutoDeleteTime;->chatId:J

    .line 31280
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatMessageAutoDeleteTime;->messageAutoDeleteTime:I

    .line 31281
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31285
    const v0, -0x59be4b01

    return v0
.end method
