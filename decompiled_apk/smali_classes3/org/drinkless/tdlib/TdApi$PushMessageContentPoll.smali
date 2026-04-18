.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentPoll;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentPoll"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2a58bc6


# instance fields
.field public isPinned:Z

.field public isRegular:Z

.field public question:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39272
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 39273
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z

    .line 39261
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 39262
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentPoll;->question:Ljava/lang/String;

    .line 39263
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentPoll;->isRegular:Z

    .line 39264
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentPoll;->isPinned:Z

    .line 39265
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39269
    const v0, -0x2a58bc6

    return v0
.end method
