.class public Lorg/drinkless/tdlib/TdApi$ChatInviteLinkCounts;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatInviteLinkCounts"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x36db11ed


# instance fields
.field public inviteLinkCounts:[Lorg/drinkless/tdlib/TdApi$ChatInviteLinkCount;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10194
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 10195
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$ChatInviteLinkCount;)V
    .locals 0
    .param p1, "chatInviteLinkCountArr"    # [Lorg/drinkless/tdlib/TdApi$ChatInviteLinkCount;

    .line 10185
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 10186
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkCounts;->inviteLinkCounts:[Lorg/drinkless/tdlib/TdApi$ChatInviteLinkCount;

    .line 10187
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10191
    const v0, 0x36db11ed

    return v0
.end method
