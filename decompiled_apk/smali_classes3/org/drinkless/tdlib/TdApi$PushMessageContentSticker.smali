.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentSticker;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentSticker"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5c98bdd3


# instance fields
.field public emoji:Ljava/lang/String;

.field public isPinned:Z

.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39294
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 39295
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Sticker;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "z8"    # Z

    .line 39283
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 39284
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentSticker;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 39285
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentSticker;->emoji:Ljava/lang/String;

    .line 39286
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentSticker;->isPinned:Z

    .line 39287
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39291
    const v0, 0x5c98bdd3

    return v0
.end method
