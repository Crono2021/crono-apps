.class public Lorg/drinkless/tdlib/TdApi$PageBlockParagraph;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockParagraph"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x467a0766


# instance fields
.field public text:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17250
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17251
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 17241
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17242
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockParagraph;->text:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 17243
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17247
    const v0, 0x467a0766

    return v0
.end method
