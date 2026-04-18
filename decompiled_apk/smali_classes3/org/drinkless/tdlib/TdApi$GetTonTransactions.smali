.class public Lorg/drinkless/tdlib/TdApi$GetTonTransactions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetTonTransactions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$TonTransactions;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7355ed2b


# instance fields
.field public direction:Lorg/drinkless/tdlib/TdApi$TransactionDirection;

.field public limit:I

.field public offset:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37578
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37579
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$TransactionDirection;Ljava/lang/String;I)V
    .locals 0
    .param p1, "transactionDirection"    # Lorg/drinkless/tdlib/TdApi$TransactionDirection;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "i9"    # I

    .line 37567
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37568
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetTonTransactions;->direction:Lorg/drinkless/tdlib/TdApi$TransactionDirection;

    .line 37569
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetTonTransactions;->offset:Ljava/lang/String;

    .line 37570
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetTonTransactions;->limit:I

    .line 37571
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37575
    const v0, -0x7355ed2b

    return v0
.end method
