.class public Lorg/drinkless/tdlib/TdApi$PageBlockMap;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockMap"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5a0f7013


# instance fields
.field public caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

.field public height:I

.field public location:Lorg/drinkless/tdlib/TdApi$Location;

.field public width:I

.field public zoom:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48294
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 48295
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Location;IIILorg/drinkless/tdlib/TdApi$PageBlockCaption;)V
    .locals 0
    .param p1, "location"    # Lorg/drinkless/tdlib/TdApi$Location;
    .param p2, "i9"    # I
    .param p3, "i10"    # I
    .param p4, "i11"    # I
    .param p5, "pageBlockCaption"    # Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

    .line 48281
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 48282
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockMap;->location:Lorg/drinkless/tdlib/TdApi$Location;

    .line 48283
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockMap;->zoom:I

    .line 48284
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$PageBlockMap;->width:I

    .line 48285
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$PageBlockMap;->height:I

    .line 48286
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$PageBlockMap;->caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

    .line 48287
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48291
    const v0, 0x5a0f7013

    return v0
.end method
