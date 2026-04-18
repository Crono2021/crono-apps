.class public Lorg/drinkless/tdlib/TdApi$AdvertisementSponsor;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AdvertisementSponsor"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x52c925ef


# instance fields
.field public info:Ljava/lang/String;

.field public photo:Lorg/drinkless/tdlib/TdApi$Photo;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35552
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35553
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Photo;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;
    .param p3, "str2"    # Ljava/lang/String;

    .line 35541
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35542
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AdvertisementSponsor;->url:Ljava/lang/String;

    .line 35543
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$AdvertisementSponsor;->photo:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 35544
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AdvertisementSponsor;->info:Ljava/lang/String;

    .line 35545
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35549
    const v0, 0x52c925ef

    return v0
.end method
