.class public Lorg/drinkless/tdlib/TdApi$SearchGiftsForResale;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchGiftsForResale"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$GiftsForResale;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x62e6ec1e


# instance fields
.field public attributes:[Lorg/drinkless/tdlib/TdApi$UpgradedGiftAttributeId;

.field public giftId:J

.field public limit:I

.field public offset:Ljava/lang/String;

.field public order:Lorg/drinkless/tdlib/TdApi$GiftForResaleOrder;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48554
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48555
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$GiftForResaleOrder;[Lorg/drinkless/tdlib/TdApi$UpgradedGiftAttributeId;Ljava/lang/String;I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "giftForResaleOrder"    # Lorg/drinkless/tdlib/TdApi$GiftForResaleOrder;
    .param p4, "upgradedGiftAttributeIdArr"    # [Lorg/drinkless/tdlib/TdApi$UpgradedGiftAttributeId;
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "i9"    # I

    .line 48541
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48542
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SearchGiftsForResale;->giftId:J

    .line 48543
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SearchGiftsForResale;->order:Lorg/drinkless/tdlib/TdApi$GiftForResaleOrder;

    .line 48544
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SearchGiftsForResale;->attributes:[Lorg/drinkless/tdlib/TdApi$UpgradedGiftAttributeId;

    .line 48545
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SearchGiftsForResale;->offset:Ljava/lang/String;

    .line 48546
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$SearchGiftsForResale;->limit:I

    .line 48547
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48551
    const v0, 0x62e6ec1e

    return v0
.end method
