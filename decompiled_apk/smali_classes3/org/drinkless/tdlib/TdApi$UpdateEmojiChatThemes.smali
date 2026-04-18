.class public Lorg/drinkless/tdlib/TdApi$UpdateEmojiChatThemes;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateEmojiChatThemes"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3ce4d149


# instance fields
.field public chatThemes:[Lorg/drinkless/tdlib/TdApi$EmojiChatTheme;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21746
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21747
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$EmojiChatTheme;)V
    .locals 0
    .param p1, "emojiChatThemeArr"    # [Lorg/drinkless/tdlib/TdApi$EmojiChatTheme;

    .line 21737
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21738
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateEmojiChatThemes;->chatThemes:[Lorg/drinkless/tdlib/TdApi$EmojiChatTheme;

    .line 21739
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21743
    const v0, -0x3ce4d149

    return v0
.end method
