.class public Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatInviteLinkInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x44440d47


# instance fields
.field public accentColorId:I

.field public accessibleFor:I

.field public chatId:J

.field public createsJoinRequest:Z

.field public description:Ljava/lang/String;

.field public isPublic:Z

.field public memberCount:I

.field public memberUserIds:[J

.field public photo:Lorg/drinkless/tdlib/TdApi$ChatPhotoInfo;

.field public subscriptionInfo:Lorg/drinkless/tdlib/TdApi$ChatInviteLinkSubscriptionInfo;

.field public title:Ljava/lang/String;

.field public type:Lorg/drinkless/tdlib/TdApi$InviteLinkChatType;

.field public verificationStatus:Lorg/drinkless/tdlib/TdApi$VerificationStatus;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53910
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53911
    return-void
.end method

.method public constructor <init>(JILorg/drinkless/tdlib/TdApi$InviteLinkChatType;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$ChatPhotoInfo;ILjava/lang/String;I[JLorg/drinkless/tdlib/TdApi$ChatInviteLinkSubscriptionInfo;ZZLorg/drinkless/tdlib/TdApi$VerificationStatus;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "inviteLinkChatType"    # Lorg/drinkless/tdlib/TdApi$InviteLinkChatType;
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "chatPhotoInfo"    # Lorg/drinkless/tdlib/TdApi$ChatPhotoInfo;
    .param p7, "i10"    # I
    .param p8, "str2"    # Ljava/lang/String;
    .param p9, "i11"    # I
    .param p10, "jArr"    # [J
    .param p11, "chatInviteLinkSubscriptionInfo"    # Lorg/drinkless/tdlib/TdApi$ChatInviteLinkSubscriptionInfo;
    .param p12, "z8"    # Z
    .param p13, "z9"    # Z
    .param p14, "verificationStatus"    # Lorg/drinkless/tdlib/TdApi$VerificationStatus;

    .line 53889
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53890
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;->chatId:J

    .line 53891
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;->accessibleFor:I

    .line 53892
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;->type:Lorg/drinkless/tdlib/TdApi$InviteLinkChatType;

    .line 53893
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;->title:Ljava/lang/String;

    .line 53894
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;->photo:Lorg/drinkless/tdlib/TdApi$ChatPhotoInfo;

    .line 53895
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;->accentColorId:I

    .line 53896
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;->description:Ljava/lang/String;

    .line 53897
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;->memberCount:I

    .line 53898
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;->memberUserIds:[J

    .line 53899
    iput-object p11, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;->subscriptionInfo:Lorg/drinkless/tdlib/TdApi$ChatInviteLinkSubscriptionInfo;

    .line 53900
    iput-boolean p12, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;->createsJoinRequest:Z

    .line 53901
    iput-boolean p13, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;->isPublic:Z

    .line 53902
    iput-object p14, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;->verificationStatus:Lorg/drinkless/tdlib/TdApi$VerificationStatus;

    .line 53903
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53907
    const v0, -0x44440d47

    return v0
.end method
