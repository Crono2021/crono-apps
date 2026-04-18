.class public Lorg/drinkless/tdlib/TdApi$AddPendingPaidMessageReaction;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddPendingPaidMessageReaction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1464322d


# instance fields
.field public chatId:J

.field public messageId:J

.field public starCount:J

.field public type:Lorg/drinkless/tdlib/TdApi$PaidReactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42270
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42271
    return-void
.end method

.method public constructor <init>(JJJLorg/drinkless/tdlib/TdApi$PaidReactionType;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "j10"    # J
    .param p7, "paidReactionType"    # Lorg/drinkless/tdlib/TdApi$PaidReactionType;

    .line 42258
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42259
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AddPendingPaidMessageReaction;->chatId:J

    .line 42260
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$AddPendingPaidMessageReaction;->messageId:J

    .line 42261
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$AddPendingPaidMessageReaction;->starCount:J

    .line 42262
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$AddPendingPaidMessageReaction;->type:Lorg/drinkless/tdlib/TdApi$PaidReactionType;

    .line 42263
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42267
    const v0, -0x1464322d

    return v0
.end method
