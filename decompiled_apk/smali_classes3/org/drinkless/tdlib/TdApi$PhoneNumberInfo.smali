.class public Lorg/drinkless/tdlib/TdApi$PhoneNumberInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PhoneNumberInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2d3c675f


# instance fields
.field public country:Lorg/drinkless/tdlib/TdApi$CountryInfo;

.field public countryCallingCode:Ljava/lang/String;

.field public formattedPhoneNumber:Ljava/lang/String;

.field public isAnonymous:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44646
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44647
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$CountryInfo;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "countryInfo"    # Lorg/drinkless/tdlib/TdApi$CountryInfo;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "str2"    # Ljava/lang/String;
    .param p4, "z8"    # Z

    .line 44634
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44635
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PhoneNumberInfo;->country:Lorg/drinkless/tdlib/TdApi$CountryInfo;

    .line 44636
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PhoneNumberInfo;->countryCallingCode:Ljava/lang/String;

    .line 44637
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$PhoneNumberInfo;->formattedPhoneNumber:Ljava/lang/String;

    .line 44638
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$PhoneNumberInfo;->isAnonymous:Z

    .line 44639
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44643
    const v0, -0x2d3c675f

    return v0
.end method
