.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypePaidMessageSend;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypePaidMessageSend"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x65e69b9b


# instance fields
.field public chatId:J

.field public messageCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32628
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32629
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 32618
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32619
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypePaidMessageSend;->chatId:J

    .line 32620
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypePaidMessageSend;->messageCount:I

    .line 32621
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32625
    const v0, -0x65e69b9b

    return v0
.end method
