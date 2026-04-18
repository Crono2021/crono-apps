.class public Lorg/drinkless/tdlib/TdApi$ReactionTypeCustomEmoji;
.super Lorg/drinkless/tdlib/TdApi$ReactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReactionTypeCustomEmoji"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3af4bd0d


# instance fields
.field public customEmojiId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18276
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReactionType;-><init>()V

    .line 18277
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 18267
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReactionType;-><init>()V

    .line 18268
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ReactionTypeCustomEmoji;->customEmojiId:J

    .line 18269
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18273
    const v0, -0x3af4bd0d

    return v0
.end method
