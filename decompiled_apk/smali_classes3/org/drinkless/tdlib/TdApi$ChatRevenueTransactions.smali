.class public Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatRevenueTransactions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x783ad9d3


# instance fields
.field public nextOffset:Ljava/lang/String;

.field public tonAmount:J

.field public transactions:[Lorg/drinkless/tdlib/TdApi$ChatRevenueTransaction;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36300
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36301
    return-void
.end method

.method public constructor <init>(J[Lorg/drinkless/tdlib/TdApi$ChatRevenueTransaction;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatRevenueTransactionArr"    # [Lorg/drinkless/tdlib/TdApi$ChatRevenueTransaction;
    .param p4, "str"    # Ljava/lang/String;

    .line 36289
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36290
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactions;->tonAmount:J

    .line 36291
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactions;->transactions:[Lorg/drinkless/tdlib/TdApi$ChatRevenueTransaction;

    .line 36292
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactions;->nextOffset:Ljava/lang/String;

    .line 36293
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36297
    const v0, -0x783ad9d3

    return v0
.end method
