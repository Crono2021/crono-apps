.class public Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LanguagePackInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x20514f5a


# instance fields
.field public baseLanguagePackId:Ljava/lang/String;

.field public id:Ljava/lang/String;

.field public isBeta:Z

.field public isInstalled:Z

.field public isOfficial:Z

.field public isRtl:Z

.field public localStringCount:I

.field public name:Ljava/lang/String;

.field public nativeName:Ljava/lang/String;

.field public pluralCode:Ljava/lang/String;

.field public totalStringCount:I

.field public translatedStringCount:I

.field public translationUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54078
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54079
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZIIILjava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "str4"    # Ljava/lang/String;
    .param p5, "str5"    # Ljava/lang/String;
    .param p6, "z8"    # Z
    .param p7, "z9"    # Z
    .param p8, "z10"    # Z
    .param p9, "z11"    # Z
    .param p10, "i9"    # I
    .param p11, "i10"    # I
    .param p12, "i11"    # I
    .param p13, "str6"    # Ljava/lang/String;

    .line 54057
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54058
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;->id:Ljava/lang/String;

    .line 54059
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;->baseLanguagePackId:Ljava/lang/String;

    .line 54060
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;->name:Ljava/lang/String;

    .line 54061
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;->nativeName:Ljava/lang/String;

    .line 54062
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;->pluralCode:Ljava/lang/String;

    .line 54063
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;->isOfficial:Z

    .line 54064
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;->isRtl:Z

    .line 54065
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;->isBeta:Z

    .line 54066
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;->isInstalled:Z

    .line 54067
    iput p10, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;->totalStringCount:I

    .line 54068
    iput p11, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;->translatedStringCount:I

    .line 54069
    iput p12, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;->localStringCount:I

    .line 54070
    iput-object p13, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;->translationUrl:Ljava/lang/String;

    .line 54071
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54075
    const v0, 0x20514f5a

    return v0
.end method
