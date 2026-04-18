.class public Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropColors;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradedGiftBackdropColors"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4081c9


# instance fields
.field public centerColor:I

.field public edgeColor:I

.field public symbolColor:I

.field public textColor:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46326
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46327
    return-void
.end method

.method public constructor <init>(IIII)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "i11"    # I
    .param p4, "i12"    # I

    .line 46314
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46315
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropColors;->centerColor:I

    .line 46316
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropColors;->edgeColor:I

    .line 46317
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropColors;->symbolColor:I

    .line 46318
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropColors;->textColor:I

    .line 46319
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46323
    const v0, 0x4081c9

    return v0
.end method
