.class public Lorg/drinkless/tdlib/TdApi$LanguagePackString;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LanguagePackString"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4df0e460


# instance fields
.field public key:Ljava/lang/String;

.field public value:Lorg/drinkless/tdlib/TdApi$LanguagePackStringValue;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27964
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27965
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$LanguagePackStringValue;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "languagePackStringValue"    # Lorg/drinkless/tdlib/TdApi$LanguagePackStringValue;

    .line 27954
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27955
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackString;->key:Ljava/lang/String;

    .line 27956
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackString;->value:Lorg/drinkless/tdlib/TdApi$LanguagePackStringValue;

    .line 27957
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27961
    const v0, 0x4df0e460    # 5.0518733E8f

    return v0
.end method
