.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeUpgradedGift;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeUpgradedGift"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x117aa30f


# instance fields
.field public gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16026
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 16027
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$UpgradedGift;)V
    .locals 0
    .param p1, "upgradedGift"    # Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 16017
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 16018
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeUpgradedGift;->gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 16019
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16023
    const v0, 0x117aa30f

    return v0
.end method
