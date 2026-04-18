.class public Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AttachmentMenuBot"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4691e441


# instance fields
.field public androidIcon:Lorg/drinkless/tdlib/TdApi$File;

.field public androidSideMenuIcon:Lorg/drinkless/tdlib/TdApi$File;

.field public botUserId:J

.field public defaultIcon:Lorg/drinkless/tdlib/TdApi$File;

.field public iconColor:Lorg/drinkless/tdlib/TdApi$AttachmentMenuBotColor;

.field public iosAnimatedIcon:Lorg/drinkless/tdlib/TdApi$File;

.field public iosSideMenuIcon:Lorg/drinkless/tdlib/TdApi$File;

.field public iosStaticIcon:Lorg/drinkless/tdlib/TdApi$File;

.field public isAdded:Z

.field public macosIcon:Lorg/drinkless/tdlib/TdApi$File;

.field public macosSideMenuIcon:Lorg/drinkless/tdlib/TdApi$File;

.field public name:Ljava/lang/String;

.field public nameColor:Lorg/drinkless/tdlib/TdApi$AttachmentMenuBotColor;

.field public requestWriteAccess:Z

.field public showDisclaimerInSideMenu:Z

.field public showInAttachmentMenu:Z

.field public showInSideMenu:Z

.field public supportsBotChats:Z

.field public supportsChannelChats:Z

.field public supportsGroupChats:Z

.field public supportsSelfChat:Z

.field public supportsUserChats:Z

.field public webAppPlaceholder:Lorg/drinkless/tdlib/TdApi$File;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53168
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53169
    return-void
.end method

.method public constructor <init>(JZZZZZZZZZZLjava/lang/String;Lorg/drinkless/tdlib/TdApi$AttachmentMenuBotColor;Lorg/drinkless/tdlib/TdApi$File;Lorg/drinkless/tdlib/TdApi$File;Lorg/drinkless/tdlib/TdApi$File;Lorg/drinkless/tdlib/TdApi$File;Lorg/drinkless/tdlib/TdApi$File;Lorg/drinkless/tdlib/TdApi$File;Lorg/drinkless/tdlib/TdApi$File;Lorg/drinkless/tdlib/TdApi$File;Lorg/drinkless/tdlib/TdApi$AttachmentMenuBotColor;Lorg/drinkless/tdlib/TdApi$File;)V
    .locals 16
    .param p1, "j5"    # J
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z
    .param p5, "z10"    # Z
    .param p6, "z11"    # Z
    .param p7, "z12"    # Z
    .param p8, "z13"    # Z
    .param p9, "z14"    # Z
    .param p10, "z15"    # Z
    .param p11, "z16"    # Z
    .param p12, "z17"    # Z
    .param p13, "str"    # Ljava/lang/String;
    .param p14, "attachmentMenuBotColor"    # Lorg/drinkless/tdlib/TdApi$AttachmentMenuBotColor;
    .param p15, "file"    # Lorg/drinkless/tdlib/TdApi$File;
    .param p16, "file2"    # Lorg/drinkless/tdlib/TdApi$File;
    .param p17, "file3"    # Lorg/drinkless/tdlib/TdApi$File;
    .param p18, "file4"    # Lorg/drinkless/tdlib/TdApi$File;
    .param p19, "file5"    # Lorg/drinkless/tdlib/TdApi$File;
    .param p20, "file6"    # Lorg/drinkless/tdlib/TdApi$File;
    .param p21, "file7"    # Lorg/drinkless/tdlib/TdApi$File;
    .param p22, "file8"    # Lorg/drinkless/tdlib/TdApi$File;
    .param p23, "attachmentMenuBotColor2"    # Lorg/drinkless/tdlib/TdApi$AttachmentMenuBotColor;
    .param p24, "file9"    # Lorg/drinkless/tdlib/TdApi$File;

    .line 53137
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53138
    move-wide/from16 v1, p1

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->botUserId:J

    .line 53139
    move/from16 v3, p3

    iput-boolean v3, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->supportsSelfChat:Z

    .line 53140
    move/from16 v4, p4

    iput-boolean v4, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->supportsUserChats:Z

    .line 53141
    move/from16 v5, p5

    iput-boolean v5, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->supportsBotChats:Z

    .line 53142
    move/from16 v6, p6

    iput-boolean v6, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->supportsGroupChats:Z

    .line 53143
    move/from16 v7, p7

    iput-boolean v7, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->supportsChannelChats:Z

    .line 53144
    move/from16 v8, p8

    iput-boolean v8, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->requestWriteAccess:Z

    .line 53145
    move/from16 v9, p9

    iput-boolean v9, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->isAdded:Z

    .line 53146
    move/from16 v10, p10

    iput-boolean v10, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->showInAttachmentMenu:Z

    .line 53147
    move/from16 v11, p11

    iput-boolean v11, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->showInSideMenu:Z

    .line 53148
    move/from16 v12, p12

    iput-boolean v12, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->showDisclaimerInSideMenu:Z

    .line 53149
    move-object/from16 v13, p13

    iput-object v13, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->name:Ljava/lang/String;

    .line 53150
    move-object/from16 v14, p14

    iput-object v14, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->nameColor:Lorg/drinkless/tdlib/TdApi$AttachmentMenuBotColor;

    .line 53151
    move-object/from16 v15, p15

    iput-object v15, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->defaultIcon:Lorg/drinkless/tdlib/TdApi$File;

    .line 53152
    move-object/from16 v1, p16

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->iosStaticIcon:Lorg/drinkless/tdlib/TdApi$File;

    .line 53153
    move-object/from16 v2, p17

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->iosAnimatedIcon:Lorg/drinkless/tdlib/TdApi$File;

    .line 53154
    move-object/from16 v1, p18

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->iosSideMenuIcon:Lorg/drinkless/tdlib/TdApi$File;

    .line 53155
    move-object/from16 v1, p19

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->androidIcon:Lorg/drinkless/tdlib/TdApi$File;

    .line 53156
    move-object/from16 v1, p20

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->androidSideMenuIcon:Lorg/drinkless/tdlib/TdApi$File;

    .line 53157
    move-object/from16 v1, p21

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->macosIcon:Lorg/drinkless/tdlib/TdApi$File;

    .line 53158
    move-object/from16 v1, p22

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->macosSideMenuIcon:Lorg/drinkless/tdlib/TdApi$File;

    .line 53159
    move-object/from16 v1, p23

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->iconColor:Lorg/drinkless/tdlib/TdApi$AttachmentMenuBotColor;

    .line 53160
    move-object/from16 v1, p24

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;->webAppPlaceholder:Lorg/drinkless/tdlib/TdApi$File;

    .line 53161
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53165
    const v0, -0x4691e441

    return v0
.end method
