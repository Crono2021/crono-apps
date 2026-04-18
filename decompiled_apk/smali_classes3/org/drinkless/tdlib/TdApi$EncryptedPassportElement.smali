.class public Lorg/drinkless/tdlib/TdApi$EncryptedPassportElement;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EncryptedPassportElement"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7759fd11


# instance fields
.field public data:[B

.field public files:[Lorg/drinkless/tdlib/TdApi$DatedFile;

.field public frontSide:Lorg/drinkless/tdlib/TdApi$DatedFile;

.field public hash:Ljava/lang/String;

.field public reverseSide:Lorg/drinkless/tdlib/TdApi$DatedFile;

.field public selfie:Lorg/drinkless/tdlib/TdApi$DatedFile;

.field public translation:[Lorg/drinkless/tdlib/TdApi$DatedFile;

.field public type:Lorg/drinkless/tdlib/TdApi$PassportElementType;

.field public value:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52630
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 52631
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PassportElementType;[BLorg/drinkless/tdlib/TdApi$DatedFile;Lorg/drinkless/tdlib/TdApi$DatedFile;Lorg/drinkless/tdlib/TdApi$DatedFile;[Lorg/drinkless/tdlib/TdApi$DatedFile;[Lorg/drinkless/tdlib/TdApi$DatedFile;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "passportElementType"    # Lorg/drinkless/tdlib/TdApi$PassportElementType;
    .param p2, "bArr"    # [B
    .param p3, "datedFile"    # Lorg/drinkless/tdlib/TdApi$DatedFile;
    .param p4, "datedFile2"    # Lorg/drinkless/tdlib/TdApi$DatedFile;
    .param p5, "datedFile3"    # Lorg/drinkless/tdlib/TdApi$DatedFile;
    .param p6, "datedFileArr"    # [Lorg/drinkless/tdlib/TdApi$DatedFile;
    .param p7, "datedFileArr2"    # [Lorg/drinkless/tdlib/TdApi$DatedFile;
    .param p8, "str"    # Ljava/lang/String;
    .param p9, "str2"    # Ljava/lang/String;

    .line 52613
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 52614
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EncryptedPassportElement;->type:Lorg/drinkless/tdlib/TdApi$PassportElementType;

    .line 52615
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$EncryptedPassportElement;->data:[B

    .line 52616
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$EncryptedPassportElement;->frontSide:Lorg/drinkless/tdlib/TdApi$DatedFile;

    .line 52617
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$EncryptedPassportElement;->reverseSide:Lorg/drinkless/tdlib/TdApi$DatedFile;

    .line 52618
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$EncryptedPassportElement;->selfie:Lorg/drinkless/tdlib/TdApi$DatedFile;

    .line 52619
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$EncryptedPassportElement;->translation:[Lorg/drinkless/tdlib/TdApi$DatedFile;

    .line 52620
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$EncryptedPassportElement;->files:[Lorg/drinkless/tdlib/TdApi$DatedFile;

    .line 52621
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$EncryptedPassportElement;->value:Ljava/lang/String;

    .line 52622
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$EncryptedPassportElement;->hash:Ljava/lang/String;

    .line 52623
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52627
    const v0, 0x7759fd11

    return v0
.end method
