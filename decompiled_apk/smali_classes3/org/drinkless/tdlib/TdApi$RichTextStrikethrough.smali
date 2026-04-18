.class public Lorg/drinkless/tdlib/TdApi$RichTextStrikethrough;
.super Lorg/drinkless/tdlib/TdApi$RichText;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RichTextStrikethrough"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2b1e6a51


# instance fields
.field public text:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19050
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 19051
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 19041
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 19042
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RichTextStrikethrough;->text:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 19043
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19047
    const v0, 0x2b1e6a51

    return v0
.end method
