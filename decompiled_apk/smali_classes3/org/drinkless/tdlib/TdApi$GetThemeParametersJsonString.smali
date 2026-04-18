.class public Lorg/drinkless/tdlib/TdApi$GetThemeParametersJsonString;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetThemeParametersJsonString"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Text;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6e46fa08


# instance fields
.field public theme:Lorg/drinkless/tdlib/TdApi$ThemeParameters;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13794
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13795
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ThemeParameters;)V
    .locals 0
    .param p1, "themeParameters"    # Lorg/drinkless/tdlib/TdApi$ThemeParameters;

    .line 13785
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13786
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetThemeParametersJsonString;->theme:Lorg/drinkless/tdlib/TdApi$ThemeParameters;

    .line 13787
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13791
    const v0, -0x6e46fa08

    return v0
.end method
