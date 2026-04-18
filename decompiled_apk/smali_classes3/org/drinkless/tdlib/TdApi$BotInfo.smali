.class public Lorg/drinkless/tdlib/TdApi$BotInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BotInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x699cd6c0


# instance fields
.field public affiliateProgram:Lorg/drinkless/tdlib/TdApi$AffiliateProgramInfo;

.field public animation:Lorg/drinkless/tdlib/TdApi$Animation;

.field public canGetRevenueStatistics:Z

.field public canManageEmojiStatus:Z

.field public commands:[Lorg/drinkless/tdlib/TdApi$BotCommand;

.field public defaultChannelAdministratorRights:Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;

.field public defaultGroupAdministratorRights:Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;

.field public description:Ljava/lang/String;

.field public editCommandsLink:Lorg/drinkless/tdlib/TdApi$InternalLinkType;

.field public editDescriptionLink:Lorg/drinkless/tdlib/TdApi$InternalLinkType;

.field public editDescriptionMediaLink:Lorg/drinkless/tdlib/TdApi$InternalLinkType;

.field public editSettingsLink:Lorg/drinkless/tdlib/TdApi$InternalLinkType;

.field public hasMediaPreviews:Z

.field public menuButton:Lorg/drinkless/tdlib/TdApi$BotMenuButton;

.field public photo:Lorg/drinkless/tdlib/TdApi$Photo;

.field public privacyPolicyUrl:Ljava/lang/String;

.field public shortDescription:Ljava/lang/String;

.field public verificationParameters:Lorg/drinkless/tdlib/TdApi$BotVerificationParameters;

.field public webAppBackgroundDarkColor:I

.field public webAppBackgroundLightColor:I

.field public webAppHeaderDarkColor:I

.field public webAppHeaderLightColor:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 55522
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55523
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Photo;Lorg/drinkless/tdlib/TdApi$Animation;Lorg/drinkless/tdlib/TdApi$BotMenuButton;[Lorg/drinkless/tdlib/TdApi$BotCommand;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;Lorg/drinkless/tdlib/TdApi$AffiliateProgramInfo;IIIILorg/drinkless/tdlib/TdApi$BotVerificationParameters;ZZZLorg/drinkless/tdlib/TdApi$InternalLinkType;Lorg/drinkless/tdlib/TdApi$InternalLinkType;Lorg/drinkless/tdlib/TdApi$InternalLinkType;Lorg/drinkless/tdlib/TdApi$InternalLinkType;)V
    .locals 16
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;
    .param p4, "animation"    # Lorg/drinkless/tdlib/TdApi$Animation;
    .param p5, "botMenuButton"    # Lorg/drinkless/tdlib/TdApi$BotMenuButton;
    .param p6, "botCommandArr"    # [Lorg/drinkless/tdlib/TdApi$BotCommand;
    .param p7, "str3"    # Ljava/lang/String;
    .param p8, "chatAdministratorRights"    # Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;
    .param p9, "chatAdministratorRights2"    # Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;
    .param p10, "affiliateProgramInfo"    # Lorg/drinkless/tdlib/TdApi$AffiliateProgramInfo;
    .param p11, "i9"    # I
    .param p12, "i10"    # I
    .param p13, "i11"    # I
    .param p14, "i12"    # I
    .param p15, "botVerificationParameters"    # Lorg/drinkless/tdlib/TdApi$BotVerificationParameters;
    .param p16, "z8"    # Z
    .param p17, "z9"    # Z
    .param p18, "z10"    # Z
    .param p19, "internalLinkType"    # Lorg/drinkless/tdlib/TdApi$InternalLinkType;
    .param p20, "internalLinkType2"    # Lorg/drinkless/tdlib/TdApi$InternalLinkType;
    .param p21, "internalLinkType3"    # Lorg/drinkless/tdlib/TdApi$InternalLinkType;
    .param p22, "internalLinkType4"    # Lorg/drinkless/tdlib/TdApi$InternalLinkType;

    .line 55492
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55493
    move-object/from16 v1, p1

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->shortDescription:Ljava/lang/String;

    .line 55494
    move-object/from16 v2, p2

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->description:Ljava/lang/String;

    .line 55495
    move-object/from16 v3, p3

    iput-object v3, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->photo:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 55496
    move-object/from16 v4, p4

    iput-object v4, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->animation:Lorg/drinkless/tdlib/TdApi$Animation;

    .line 55497
    move-object/from16 v5, p5

    iput-object v5, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->menuButton:Lorg/drinkless/tdlib/TdApi$BotMenuButton;

    .line 55498
    move-object/from16 v6, p6

    iput-object v6, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->commands:[Lorg/drinkless/tdlib/TdApi$BotCommand;

    .line 55499
    move-object/from16 v7, p7

    iput-object v7, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->privacyPolicyUrl:Ljava/lang/String;

    .line 55500
    move-object/from16 v8, p8

    iput-object v8, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->defaultGroupAdministratorRights:Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;

    .line 55501
    move-object/from16 v9, p9

    iput-object v9, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->defaultChannelAdministratorRights:Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;

    .line 55502
    move-object/from16 v10, p10

    iput-object v10, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->affiliateProgram:Lorg/drinkless/tdlib/TdApi$AffiliateProgramInfo;

    .line 55503
    move/from16 v11, p11

    iput v11, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->webAppBackgroundLightColor:I

    .line 55504
    move/from16 v12, p12

    iput v12, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->webAppBackgroundDarkColor:I

    .line 55505
    move/from16 v13, p13

    iput v13, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->webAppHeaderLightColor:I

    .line 55506
    move/from16 v14, p14

    iput v14, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->webAppHeaderDarkColor:I

    .line 55507
    move-object/from16 v15, p15

    iput-object v15, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->verificationParameters:Lorg/drinkless/tdlib/TdApi$BotVerificationParameters;

    .line 55508
    move/from16 v1, p16

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->canGetRevenueStatistics:Z

    .line 55509
    move/from16 v1, p17

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->canManageEmojiStatus:Z

    .line 55510
    move/from16 v1, p18

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->hasMediaPreviews:Z

    .line 55511
    move-object/from16 v1, p19

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->editCommandsLink:Lorg/drinkless/tdlib/TdApi$InternalLinkType;

    .line 55512
    move-object/from16 v1, p20

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->editDescriptionLink:Lorg/drinkless/tdlib/TdApi$InternalLinkType;

    .line 55513
    move-object/from16 v1, p21

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->editDescriptionMediaLink:Lorg/drinkless/tdlib/TdApi$InternalLinkType;

    .line 55514
    move-object/from16 v1, p22

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$BotInfo;->editSettingsLink:Lorg/drinkless/tdlib/TdApi$InternalLinkType;

    .line 55515
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 55519
    const v0, 0x699cd6c0

    return v0
.end method
