.class public Lorg/drinkless/tdlib/TdApi$PersonalDetails;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PersonalDetails"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3f479649


# instance fields
.field public birthdate:Lorg/drinkless/tdlib/TdApi$Date;

.field public countryCode:Ljava/lang/String;

.field public firstName:Ljava/lang/String;

.field public gender:Ljava/lang/String;

.field public lastName:Ljava/lang/String;

.field public middleName:Ljava/lang/String;

.field public nativeFirstName:Ljava/lang/String;

.field public nativeLastName:Ljava/lang/String;

.field public nativeMiddleName:Ljava/lang/String;

.field public residenceCountryCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53384
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53385
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "str4"    # Ljava/lang/String;
    .param p5, "str5"    # Ljava/lang/String;
    .param p6, "str6"    # Ljava/lang/String;
    .param p7, "date"    # Lorg/drinkless/tdlib/TdApi$Date;
    .param p8, "str7"    # Ljava/lang/String;
    .param p9, "str8"    # Ljava/lang/String;
    .param p10, "str9"    # Ljava/lang/String;

    .line 53366
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53367
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PersonalDetails;->firstName:Ljava/lang/String;

    .line 53368
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PersonalDetails;->middleName:Ljava/lang/String;

    .line 53369
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$PersonalDetails;->lastName:Ljava/lang/String;

    .line 53370
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$PersonalDetails;->nativeFirstName:Ljava/lang/String;

    .line 53371
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$PersonalDetails;->nativeMiddleName:Ljava/lang/String;

    .line 53372
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$PersonalDetails;->nativeLastName:Ljava/lang/String;

    .line 53373
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$PersonalDetails;->birthdate:Lorg/drinkless/tdlib/TdApi$Date;

    .line 53374
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$PersonalDetails;->gender:Ljava/lang/String;

    .line 53375
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$PersonalDetails;->countryCode:Ljava/lang/String;

    .line 53376
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$PersonalDetails;->residenceCountryCode:Ljava/lang/String;

    .line 53377
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53381
    const v0, -0x3f479649

    return v0
.end method
