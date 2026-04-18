.class public Lorg/drinkless/tdlib/TdApi$ChatInviteLinks;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatInviteLinks"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6ba9623


# instance fields
.field public inviteLinks:[Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24204
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24205
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$ChatInviteLink;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "chatInviteLinkArr"    # [Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

    .line 24194
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24195
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinks;->totalCount:I

    .line 24196
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinks;->inviteLinks:[Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

    .line 24197
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24201
    const v0, 0x6ba9623

    return v0
.end method
