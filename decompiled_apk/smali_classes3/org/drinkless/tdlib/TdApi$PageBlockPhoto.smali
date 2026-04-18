.class public Lorg/drinkless/tdlib/TdApi$PageBlockPhoto;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockPhoto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x18e41684


# instance fields
.field public caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

.field public photo:Lorg/drinkless/tdlib/TdApi$Photo;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38832
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 38833
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Photo;Lorg/drinkless/tdlib/TdApi$PageBlockCaption;Ljava/lang/String;)V
    .locals 0
    .param p1, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;
    .param p2, "pageBlockCaption"    # Lorg/drinkless/tdlib/TdApi$PageBlockCaption;
    .param p3, "str"    # Ljava/lang/String;

    .line 38821
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 38822
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockPhoto;->photo:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 38823
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockPhoto;->caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

    .line 38824
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$PageBlockPhoto;->url:Ljava/lang/String;

    .line 38825
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38829
    const v0, 0x18e41684

    return v0
.end method
