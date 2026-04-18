.class public Lorg/drinkless/tdlib/TdApi$LanguagePackStringValuePluralized;
.super Lorg/drinkless/tdlib/TdApi$LanguagePackStringValue;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LanguagePackStringValuePluralized"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x71a812c5


# instance fields
.field public fewValue:Ljava/lang/String;

.field public manyValue:Ljava/lang/String;

.field public oneValue:Ljava/lang/String;

.field public otherValue:Ljava/lang/String;

.field public twoValue:Ljava/lang/String;

.field public zeroValue:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50150
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LanguagePackStringValue;-><init>()V

    .line 50151
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "str4"    # Ljava/lang/String;
    .param p5, "str5"    # Ljava/lang/String;
    .param p6, "str6"    # Ljava/lang/String;

    .line 50136
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LanguagePackStringValue;-><init>()V

    .line 50137
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackStringValuePluralized;->zeroValue:Ljava/lang/String;

    .line 50138
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackStringValuePluralized;->oneValue:Ljava/lang/String;

    .line 50139
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackStringValuePluralized;->twoValue:Ljava/lang/String;

    .line 50140
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackStringValuePluralized;->fewValue:Ljava/lang/String;

    .line 50141
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackStringValuePluralized;->manyValue:Ljava/lang/String;

    .line 50142
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackStringValuePluralized;->otherValue:Ljava/lang/String;

    .line 50143
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50147
    const v0, 0x71a812c5

    return v0
.end method
