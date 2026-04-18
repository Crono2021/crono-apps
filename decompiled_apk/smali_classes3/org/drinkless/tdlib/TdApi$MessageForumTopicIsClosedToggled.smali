.class public Lorg/drinkless/tdlib/TdApi$MessageForumTopicIsClosedToggled;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageForumTopicIsClosedToggled"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4b578fe0


# instance fields
.field public isClosed:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16476
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16477
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 16467
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16468
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$MessageForumTopicIsClosedToggled;->isClosed:Z

    .line 16469
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16473
    const v0, 0x4b578fe0    # 1.4127072E7f

    return v0
.end method
