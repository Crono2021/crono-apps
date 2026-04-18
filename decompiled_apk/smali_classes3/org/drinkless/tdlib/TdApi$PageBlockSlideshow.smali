.class public Lorg/drinkless/tdlib/TdApi$PageBlockSlideshow;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockSlideshow"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2023cddf


# instance fields
.field public caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

.field public pageBlocks:[Lorg/drinkless/tdlib/TdApi$PageBlock;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29144
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 29145
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$PageBlock;Lorg/drinkless/tdlib/TdApi$PageBlockCaption;)V
    .locals 0
    .param p1, "pageBlockArr"    # [Lorg/drinkless/tdlib/TdApi$PageBlock;
    .param p2, "pageBlockCaption"    # Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

    .line 29134
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 29135
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockSlideshow;->pageBlocks:[Lorg/drinkless/tdlib/TdApi$PageBlock;

    .line 29136
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockSlideshow;->caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

    .line 29137
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29141
    const v0, 0x2023cddf

    return v0
.end method
