.class public Lorg/drinkless/tdlib/TdApi$UpgradedGiftValueInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradedGiftValueInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x671bd6ad


# instance fields
.field public averageSalePrice:J

.field public currency:Ljava/lang/String;

.field public fragmentListedGiftCount:I

.field public fragmentUrl:Ljava/lang/String;

.field public initialSaleDate:I

.field public initialSalePrice:J

.field public initialSaleStarCount:J

.field public isLastSaleOnFragment:Z

.field public isValueAverage:Z

.field public lastSaleDate:I

.field public lastSalePrice:J

.field public minimumPrice:J

.field public telegramListedGiftCount:I

.field public value:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 55102
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55103
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JZIJJIJZJJIILjava/lang/String;)V
    .locals 16
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "z8"    # Z
    .param p5, "i9"    # I
    .param p6, "j9"    # J
    .param p8, "j10"    # J
    .param p10, "i10"    # I
    .param p11, "j11"    # J
    .param p13, "z9"    # Z
    .param p14, "j12"    # J
    .param p16, "j13"    # J
    .param p18, "i11"    # I
    .param p19, "i12"    # I
    .param p20, "str2"    # Ljava/lang/String;

    .line 55080
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55081
    move-object/from16 v1, p1

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftValueInfo;->currency:Ljava/lang/String;

    .line 55082
    move-wide/from16 v2, p2

    iput-wide v2, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftValueInfo;->value:J

    .line 55083
    move/from16 v4, p4

    iput-boolean v4, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftValueInfo;->isValueAverage:Z

    .line 55084
    move/from16 v5, p5

    iput v5, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftValueInfo;->initialSaleDate:I

    .line 55085
    move-wide/from16 v6, p6

    iput-wide v6, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftValueInfo;->initialSaleStarCount:J

    .line 55086
    move-wide/from16 v8, p8

    iput-wide v8, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftValueInfo;->initialSalePrice:J

    .line 55087
    move/from16 v10, p10

    iput v10, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftValueInfo;->lastSaleDate:I

    .line 55088
    move-wide/from16 v11, p11

    iput-wide v11, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftValueInfo;->lastSalePrice:J

    .line 55089
    move/from16 v13, p13

    iput-boolean v13, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftValueInfo;->isLastSaleOnFragment:Z

    .line 55090
    move-wide/from16 v14, p14

    iput-wide v14, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftValueInfo;->minimumPrice:J

    .line 55091
    move-wide/from16 v1, p16

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftValueInfo;->averageSalePrice:J

    .line 55092
    move/from16 v3, p18

    iput v3, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftValueInfo;->telegramListedGiftCount:I

    .line 55093
    move/from16 v1, p19

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftValueInfo;->fragmentListedGiftCount:I

    .line 55094
    move-object/from16 v2, p20

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftValueInfo;->fragmentUrl:Ljava/lang/String;

    .line 55095
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 55099
    const v0, -0x671bd6ad

    return v0
.end method
