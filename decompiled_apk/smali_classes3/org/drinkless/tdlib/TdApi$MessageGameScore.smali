.class public Lorg/drinkless/tdlib/TdApi$MessageGameScore;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageGameScore"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x50299d7f


# instance fields
.field public gameId:J

.field public gameMessageId:J

.field public score:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38546
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38547
    return-void
.end method

.method public constructor <init>(JJI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I

    .line 38535
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38536
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageGameScore;->gameMessageId:J

    .line 38537
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$MessageGameScore;->gameId:J

    .line 38538
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$MessageGameScore;->score:I

    .line 38539
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38543
    const v0, 0x50299d7f

    return v0
.end method
