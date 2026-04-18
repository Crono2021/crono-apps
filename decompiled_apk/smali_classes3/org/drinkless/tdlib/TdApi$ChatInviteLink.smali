.class public Lorg/drinkless/tdlib/TdApi$ChatInviteLink;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatInviteLink"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x39149ad0


# instance fields
.field public createsJoinRequest:Z

.field public creatorUserId:J

.field public date:I

.field public editDate:I

.field public expirationDate:I

.field public expiredMemberCount:I

.field public inviteLink:Ljava/lang/String;

.field public isPrimary:Z

.field public isRevoked:Z

.field public memberCount:I

.field public memberLimit:I

.field public name:Ljava/lang/String;

.field public pendingJoinRequestCount:I

.field public subscriptionPricing:Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54294
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54295
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;JIIILorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;IIIIZZZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "j5"    # J
    .param p5, "i9"    # I
    .param p6, "i10"    # I
    .param p7, "i11"    # I
    .param p8, "starSubscriptionPricing"    # Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;
    .param p9, "i12"    # I
    .param p10, "i13"    # I
    .param p11, "i14"    # I
    .param p12, "i15"    # I
    .param p13, "z8"    # Z
    .param p14, "z9"    # Z
    .param p15, "z10"    # Z

    .line 54272
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54273
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLink;->inviteLink:Ljava/lang/String;

    .line 54274
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLink;->name:Ljava/lang/String;

    .line 54275
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLink;->creatorUserId:J

    .line 54276
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLink;->date:I

    .line 54277
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLink;->editDate:I

    .line 54278
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLink;->expirationDate:I

    .line 54279
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLink;->subscriptionPricing:Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;

    .line 54280
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLink;->memberLimit:I

    .line 54281
    iput p10, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLink;->memberCount:I

    .line 54282
    iput p11, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLink;->expiredMemberCount:I

    .line 54283
    iput p12, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLink;->pendingJoinRequestCount:I

    .line 54284
    iput-boolean p13, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLink;->createsJoinRequest:Z

    .line 54285
    iput-boolean p14, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLink;->isPrimary:Z

    .line 54286
    iput-boolean p15, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLink;->isRevoked:Z

    .line 54287
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54291
    const v0, -0x39149ad0

    return v0
.end method
