.class public Lorg/drinkless/tdlib/TdApi$SetUserPersonalProfilePhoto;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetUserPersonalProfilePhoto"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1baa28f6


# instance fields
.field public photo:Lorg/drinkless/tdlib/TdApi$InputChatPhoto;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32168
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32169
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$InputChatPhoto;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "inputChatPhoto"    # Lorg/drinkless/tdlib/TdApi$InputChatPhoto;

    .line 32158
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32159
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetUserPersonalProfilePhoto;->userId:J

    .line 32160
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetUserPersonalProfilePhoto;->photo:Lorg/drinkless/tdlib/TdApi$InputChatPhoto;

    .line 32161
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32165
    const v0, 0x1baa28f6

    return v0
.end method
