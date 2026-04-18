.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeChat;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x51d05ede


# instance fields
.field public createsJoinRequest:Z

.field public photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

.field public type:Lorg/drinkless/tdlib/TdApi$InviteLinkChatType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38304
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 38305
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InviteLinkChatType;Lorg/drinkless/tdlib/TdApi$ChatPhoto;Z)V
    .locals 0
    .param p1, "inviteLinkChatType"    # Lorg/drinkless/tdlib/TdApi$InviteLinkChatType;
    .param p2, "chatPhoto"    # Lorg/drinkless/tdlib/TdApi$ChatPhoto;
    .param p3, "z8"    # Z

    .line 38293
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 38294
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeChat;->type:Lorg/drinkless/tdlib/TdApi$InviteLinkChatType;

    .line 38295
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeChat;->photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 38296
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeChat;->createsJoinRequest:Z

    .line 38297
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38301
    const v0, -0x51d05ede

    return v0
.end method
