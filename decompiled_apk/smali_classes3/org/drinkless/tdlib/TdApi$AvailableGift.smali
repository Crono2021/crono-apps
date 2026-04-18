.class public Lorg/drinkless/tdlib/TdApi$AvailableGift;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AvailableGift"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x32b210c6


# instance fields
.field public gift:Lorg/drinkless/tdlib/TdApi$Gift;

.field public minResaleStarCount:J

.field public resaleCount:I

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42438
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42439
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Gift;IJLjava/lang/String;)V
    .locals 0
    .param p1, "gift"    # Lorg/drinkless/tdlib/TdApi$Gift;
    .param p2, "i9"    # I
    .param p3, "j5"    # J
    .param p5, "str"    # Ljava/lang/String;

    .line 42426
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42427
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AvailableGift;->gift:Lorg/drinkless/tdlib/TdApi$Gift;

    .line 42428
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$AvailableGift;->resaleCount:I

    .line 42429
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$AvailableGift;->minResaleStarCount:J

    .line 42430
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$AvailableGift;->title:Ljava/lang/String;

    .line 42431
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42435
    const v0, 0x32b210c6

    return v0
.end method
