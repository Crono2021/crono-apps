.class public Lorg/drinkless/tdlib/TdApi$UpdateChatMember;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatMember"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6779a439


# instance fields
.field public actorUserId:J

.field public chatId:J

.field public date:I

.field public inviteLink:Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

.field public newChatMember:Lorg/drinkless/tdlib/TdApi$ChatMember;

.field public oldChatMember:Lorg/drinkless/tdlib/TdApi$ChatMember;

.field public viaChatFolderInviteLink:Z

.field public viaJoinRequest:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52364
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 52365
    return-void
.end method

.method public constructor <init>(JJILorg/drinkless/tdlib/TdApi$ChatInviteLink;ZZLorg/drinkless/tdlib/TdApi$ChatMember;Lorg/drinkless/tdlib/TdApi$ChatMember;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I
    .param p6, "chatInviteLink"    # Lorg/drinkless/tdlib/TdApi$ChatInviteLink;
    .param p7, "z8"    # Z
    .param p8, "z9"    # Z
    .param p9, "chatMember"    # Lorg/drinkless/tdlib/TdApi$ChatMember;
    .param p10, "chatMember2"    # Lorg/drinkless/tdlib/TdApi$ChatMember;

    .line 52348
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 52349
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatMember;->chatId:J

    .line 52350
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatMember;->actorUserId:J

    .line 52351
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatMember;->date:I

    .line 52352
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatMember;->inviteLink:Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

    .line 52353
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatMember;->viaJoinRequest:Z

    .line 52354
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatMember;->viaChatFolderInviteLink:Z

    .line 52355
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatMember;->oldChatMember:Lorg/drinkless/tdlib/TdApi$ChatMember;

    .line 52356
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatMember;->newChatMember:Lorg/drinkless/tdlib/TdApi$ChatMember;

    .line 52357
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52361
    const v0, -0x6779a439

    return v0
.end method
