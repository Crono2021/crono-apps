.class public Lorg/drinkless/tdlib/TdApi$UpgradedGiftAttributeIdBackdrop;
.super Lorg/drinkless/tdlib/TdApi$UpgradedGiftAttributeId;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradedGiftAttributeIdBackdrop"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5724516f


# instance fields
.field public backdropId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22304
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UpgradedGiftAttributeId;-><init>()V

    .line 22305
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 22295
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UpgradedGiftAttributeId;-><init>()V

    .line 22296
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftAttributeIdBackdrop;->backdropId:I

    .line 22297
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22301
    const v0, 0x5724516f

    return v0
.end method
