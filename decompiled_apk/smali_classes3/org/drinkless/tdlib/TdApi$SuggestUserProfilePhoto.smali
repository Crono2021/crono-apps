.class public Lorg/drinkless/tdlib/TdApi$SuggestUserProfilePhoto;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SuggestUserProfilePhoto"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6a9e0b9d


# instance fields
.field public photo:Lorg/drinkless/tdlib/TdApi$InputChatPhoto;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32948
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32949
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$InputChatPhoto;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "inputChatPhoto"    # Lorg/drinkless/tdlib/TdApi$InputChatPhoto;

    .line 32938
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32939
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SuggestUserProfilePhoto;->userId:J

    .line 32940
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SuggestUserProfilePhoto;->photo:Lorg/drinkless/tdlib/TdApi$InputChatPhoto;

    .line 32941
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32945
    const v0, -0x6a9e0b9d

    return v0
.end method
