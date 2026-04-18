.class public Lorg/drinkless/tdlib/TdApi$EmojiStatuses;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EmojiStatuses"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x46b28352


# instance fields
.field public emojiStatuses:[Lorg/drinkless/tdlib/TdApi$EmojiStatus;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11796
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11797
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$EmojiStatus;)V
    .locals 0
    .param p1, "emojiStatusArr"    # [Lorg/drinkless/tdlib/TdApi$EmojiStatus;

    .line 11787
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11788
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EmojiStatuses;->emojiStatuses:[Lorg/drinkless/tdlib/TdApi$EmojiStatus;

    .line 11789
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11793
    const v0, 0x46b28352

    return v0
.end method
