.class public Lorg/drinkless/tdlib/TdApi$BlockMessageSenderFromReplies;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BlockMessageSenderFromReplies"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x48620a75


# instance fields
.field public deleteAllMessages:Z

.field public deleteMessage:Z

.field public messageId:J

.field public reportSpam:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42510
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42511
    return-void
.end method

.method public constructor <init>(JZZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z
    .param p5, "z10"    # Z

    .line 42498
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42499
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$BlockMessageSenderFromReplies;->messageId:J

    .line 42500
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$BlockMessageSenderFromReplies;->deleteMessage:Z

    .line 42501
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$BlockMessageSenderFromReplies;->deleteAllMessages:Z

    .line 42502
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$BlockMessageSenderFromReplies;->reportSpam:Z

    .line 42503
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42507
    const v0, -0x48620a75

    return v0
.end method
