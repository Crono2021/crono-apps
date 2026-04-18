.class public Lorg/drinkless/tdlib/TdApi$StoryAreaTypeUpgradedGift;
.super Lorg/drinkless/tdlib/TdApi$StoryAreaType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryAreaTypeUpgradedGift"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2d50f987


# instance fields
.field public giftName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20382
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryAreaType;-><init>()V

    .line 20383
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 20373
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryAreaType;-><init>()V

    .line 20374
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaTypeUpgradedGift;->giftName:Ljava/lang/String;

    .line 20375
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20379
    const v0, 0x2d50f987

    return v0
.end method
