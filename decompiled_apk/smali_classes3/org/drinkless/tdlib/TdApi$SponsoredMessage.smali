.class public Lorg/drinkless/tdlib/TdApi$SponsoredMessage;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SponsoredMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5ab48dc8


# instance fields
.field public accentColorId:I

.field public additionalInfo:Ljava/lang/String;

.field public backgroundCustomEmojiId:J

.field public buttonText:Ljava/lang/String;

.field public canBeReported:Z

.field public content:Lorg/drinkless/tdlib/TdApi$MessageContent;

.field public isRecommended:Z

.field public messageId:J

.field public sponsor:Lorg/drinkless/tdlib/TdApi$AdvertisementSponsor;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53492
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53493
    return-void
.end method

.method public constructor <init>(JZZLorg/drinkless/tdlib/TdApi$MessageContent;Lorg/drinkless/tdlib/TdApi$AdvertisementSponsor;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z
    .param p5, "messageContent"    # Lorg/drinkless/tdlib/TdApi$MessageContent;
    .param p6, "advertisementSponsor"    # Lorg/drinkless/tdlib/TdApi$AdvertisementSponsor;
    .param p7, "str"    # Ljava/lang/String;
    .param p8, "str2"    # Ljava/lang/String;
    .param p9, "i9"    # I
    .param p10, "j9"    # J
    .param p12, "str3"    # Ljava/lang/String;

    .line 53474
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53475
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SponsoredMessage;->messageId:J

    .line 53476
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$SponsoredMessage;->isRecommended:Z

    .line 53477
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$SponsoredMessage;->canBeReported:Z

    .line 53478
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SponsoredMessage;->content:Lorg/drinkless/tdlib/TdApi$MessageContent;

    .line 53479
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$SponsoredMessage;->sponsor:Lorg/drinkless/tdlib/TdApi$AdvertisementSponsor;

    .line 53480
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$SponsoredMessage;->title:Ljava/lang/String;

    .line 53481
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$SponsoredMessage;->buttonText:Ljava/lang/String;

    .line 53482
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$SponsoredMessage;->accentColorId:I

    .line 53483
    iput-wide p10, p0, Lorg/drinkless/tdlib/TdApi$SponsoredMessage;->backgroundCustomEmojiId:J

    .line 53484
    iput-object p12, p0, Lorg/drinkless/tdlib/TdApi$SponsoredMessage;->additionalInfo:Ljava/lang/String;

    .line 53485
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53489
    const v0, 0x5ab48dc8

    return v0
.end method
