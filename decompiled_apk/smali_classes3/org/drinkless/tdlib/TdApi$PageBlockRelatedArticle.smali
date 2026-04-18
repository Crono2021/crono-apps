.class public Lorg/drinkless/tdlib/TdApi$PageBlockRelatedArticle;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockRelatedArticle"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1cae8493


# instance fields
.field public author:Ljava/lang/String;

.field public description:Ljava/lang/String;

.field public photo:Lorg/drinkless/tdlib/TdApi$Photo;

.field public publishDate:I

.field public title:Ljava/lang/String;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50374
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50375
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Photo;Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;
    .param p5, "str4"    # Ljava/lang/String;
    .param p6, "i9"    # I

    .line 50360
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50361
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockRelatedArticle;->url:Ljava/lang/String;

    .line 50362
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockRelatedArticle;->title:Ljava/lang/String;

    .line 50363
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$PageBlockRelatedArticle;->description:Ljava/lang/String;

    .line 50364
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$PageBlockRelatedArticle;->photo:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 50365
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$PageBlockRelatedArticle;->author:Ljava/lang/String;

    .line 50366
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$PageBlockRelatedArticle;->publishDate:I

    .line 50367
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50371
    const v0, 0x1cae8493

    return v0
.end method
