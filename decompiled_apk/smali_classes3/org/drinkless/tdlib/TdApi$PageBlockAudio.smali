.class public Lorg/drinkless/tdlib/TdApi$PageBlockAudio;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockAudio"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3c6f7ed


# instance fields
.field public audio:Lorg/drinkless/tdlib/TdApi$Audio;

.field public caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28964
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 28965
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Audio;Lorg/drinkless/tdlib/TdApi$PageBlockCaption;)V
    .locals 0
    .param p1, "audio"    # Lorg/drinkless/tdlib/TdApi$Audio;
    .param p2, "pageBlockCaption"    # Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

    .line 28954
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 28955
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockAudio;->audio:Lorg/drinkless/tdlib/TdApi$Audio;

    .line 28956
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockAudio;->caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

    .line 28957
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28961
    const v0, -0x3c6f7ed

    return v0
.end method
