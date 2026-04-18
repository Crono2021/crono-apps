.class public Lorg/drinkless/tdlib/TdApi$SetChatPhoto;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatPhoto"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x168472fd


# instance fields
.field public chatId:J

.field public photo:Lorg/drinkless/tdlib/TdApi$InputChatPhoto;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31388
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31389
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$InputChatPhoto;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "inputChatPhoto"    # Lorg/drinkless/tdlib/TdApi$InputChatPhoto;

    .line 31378
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31379
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatPhoto;->chatId:J

    .line 31380
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatPhoto;->photo:Lorg/drinkless/tdlib/TdApi$InputChatPhoto;

    .line 31381
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31385
    const v0, -0x168472fd

    return v0
.end method
