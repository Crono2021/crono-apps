.class public Lorg/drinkless/tdlib/TdApi$UpdateNewChatJoinRequest;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateNewChatJoinRequest"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7e48b843


# instance fields
.field public chatId:J

.field public inviteLink:Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

.field public request:Lorg/drinkless/tdlib/TdApi$ChatJoinRequest;

.field public userChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46182
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46183
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatJoinRequest;JLorg/drinkless/tdlib/TdApi$ChatInviteLink;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatJoinRequest"    # Lorg/drinkless/tdlib/TdApi$ChatJoinRequest;
    .param p4, "j9"    # J
    .param p6, "chatInviteLink"    # Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

    .line 46170
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46171
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewChatJoinRequest;->chatId:J

    .line 46172
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewChatJoinRequest;->request:Lorg/drinkless/tdlib/TdApi$ChatJoinRequest;

    .line 46173
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewChatJoinRequest;->userChatId:J

    .line 46174
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewChatJoinRequest;->inviteLink:Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

    .line 46175
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46179
    const v0, 0x7e48b843

    return v0
.end method
