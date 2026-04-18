.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementDriverLicense;
.super Lorg/drinkless/tdlib/TdApi$InputPassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementDriverLicense"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x122b14d0


# instance fields
.field public driverLicense:Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14820
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 14821
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;)V
    .locals 0
    .param p1, "inputIdentityDocument"    # Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;

    .line 14811
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 14812
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementDriverLicense;->driverLicense:Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;

    .line 14813
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14817
    const v0, 0x122b14d0

    return v0
.end method
