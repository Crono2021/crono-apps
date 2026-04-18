.class public Lorg/drinkless/tdlib/TdApi$SetChatEmojiStatus;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatEmojiStatus"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x55881912


# instance fields
.field public chatId:J

.field public emojiStatus:Lorg/drinkless/tdlib/TdApi$EmojiStatus;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31248
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31249
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$EmojiStatus;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "emojiStatus"    # Lorg/drinkless/tdlib/TdApi$EmojiStatus;

    .line 31238
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31239
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatEmojiStatus;->chatId:J

    .line 31240
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatEmojiStatus;->emojiStatus:Lorg/drinkless/tdlib/TdApi$EmojiStatus;

    .line 31241
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31245
    const v0, 0x55881912

    return v0
.end method
