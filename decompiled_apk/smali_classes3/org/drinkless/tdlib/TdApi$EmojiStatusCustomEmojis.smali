.class public Lorg/drinkless/tdlib/TdApi$EmojiStatusCustomEmojis;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EmojiStatusCustomEmojis"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x36aa3109


# instance fields
.field public customEmojiIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11760
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11761
    return-void
.end method

.method public constructor <init>([J)V
    .locals 0
    .param p1, "jArr"    # [J

    .line 11751
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11752
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EmojiStatusCustomEmojis;->customEmojiIds:[J

    .line 11753
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11757
    const v0, 0x36aa3109

    return v0
.end method
