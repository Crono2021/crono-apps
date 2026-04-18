.class public Lorg/drinkless/tdlib/TdApi$UpgradeGift;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradeGift"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$UpgradeGiftResult;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6a393d27


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public keepOriginalDetails:Z

.field public receivedGiftId:Ljava/lang/String;

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46278
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 46279
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZJ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "z8"    # Z
    .param p4, "j5"    # J

    .line 46266
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 46267
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpgradeGift;->businessConnectionId:Ljava/lang/String;

    .line 46268
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpgradeGift;->receivedGiftId:Ljava/lang/String;

    .line 46269
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$UpgradeGift;->keepOriginalDetails:Z

    .line 46270
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$UpgradeGift;->starCount:J

    .line 46271
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46275
    const v0, -0x6a393d27

    return v0
.end method
