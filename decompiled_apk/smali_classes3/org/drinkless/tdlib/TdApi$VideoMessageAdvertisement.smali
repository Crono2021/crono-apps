.class public Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisement;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "VideoMessageAdvertisement"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6b2f56f


# instance fields
.field public additionalInfo:Ljava/lang/String;

.field public canBeReported:Z

.field public maxDisplayDuration:I

.field public minDisplayDuration:I

.field public sponsor:Lorg/drinkless/tdlib/TdApi$AdvertisementSponsor;

.field public text:Ljava/lang/String;

.field public title:Ljava/lang/String;

.field public uniqueId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52460
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 52461
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;IIZLorg/drinkless/tdlib/TdApi$AdvertisementSponsor;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "i9"    # I
    .param p5, "i10"    # I
    .param p6, "z8"    # Z
    .param p7, "advertisementSponsor"    # Lorg/drinkless/tdlib/TdApi$AdvertisementSponsor;
    .param p8, "str2"    # Ljava/lang/String;
    .param p9, "str3"    # Ljava/lang/String;

    .line 52444
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 52445
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisement;->uniqueId:J

    .line 52446
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisement;->text:Ljava/lang/String;

    .line 52447
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisement;->minDisplayDuration:I

    .line 52448
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisement;->maxDisplayDuration:I

    .line 52449
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisement;->canBeReported:Z

    .line 52450
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisement;->sponsor:Lorg/drinkless/tdlib/TdApi$AdvertisementSponsor;

    .line 52451
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisement;->title:Ljava/lang/String;

    .line 52452
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisement;->additionalInfo:Ljava/lang/String;

    .line 52453
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52457
    const v0, -0x6b2f56f

    return v0
.end method
