.class public Lorg/drinkless/tdlib/TdApi$GetInstalledBackgrounds;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetInstalledBackgrounds"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Backgrounds;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3eab2fa1


# instance fields
.field public forDarkTheme:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12930
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12931
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 12921
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12922
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$GetInstalledBackgrounds;->forDarkTheme:Z

    .line 12923
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12927
    const v0, -0x3eab2fa1

    return v0
.end method
