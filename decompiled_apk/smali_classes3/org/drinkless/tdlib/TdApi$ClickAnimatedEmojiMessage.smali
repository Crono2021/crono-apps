.class public Lorg/drinkless/tdlib/TdApi$ClickAnimatedEmojiMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ClickAnimatedEmojiMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Sticker;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xbb17662


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24564
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24565
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 24554
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24555
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ClickAnimatedEmojiMessage;->chatId:J

    .line 24556
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ClickAnimatedEmojiMessage;->messageId:J

    .line 24557
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24561
    const v0, 0xbb17662

    return v0
.end method
