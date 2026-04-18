.class public Lorg/drinkless/tdlib/TdApi$ChatEventMemberJoinedByRequest;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventMemberJoinedByRequest"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x623781c1


# instance fields
.field public approverUserId:J

.field public inviteLink:Lorg/drinkless/tdlib/TdApi$ChatInviteLink;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23924
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23925
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatInviteLink;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatInviteLink"    # Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

    .line 23914
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23915
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMemberJoinedByRequest;->approverUserId:J

    .line 23916
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMemberJoinedByRequest;->inviteLink:Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

    .line 23917
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23921
    const v0, -0x623781c1

    return v0
.end method
