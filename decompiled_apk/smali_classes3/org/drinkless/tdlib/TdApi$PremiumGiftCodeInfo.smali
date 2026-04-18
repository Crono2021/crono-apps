.class public Lorg/drinkless/tdlib/TdApi$PremiumGiftCodeInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PremiumGiftCodeInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x47705722


# instance fields
.field public creationDate:I

.field public creatorId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public giveawayMessageId:J

.field public isFromGiveaway:Z

.field public monthCount:I

.field public useDate:I

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51674
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51675
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;IZJIJI)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "i9"    # I
    .param p3, "z8"    # Z
    .param p4, "j5"    # J
    .param p6, "i10"    # I
    .param p7, "j9"    # J
    .param p9, "i11"    # I

    .line 51659
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51660
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiftCodeInfo;->creatorId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 51661
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiftCodeInfo;->creationDate:I

    .line 51662
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiftCodeInfo;->isFromGiveaway:Z

    .line 51663
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiftCodeInfo;->giveawayMessageId:J

    .line 51664
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiftCodeInfo;->monthCount:I

    .line 51665
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiftCodeInfo;->userId:J

    .line 51666
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiftCodeInfo;->useDate:I

    .line 51667
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51671
    const v0, -0x47705722

    return v0
.end method
