.class public Lorg/drinkless/tdlib/TdApi$CollectibleItemInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CollectibleItemInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x570f9bcd


# instance fields
.field public amount:J

.field public cryptocurrency:Ljava/lang/String;

.field public cryptocurrencyAmount:J

.field public currency:Ljava/lang/String;

.field public purchaseDate:I

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49562
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49563
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;JLjava/lang/String;JLjava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "j5"    # J
    .param p5, "str2"    # Ljava/lang/String;
    .param p6, "j9"    # J
    .param p8, "str3"    # Ljava/lang/String;

    .line 49548
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49549
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$CollectibleItemInfo;->purchaseDate:I

    .line 49550
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$CollectibleItemInfo;->currency:Ljava/lang/String;

    .line 49551
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$CollectibleItemInfo;->amount:J

    .line 49552
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$CollectibleItemInfo;->cryptocurrency:Ljava/lang/String;

    .line 49553
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$CollectibleItemInfo;->cryptocurrencyAmount:J

    .line 49554
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$CollectibleItemInfo;->url:Ljava/lang/String;

    .line 49555
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49559
    const v0, 0x570f9bcd

    return v0
.end method
