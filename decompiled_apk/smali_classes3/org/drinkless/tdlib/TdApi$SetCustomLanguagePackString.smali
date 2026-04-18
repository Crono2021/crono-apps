.class public Lorg/drinkless/tdlib/TdApi$SetCustomLanguagePackString;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetCustomLanguagePackString"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4e762518


# instance fields
.field public languagePackId:Ljava/lang/String;

.field public newString:Lorg/drinkless/tdlib/TdApi$LanguagePackString;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31528
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31529
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$LanguagePackString;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "languagePackString"    # Lorg/drinkless/tdlib/TdApi$LanguagePackString;

    .line 31518
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31519
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetCustomLanguagePackString;->languagePackId:Ljava/lang/String;

    .line 31520
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetCustomLanguagePackString;->newString:Lorg/drinkless/tdlib/TdApi$LanguagePackString;

    .line 31521
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31525
    const v0, 0x4e762518

    return v0
.end method
