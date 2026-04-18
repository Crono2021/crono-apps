.class public Lorg/drinkless/tdlib/TdApi$TextEntityTypeCustomEmoji;
.super Lorg/drinkless/tdlib/TdApi$TextEntityType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TextEntityTypeCustomEmoji"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x66ceacc5


# instance fields
.field public customEmojiId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21224
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TextEntityType;-><init>()V

    .line 21225
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 21215
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TextEntityType;-><init>()V

    .line 21216
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$TextEntityTypeCustomEmoji;->customEmojiId:J

    .line 21217
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21221
    const v0, 0x66ceacc5

    return v0
.end method
