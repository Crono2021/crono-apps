.class public Lorg/drinkless/tdlib/TdApi$CommitPendingPaidMessageReactions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CommitPendingPaidMessageReactions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xa36a9fa


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24624
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24625
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 24614
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24615
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CommitPendingPaidMessageReactions;->chatId:J

    .line 24616
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$CommitPendingPaidMessageReactions;->messageId:J

    .line 24617
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24621
    const v0, -0xa36a9fa

    return v0
.end method
