.class public Lorg/drinkless/tdlib/TdApi$TonTransaction;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TonTransaction"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5d1ac92f


# instance fields
.field public date:I

.field public id:Ljava/lang/String;

.field public isRefund:Z

.field public tonAmount:J

.field public type:Lorg/drinkless/tdlib/TdApi$TonTransactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49152
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49153
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JZILorg/drinkless/tdlib/TdApi$TonTransactionType;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "z8"    # Z
    .param p5, "i9"    # I
    .param p6, "tonTransactionType"    # Lorg/drinkless/tdlib/TdApi$TonTransactionType;

    .line 49139
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49140
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TonTransaction;->id:Ljava/lang/String;

    .line 49141
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$TonTransaction;->tonAmount:J

    .line 49142
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$TonTransaction;->isRefund:Z

    .line 49143
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$TonTransaction;->date:I

    .line 49144
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$TonTransaction;->type:Lorg/drinkless/tdlib/TdApi$TonTransactionType;

    .line 49145
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49149
    const v0, 0x5d1ac92f

    return v0
.end method
