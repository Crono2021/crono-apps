.class public Lorg/drinkless/tdlib/TdApi$InputSticker;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputSticker"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5ebc3412


# instance fields
.field public emojis:Ljava/lang/String;

.field public format:Lorg/drinkless/tdlib/TdApi$StickerFormat;

.field public keywords:[Ljava/lang/String;

.field public maskPosition:Lorg/drinkless/tdlib/TdApi$MaskPosition;

.field public sticker:Lorg/drinkless/tdlib/TdApi$InputFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47800
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 47801
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;Lorg/drinkless/tdlib/TdApi$StickerFormat;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$MaskPosition;[Ljava/lang/String;)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "stickerFormat"    # Lorg/drinkless/tdlib/TdApi$StickerFormat;
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "maskPosition"    # Lorg/drinkless/tdlib/TdApi$MaskPosition;
    .param p5, "strArr"    # [Ljava/lang/String;

    .line 47787
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 47788
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputSticker;->sticker:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 47789
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputSticker;->format:Lorg/drinkless/tdlib/TdApi$StickerFormat;

    .line 47790
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputSticker;->emojis:Ljava/lang/String;

    .line 47791
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InputSticker;->maskPosition:Lorg/drinkless/tdlib/TdApi$MaskPosition;

    .line 47792
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InputSticker;->keywords:[Ljava/lang/String;

    .line 47793
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47797
    const v0, 0x5ebc3412

    return v0
.end method
