.class public Lorg/drinkless/tdlib/TdApi$BusinessInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5520498e


# instance fields
.field public awayMessageSettings:Lorg/drinkless/tdlib/TdApi$BusinessAwayMessageSettings;

.field public greetingMessageSettings:Lorg/drinkless/tdlib/TdApi$BusinessGreetingMessageSettings;

.field public localOpeningHours:Lorg/drinkless/tdlib/TdApi$BusinessOpeningHours;

.field public location:Lorg/drinkless/tdlib/TdApi$BusinessLocation;

.field public nextCloseIn:I

.field public nextOpenIn:I

.field public openingHours:Lorg/drinkless/tdlib/TdApi$BusinessOpeningHours;

.field public startPage:Lorg/drinkless/tdlib/TdApi$BusinessStartPage;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51948
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51949
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BusinessLocation;Lorg/drinkless/tdlib/TdApi$BusinessOpeningHours;Lorg/drinkless/tdlib/TdApi$BusinessOpeningHours;IILorg/drinkless/tdlib/TdApi$BusinessGreetingMessageSettings;Lorg/drinkless/tdlib/TdApi$BusinessAwayMessageSettings;Lorg/drinkless/tdlib/TdApi$BusinessStartPage;)V
    .locals 0
    .param p1, "businessLocation"    # Lorg/drinkless/tdlib/TdApi$BusinessLocation;
    .param p2, "businessOpeningHours"    # Lorg/drinkless/tdlib/TdApi$BusinessOpeningHours;
    .param p3, "businessOpeningHours2"    # Lorg/drinkless/tdlib/TdApi$BusinessOpeningHours;
    .param p4, "i9"    # I
    .param p5, "i10"    # I
    .param p6, "businessGreetingMessageSettings"    # Lorg/drinkless/tdlib/TdApi$BusinessGreetingMessageSettings;
    .param p7, "businessAwayMessageSettings"    # Lorg/drinkless/tdlib/TdApi$BusinessAwayMessageSettings;
    .param p8, "businessStartPage"    # Lorg/drinkless/tdlib/TdApi$BusinessStartPage;

    .line 51932
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51933
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessInfo;->location:Lorg/drinkless/tdlib/TdApi$BusinessLocation;

    .line 51934
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$BusinessInfo;->openingHours:Lorg/drinkless/tdlib/TdApi$BusinessOpeningHours;

    .line 51935
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$BusinessInfo;->localOpeningHours:Lorg/drinkless/tdlib/TdApi$BusinessOpeningHours;

    .line 51936
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$BusinessInfo;->nextOpenIn:I

    .line 51937
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$BusinessInfo;->nextCloseIn:I

    .line 51938
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$BusinessInfo;->greetingMessageSettings:Lorg/drinkless/tdlib/TdApi$BusinessGreetingMessageSettings;

    .line 51939
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$BusinessInfo;->awayMessageSettings:Lorg/drinkless/tdlib/TdApi$BusinessAwayMessageSettings;

    .line 51940
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$BusinessInfo;->startPage:Lorg/drinkless/tdlib/TdApi$BusinessStartPage;

    .line 51941
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51945
    const v0, 0x5520498e

    return v0
.end method
