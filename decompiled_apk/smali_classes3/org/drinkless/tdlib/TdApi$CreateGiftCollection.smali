.class public Lorg/drinkless/tdlib/TdApi$CreateGiftCollection;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateGiftCollection"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$GiftCollection;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x17ab1563


# instance fields
.field public name:Ljava/lang/String;

.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public receivedGiftIds:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36454
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36455
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;Ljava/lang/String;[Ljava/lang/String;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "strArr"    # [Ljava/lang/String;

    .line 36443
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36444
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CreateGiftCollection;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 36445
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$CreateGiftCollection;->name:Ljava/lang/String;

    .line 36446
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CreateGiftCollection;->receivedGiftIds:[Ljava/lang/String;

    .line 36447
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36451
    const v0, -0x17ab1563

    return v0
.end method
