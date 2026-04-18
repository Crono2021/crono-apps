.class public Lorg/drinkless/tdlib/TdApi$GetLocalizationTargetInfo;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetLocalizationTargetInfo"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$LocalizationTargetInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6e3d1f86


# instance fields
.field public onlyLocal:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13038
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13039
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 13029
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13030
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$GetLocalizationTargetInfo;->onlyLocal:Z

    .line 13031
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13035
    const v0, 0x6e3d1f86

    return v0
.end method
