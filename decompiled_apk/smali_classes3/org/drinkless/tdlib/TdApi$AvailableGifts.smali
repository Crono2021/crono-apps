.class public Lorg/drinkless/tdlib/TdApi$AvailableGifts;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AvailableGifts"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x567275fe


# instance fields
.field public gifts:[Lorg/drinkless/tdlib/TdApi$AvailableGift;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9006
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 9007
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$AvailableGift;)V
    .locals 0
    .param p1, "availableGiftArr"    # [Lorg/drinkless/tdlib/TdApi$AvailableGift;

    .line 8997
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 8998
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AvailableGifts;->gifts:[Lorg/drinkless/tdlib/TdApi$AvailableGift;

    .line 8999
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9003
    const v0, -0x567275fe

    return v0
.end method
