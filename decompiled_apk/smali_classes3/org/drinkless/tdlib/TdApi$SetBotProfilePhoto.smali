.class public Lorg/drinkless/tdlib/TdApi$SetBotProfilePhoto;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetBotProfilePhoto"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4279b49a


# instance fields
.field public botUserId:J

.field public photo:Lorg/drinkless/tdlib/TdApi$InputChatPhoto;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31028
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31029
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$InputChatPhoto;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "inputChatPhoto"    # Lorg/drinkless/tdlib/TdApi$InputChatPhoto;

    .line 31018
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31019
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetBotProfilePhoto;->botUserId:J

    .line 31020
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetBotProfilePhoto;->photo:Lorg/drinkless/tdlib/TdApi$InputChatPhoto;

    .line 31021
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31025
    const v0, -0x4279b49a

    return v0
.end method
