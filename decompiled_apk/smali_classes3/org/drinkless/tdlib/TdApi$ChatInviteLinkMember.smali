.class public Lorg/drinkless/tdlib/TdApi$ChatInviteLinkMember;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatInviteLinkMember"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1bce5bb


# instance fields
.field public approverUserId:J

.field public joinedChatDate:I

.field public userId:J

.field public viaChatFolderInviteLink:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42750
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42751
    return-void
.end method

.method public constructor <init>(JIZJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "z8"    # Z
    .param p5, "j9"    # J

    .line 42738
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42739
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkMember;->userId:J

    .line 42740
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkMember;->joinedChatDate:I

    .line 42741
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkMember;->viaChatFolderInviteLink:Z

    .line 42742
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkMember;->approverUserId:J

    .line 42743
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42747
    const v0, 0x1bce5bb

    return v0
.end method
