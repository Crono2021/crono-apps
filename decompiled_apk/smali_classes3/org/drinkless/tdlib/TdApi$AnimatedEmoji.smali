.class public Lorg/drinkless/tdlib/TdApi$AnimatedEmoji;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AnimatedEmoji"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x52309ebf


# instance fields
.field public fitzpatrickType:I

.field public sound:Lorg/drinkless/tdlib/TdApi$File;

.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public stickerHeight:I

.field public stickerWidth:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46578
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46579
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Sticker;IIILorg/drinkless/tdlib/TdApi$File;)V
    .locals 0
    .param p1, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p2, "i9"    # I
    .param p3, "i10"    # I
    .param p4, "i11"    # I
    .param p5, "file"    # Lorg/drinkless/tdlib/TdApi$File;

    .line 46565
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46566
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AnimatedEmoji;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 46567
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$AnimatedEmoji;->stickerWidth:I

    .line 46568
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$AnimatedEmoji;->stickerHeight:I

    .line 46569
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$AnimatedEmoji;->fitzpatrickType:I

    .line 46570
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$AnimatedEmoji;->sound:Lorg/drinkless/tdlib/TdApi$File;

    .line 46571
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46575
    const v0, 0x52309ebf

    return v0
.end method
