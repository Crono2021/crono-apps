.class public Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ScopeNotificationSettings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x54467fe


# instance fields
.field public disableMentionNotifications:Z

.field public disablePinnedMessageNotifications:Z

.field public muteFor:I

.field public muteStories:Z

.field public showPreview:Z

.field public showStoryPoster:Z

.field public soundId:J

.field public storySoundId:J

.field public useDefaultMuteStories:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53038
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53039
    return-void
.end method

.method public constructor <init>(IJZZZJZZZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J
    .param p4, "z8"    # Z
    .param p5, "z9"    # Z
    .param p6, "z10"    # Z
    .param p7, "j9"    # J
    .param p9, "z11"    # Z
    .param p10, "z12"    # Z
    .param p11, "z13"    # Z

    .line 53021
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53022
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;->muteFor:I

    .line 53023
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;->soundId:J

    .line 53024
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;->showPreview:Z

    .line 53025
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;->useDefaultMuteStories:Z

    .line 53026
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;->muteStories:Z

    .line 53027
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;->storySoundId:J

    .line 53028
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;->showStoryPoster:Z

    .line 53029
    iput-boolean p10, p0, Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;->disablePinnedMessageNotifications:Z

    .line 53030
    iput-boolean p11, p0, Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;->disableMentionNotifications:Z

    .line 53031
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53035
    const v0, 0x54467fe

    return v0
.end method
