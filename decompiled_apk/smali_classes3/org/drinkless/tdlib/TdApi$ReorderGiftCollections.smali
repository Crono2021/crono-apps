.class public Lorg/drinkless/tdlib/TdApi$ReorderGiftCollections;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReorderGiftCollections"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5fcc2f10


# instance fields
.field public collectionIds:[I

.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30068
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30069
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;[I)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "iArr"    # [I

    .line 30058
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30059
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReorderGiftCollections;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 30060
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ReorderGiftCollections;->collectionIds:[I

    .line 30061
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30065
    const v0, -0x5fcc2f10

    return v0
.end method
