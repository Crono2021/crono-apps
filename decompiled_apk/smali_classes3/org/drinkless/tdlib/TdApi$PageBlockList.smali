.class public Lorg/drinkless/tdlib/TdApi$PageBlockList;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockList"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3dd081a4


# instance fields
.field public items:[Lorg/drinkless/tdlib/TdApi$PageBlockListItem;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17232
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17233
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$PageBlockListItem;)V
    .locals 0
    .param p1, "pageBlockListItemArr"    # [Lorg/drinkless/tdlib/TdApi$PageBlockListItem;

    .line 17223
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17224
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockList;->items:[Lorg/drinkless/tdlib/TdApi$PageBlockListItem;

    .line 17225
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17229
    const v0, -0x3dd081a4

    return v0
.end method
