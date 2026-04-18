.class public Lorg/drinkless/tdlib/TdApi$SentGiftUpgraded;
.super Lorg/drinkless/tdlib/TdApi$SentGift;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SentGiftUpgraded"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x25674480


# instance fields
.field public gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19338
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SentGift;-><init>()V

    .line 19339
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$UpgradedGift;)V
    .locals 0
    .param p1, "upgradedGift"    # Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 19329
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SentGift;-><init>()V

    .line 19330
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SentGiftUpgraded;->gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 19331
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19335
    const v0, 0x25674480

    return v0
.end method
