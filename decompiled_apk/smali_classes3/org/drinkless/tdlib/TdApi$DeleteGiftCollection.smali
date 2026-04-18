.class public Lorg/drinkless/tdlib/TdApi$DeleteGiftCollection;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteGiftCollection"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xaf3cb7b


# instance fields
.field public collectionId:I

.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25124
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25125
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;I)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "i9"    # I

    .line 25114
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25115
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteGiftCollection;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 25116
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$DeleteGiftCollection;->collectionId:I

    .line 25117
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25121
    const v0, -0xaf3cb7b

    return v0
.end method
