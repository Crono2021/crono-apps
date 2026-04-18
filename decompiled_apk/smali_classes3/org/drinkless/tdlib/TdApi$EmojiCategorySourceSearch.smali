.class public Lorg/drinkless/tdlib/TdApi$EmojiCategorySourceSearch;
.super Lorg/drinkless/tdlib/TdApi$EmojiCategorySource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EmojiCategorySourceSearch"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1b0433e6


# instance fields
.field public emojis:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11724
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$EmojiCategorySource;-><init>()V

    .line 11725
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;)V
    .locals 0
    .param p1, "strArr"    # [Ljava/lang/String;

    .line 11715
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$EmojiCategorySource;-><init>()V

    .line 11716
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EmojiCategorySourceSearch;->emojis:[Ljava/lang/String;

    .line 11717
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11721
    const v0, -0x1b0433e6

    return v0
.end method
