.class public Lorg/drinkless/tdlib/TdApi$SetGiftCollectionName;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetGiftCollectionName"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$GiftCollection;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x42102a09


# instance fields
.field public collectionId:I

.field public name:Ljava/lang/String;

.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40394
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40395
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;ILjava/lang/String;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "i9"    # I
    .param p3, "str"    # Ljava/lang/String;

    .line 40383
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40384
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetGiftCollectionName;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 40385
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$SetGiftCollectionName;->collectionId:I

    .line 40386
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetGiftCollectionName;->name:Ljava/lang/String;

    .line 40387
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40391
    const v0, 0x42102a09

    return v0
.end method
