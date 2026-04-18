.class public Lorg/drinkless/tdlib/TdApi$SetUserEmojiStatus;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetUserEmojiStatus"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1ae9a435


# instance fields
.field public emojiStatus:Lorg/drinkless/tdlib/TdApi$EmojiStatus;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32128
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32129
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$EmojiStatus;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "emojiStatus"    # Lorg/drinkless/tdlib/TdApi$EmojiStatus;

    .line 32118
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32119
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetUserEmojiStatus;->userId:J

    .line 32120
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetUserEmojiStatus;->emojiStatus:Lorg/drinkless/tdlib/TdApi$EmojiStatus;

    .line 32121
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32125
    const v0, -0x1ae9a435

    return v0
.end method
