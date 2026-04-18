.class public Lorg/drinkless/tdlib/TdApi$PageBlockEmbeddedPost;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockEmbeddedPost"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x17b2e8b5


# instance fields
.field public author:Ljava/lang/String;

.field public authorPhoto:Lorg/drinkless/tdlib/TdApi$Photo;

.field public caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

.field public date:I

.field public pageBlocks:[Lorg/drinkless/tdlib/TdApi$PageBlock;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50346
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 50347
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Photo;I[Lorg/drinkless/tdlib/TdApi$PageBlock;Lorg/drinkless/tdlib/TdApi$PageBlockCaption;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;
    .param p4, "i9"    # I
    .param p5, "pageBlockArr"    # [Lorg/drinkless/tdlib/TdApi$PageBlock;
    .param p6, "pageBlockCaption"    # Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

    .line 50332
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 50333
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockEmbeddedPost;->url:Ljava/lang/String;

    .line 50334
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockEmbeddedPost;->author:Ljava/lang/String;

    .line 50335
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$PageBlockEmbeddedPost;->authorPhoto:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 50336
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$PageBlockEmbeddedPost;->date:I

    .line 50337
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$PageBlockEmbeddedPost;->pageBlocks:[Lorg/drinkless/tdlib/TdApi$PageBlock;

    .line 50338
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$PageBlockEmbeddedPost;->caption:Lorg/drinkless/tdlib/TdApi$PageBlockCaption;

    .line 50339
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50343
    const v0, 0x17b2e8b5

    return v0
.end method
