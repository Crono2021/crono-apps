.class public Lorg/drinkless/tdlib/TdApi$PageBlockTitle;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockTitle"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6122b610


# instance fields
.field public title:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17304
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17305
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 17295
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17296
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockTitle;->title:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 17297
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17301
    const v0, 0x6122b610

    return v0
.end method
