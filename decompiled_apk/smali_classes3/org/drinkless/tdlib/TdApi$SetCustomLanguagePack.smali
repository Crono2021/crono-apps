.class public Lorg/drinkless/tdlib/TdApi$SetCustomLanguagePack;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetCustomLanguagePack"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x11afefa3


# instance fields
.field public info:Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;

.field public strings:[Lorg/drinkless/tdlib/TdApi$LanguagePackString;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31508
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31509
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;[Lorg/drinkless/tdlib/TdApi$LanguagePackString;)V
    .locals 0
    .param p1, "languagePackInfo"    # Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;
    .param p2, "languagePackStringArr"    # [Lorg/drinkless/tdlib/TdApi$LanguagePackString;

    .line 31498
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31499
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetCustomLanguagePack;->info:Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;

    .line 31500
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetCustomLanguagePack;->strings:[Lorg/drinkless/tdlib/TdApi$LanguagePackString;

    .line 31501
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31505
    const v0, -0x11afefa3

    return v0
.end method
