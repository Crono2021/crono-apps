.class public Lorg/drinkless/tdlib/TdApi$Gift;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Gift"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x78df12e0


# instance fields
.field public defaultSellStarCount:J

.field public firstSendDate:I

.field public hasColors:Z

.field public id:J

.field public isForBirthday:Z

.field public isPremium:Z

.field public lastSendDate:I

.field public nextSendDate:I

.field public overallLimits:Lorg/drinkless/tdlib/TdApi$GiftPurchaseLimits;

.field public publisherChatId:J

.field public starCount:J

.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public upgradeStarCount:J

.field public userLimits:Lorg/drinkless/tdlib/TdApi$GiftPurchaseLimits;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 55058
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55059
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$Sticker;JJJZZZILorg/drinkless/tdlib/TdApi$GiftPurchaseLimits;Lorg/drinkless/tdlib/TdApi$GiftPurchaseLimits;II)V
    .locals 16
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p6, "j10"    # J
    .param p8, "j11"    # J
    .param p10, "j12"    # J
    .param p12, "z8"    # Z
    .param p13, "z9"    # Z
    .param p14, "z10"    # Z
    .param p15, "i9"    # I
    .param p16, "giftPurchaseLimits"    # Lorg/drinkless/tdlib/TdApi$GiftPurchaseLimits;
    .param p17, "giftPurchaseLimits2"    # Lorg/drinkless/tdlib/TdApi$GiftPurchaseLimits;
    .param p18, "i10"    # I
    .param p19, "i11"    # I

    .line 55036
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55037
    move-wide/from16 v1, p1

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$Gift;->id:J

    .line 55038
    move-wide/from16 v3, p3

    iput-wide v3, v0, Lorg/drinkless/tdlib/TdApi$Gift;->publisherChatId:J

    .line 55039
    move-object/from16 v5, p5

    iput-object v5, v0, Lorg/drinkless/tdlib/TdApi$Gift;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 55040
    move-wide/from16 v6, p6

    iput-wide v6, v0, Lorg/drinkless/tdlib/TdApi$Gift;->starCount:J

    .line 55041
    move-wide/from16 v8, p8

    iput-wide v8, v0, Lorg/drinkless/tdlib/TdApi$Gift;->defaultSellStarCount:J

    .line 55042
    move-wide/from16 v10, p10

    iput-wide v10, v0, Lorg/drinkless/tdlib/TdApi$Gift;->upgradeStarCount:J

    .line 55043
    move/from16 v12, p12

    iput-boolean v12, v0, Lorg/drinkless/tdlib/TdApi$Gift;->hasColors:Z

    .line 55044
    move/from16 v13, p13

    iput-boolean v13, v0, Lorg/drinkless/tdlib/TdApi$Gift;->isForBirthday:Z

    .line 55045
    move/from16 v14, p14

    iput-boolean v14, v0, Lorg/drinkless/tdlib/TdApi$Gift;->isPremium:Z

    .line 55046
    move/from16 v15, p15

    iput v15, v0, Lorg/drinkless/tdlib/TdApi$Gift;->nextSendDate:I

    .line 55047
    move-object/from16 v1, p16

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Gift;->userLimits:Lorg/drinkless/tdlib/TdApi$GiftPurchaseLimits;

    .line 55048
    move-object/from16 v2, p17

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$Gift;->overallLimits:Lorg/drinkless/tdlib/TdApi$GiftPurchaseLimits;

    .line 55049
    move/from16 v1, p18

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$Gift;->firstSendDate:I

    .line 55050
    move/from16 v1, p19

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$Gift;->lastSendDate:I

    .line 55051
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 55055
    const v0, -0x78df12e0

    return v0
.end method
