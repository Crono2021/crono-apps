.class public Lorg/drinkless/tdlib/TdApi$SetPaidMessageReactionType;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetPaidMessageReactionType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3177cd52


# instance fields
.field public chatId:J

.field public messageId:J

.field public type:Lorg/drinkless/tdlib/TdApi$PaidReactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40504
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40505
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$PaidReactionType;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "paidReactionType"    # Lorg/drinkless/tdlib/TdApi$PaidReactionType;

    .line 40493
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40494
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetPaidMessageReactionType;->chatId:J

    .line 40495
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$SetPaidMessageReactionType;->messageId:J

    .line 40496
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SetPaidMessageReactionType;->type:Lorg/drinkless/tdlib/TdApi$PaidReactionType;

    .line 40497
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40501
    const v0, -0x3177cd52

    return v0
.end method
