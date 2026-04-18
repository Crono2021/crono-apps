.class public Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputIdentityDocument"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2dbce358


# instance fields
.field public expirationDate:Lorg/drinkless/tdlib/TdApi$Date;

.field public frontSide:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public number:Ljava/lang/String;

.field public reverseSide:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public selfie:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public translation:[Lorg/drinkless/tdlib/TdApi$InputFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50010
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50011
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Date;Lorg/drinkless/tdlib/TdApi$InputFile;Lorg/drinkless/tdlib/TdApi$InputFile;Lorg/drinkless/tdlib/TdApi$InputFile;[Lorg/drinkless/tdlib/TdApi$InputFile;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "date"    # Lorg/drinkless/tdlib/TdApi$Date;
    .param p3, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p4, "inputFile2"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p5, "inputFile3"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p6, "inputFileArr"    # [Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 49996
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49997
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;->number:Ljava/lang/String;

    .line 49998
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;->expirationDate:Lorg/drinkless/tdlib/TdApi$Date;

    .line 49999
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;->frontSide:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 50000
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;->reverseSide:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 50001
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;->selfie:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 50002
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;->translation:[Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 50003
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50007
    const v0, 0x2dbce358

    return v0
.end method
