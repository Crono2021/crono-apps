.class public Lorg/drinkless/tdlib/TdApi$Sticker;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Sticker"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2690a2c1


# instance fields
.field public emoji:Ljava/lang/String;

.field public format:Lorg/drinkless/tdlib/TdApi$StickerFormat;

.field public fullType:Lorg/drinkless/tdlib/TdApi$StickerFullType;

.field public height:I

.field public id:J

.field public setId:J

.field public sticker:Lorg/drinkless/tdlib/TdApi$File;

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53072
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53073
    return-void
.end method

.method public constructor <init>(JJIILjava/lang/String;Lorg/drinkless/tdlib/TdApi$StickerFormat;Lorg/drinkless/tdlib/TdApi$StickerFullType;Lorg/drinkless/tdlib/TdApi$Thumbnail;Lorg/drinkless/tdlib/TdApi$File;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I
    .param p6, "i10"    # I
    .param p7, "str"    # Ljava/lang/String;
    .param p8, "stickerFormat"    # Lorg/drinkless/tdlib/TdApi$StickerFormat;
    .param p9, "stickerFullType"    # Lorg/drinkless/tdlib/TdApi$StickerFullType;
    .param p10, "thumbnail"    # Lorg/drinkless/tdlib/TdApi$Thumbnail;
    .param p11, "file"    # Lorg/drinkless/tdlib/TdApi$File;

    .line 53055
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53056
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$Sticker;->id:J

    .line 53057
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$Sticker;->setId:J

    .line 53058
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$Sticker;->width:I

    .line 53059
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$Sticker;->height:I

    .line 53060
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$Sticker;->emoji:Ljava/lang/String;

    .line 53061
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$Sticker;->format:Lorg/drinkless/tdlib/TdApi$StickerFormat;

    .line 53062
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$Sticker;->fullType:Lorg/drinkless/tdlib/TdApi$StickerFullType;

    .line 53063
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$Sticker;->thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

    .line 53064
    iput-object p11, p0, Lorg/drinkless/tdlib/TdApi$Sticker;->sticker:Lorg/drinkless/tdlib/TdApi$File;

    .line 53065
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53069
    const v0, -0x2690a2c1

    return v0
.end method
