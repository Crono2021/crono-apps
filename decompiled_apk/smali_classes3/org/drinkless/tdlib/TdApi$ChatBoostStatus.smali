.class public Lorg/drinkless/tdlib/TdApi$ChatBoostStatus;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatBoostStatus"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3e9acdca


# instance fields
.field public appliedSlotIds:[I

.field public boostCount:I

.field public boostUrl:Ljava/lang/String;

.field public currentLevelBoostCount:I

.field public giftCodeBoostCount:I

.field public level:I

.field public nextLevelBoostCount:I

.field public premiumMemberCount:I

.field public premiumMemberPercentage:D

.field public prepaidGiveaways:[Lorg/drinkless/tdlib/TdApi$PrepaidGiveaway;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53240
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53241
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[IIIIIIID[Lorg/drinkless/tdlib/TdApi$PrepaidGiveaway;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "iArr"    # [I
    .param p3, "i9"    # I
    .param p4, "i10"    # I
    .param p5, "i11"    # I
    .param p6, "i12"    # I
    .param p7, "i13"    # I
    .param p8, "i14"    # I
    .param p9, "d9"    # D
    .param p11, "prepaidGiveawayArr"    # [Lorg/drinkless/tdlib/TdApi$PrepaidGiveaway;

    .line 53222
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53223
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostStatus;->boostUrl:Ljava/lang/String;

    .line 53224
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostStatus;->appliedSlotIds:[I

    .line 53225
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostStatus;->level:I

    .line 53226
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostStatus;->giftCodeBoostCount:I

    .line 53227
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostStatus;->boostCount:I

    .line 53228
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostStatus;->currentLevelBoostCount:I

    .line 53229
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostStatus;->nextLevelBoostCount:I

    .line 53230
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostStatus;->premiumMemberCount:I

    .line 53231
    iput-wide p9, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostStatus;->premiumMemberPercentage:D

    .line 53232
    iput-object p11, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostStatus;->prepaidGiveaways:[Lorg/drinkless/tdlib/TdApi$PrepaidGiveaway;

    .line 53233
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53237
    const v0, -0x3e9acdca

    return v0
.end method
