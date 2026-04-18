.class public Lorg/drinkless/tdlib/TdApi$MessageForumTopicIsHiddenToggled;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageForumTopicIsHiddenToggled"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x686c6c02


# instance fields
.field public isHidden:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16494
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16495
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 16485
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16486
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$MessageForumTopicIsHiddenToggled;->isHidden:Z

    .line 16487
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16491
    const v0, -0x686c6c02

    return v0
.end method
