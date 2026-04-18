.class public Lorg/drinkless/tdlib/TdApi$InputStoryAreaTypeUpgradedGift;
.super Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputStoryAreaTypeUpgradedGift"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2f45216e


# instance fields
.field public giftName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15180
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;-><init>()V

    .line 15181
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15171
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;-><init>()V

    .line 15172
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputStoryAreaTypeUpgradedGift;->giftName:Ljava/lang/String;

    .line 15173
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15177
    const v0, 0x2f45216e

    return v0
.end method
