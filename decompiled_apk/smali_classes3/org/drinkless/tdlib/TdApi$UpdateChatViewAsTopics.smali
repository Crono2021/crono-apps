.class public Lorg/drinkless/tdlib/TdApi$UpdateChatViewAsTopics;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatViewAsTopics"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5bff163d


# instance fields
.field public chatId:J

.field public viewAsTopics:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34448
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34449
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 34438
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34439
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatViewAsTopics;->chatId:J

    .line 34440
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatViewAsTopics;->viewAsTopics:Z

    .line 34441
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34445
    const v0, 0x5bff163d

    return v0
.end method
