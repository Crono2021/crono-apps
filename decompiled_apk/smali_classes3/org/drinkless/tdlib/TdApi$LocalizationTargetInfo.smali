.class public Lorg/drinkless/tdlib/TdApi$LocalizationTargetInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LocalizationTargetInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7a1c3c59


# instance fields
.field public languagePacks:[Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16152
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 16153
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;)V
    .locals 0
    .param p1, "languagePackInfoArr"    # [Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;

    .line 16143
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 16144
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LocalizationTargetInfo;->languagePacks:[Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;

    .line 16145
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16149
    const v0, -0x7a1c3c59

    return v0
.end method
