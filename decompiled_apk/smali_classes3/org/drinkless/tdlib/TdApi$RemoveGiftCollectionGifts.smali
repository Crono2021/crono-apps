.class public Lorg/drinkless/tdlib/TdApi$RemoveGiftCollectionGifts;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RemoveGiftCollectionGifts"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$GiftCollection;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2943eb15


# instance fields
.field public collectionId:I

.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public receivedGiftIds:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39470
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39471
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;I[Ljava/lang/String;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "i9"    # I
    .param p3, "strArr"    # [Ljava/lang/String;

    .line 39459
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39460
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RemoveGiftCollectionGifts;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 39461
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$RemoveGiftCollectionGifts;->collectionId:I

    .line 39462
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$RemoveGiftCollectionGifts;->receivedGiftIds:[Ljava/lang/String;

    .line 39463
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39467
    const v0, -0x2943eb15

    return v0
.end method
