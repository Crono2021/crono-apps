.class public Lorg/drinkless/tdlib/TdApi$GetPreferredCountryLanguage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetPreferredCountryLanguage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Text;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x379d342a


# instance fields
.field public countryCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13254
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13255
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 13245
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13246
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetPreferredCountryLanguage;->countryCode:Ljava/lang/String;

    .line 13247
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13251
    const v0, -0x379d342a

    return v0
.end method
