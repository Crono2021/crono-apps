.class public Lorg/drinkless/tdlib/TdApi$SetProfilePhoto;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetProfilePhoto"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7a15fa13


# instance fields
.field public isPublic:Z

.field public photo:Lorg/drinkless/tdlib/TdApi$InputChatPhoto;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31808
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31809
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputChatPhoto;Z)V
    .locals 0
    .param p1, "inputChatPhoto"    # Lorg/drinkless/tdlib/TdApi$InputChatPhoto;
    .param p2, "z8"    # Z

    .line 31798
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31799
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetProfilePhoto;->photo:Lorg/drinkless/tdlib/TdApi$InputChatPhoto;

    .line 31800
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$SetProfilePhoto;->isPublic:Z

    .line 31801
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31805
    const v0, -0x7a15fa13

    return v0
.end method
