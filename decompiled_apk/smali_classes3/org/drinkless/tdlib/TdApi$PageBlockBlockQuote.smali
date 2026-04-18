.class public Lorg/drinkless/tdlib/TdApi$PageBlockBlockQuote;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockBlockQuote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x62d08a9e


# instance fields
.field public credit:Lorg/drinkless/tdlib/TdApi$RichText;

.field public text:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29004
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 29005
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;
    .param p2, "richText2"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 28994
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 28995
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockBlockQuote;->text:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 28996
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockBlockQuote;->credit:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 28997
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29001
    const v0, 0x62d08a9e

    return v0
.end method
