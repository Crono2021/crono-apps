.class public Lorg/drinkless/tdlib/TdApi$UpdateChatUnreadMentionCount;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatUnreadMentionCount"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7f0b84e4


# instance fields
.field public chatId:J

.field public unreadMentionCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34388
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34389
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 34378
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34379
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatUnreadMentionCount;->chatId:J

    .line 34380
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatUnreadMentionCount;->unreadMentionCount:I

    .line 34381
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34385
    const v0, -0x7f0b84e4

    return v0
.end method
