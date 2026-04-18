.class public Lorg/drinkless/tdlib/TdApi$TonTransactionTypeFragmentDeposit;
.super Lorg/drinkless/tdlib/TdApi$TonTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TonTransactionTypeFragmentDeposit"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x532e1bac


# instance fields
.field public isGift:Z

.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33588
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TonTransactionType;-><init>()V

    .line 33589
    return-void
.end method

.method public constructor <init>(ZLorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 33578
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TonTransactionType;-><init>()V

    .line 33579
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$TonTransactionTypeFragmentDeposit;->isGift:Z

    .line 33580
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$TonTransactionTypeFragmentDeposit;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 33581
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33585
    const v0, -0x532e1bac

    return v0
.end method
