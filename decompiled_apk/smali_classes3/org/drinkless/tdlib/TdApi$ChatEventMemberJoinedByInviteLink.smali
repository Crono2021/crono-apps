.class public Lorg/drinkless/tdlib/TdApi$ChatEventMemberJoinedByInviteLink;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventMemberJoinedByInviteLink"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x56292286


# instance fields
.field public inviteLink:Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

.field public viaChatFolderInviteLink:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23904
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23905
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatInviteLink;Z)V
    .locals 0
    .param p1, "chatInviteLink"    # Lorg/drinkless/tdlib/TdApi$ChatInviteLink;
    .param p2, "z8"    # Z

    .line 23894
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23895
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMemberJoinedByInviteLink;->inviteLink:Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

    .line 23896
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMemberJoinedByInviteLink;->viaChatFolderInviteLink:Z

    .line 23897
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23901
    const v0, -0x56292286

    return v0
.end method
