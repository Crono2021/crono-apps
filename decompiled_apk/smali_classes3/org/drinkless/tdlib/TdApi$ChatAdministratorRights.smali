.class public Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatAdministratorRights"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x441ef876


# instance fields
.field public canChangeInfo:Z

.field public canDeleteMessages:Z

.field public canDeleteStories:Z

.field public canEditMessages:Z

.field public canEditStories:Z

.field public canInviteUsers:Z

.field public canManageChat:Z

.field public canManageDirectMessages:Z

.field public canManageTopics:Z

.field public canManageVideoChats:Z

.field public canPinMessages:Z

.field public canPostMessages:Z

.field public canPostStories:Z

.field public canPromoteMembers:Z

.field public canRestrictMembers:Z

.field public isAnonymous:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54876
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54877
    return-void
.end method

.method public constructor <init>(ZZZZZZZZZZZZZZZZ)V
    .locals 16
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
    .param p15, "z22"    # Z
    .param p16, "z23"    # Z

    .line 54852
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54853
    move/from16 v1, p1

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;->canManageChat:Z

    .line 54854
    move/from16 v2, p2

    iput-boolean v2, v0, Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;->canChangeInfo:Z

    .line 54855
    move/from16 v3, p3

    iput-boolean v3, v0, Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;->canPostMessages:Z

    .line 54856
    move/from16 v4, p4

    iput-boolean v4, v0, Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;->canEditMessages:Z

    .line 54857
    move/from16 v5, p5

    iput-boolean v5, v0, Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;->canDeleteMessages:Z

    .line 54858
    move/from16 v6, p6

    iput-boolean v6, v0, Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;->canInviteUsers:Z

    .line 54859
    move/from16 v7, p7

    iput-boolean v7, v0, Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;->canRestrictMembers:Z

    .line 54860
    move/from16 v8, p8

    iput-boolean v8, v0, Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;->canPinMessages:Z

    .line 54861
    move/from16 v9, p9

    iput-boolean v9, v0, Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;->canManageTopics:Z

    .line 54862
    move/from16 v10, p10

    iput-boolean v10, v0, Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;->canPromoteMembers:Z

    .line 54863
    move/from16 v11, p11

    iput-boolean v11, v0, Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;->canManageVideoChats:Z

    .line 54864
    move/from16 v12, p12

    iput-boolean v12, v0, Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;->canPostStories:Z

    .line 54865
    move/from16 v13, p13

    iput-boolean v13, v0, Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;->canEditStories:Z

    .line 54866
    move/from16 v14, p14

    iput-boolean v14, v0, Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;->canDeleteStories:Z

    .line 54867
    move/from16 v15, p15

    iput-boolean v15, v0, Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;->canManageDirectMessages:Z

    .line 54868
    move/from16 v1, p16

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;->isAnonymous:Z

    .line 54869
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54873
    const v0, -0x441ef876

    return v0
.end method
