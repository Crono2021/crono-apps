.class public Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropCount;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradedGiftBackdropCount"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x21839f48


# instance fields
.field public backdrop:Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdrop;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35168
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35169
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdrop;I)V
    .locals 0
    .param p1, "upgradedGiftBackdrop"    # Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdrop;
    .param p2, "i9"    # I

    .line 35158
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35159
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropCount;->backdrop:Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdrop;

    .line 35160
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropCount;->totalCount:I

    .line 35161
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35165
    const v0, -0x21839f48

    return v0
.end method
