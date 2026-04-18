.class public Lorg/drinkless/tdlib/TdApi$StickerSet;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StickerSet"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6a48b682


# instance fields
.field public emojis:[Lorg/drinkless/tdlib/TdApi$Emojis;

.field public id:J

.field public isAllowedAsChatEmojiStatus:Z

.field public isArchived:Z

.field public isInstalled:Z

.field public isOfficial:Z

.field public isOwned:Z

.field public isViewed:Z

.field public name:Ljava/lang/String;

.field public needsRepainting:Z

.field public stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;

.field public stickers:[Lorg/drinkless/tdlib/TdApi$Sticker;

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

.field public thumbnailOutline:Lorg/drinkless/tdlib/TdApi$Outline;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54782
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54783
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Thumbnail;Lorg/drinkless/tdlib/TdApi$Outline;ZZZZLorg/drinkless/tdlib/TdApi$StickerType;ZZZ[Lorg/drinkless/tdlib/TdApi$Sticker;[Lorg/drinkless/tdlib/TdApi$Emojis;)V
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
    .param p15, "stickerArr"    # [Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p16, "emojisArr"    # [Lorg/drinkless/tdlib/TdApi$Emojis;

    .line 54759
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54760
    move-wide/from16 v1, p1

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$StickerSet;->id:J

    .line 54761
    move-object/from16 v3, p3

    iput-object v3, v0, Lorg/drinkless/tdlib/TdApi$StickerSet;->title:Ljava/lang/String;

    .line 54762
    move-object/from16 v4, p4

    iput-object v4, v0, Lorg/drinkless/tdlib/TdApi$StickerSet;->name:Ljava/lang/String;

    .line 54763
    move-object/from16 v5, p5

    iput-object v5, v0, Lorg/drinkless/tdlib/TdApi$StickerSet;->thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

    .line 54764
    move-object/from16 v6, p6

    iput-object v6, v0, Lorg/drinkless/tdlib/TdApi$StickerSet;->thumbnailOutline:Lorg/drinkless/tdlib/TdApi$Outline;

    .line 54765
    move/from16 v7, p7

    iput-boolean v7, v0, Lorg/drinkless/tdlib/TdApi$StickerSet;->isOwned:Z

    .line 54766
    move/from16 v8, p8

    iput-boolean v8, v0, Lorg/drinkless/tdlib/TdApi$StickerSet;->isInstalled:Z

    .line 54767
    move/from16 v9, p9

    iput-boolean v9, v0, Lorg/drinkless/tdlib/TdApi$StickerSet;->isArchived:Z

    .line 54768
    move/from16 v10, p10

    iput-boolean v10, v0, Lorg/drinkless/tdlib/TdApi$StickerSet;->isOfficial:Z

    .line 54769
    move-object/from16 v11, p11

    iput-object v11, v0, Lorg/drinkless/tdlib/TdApi$StickerSet;->stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;

    .line 54770
    move/from16 v12, p12

    iput-boolean v12, v0, Lorg/drinkless/tdlib/TdApi$StickerSet;->needsRepainting:Z

    .line 54771
    move/from16 v13, p13

    iput-boolean v13, v0, Lorg/drinkless/tdlib/TdApi$StickerSet;->isAllowedAsChatEmojiStatus:Z

    .line 54772
    move/from16 v14, p14

    iput-boolean v14, v0, Lorg/drinkless/tdlib/TdApi$StickerSet;->isViewed:Z

    .line 54773
    move-object/from16 v15, p15

    iput-object v15, v0, Lorg/drinkless/tdlib/TdApi$StickerSet;->stickers:[Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 54774
    move-object/from16 v1, p16

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$StickerSet;->emojis:[Lorg/drinkless/tdlib/TdApi$Emojis;

    .line 54775
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54779
    const v0, -0x6a48b682

    return v0
.end method
