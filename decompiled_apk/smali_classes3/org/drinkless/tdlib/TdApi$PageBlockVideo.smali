.class public Lorg/drinkless/tdlib/TdApi$PageBlockVideo;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockVideo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1e669d32


# instance fields
.field public caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

.field public isLooped:Z

.field public needAutoplay:Z

.field public video:Lorg/drinkless/tdlib/TdApi$Video;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44502
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 44503
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Video;Lorg/drinkless/tdlib/TdApi$PageBlockCaption;ZZ)V
    .locals 0
    .param p1, "video"    # Lorg/drinkless/tdlib/TdApi$Video;
    .param p2, "pageBlockCaption"    # Lorg/drinkless/tdlib/TdApi$PageBlockCaption;
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z

    .line 44490
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 44491
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockVideo;->video:Lorg/drinkless/tdlib/TdApi$Video;

    .line 44492
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockVideo;->caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

    .line 44493
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PageBlockVideo;->needAutoplay:Z

    .line 44494
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$PageBlockVideo;->isLooped:Z

    .line 44495
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44499
    const v0, 0x1e669d32

    return v0
.end method
