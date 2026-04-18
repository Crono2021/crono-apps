.class public Lorg/drinkless/tdlib/TdApi$UpdateChatEmojiStatus;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatEmojiStatus"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x77796510


# instance fields
.field public chatId:J

.field public emojiStatus:Lorg/drinkless/tdlib/TdApi$EmojiStatus;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34008
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34009
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$EmojiStatus;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "emojiStatus"    # Lorg/drinkless/tdlib/TdApi$EmojiStatus;

    .line 33998
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33999
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatEmojiStatus;->chatId:J

    .line 34000
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatEmojiStatus;->emojiStatus:Lorg/drinkless/tdlib/TdApi$EmojiStatus;

    .line 34001
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34005
    const v0, 0x77796510

    return v0
.end method
