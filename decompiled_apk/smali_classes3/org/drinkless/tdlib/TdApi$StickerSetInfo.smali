.class public Lorg/drinkless/tdlib/TdApi$StickerSetInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StickerSetInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x624ae229


# instance fields
.field public covers:[Lorg/drinkless/tdlib/TdApi$Sticker;

.field public id:J

.field public isAllowedAsChatEmojiStatus:Z

.field public isArchived:Z

.field public isInstalled:Z

.field public isOfficial:Z

.field public isOwned:Z

.field public isViewed:Z

.field public name:Ljava/lang/String;

.field public needsRepainting:Z

.field public size:I

.field public stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

.field public thumbnailOutline:Lorg/drinkless/tdlib/TdApi$Outline;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54828
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54829
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Thumbnail;Lorg/drinkless/tdlib/TdApi$Outline;ZZZZLorg/drinkless/tdlib/TdApi$StickerType;ZZZI[Lorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 16
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;
    .param p5, "thumbnail"    # Lorg/drinkless/tdlib/TdApi$Thumbnail;
    .param p6, "outline"    # Lorg/drinkless/tdlib/TdApi$Outline;
    .param p7, "z8"    # Z
    .param p8, "z9"    # Z
    .param p9, "z10"    # Z
    .param p10, "z11"    # Z
    .param p11, "stickerType"    # Lorg/drinkless/tdlib/TdApi$StickerType;
    .param p12, "z12"    # Z
    .param p13, "z13"    # Z
    .param p14, "z14"    # Z
    .param p15, "i9"    # I
    .param p16, "stickerArr"    # [Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 54805
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54806
    move-wide/from16 v1, p1

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$StickerSetInfo;->id:J

    .line 54807
    move-object/from16 v3, p3

    iput-object v3, v0, Lorg/drinkless/tdlib/TdApi$StickerSetInfo;->title:Ljava/lang/String;

    .line 54808
    move-object/from16 v4, p4

    iput-object v4, v0, Lorg/drinkless/tdlib/TdApi$StickerSetInfo;->name:Ljava/lang/String;

    .line 54809
    move-object/from16 v5, p5

    iput-object v5, v0, Lorg/drinkless/tdlib/TdApi$StickerSetInfo;->thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

    .line 54810
    move-object/from16 v6, p6

    iput-object v6, v0, Lorg/drinkless/tdlib/TdApi$StickerSetInfo;->thumbnailOutline:Lorg/drinkless/tdlib/TdApi$Outline;

    .line 54811
    move/from16 v7, p7

    iput-boolean v7, v0, Lorg/drinkless/tdlib/TdApi$StickerSetInfo;->isOwned:Z

    .line 54812
    move/from16 v8, p8

    iput-boolean v8, v0, Lorg/drinkless/tdlib/TdApi$StickerSetInfo;->isInstalled:Z

    .line 54813
    move/from16 v9, p9

    iput-boolean v9, v0, Lorg/drinkless/tdlib/TdApi$StickerSetInfo;->isArchived:Z

    .line 54814
    move/from16 v10, p10

    iput-boolean v10, v0, Lorg/drinkless/tdlib/TdApi$StickerSetInfo;->isOfficial:Z

    .line 54815
    move-object/from16 v11, p11

    iput-object v11, v0, Lorg/drinkless/tdlib/TdApi$StickerSetInfo;->stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;

    .line 54816
    move/from16 v12, p12

    iput-boolean v12, v0, Lorg/drinkless/tdlib/TdApi$StickerSetInfo;->needsRepainting:Z

    .line 54817
    move/from16 v13, p13

    iput-boolean v13, v0, Lorg/drinkless/tdlib/TdApi$StickerSetInfo;->isAllowedAsChatEmojiStatus:Z

    .line 54818
    move/from16 v14, p14

    iput-boolean v14, v0, Lorg/drinkless/tdlib/TdApi$StickerSetInfo;->isViewed:Z

    .line 54819
    move/from16 v15, p15

    iput v15, v0, Lorg/drinkless/tdlib/TdApi$StickerSetInfo;->size:I

    .line 54820
    move-object/from16 v1, p16

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$StickerSetInfo;->covers:[Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 54821
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54825
    const v0, -0x624ae229

    return v0
.end method
