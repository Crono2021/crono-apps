.class public Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatNotificationSettings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x56feb816


# instance fields
.field public disableMentionNotifications:Z

.field public disablePinnedMessageNotifications:Z

.field public muteFor:I

.field public muteStories:Z

.field public showPreview:Z

.field public showStoryPoster:Z

.field public soundId:J

.field public storySoundId:J

.field public useDefaultDisableMentionNotifications:Z

.field public useDefaultDisablePinnedMessageNotifications:Z

.field public useDefaultMuteFor:Z

.field public useDefaultMuteStories:Z

.field public useDefaultShowPreview:Z

.field public useDefaultShowStoryPoster:Z

.field public useDefaultSound:Z

.field public useDefaultStorySound:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 55150
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55151
    return-void
.end method

.method public constructor <init>(ZIZJZZZZZJZZZZZZ)V
    .locals 16
    .param p1, "z8"    # Z
    .param p2, "i9"    # I
    .param p3, "z9"    # Z
    .param p4, "j5"    # J
    .param p6, "z10"    # Z
    .param p7, "z11"    # Z
    .param p8, "z12"    # Z
    .param p9, "z13"    # Z
    .param p10, "z14"    # Z
    .param p11, "j9"    # J
    .param p13, "z15"    # Z
    .param p14, "z16"    # Z
    .param p15, "z17"    # Z
    .param p16, "z18"    # Z
    .param p17, "z19"    # Z
    .param p18, "z20"    # Z

    .line 55126
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55127
    move/from16 v1, p1

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;->useDefaultMuteFor:Z

    .line 55128
    move/from16 v2, p2

    iput v2, v0, Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;->muteFor:I

    .line 55129
    move/from16 v3, p3

    iput-boolean v3, v0, Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;->useDefaultSound:Z

    .line 55130
    move-wide/from16 v4, p4

    iput-wide v4, v0, Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;->soundId:J

    .line 55131
    move/from16 v6, p6

    iput-boolean v6, v0, Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;->useDefaultShowPreview:Z

    .line 55132
    move/from16 v7, p7

    iput-boolean v7, v0, Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;->showPreview:Z

    .line 55133
    move/from16 v8, p8

    iput-boolean v8, v0, Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;->useDefaultMuteStories:Z

    .line 55134
    move/from16 v9, p9

    iput-boolean v9, v0, Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;->muteStories:Z

    .line 55135
    move/from16 v10, p10

    iput-boolean v10, v0, Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;->useDefaultStorySound:Z

    .line 55136
    move-wide/from16 v11, p11

    iput-wide v11, v0, Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;->storySoundId:J

    .line 55137
    move/from16 v13, p13

    iput-boolean v13, v0, Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;->useDefaultShowStoryPoster:Z

    .line 55138
    move/from16 v14, p14

    iput-boolean v14, v0, Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;->showStoryPoster:Z

    .line 55139
    move/from16 v15, p15

    iput-boolean v15, v0, Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;->useDefaultDisablePinnedMessageNotifications:Z

    .line 55140
    move/from16 v1, p16

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;->disablePinnedMessageNotifications:Z

    .line 55141
    move/from16 v1, p17

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;->useDefaultDisableMentionNotifications:Z

    .line 55142
    move/from16 v1, p18

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;->disableMentionNotifications:Z

    .line 55143
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 55147
    const v0, 0x56feb816

    return v0
.end method
