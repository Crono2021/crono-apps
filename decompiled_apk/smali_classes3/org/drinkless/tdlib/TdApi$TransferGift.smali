.class public Lorg/drinkless/tdlib/TdApi$TransferGift;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TransferGift"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x45937ac6


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public newOwnerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public receivedGiftId:Ljava/lang/String;

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45942
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45943
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$MessageSender;J)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p4, "j5"    # J

    .line 45930
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45931
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TransferGift;->businessConnectionId:Ljava/lang/String;

    .line 45932
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$TransferGift;->receivedGiftId:Ljava/lang/String;

    .line 45933
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$TransferGift;->newOwnerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 45934
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$TransferGift;->starCount:J

    .line 45935
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45939
    const v0, -0x45937ac6

    return v0
.end method
