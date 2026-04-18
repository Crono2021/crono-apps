.class public Lorg/drinkless/tdlib/TdApi$UpdateChatUnreadReactionCount;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatUnreadReactionCount"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7e9fc323


# instance fields
.field public chatId:J

.field public unreadReactionCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34408
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34409
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 34398
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34399
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatUnreadReactionCount;->chatId:J

    .line 34400
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatUnreadReactionCount;->unreadReactionCount:I

    .line 34401
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34405
    const v0, -0x7e9fc323

    return v0
.end method
