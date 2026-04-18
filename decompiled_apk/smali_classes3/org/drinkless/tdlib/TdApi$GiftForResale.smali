.class public Lorg/drinkless/tdlib/TdApi$GiftForResale;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiftForResale"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x43698bb3


# instance fields
.field public gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

.field public receivedGiftId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26904
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 26905
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$UpgradedGift;Ljava/lang/String;)V
    .locals 0
    .param p1, "upgradedGift"    # Lorg/drinkless/tdlib/TdApi$UpgradedGift;
    .param p2, "str"    # Ljava/lang/String;

    .line 26894
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 26895
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GiftForResale;->gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 26896
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GiftForResale;->receivedGiftId:Ljava/lang/String;

    .line 26897
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26901
    const v0, 0x43698bb3    # 233.5457f

    return v0
.end method
