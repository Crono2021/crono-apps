.class public Lorg/drinkless/tdlib/TdApi$GetReceivedGifts;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetReceivedGifts"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ReceivedGifts;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x542615de


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public collectionId:I

.field public excludeHosted:Z

.field public excludeNonUpgradable:Z

.field public excludeSaved:Z

.field public excludeUnlimited:Z

.field public excludeUnsaved:Z

.field public excludeUpgradable:Z

.field public excludeUpgraded:Z

.field public excludeWithoutColors:Z

.field public limit:I

.field public offset:Ljava/lang/String;

.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public sortByPrice:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54382
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 54383
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$MessageSender;IZZZZZZZZZLjava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p3, "i9"    # I
    .param p4, "z8"    # Z
    .param p5, "z9"    # Z
    .param p6, "z10"    # Z
    .param p7, "z11"    # Z
    .param p8, "z12"    # Z
    .param p9, "z13"    # Z
    .param p10, "z14"    # Z
    .param p11, "z15"    # Z
    .param p12, "z16"    # Z
    .param p13, "str2"    # Ljava/lang/String;
    .param p14, "i10"    # I

    .line 54360
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 54361
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetReceivedGifts;->businessConnectionId:Ljava/lang/String;

    .line 54362
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetReceivedGifts;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 54363
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetReceivedGifts;->collectionId:I

    .line 54364
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$GetReceivedGifts;->excludeUnsaved:Z

    .line 54365
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$GetReceivedGifts;->excludeSaved:Z

    .line 54366
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$GetReceivedGifts;->excludeUnlimited:Z

    .line 54367
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$GetReceivedGifts;->excludeUpgradable:Z

    .line 54368
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$GetReceivedGifts;->excludeNonUpgradable:Z

    .line 54369
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$GetReceivedGifts;->excludeUpgraded:Z

    .line 54370
    iput-boolean p10, p0, Lorg/drinkless/tdlib/TdApi$GetReceivedGifts;->excludeWithoutColors:Z

    .line 54371
    iput-boolean p11, p0, Lorg/drinkless/tdlib/TdApi$GetReceivedGifts;->excludeHosted:Z

    .line 54372
    iput-boolean p12, p0, Lorg/drinkless/tdlib/TdApi$GetReceivedGifts;->sortByPrice:Z

    .line 54373
    iput-object p13, p0, Lorg/drinkless/tdlib/TdApi$GetReceivedGifts;->offset:Ljava/lang/String;

    .line 54374
    iput p14, p0, Lorg/drinkless/tdlib/TdApi$GetReceivedGifts;->limit:I

    .line 54375
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54379
    const v0, 0x542615de

    return v0
.end method
