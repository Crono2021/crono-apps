.class public Lorg/drinkless/tdlib/TdApi$UpdateActiveEmojiReactions;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateActiveEmojiReactions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x49f6c52


# instance fields
.field public emojis:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21458
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21459
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;)V
    .locals 0
    .param p1, "strArr"    # [Ljava/lang/String;

    .line 21449
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21450
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateActiveEmojiReactions;->emojis:[Ljava/lang/String;

    .line 21451
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21455
    const v0, 0x49f6c52

    return v0
.end method
