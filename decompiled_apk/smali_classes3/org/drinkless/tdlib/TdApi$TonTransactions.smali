.class public Lorg/drinkless/tdlib/TdApi$TonTransactions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TonTransactions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4e83694d


# instance fields
.field public nextOffset:Ljava/lang/String;

.field public tonAmount:J

.field public transactions:[Lorg/drinkless/tdlib/TdApi$TonTransaction;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41318
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 41319
    return-void
.end method

.method public constructor <init>(J[Lorg/drinkless/tdlib/TdApi$TonTransaction;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "tonTransactionArr"    # [Lorg/drinkless/tdlib/TdApi$TonTransaction;
    .param p4, "str"    # Ljava/lang/String;

    .line 41307
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 41308
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$TonTransactions;->tonAmount:J

    .line 41309
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$TonTransactions;->transactions:[Lorg/drinkless/tdlib/TdApi$TonTransaction;

    .line 41310
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$TonTransactions;->nextOffset:Ljava/lang/String;

    .line 41311
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41315
    const v0, 0x4e83694d

    return v0
.end method
