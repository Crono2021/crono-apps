.class public Lorg/drinkless/tdlib/TdApi$RichTextUrl;
.super Lorg/drinkless/tdlib/TdApi$RichText;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RichTextUrl"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x500cf14


# instance fields
.field public isCached:Z

.field public text:Lorg/drinkless/tdlib/TdApi$RichText;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39712
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 39713
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "z8"    # Z

    .line 39701
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 39702
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RichTextUrl;->text:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 39703
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$RichTextUrl;->url:Ljava/lang/String;

    .line 39704
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$RichTextUrl;->isCached:Z

    .line 39705
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39709
    const v0, 0x500cf14

    return v0
.end method
