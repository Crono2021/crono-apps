.class public Lorg/drinkless/tdlib/TdApi$PageBlockPullQuote;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockPullQuote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1d38810d


# instance fields
.field public credit:Lorg/drinkless/tdlib/TdApi$RichText;

.field public text:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29104
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 29105
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;
    .param p2, "richText2"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 29094
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 29095
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockPullQuote;->text:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 29096
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockPullQuote;->credit:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 29097
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29101
    const v0, 0x1d38810d

    return v0
.end method
