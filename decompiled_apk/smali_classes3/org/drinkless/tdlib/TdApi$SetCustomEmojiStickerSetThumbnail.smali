.class public Lorg/drinkless/tdlib/TdApi$SetCustomEmojiStickerSetThumbnail;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetCustomEmojiStickerSetThumbnail"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x42ed1f16


# instance fields
.field public customEmojiId:J

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31488
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31489
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;J)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J

    .line 31478
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31479
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetCustomEmojiStickerSetThumbnail;->name:Ljava/lang/String;

    .line 31480
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$SetCustomEmojiStickerSetThumbnail;->customEmojiId:J

    .line 31481
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31485
    const v0, -0x42ed1f16

    return v0
.end method
