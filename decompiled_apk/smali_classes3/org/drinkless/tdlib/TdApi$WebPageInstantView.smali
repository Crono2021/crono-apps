.class public Lorg/drinkless/tdlib/TdApi$WebPageInstantView;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "WebPageInstantView"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2e626d55


# instance fields
.field public feedbackLink:Lorg/drinkless/tdlib/TdApi$InternalLinkType;

.field public isFull:Z

.field public isRtl:Z

.field public pageBlocks:[Lorg/drinkless/tdlib/TdApi$PageBlock;

.field public version:I

.field public viewCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51074
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51075
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$PageBlock;IIZZLorg/drinkless/tdlib/TdApi$InternalLinkType;)V
    .locals 0
    .param p1, "pageBlockArr"    # [Lorg/drinkless/tdlib/TdApi$PageBlock;
    .param p2, "i9"    # I
    .param p3, "i10"    # I
    .param p4, "z8"    # Z
    .param p5, "z9"    # Z
    .param p6, "internalLinkType"    # Lorg/drinkless/tdlib/TdApi$InternalLinkType;

    .line 51060
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51061
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$WebPageInstantView;->pageBlocks:[Lorg/drinkless/tdlib/TdApi$PageBlock;

    .line 51062
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$WebPageInstantView;->viewCount:I

    .line 51063
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$WebPageInstantView;->version:I

    .line 51064
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$WebPageInstantView;->isRtl:Z

    .line 51065
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$WebPageInstantView;->isFull:Z

    .line 51066
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$WebPageInstantView;->feedbackLink:Lorg/drinkless/tdlib/TdApi$InternalLinkType;

    .line 51067
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51071
    const v0, 0x2e626d55

    return v0
.end method
