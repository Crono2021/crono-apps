.class public Lorg/drinkless/tdlib/TdApi$StickerFullTypeCustomEmoji;
.super Lorg/drinkless/tdlib/TdApi$StickerFullType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StickerFullTypeCustomEmoji"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3c80fa55


# instance fields
.field public customEmojiId:J

.field public needsRepainting:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32708
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StickerFullType;-><init>()V

    .line 32709
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 32698
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StickerFullType;-><init>()V

    .line 32699
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StickerFullTypeCustomEmoji;->customEmojiId:J

    .line 32700
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$StickerFullTypeCustomEmoji;->needsRepainting:Z

    .line 32701
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32705
    const v0, -0x3c80fa55

    return v0
.end method
