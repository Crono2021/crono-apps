.class public Lorg/drinkless/tdlib/TdApi$SetPinnedGifts;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetPinnedGifts"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x602c7522


# instance fields
.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public receivedGiftIds:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31748
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31749
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;[Ljava/lang/String;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "strArr"    # [Ljava/lang/String;

    .line 31738
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31739
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetPinnedGifts;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 31740
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetPinnedGifts;->receivedGiftIds:[Ljava/lang/String;

    .line 31741
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31745
    const v0, 0x602c7522

    return v0
.end method
