.class public Lorg/drinkless/tdlib/TdApi$UpdateChatReadOutbox;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatReadOutbox"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2a385285


# instance fields
.field public chatId:J

.field public lastReadOutboxMessageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34268
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34269
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 34258
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34259
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatReadOutbox;->chatId:J

    .line 34260
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatReadOutbox;->lastReadOutboxMessageId:J

    .line 34261
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34265
    const v0, 0x2a385285

    return v0
.end method
