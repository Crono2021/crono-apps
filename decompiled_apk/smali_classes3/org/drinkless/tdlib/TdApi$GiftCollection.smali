.class public Lorg/drinkless/tdlib/TdApi$GiftCollection;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiftCollection"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3a1cf7d8


# instance fields
.field public giftCount:I

.field public icon:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public id:I

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43662
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 43663
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Lorg/drinkless/tdlib/TdApi$Sticker;I)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p4, "i10"    # I

    .line 43650
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 43651
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GiftCollection;->id:I

    .line 43652
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GiftCollection;->name:Ljava/lang/String;

    .line 43653
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GiftCollection;->icon:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 43654
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$GiftCollection;->giftCount:I

    .line 43655
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43659
    const v0, -0x3a1cf7d8

    return v0
.end method
