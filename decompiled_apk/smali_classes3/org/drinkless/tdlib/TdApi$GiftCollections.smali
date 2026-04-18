.class public Lorg/drinkless/tdlib/TdApi$GiftCollections;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiftCollections"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7addc177


# instance fields
.field public collections:[Lorg/drinkless/tdlib/TdApi$GiftCollection;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14028
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 14029
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$GiftCollection;)V
    .locals 0
    .param p1, "giftCollectionArr"    # [Lorg/drinkless/tdlib/TdApi$GiftCollection;

    .line 14019
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 14020
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GiftCollections;->collections:[Lorg/drinkless/tdlib/TdApi$GiftCollection;

    .line 14021
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14025
    const v0, -0x7addc177

    return v0
.end method
