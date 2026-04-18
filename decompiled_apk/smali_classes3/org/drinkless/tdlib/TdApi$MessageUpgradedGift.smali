.class public Lorg/drinkless/tdlib/TdApi$MessageUpgradedGift;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageUpgradedGift"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x78334287


# instance fields
.field public canBeTransferred:Z

.field public dropOriginalDetailsStarCount:J

.field public exportDate:I

.field public gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

.field public isSaved:Z

.field public nextResaleDate:I

.field public nextTransferDate:I

.field public origin:Lorg/drinkless/tdlib/TdApi$UpgradedGiftOrigin;

.field public receivedGiftId:Ljava/lang/String;

.field public receiverId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public transferStarCount:J

.field public wasTransferred:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54162
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 54163
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$UpgradedGift;Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$UpgradedGiftOrigin;Ljava/lang/String;ZZZJJIII)V
    .locals 0
    .param p1, "upgradedGift"    # Lorg/drinkless/tdlib/TdApi$UpgradedGift;
    .param p2, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p3, "messageSender2"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p4, "upgradedGiftOrigin"    # Lorg/drinkless/tdlib/TdApi$UpgradedGiftOrigin;
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "z8"    # Z
    .param p7, "z9"    # Z
    .param p8, "z10"    # Z
    .param p9, "j5"    # J
    .param p11, "j9"    # J
    .param p13, "i9"    # I
    .param p14, "i10"    # I
    .param p15, "i11"    # I

    .line 54141
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 54142
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageUpgradedGift;->gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 54143
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageUpgradedGift;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 54144
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$MessageUpgradedGift;->receiverId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 54145
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$MessageUpgradedGift;->origin:Lorg/drinkless/tdlib/TdApi$UpgradedGiftOrigin;

    .line 54146
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$MessageUpgradedGift;->receivedGiftId:Ljava/lang/String;

    .line 54147
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$MessageUpgradedGift;->isSaved:Z

    .line 54148
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$MessageUpgradedGift;->canBeTransferred:Z

    .line 54149
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$MessageUpgradedGift;->wasTransferred:Z

    .line 54150
    iput-wide p9, p0, Lorg/drinkless/tdlib/TdApi$MessageUpgradedGift;->transferStarCount:J

    .line 54151
    iput-wide p11, p0, Lorg/drinkless/tdlib/TdApi$MessageUpgradedGift;->dropOriginalDetailsStarCount:J

    .line 54152
    iput p13, p0, Lorg/drinkless/tdlib/TdApi$MessageUpgradedGift;->nextTransferDate:I

    .line 54153
    iput p14, p0, Lorg/drinkless/tdlib/TdApi$MessageUpgradedGift;->nextResaleDate:I

    .line 54154
    iput p15, p0, Lorg/drinkless/tdlib/TdApi$MessageUpgradedGift;->exportDate:I

    .line 54155
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54159
    const v0, 0x78334287

    return v0
.end method
