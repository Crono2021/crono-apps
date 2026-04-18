.class public Lorg/drinkless/tdlib/TdApi$IdentityDocument;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "IdentityDocument"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3bb4c8b6


# instance fields
.field public expirationDate:Lorg/drinkless/tdlib/TdApi$Date;

.field public frontSide:Lorg/drinkless/tdlib/TdApi$DatedFile;

.field public number:Ljava/lang/String;

.field public reverseSide:Lorg/drinkless/tdlib/TdApi$DatedFile;

.field public selfie:Lorg/drinkless/tdlib/TdApi$DatedFile;

.field public translation:[Lorg/drinkless/tdlib/TdApi$DatedFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49982
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49983
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Date;Lorg/drinkless/tdlib/TdApi$DatedFile;Lorg/drinkless/tdlib/TdApi$DatedFile;Lorg/drinkless/tdlib/TdApi$DatedFile;[Lorg/drinkless/tdlib/TdApi$DatedFile;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "date"    # Lorg/drinkless/tdlib/TdApi$Date;
    .param p3, "datedFile"    # Lorg/drinkless/tdlib/TdApi$DatedFile;
    .param p4, "datedFile2"    # Lorg/drinkless/tdlib/TdApi$DatedFile;
    .param p5, "datedFile3"    # Lorg/drinkless/tdlib/TdApi$DatedFile;
    .param p6, "datedFileArr"    # [Lorg/drinkless/tdlib/TdApi$DatedFile;

    .line 49968
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49969
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$IdentityDocument;->number:Ljava/lang/String;

    .line 49970
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$IdentityDocument;->expirationDate:Lorg/drinkless/tdlib/TdApi$Date;

    .line 49971
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$IdentityDocument;->frontSide:Lorg/drinkless/tdlib/TdApi$DatedFile;

    .line 49972
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$IdentityDocument;->reverseSide:Lorg/drinkless/tdlib/TdApi$DatedFile;

    .line 49973
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$IdentityDocument;->selfie:Lorg/drinkless/tdlib/TdApi$DatedFile;

    .line 49974
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$IdentityDocument;->translation:[Lorg/drinkless/tdlib/TdApi$DatedFile;

    .line 49975
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49979
    const v0, 0x3bb4c8b6

    return v0
.end method
