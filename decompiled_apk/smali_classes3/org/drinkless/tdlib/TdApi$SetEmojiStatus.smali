.class public Lorg/drinkless/tdlib/TdApi$SetEmojiStatus;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetEmojiStatus"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6d07c1a3


# instance fields
.field public emojiStatus:Lorg/drinkless/tdlib/TdApi$EmojiStatus;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19698
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19699
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$EmojiStatus;)V
    .locals 0
    .param p1, "emojiStatus"    # Lorg/drinkless/tdlib/TdApi$EmojiStatus;

    .line 19689
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19690
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetEmojiStatus;->emojiStatus:Lorg/drinkless/tdlib/TdApi$EmojiStatus;

    .line 19691
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19695
    const v0, -0x6d07c1a3

    return v0
.end method
