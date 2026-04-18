.class public Lorg/drinkless/tdlib/TdApi$PageBlockSubtitle;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockSubtitle"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xfc451e7


# instance fields
.field public subtitle:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17286
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17287
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 17277
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17278
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockSubtitle;->subtitle:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 17279
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17283
    const v0, 0xfc451e7

    return v0
.end method
