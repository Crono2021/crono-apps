.class public Lorg/drinkless/tdlib/TdApi$UpgradedGiftAttributeIdSymbol;
.super Lorg/drinkless/tdlib/TdApi$UpgradedGiftAttributeId;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradedGiftAttributeIdSymbol"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x46d29428


# instance fields
.field public stickerId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22340
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UpgradedGiftAttributeId;-><init>()V

    .line 22341
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 22331
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UpgradedGiftAttributeId;-><init>()V

    .line 22332
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftAttributeIdSymbol;->stickerId:J

    .line 22333
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22337
    const v0, 0x46d29428

    return v0
.end method
