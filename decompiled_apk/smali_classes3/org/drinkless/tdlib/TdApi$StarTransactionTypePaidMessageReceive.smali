.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypePaidMessageReceive;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypePaidMessageReceive"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2857c23a


# instance fields
.field public commissionPerMille:I

.field public commissionStarAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

.field public messageCount:I

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45462
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 45463
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;IILorg/drinkless/tdlib/TdApi$StarAmount;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "i9"    # I
    .param p3, "i10"    # I
    .param p4, "starAmount"    # Lorg/drinkless/tdlib/TdApi$StarAmount;

    .line 45450
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 45451
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypePaidMessageReceive;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 45452
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypePaidMessageReceive;->messageCount:I

    .line 45453
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypePaidMessageReceive;->commissionPerMille:I

    .line 45454
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypePaidMessageReceive;->commissionStarAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

    .line 45455
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45459
    const v0, -0x2857c23a

    return v0
.end method
