.class public Lorg/drinkless/tdlib/TdApi$ChatFolderInviteLinks;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatFolderInviteLinks"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6e77e665


# instance fields
.field public inviteLinks:[Lorg/drinkless/tdlib/TdApi$ChatFolderInviteLink;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10176
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 10177
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$ChatFolderInviteLink;)V
    .locals 0
    .param p1, "chatFolderInviteLinkArr"    # [Lorg/drinkless/tdlib/TdApi$ChatFolderInviteLink;

    .line 10167
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 10168
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatFolderInviteLinks;->inviteLinks:[Lorg/drinkless/tdlib/TdApi$ChatFolderInviteLink;

    .line 10169
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10173
    const v0, 0x6e77e665

    return v0
.end method
