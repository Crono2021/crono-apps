.class public Lorg/drinkless/tdlib/TdApi$GetLanguagePackString;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetLanguagePackString"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$LanguagePackStringValue;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x8fcde73


# instance fields
.field public key:Ljava/lang/String;

.field public languagePackDatabasePath:Ljava/lang/String;

.field public languagePackId:Ljava/lang/String;

.field public localizationTarget:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43422
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43423
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "str4"    # Ljava/lang/String;

    .line 43410
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43411
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetLanguagePackString;->languagePackDatabasePath:Ljava/lang/String;

    .line 43412
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetLanguagePackString;->localizationTarget:Ljava/lang/String;

    .line 43413
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetLanguagePackString;->languagePackId:Ljava/lang/String;

    .line 43414
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$GetLanguagePackString;->key:Ljava/lang/String;

    .line 43415
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43419
    const v0, 0x8fcde73

    return v0
.end method
