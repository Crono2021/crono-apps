.class public Lorg/drinkless/tdlib/TdApi$PassportElementRentalAgreement;
.super Lorg/drinkless/tdlib/TdApi$PassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportElementRentalAgreement"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x114b34d8


# instance fields
.field public rentalAgreement:Lorg/drinkless/tdlib/TdApi$PersonalDocument;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17610
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17611
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PersonalDocument;)V
    .locals 0
    .param p1, "personalDocument"    # Lorg/drinkless/tdlib/TdApi$PersonalDocument;

    .line 17601
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17602
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PassportElementRentalAgreement;->rentalAgreement:Lorg/drinkless/tdlib/TdApi$PersonalDocument;

    .line 17603
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17607
    const v0, -0x114b34d8

    return v0
.end method
