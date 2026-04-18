.class public Lorg/drinkless/tdlib/TdApi$ChatPermissions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatPermissions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x70da587


# instance fields
.field public canAddLinkPreviews:Z

.field public canChangeInfo:Z

.field public canCreateTopics:Z

.field public canInviteUsers:Z

.field public canPinMessages:Z

.field public canSendAudios:Z

.field public canSendBasicMessages:Z

.field public canSendDocuments:Z

.field public canSendOtherMessages:Z

.field public canSendPhotos:Z

.field public canSendPolls:Z

.field public canSendVideoNotes:Z

.field public canSendVideos:Z

.field public canSendVoiceNotes:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54338
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54339
    return-void
.end method

.method public constructor <init>(ZZZZZZZZZZZZZZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z
    .param p3, "z10"    # Z
    .param p4, "z11"    # Z
    .param p5, "z12"    # Z
    .param p6, "z13"    # Z
    .param p7, "z14"    # Z
    .param p8, "z15"    # Z
    .param p9, "z16"    # Z
    .param p10, "z17"    # Z
    .param p11, "z18"    # Z
    .param p12, "z19"    # Z
    .param p13, "z20"    # Z
    .param p14, "z21"    # Z

    .line 54316
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54317
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ChatPermissions;->canSendBasicMessages:Z

    .line 54318
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ChatPermissions;->canSendAudios:Z

    .line 54319
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ChatPermissions;->canSendDocuments:Z

    .line 54320
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ChatPermissions;->canSendPhotos:Z

    .line 54321
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$ChatPermissions;->canSendVideos:Z

    .line 54322
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$ChatPermissions;->canSendVideoNotes:Z

    .line 54323
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$ChatPermissions;->canSendVoiceNotes:Z

    .line 54324
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$ChatPermissions;->canSendPolls:Z

    .line 54325
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$ChatPermissions;->canSendOtherMessages:Z

    .line 54326
    iput-boolean p10, p0, Lorg/drinkless/tdlib/TdApi$ChatPermissions;->canAddLinkPreviews:Z

    .line 54327
    iput-boolean p11, p0, Lorg/drinkless/tdlib/TdApi$ChatPermissions;->canChangeInfo:Z

    .line 54328
    iput-boolean p12, p0, Lorg/drinkless/tdlib/TdApi$ChatPermissions;->canInviteUsers:Z

    .line 54329
    iput-boolean p13, p0, Lorg/drinkless/tdlib/TdApi$ChatPermissions;->canPinMessages:Z

    .line 54330
    iput-boolean p14, p0, Lorg/drinkless/tdlib/TdApi$ChatPermissions;->canCreateTopics:Z

    .line 54331
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54335
    const v0, -0x70da587

    return v0
.end method
