.class public Lorg/drinkless/tdlib/TdApi$AcceptedGiftTypes;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AcceptedGiftTypes"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6a4e6014


# instance fields
.field public limitedGifts:Z

.field public premiumSubscription:Z

.field public unlimitedGifts:Z

.field public upgradedGifts:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42222
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42223
    return-void
.end method

.method public constructor <init>(ZZZZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z
    .param p3, "z10"    # Z
    .param p4, "z11"    # Z

    .line 42210
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42211
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$AcceptedGiftTypes;->unlimitedGifts:Z

    .line 42212
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$AcceptedGiftTypes;->limitedGifts:Z

    .line 42213
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$AcceptedGiftTypes;->upgradedGifts:Z

    .line 42214
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$AcceptedGiftTypes;->premiumSubscription:Z

    .line 42215
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42219
    const v0, 0x6a4e6014

    return v0
.end method
