.class public Lorg/drinkless/tdlib/TdApi$GetEmojiCategories;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetEmojiCategories"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$EmojiCategories;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7f86c16e


# instance fields
.field public type:Lorg/drinkless/tdlib/TdApi$EmojiCategoryType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12750
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12751
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$EmojiCategoryType;)V
    .locals 0
    .param p1, "emojiCategoryType"    # Lorg/drinkless/tdlib/TdApi$EmojiCategoryType;

    .line 12741
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12742
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetEmojiCategories;->type:Lorg/drinkless/tdlib/TdApi$EmojiCategoryType;

    .line 12743
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12747
    const v0, 0x7f86c16e

    return v0
.end method
