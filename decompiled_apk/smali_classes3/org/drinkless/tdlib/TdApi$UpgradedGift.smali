.class public Lorg/drinkless/tdlib/TdApi$UpgradedGift;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradedGift"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3fb29acc


# instance fields
.field public backdrop:Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdrop;

.field public colors:Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;

.field public giftAddress:Ljava/lang/String;

.field public hostId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public id:J

.field public isPremium:Z

.field public isThemeAvailable:Z

.field public maxUpgradedCount:I

.field public model:Lorg/drinkless/tdlib/TdApi$UpgradedGiftModel;

.field public name:Ljava/lang/String;

.field public number:I

.field public originalDetails:Lorg/drinkless/tdlib/TdApi$UpgradedGiftOriginalDetails;

.field public ownerAddress:Ljava/lang/String;

.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public ownerName:Ljava/lang/String;

.field public publisherChatId:J

.field public regularGiftId:J

.field public resaleParameters:Lorg/drinkless/tdlib/TdApi$GiftResaleParameters;

.field public symbol:Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbol;

.field public title:Ljava/lang/String;

.field public totalUpgradedCount:I

.field public usedThemeChatId:J

.field public valueAmount:J

.field public valueCurrency:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8001
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 8002
    return-void
.end method

.method public constructor <init>(JJJLjava/lang/String;Ljava/lang/String;IIIZZJLorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$MessageSender;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$UpgradedGiftModel;Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbol;Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdrop;Lorg/drinkless/tdlib/TdApi$UpgradedGiftOriginalDetails;Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;Lorg/drinkless/tdlib/TdApi$GiftResaleParameters;Ljava/lang/String;J)V
    .locals 16
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "j10"    # J
    .param p7, "str"    # Ljava/lang/String;
    .param p8, "str2"    # Ljava/lang/String;
    .param p9, "i9"    # I
    .param p10, "i10"    # I
    .param p11, "i11"    # I
    .param p12, "z8"    # Z
    .param p13, "z9"    # Z
    .param p14, "j11"    # J
    .param p16, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p17, "messageSender2"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p18, "str3"    # Ljava/lang/String;
    .param p19, "str4"    # Ljava/lang/String;
    .param p20, "str5"    # Ljava/lang/String;
    .param p21, "upgradedGiftModel"    # Lorg/drinkless/tdlib/TdApi$UpgradedGiftModel;
    .param p22, "upgradedGiftSymbol"    # Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbol;
    .param p23, "upgradedGiftBackdrop"    # Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdrop;
    .param p24, "upgradedGiftOriginalDetails"    # Lorg/drinkless/tdlib/TdApi$UpgradedGiftOriginalDetails;
    .param p25, "upgradedGiftColors"    # Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;
    .param p26, "giftResaleParameters"    # Lorg/drinkless/tdlib/TdApi$GiftResaleParameters;
    .param p27, "str6"    # Ljava/lang/String;
    .param p28, "j12"    # J

    .line 7969
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 7970
    move-wide/from16 v1, p1

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->id:J

    .line 7971
    move-wide/from16 v3, p3

    iput-wide v3, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->regularGiftId:J

    .line 7972
    move-wide/from16 v5, p5

    iput-wide v5, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->publisherChatId:J

    .line 7973
    move-object/from16 v7, p7

    iput-object v7, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->title:Ljava/lang/String;

    .line 7974
    move-object/from16 v8, p8

    iput-object v8, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->name:Ljava/lang/String;

    .line 7975
    move/from16 v9, p9

    iput v9, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->number:I

    .line 7976
    move/from16 v10, p10

    iput v10, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->totalUpgradedCount:I

    .line 7977
    move/from16 v11, p11

    iput v11, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->maxUpgradedCount:I

    .line 7978
    move/from16 v12, p12

    iput-boolean v12, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->isPremium:Z

    .line 7979
    move/from16 v13, p13

    iput-boolean v13, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->isThemeAvailable:Z

    .line 7980
    move-wide/from16 v14, p14

    iput-wide v14, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->usedThemeChatId:J

    .line 7981
    move-object/from16 v1, p16

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->hostId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 7982
    move-object/from16 v2, p17

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 7983
    move-object/from16 v1, p18

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->ownerAddress:Ljava/lang/String;

    .line 7984
    move-object/from16 v1, p19

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->ownerName:Ljava/lang/String;

    .line 7985
    move-object/from16 v1, p20

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->giftAddress:Ljava/lang/String;

    .line 7986
    move-object/from16 v1, p21

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->model:Lorg/drinkless/tdlib/TdApi$UpgradedGiftModel;

    .line 7987
    move-object/from16 v1, p22

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->symbol:Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbol;

    .line 7988
    move-object/from16 v1, p23

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->backdrop:Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdrop;

    .line 7989
    move-object/from16 v1, p24

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->originalDetails:Lorg/drinkless/tdlib/TdApi$UpgradedGiftOriginalDetails;

    .line 7990
    move-object/from16 v1, p25

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->colors:Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;

    .line 7991
    move-object/from16 v1, p26

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->resaleParameters:Lorg/drinkless/tdlib/TdApi$GiftResaleParameters;

    .line 7992
    move-object/from16 v1, p27

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->valueCurrency:Ljava/lang/String;

    .line 7993
    move-wide/from16 v1, p28

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGift;->valueAmount:J

    .line 7994
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 7998
    const v0, -0x3fb29acc

    return v0
.end method
