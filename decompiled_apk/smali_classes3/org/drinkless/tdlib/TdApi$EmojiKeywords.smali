.class public Lorg/drinkless/tdlib/TdApi$EmojiKeywords;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EmojiKeywords"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x291c57cb


# instance fields
.field public emojiKeywords:[Lorg/drinkless/tdlib/TdApi$EmojiKeyword;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11742
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11743
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$EmojiKeyword;)V
    .locals 0
    .param p1, "emojiKeywordArr"    # [Lorg/drinkless/tdlib/TdApi$EmojiKeyword;

    .line 11733
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11734
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EmojiKeywords;->emojiKeywords:[Lorg/drinkless/tdlib/TdApi$EmojiKeyword;

    .line 11735
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11739
    const v0, 0x291c57cb

    return v0
.end method
