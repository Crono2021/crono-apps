.class public Lorg/drinkless/tdlib/TdApi$SetGiftResalePrice;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetGiftResalePrice"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1649820a


# instance fields
.field public price:Lorg/drinkless/tdlib/TdApi$GiftResalePrice;

.field public receivedGiftId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31548
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31549
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$GiftResalePrice;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "giftResalePrice"    # Lorg/drinkless/tdlib/TdApi$GiftResalePrice;

    .line 31538
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31539
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetGiftResalePrice;->receivedGiftId:Ljava/lang/String;

    .line 31540
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetGiftResalePrice;->price:Lorg/drinkless/tdlib/TdApi$GiftResalePrice;

    .line 31541
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31545
    const v0, 0x1649820a

    return v0
.end method
