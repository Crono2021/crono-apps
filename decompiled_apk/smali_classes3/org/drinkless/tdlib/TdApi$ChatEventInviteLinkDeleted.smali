.class public Lorg/drinkless/tdlib/TdApi$ChatEventInviteLinkDeleted;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventInviteLinkDeleted"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x53259e99


# instance fields
.field public inviteLink:Lorg/drinkless/tdlib/TdApi$ChatInviteLink;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9906
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9907
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatInviteLink;)V
    .locals 0
    .param p1, "chatInviteLink"    # Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

    .line 9897
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9898
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventInviteLinkDeleted;->inviteLink:Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

    .line 9899
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9903
    const v0, -0x53259e99

    return v0
.end method
