.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypePremiumPurchase;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypePremiumPurchase"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3b7db803


# instance fields
.field public monthCount:I

.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40702
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 40703
    return-void
.end method

.method public constructor <init>(JILorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 40691
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 40692
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypePremiumPurchase;->userId:J

    .line 40693
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypePremiumPurchase;->monthCount:I

    .line 40694
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypePremiumPurchase;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 40695
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40699
    const v0, 0x3b7db803

    return v0
.end method
