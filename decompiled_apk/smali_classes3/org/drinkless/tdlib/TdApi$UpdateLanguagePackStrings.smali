.class public Lorg/drinkless/tdlib/TdApi$UpdateLanguagePackStrings;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateLanguagePackStrings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3ef6298e


# instance fields
.field public languagePackId:Ljava/lang/String;

.field public localizationTarget:Ljava/lang/String;

.field public strings:[Lorg/drinkless/tdlib/TdApi$LanguagePackString;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41670
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41671
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;[Lorg/drinkless/tdlib/TdApi$LanguagePackString;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "languagePackStringArr"    # [Lorg/drinkless/tdlib/TdApi$LanguagePackString;

    .line 41659
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41660
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateLanguagePackStrings;->localizationTarget:Ljava/lang/String;

    .line 41661
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateLanguagePackStrings;->languagePackId:Ljava/lang/String;

    .line 41662
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateLanguagePackStrings;->strings:[Lorg/drinkless/tdlib/TdApi$LanguagePackString;

    .line 41663
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41667
    const v0, -0x3ef6298e

    return v0
.end method
