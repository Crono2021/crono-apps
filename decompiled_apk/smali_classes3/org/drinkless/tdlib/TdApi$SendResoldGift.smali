.class public Lorg/drinkless/tdlib/TdApi$SendResoldGift;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendResoldGift"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$GiftResaleResult;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x55151c32


# instance fields
.field public giftName:Ljava/lang/String;

.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public price:Lorg/drinkless/tdlib/TdApi$GiftResalePrice;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39998
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39999
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$GiftResalePrice;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p3, "giftResalePrice"    # Lorg/drinkless/tdlib/TdApi$GiftResalePrice;

    .line 39987
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39988
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SendResoldGift;->giftName:Ljava/lang/String;

    .line 39989
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SendResoldGift;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 39990
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SendResoldGift;->price:Lorg/drinkless/tdlib/TdApi$GiftResalePrice;

    .line 39991
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39995
    const v0, -0x55151c32

    return v0
.end method
