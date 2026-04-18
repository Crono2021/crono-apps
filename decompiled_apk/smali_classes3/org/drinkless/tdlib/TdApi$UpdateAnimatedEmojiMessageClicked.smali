.class public Lorg/drinkless/tdlib/TdApi$UpdateAnimatedEmojiMessageClicked;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateAnimatedEmojiMessageClicked"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5ce98bfb


# instance fields
.field public chatId:J

.field public messageId:J

.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41428
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41429
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 41417
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41418
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateAnimatedEmojiMessageClicked;->chatId:J

    .line 41419
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateAnimatedEmojiMessageClicked;->messageId:J

    .line 41420
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateAnimatedEmojiMessageClicked;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 41421
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41425
    const v0, -0x5ce98bfb

    return v0
.end method
