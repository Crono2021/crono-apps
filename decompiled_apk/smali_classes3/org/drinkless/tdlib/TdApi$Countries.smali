.class public Lorg/drinkless/tdlib/TdApi$Countries;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Countries"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6e8506e5


# instance fields
.field public countries:[Lorg/drinkless/tdlib/TdApi$CountryInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11040
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11041
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$CountryInfo;)V
    .locals 0
    .param p1, "countryInfoArr"    # [Lorg/drinkless/tdlib/TdApi$CountryInfo;

    .line 11031
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11032
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$Countries;->countries:[Lorg/drinkless/tdlib/TdApi$CountryInfo;

    .line 11033
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11037
    const v0, 0x6e8506e5

    return v0
.end method
