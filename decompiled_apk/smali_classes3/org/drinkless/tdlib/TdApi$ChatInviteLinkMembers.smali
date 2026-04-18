.class public Lorg/drinkless/tdlib/TdApi$ChatInviteLinkMembers;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatInviteLinkMembers"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x12d0356b


# instance fields
.field public members:[Lorg/drinkless/tdlib/TdApi$ChatInviteLinkMember;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24184
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24185
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$ChatInviteLinkMember;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "chatInviteLinkMemberArr"    # [Lorg/drinkless/tdlib/TdApi$ChatInviteLinkMember;

    .line 24174
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24175
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkMembers;->totalCount:I

    .line 24176
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkMembers;->members:[Lorg/drinkless/tdlib/TdApi$ChatInviteLinkMember;

    .line 24177
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24181
    const v0, 0x12d0356b

    return v0
.end method
