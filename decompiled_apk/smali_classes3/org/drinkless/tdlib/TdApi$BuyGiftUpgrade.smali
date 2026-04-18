.class public Lorg/drinkless/tdlib/TdApi$BuyGiftUpgrade;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BuyGiftUpgrade"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x9325eda


# instance fields
.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public prepaidUpgradeHash:Ljava/lang/String;

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35926
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35927
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;Ljava/lang/String;J)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "j5"    # J

    .line 35915
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35916
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BuyGiftUpgrade;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 35917
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$BuyGiftUpgrade;->prepaidUpgradeHash:Ljava/lang/String;

    .line 35918
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$BuyGiftUpgrade;->starCount:J

    .line 35919
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35923
    const v0, 0x9325eda

    return v0
.end method
