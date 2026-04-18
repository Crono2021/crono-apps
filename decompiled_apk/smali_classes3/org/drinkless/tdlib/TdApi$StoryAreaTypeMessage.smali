.class public Lorg/drinkless/tdlib/TdApi$StoryAreaTypeMessage;
.super Lorg/drinkless/tdlib/TdApi$StoryAreaType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryAreaTypeMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4010894c


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32808
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryAreaType;-><init>()V

    .line 32809
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 32798
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryAreaType;-><init>()V

    .line 32799
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaTypeMessage;->chatId:J

    .line 32800
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaTypeMessage;->messageId:J

    .line 32801
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32805
    const v0, -0x4010894c

    return v0
.end method
