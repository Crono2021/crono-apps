.class public Lorg/drinkless/tdlib/TdApi$EmojiStatusTypeCustomEmoji;
.super Lorg/drinkless/tdlib/TdApi$EmojiStatusType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EmojiStatusTypeCustomEmoji"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x63590f0b


# instance fields
.field public customEmojiId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11778
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$EmojiStatusType;-><init>()V

    .line 11779
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 11769
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$EmojiStatusType;-><init>()V

    .line 11770
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$EmojiStatusTypeCustomEmoji;->customEmojiId:J

    .line 11771
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11775
    const v0, -0x63590f0b

    return v0
.end method
