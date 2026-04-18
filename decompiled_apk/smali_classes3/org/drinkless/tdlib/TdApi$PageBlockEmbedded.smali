.class public Lorg/drinkless/tdlib/TdApi$PageBlockEmbedded;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockEmbedded"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x73c96263


# instance fields
.field public allowScrolling:Z

.field public caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

.field public height:I

.field public html:Ljava/lang/String;

.field public isFullWidth:Z

.field public posterPhoto:Lorg/drinkless/tdlib/TdApi$Photo;

.field public url:Ljava/lang/String;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52140
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 52141
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Photo;IILorg/drinkless/tdlib/TdApi$PageBlockCaption;ZZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;
    .param p4, "i9"    # I
    .param p5, "i10"    # I
    .param p6, "pageBlockCaption"    # Lorg/drinkless/tdlib/TdApi$PageBlockCaption;
    .param p7, "z8"    # Z
    .param p8, "z9"    # Z

    .line 52124
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 52125
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockEmbedded;->url:Ljava/lang/String;

    .line 52126
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockEmbedded;->html:Ljava/lang/String;

    .line 52127
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$PageBlockEmbedded;->posterPhoto:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 52128
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$PageBlockEmbedded;->width:I

    .line 52129
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$PageBlockEmbedded;->height:I

    .line 52130
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$PageBlockEmbedded;->caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

    .line 52131
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$PageBlockEmbedded;->isFullWidth:Z

    .line 52132
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$PageBlockEmbedded;->allowScrolling:Z

    .line 52133
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52137
    const v0, -0x73c96263    # -1.40682E-31f

    return v0
.end method
