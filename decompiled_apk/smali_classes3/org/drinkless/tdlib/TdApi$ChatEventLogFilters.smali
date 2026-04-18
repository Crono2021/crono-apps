.class public Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventLogFilters"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3d91ce4f


# instance fields
.field public forumChanges:Z

.field public infoChanges:Z

.field public inviteLinkChanges:Z

.field public memberInvites:Z

.field public memberJoins:Z

.field public memberLeaves:Z

.field public memberPromotions:Z

.field public memberRestrictions:Z

.field public messageDeletions:Z

.field public messageEdits:Z

.field public messagePins:Z

.field public settingChanges:Z

.field public subscriptionExtensions:Z

.field public videoChatChanges:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54250
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54251
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

    .line 54228
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54229
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;->messageEdits:Z

    .line 54230
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;->messageDeletions:Z

    .line 54231
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;->messagePins:Z

    .line 54232
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;->memberJoins:Z

    .line 54233
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;->memberLeaves:Z

    .line 54234
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;->memberInvites:Z

    .line 54235
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;->memberPromotions:Z

    .line 54236
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;->memberRestrictions:Z

    .line 54237
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;->infoChanges:Z

    .line 54238
    iput-boolean p10, p0, Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;->settingChanges:Z

    .line 54239
    iput-boolean p11, p0, Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;->inviteLinkChanges:Z

    .line 54240
    iput-boolean p12, p0, Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;->videoChatChanges:Z

    .line 54241
    iput-boolean p13, p0, Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;->forumChanges:Z

    .line 54242
    iput-boolean p14, p0, Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;->subscriptionExtensions:Z

    .line 54243
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54247
    const v0, -0x3d91ce4f

    return v0
.end method
