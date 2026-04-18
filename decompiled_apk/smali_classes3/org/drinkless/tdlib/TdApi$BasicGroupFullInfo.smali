.class public Lorg/drinkless/tdlib/TdApi$BasicGroupFullInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BasicGroupFullInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6fffce80


# instance fields
.field public botCommands:[Lorg/drinkless/tdlib/TdApi$BotCommands;

.field public canHideMembers:Z

.field public canToggleAggressiveAntiSpam:Z

.field public creatorUserId:J

.field public description:Ljava/lang/String;

.field public inviteLink:Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

.field public members:[Lorg/drinkless/tdlib/TdApi$ChatMember;

.field public photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51916
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51917
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatPhoto;Ljava/lang/String;J[Lorg/drinkless/tdlib/TdApi$ChatMember;ZZLorg/drinkless/tdlib/TdApi$ChatInviteLink;[Lorg/drinkless/tdlib/TdApi$BotCommands;)V
    .locals 0
    .param p1, "chatPhoto"    # Lorg/drinkless/tdlib/TdApi$ChatPhoto;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "j5"    # J
    .param p5, "chatMemberArr"    # [Lorg/drinkless/tdlib/TdApi$ChatMember;
    .param p6, "z8"    # Z
    .param p7, "z9"    # Z
    .param p8, "chatInviteLink"    # Lorg/drinkless/tdlib/TdApi$ChatInviteLink;
    .param p9, "botCommandsArr"    # [Lorg/drinkless/tdlib/TdApi$BotCommands;

    .line 51900
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51901
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BasicGroupFullInfo;->photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 51902
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$BasicGroupFullInfo;->description:Ljava/lang/String;

    .line 51903
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$BasicGroupFullInfo;->creatorUserId:J

    .line 51904
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$BasicGroupFullInfo;->members:[Lorg/drinkless/tdlib/TdApi$ChatMember;

    .line 51905
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$BasicGroupFullInfo;->canHideMembers:Z

    .line 51906
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$BasicGroupFullInfo;->canToggleAggressiveAntiSpam:Z

    .line 51907
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$BasicGroupFullInfo;->inviteLink:Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

    .line 51908
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$BasicGroupFullInfo;->botCommands:[Lorg/drinkless/tdlib/TdApi$BotCommands;

    .line 51909
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51913
    const v0, -0x6fffce80

    return v0
.end method
