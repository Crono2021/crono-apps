.class public Lorg/drinkless/tdlib/TdApi$PageBlockCollage;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockCollage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x455d91ee


# instance fields
.field public caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

.field public pageBlocks:[Lorg/drinkless/tdlib/TdApi$PageBlock;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29044
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 29045
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$PageBlock;Lorg/drinkless/tdlib/TdApi$PageBlockCaption;)V
    .locals 0
    .param p1, "pageBlockArr"    # [Lorg/drinkless/tdlib/TdApi$PageBlock;
    .param p2, "pageBlockCaption"    # Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

    .line 29034
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 29035
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockCollage;->pageBlocks:[Lorg/drinkless/tdlib/TdApi$PageBlock;

    .line 29036
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockCollage;->caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

    .line 29037
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29041
    const v0, 0x455d91ee

    return v0
.end method
