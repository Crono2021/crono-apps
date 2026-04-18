.class public Lorg/drinkless/tdlib/TdApi$EmojiStatus;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EmojiStatus"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3a054910


# instance fields
.field public expirationDate:I

.field public type:Lorg/drinkless/tdlib/TdApi$EmojiStatusType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25444
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25445
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$EmojiStatusType;I)V
    .locals 0
    .param p1, "emojiStatusType"    # Lorg/drinkless/tdlib/TdApi$EmojiStatusType;
    .param p2, "i9"    # I

    .line 25434
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25435
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EmojiStatus;->type:Lorg/drinkless/tdlib/TdApi$EmojiStatusType;

    .line 25436
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$EmojiStatus;->expirationDate:I

    .line 25437
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25441
    const v0, 0x3a054910

    return v0
.end method
