.class public Lorg/drinkless/tdlib/TdApi$GetStarTransactions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetStarTransactions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StarTransactions;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1220d5b3


# instance fields
.field public direction:Lorg/drinkless/tdlib/TdApi$TransactionDirection;

.field public limit:I

.field public offset:Ljava/lang/String;

.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public subscriptionId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47592
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47593
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$TransactionDirection;Ljava/lang/String;I)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "transactionDirection"    # Lorg/drinkless/tdlib/TdApi$TransactionDirection;
    .param p4, "str2"    # Ljava/lang/String;
    .param p5, "i9"    # I

    .line 47579
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47580
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetStarTransactions;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 47581
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetStarTransactions;->subscriptionId:Ljava/lang/String;

    .line 47582
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetStarTransactions;->direction:Lorg/drinkless/tdlib/TdApi$TransactionDirection;

    .line 47583
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$GetStarTransactions;->offset:Ljava/lang/String;

    .line 47584
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$GetStarTransactions;->limit:I

    .line 47585
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47589
    const v0, -0x1220d5b3

    return v0
.end method
