.class public Lorg/drinkless/tdlib/TdApi$AddGiftCollectionGifts;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddGiftCollectionGifts"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$GiftCollection;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xfb4269e


# instance fields
.field public collectionId:I

.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public receivedGiftIds:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35398
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35399
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;I[Ljava/lang/String;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "i9"    # I
    .param p3, "strArr"    # [Ljava/lang/String;

    .line 35387
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35388
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AddGiftCollectionGifts;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 35389
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$AddGiftCollectionGifts;->collectionId:I

    .line 35390
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AddGiftCollectionGifts;->receivedGiftIds:[Ljava/lang/String;

    .line 35391
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35395
    const v0, -0xfb4269e

    return v0
.end method
