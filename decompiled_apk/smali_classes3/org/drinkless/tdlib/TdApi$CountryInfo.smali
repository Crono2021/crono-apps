.class public Lorg/drinkless/tdlib/TdApi$CountryInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CountryInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x606472ca


# instance fields
.field public callingCodes:[Ljava/lang/String;

.field public countryCode:Ljava/lang/String;

.field public englishName:Ljava/lang/String;

.field public isHidden:Z

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46890
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46891
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z[Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "z8"    # Z
    .param p5, "strArr"    # [Ljava/lang/String;

    .line 46877
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46878
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CountryInfo;->countryCode:Ljava/lang/String;

    .line 46879
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$CountryInfo;->name:Ljava/lang/String;

    .line 46880
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CountryInfo;->englishName:Ljava/lang/String;

    .line 46881
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$CountryInfo;->isHidden:Z

    .line 46882
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$CountryInfo;->callingCodes:[Ljava/lang/String;

    .line 46883
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46887
    const v0, 0x606472ca

    return v0
.end method
