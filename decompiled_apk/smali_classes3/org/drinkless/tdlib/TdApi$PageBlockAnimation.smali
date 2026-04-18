.class public Lorg/drinkless/tdlib/TdApi$PageBlockAnimation;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockAnimation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x50cde009


# instance fields
.field public animation:Lorg/drinkless/tdlib/TdApi$Animation;

.field public caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

.field public needAutoplay:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38788
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 38789
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Animation;Lorg/drinkless/tdlib/TdApi$PageBlockCaption;Z)V
    .locals 0
    .param p1, "animation"    # Lorg/drinkless/tdlib/TdApi$Animation;
    .param p2, "pageBlockCaption"    # Lorg/drinkless/tdlib/TdApi$PageBlockCaption;
    .param p3, "z8"    # Z

    .line 38777
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 38778
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockAnimation;->animation:Lorg/drinkless/tdlib/TdApi$Animation;

    .line 38779
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockAnimation;->caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

    .line 38780
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PageBlockAnimation;->needAutoplay:Z

    .line 38781
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38785
    const v0, 0x50cde009

    return v0
.end method
