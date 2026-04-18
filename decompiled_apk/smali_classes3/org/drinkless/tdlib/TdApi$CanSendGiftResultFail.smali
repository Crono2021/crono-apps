.class public Lorg/drinkless/tdlib/TdApi$CanSendGiftResultFail;
.super Lorg/drinkless/tdlib/TdApi$CanSendGiftResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CanSendGiftResultFail"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x51025b3c


# instance fields
.field public reason:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9474
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CanSendGiftResult;-><init>()V

    .line 9475
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 9465
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CanSendGiftResult;-><init>()V

    .line 9466
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CanSendGiftResultFail;->reason:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 9467
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9471
    const v0, 0x51025b3c

    return v0
.end method
