.class public Lorg/drinkless/tdlib/TdApi$ChatEventEmojiStatusChanged;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventEmojiStatusChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7c1684e2


# instance fields
.field public newEmojiStatus:Lorg/drinkless/tdlib/TdApi$EmojiStatus;

.field public oldEmojiStatus:Lorg/drinkless/tdlib/TdApi$EmojiStatus;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23764
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23765
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$EmojiStatus;Lorg/drinkless/tdlib/TdApi$EmojiStatus;)V
    .locals 0
    .param p1, "emojiStatus"    # Lorg/drinkless/tdlib/TdApi$EmojiStatus;
    .param p2, "emojiStatus2"    # Lorg/drinkless/tdlib/TdApi$EmojiStatus;

    .line 23754
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23755
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventEmojiStatusChanged;->oldEmojiStatus:Lorg/drinkless/tdlib/TdApi$EmojiStatus;

    .line 23756
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventEmojiStatusChanged;->newEmojiStatus:Lorg/drinkless/tdlib/TdApi$EmojiStatus;

    .line 23757
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23761
    const v0, -0x7c1684e2

    return v0
.end method
