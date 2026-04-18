.class public Lorg/drinkless/tdlib/TdApi$GetMessageAddedReactions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetMessageAddedReactions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$AddedReactions;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7dc6ae52


# instance fields
.field public chatId:J

.field public limit:I

.field public messageId:J

.field public offset:Ljava/lang/String;

.field public reactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47488
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47489
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$ReactionType;Ljava/lang/String;I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "reactionType"    # Lorg/drinkless/tdlib/TdApi$ReactionType;
    .param p6, "str"    # Ljava/lang/String;
    .param p7, "i9"    # I

    .line 47475
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47476
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetMessageAddedReactions;->chatId:J

    .line 47477
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetMessageAddedReactions;->messageId:J

    .line 47478
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$GetMessageAddedReactions;->reactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 47479
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$GetMessageAddedReactions;->offset:Ljava/lang/String;

    .line 47480
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$GetMessageAddedReactions;->limit:I

    .line 47481
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47485
    const v0, 0x7dc6ae52

    return v0
.end method
