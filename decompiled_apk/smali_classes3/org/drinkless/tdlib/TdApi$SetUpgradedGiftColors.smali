.class public Lorg/drinkless/tdlib/TdApi$SetUpgradedGiftColors;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetUpgradedGiftColors"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x39a0b112


# instance fields
.field public upgradedGiftColorsId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19932
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19933
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 19923
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19924
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetUpgradedGiftColors;->upgradedGiftColorsId:J

    .line 19925
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19929
    const v0, -0x39a0b112

    return v0
.end method
