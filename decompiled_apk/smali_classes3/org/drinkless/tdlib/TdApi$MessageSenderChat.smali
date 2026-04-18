.class public Lorg/drinkless/tdlib/TdApi$MessageSenderChat;
.super Lorg/drinkless/tdlib/TdApi$MessageSender;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageSenderChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xe48eecf


# instance fields
.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16728
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageSender;-><init>()V

    .line 16729
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 16719
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageSender;-><init>()V

    .line 16720
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageSenderChat;->chatId:J

    .line 16721
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16725
    const v0, -0xe48eecf

    return v0
.end method
