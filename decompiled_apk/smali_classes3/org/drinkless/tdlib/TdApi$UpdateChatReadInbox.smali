.class public Lorg/drinkless/tdlib/TdApi$UpdateChatReadInbox;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatReadInbox"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2f8fc919


# instance fields
.field public chatId:J

.field public lastReadInboxMessageId:J

.field public unreadCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41582
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41583
    return-void
.end method

.method public constructor <init>(JJI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I

    .line 41571
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41572
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatReadInbox;->chatId:J

    .line 41573
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatReadInbox;->lastReadInboxMessageId:J

    .line 41574
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatReadInbox;->unreadCount:I

    .line 41575
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41579
    const v0, -0x2f8fc919

    return v0
.end method
