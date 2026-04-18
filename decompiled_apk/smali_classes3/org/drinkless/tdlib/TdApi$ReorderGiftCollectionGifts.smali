.class public Lorg/drinkless/tdlib/TdApi$ReorderGiftCollectionGifts;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReorderGiftCollectionGifts"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$GiftCollection;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5c1c0603


# instance fields
.field public collectionId:I

.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public receivedGiftIds:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39558
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39559
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;I[Ljava/lang/String;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "i9"    # I
    .param p3, "strArr"    # [Ljava/lang/String;

    .line 39547
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39548
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReorderGiftCollectionGifts;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 39549
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$ReorderGiftCollectionGifts;->collectionId:I

    .line 39550
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ReorderGiftCollectionGifts;->receivedGiftIds:[Ljava/lang/String;

    .line 39551
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39555
    const v0, -0x5c1c0603

    return v0
.end method
