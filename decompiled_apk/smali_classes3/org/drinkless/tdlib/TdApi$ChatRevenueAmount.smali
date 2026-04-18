.class public Lorg/drinkless/tdlib/TdApi$ChatRevenueAmount;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatRevenueAmount"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x59b731a8


# instance fields
.field public availableAmount:J

.field public balanceAmount:J

.field public cryptocurrency:Ljava/lang/String;

.field public totalAmount:J

.field public withdrawalEnabled:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46838
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46839
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJJZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "j10"    # J
    .param p8, "z8"    # Z

    .line 46825
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46826
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueAmount;->cryptocurrency:Ljava/lang/String;

    .line 46827
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueAmount;->totalAmount:J

    .line 46828
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueAmount;->balanceAmount:J

    .line 46829
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueAmount;->availableAmount:J

    .line 46830
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueAmount;->withdrawalEnabled:Z

    .line 46831
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46835
    const v0, -0x59b731a8

    return v0
.end method
