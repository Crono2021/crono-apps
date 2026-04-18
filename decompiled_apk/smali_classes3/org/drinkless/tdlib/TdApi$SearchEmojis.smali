.class public Lorg/drinkless/tdlib/TdApi$SearchEmojis;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchEmojis"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$EmojiKeywords;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x56cba914


# instance fields
.field public inputLanguageCodes:[Ljava/lang/String;

.field public text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30608
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30609
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "strArr"    # [Ljava/lang/String;

    .line 30598
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30599
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchEmojis;->text:Ljava/lang/String;

    .line 30600
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SearchEmojis;->inputLanguageCodes:[Ljava/lang/String;

    .line 30601
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30605
    const v0, -0x56cba914

    return v0
.end method
