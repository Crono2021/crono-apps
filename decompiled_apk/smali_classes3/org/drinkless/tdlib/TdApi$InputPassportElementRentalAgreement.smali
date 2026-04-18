.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementRentalAgreement;
.super Lorg/drinkless/tdlib/TdApi$InputPassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementRentalAgreement"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x677b9c2b


# instance fields
.field public rentalAgreement:Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15108
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 15109
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;)V
    .locals 0
    .param p1, "inputPersonalDocument"    # Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;

    .line 15099
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 15100
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementRentalAgreement;->rentalAgreement:Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;

    .line 15101
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15105
    const v0, 0x677b9c2b

    return v0
.end method
