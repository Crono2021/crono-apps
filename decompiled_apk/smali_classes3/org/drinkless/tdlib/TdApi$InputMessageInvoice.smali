.class public Lorg/drinkless/tdlib/TdApi$InputMessageInvoice;
.super Lorg/drinkless/tdlib/TdApi$InputMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessageInvoice"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4543708f


# instance fields
.field public description:Ljava/lang/String;

.field public invoice:Lorg/drinkless/tdlib/TdApi$Invoice;

.field public paidMedia:Lorg/drinkless/tdlib/TdApi$InputPaidMedia;

.field public paidMediaCaption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public payload:[B

.field public photoHeight:I

.field public photoSize:I

.field public photoUrl:Ljava/lang/String;

.field public photoWidth:I

.field public providerData:Ljava/lang/String;

.field public providerToken:Ljava/lang/String;

.field public startParameter:Ljava/lang/String;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53952
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 53953
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Invoice;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III[BLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$InputPaidMedia;Lorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "invoice"    # Lorg/drinkless/tdlib/TdApi$Invoice;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "str2"    # Ljava/lang/String;
    .param p4, "str3"    # Ljava/lang/String;
    .param p5, "i9"    # I
    .param p6, "i10"    # I
    .param p7, "i11"    # I
    .param p8, "bArr"    # [B
    .param p9, "str4"    # Ljava/lang/String;
    .param p10, "str5"    # Ljava/lang/String;
    .param p11, "str6"    # Ljava/lang/String;
    .param p12, "inputPaidMedia"    # Lorg/drinkless/tdlib/TdApi$InputPaidMedia;
    .param p13, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 53931
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 53932
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessageInvoice;->invoice:Lorg/drinkless/tdlib/TdApi$Invoice;

    .line 53933
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputMessageInvoice;->title:Ljava/lang/String;

    .line 53934
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputMessageInvoice;->description:Ljava/lang/String;

    .line 53935
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InputMessageInvoice;->photoUrl:Ljava/lang/String;

    .line 53936
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$InputMessageInvoice;->photoSize:I

    .line 53937
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$InputMessageInvoice;->photoWidth:I

    .line 53938
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$InputMessageInvoice;->photoHeight:I

    .line 53939
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$InputMessageInvoice;->payload:[B

    .line 53940
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$InputMessageInvoice;->providerToken:Ljava/lang/String;

    .line 53941
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$InputMessageInvoice;->providerData:Ljava/lang/String;

    .line 53942
    iput-object p11, p0, Lorg/drinkless/tdlib/TdApi$InputMessageInvoice;->startParameter:Ljava/lang/String;

    .line 53943
    iput-object p12, p0, Lorg/drinkless/tdlib/TdApi$InputMessageInvoice;->paidMedia:Lorg/drinkless/tdlib/TdApi$InputPaidMedia;

    .line 53944
    iput-object p13, p0, Lorg/drinkless/tdlib/TdApi$InputMessageInvoice;->paidMediaCaption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 53945
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53949
    const v0, -0x4543708f

    return v0
.end method
