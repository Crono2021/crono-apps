.class public Lorg/drinkless/tdlib/TdApi$GetAllStickerEmojis;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetAllStickerEmojis"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Emojis;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x11ad2e30


# instance fields
.field public chatId:J

.field public query:Ljava/lang/String;

.field public returnOnlyMainEmoji:Z

.field public stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43302
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43303
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StickerType;Ljava/lang/String;JZ)V
    .locals 0
    .param p1, "stickerType"    # Lorg/drinkless/tdlib/TdApi$StickerType;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "j5"    # J
    .param p5, "z8"    # Z

    .line 43290
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43291
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetAllStickerEmojis;->stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;

    .line 43292
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetAllStickerEmojis;->query:Ljava/lang/String;

    .line 43293
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetAllStickerEmojis;->chatId:J

    .line 43294
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$GetAllStickerEmojis;->returnOnlyMainEmoji:Z

    .line 43295
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43299
    const v0, 0x11ad2e30

    return v0
.end method
