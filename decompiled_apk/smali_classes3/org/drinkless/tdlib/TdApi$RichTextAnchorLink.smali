.class public Lorg/drinkless/tdlib/TdApi$RichTextAnchorLink;
.super Lorg/drinkless/tdlib/TdApi$RichText;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RichTextAnchorLink"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5be02d2a


# instance fields
.field public anchorName:Ljava/lang/String;

.field public text:Lorg/drinkless/tdlib/TdApi$RichText;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39646
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 39647
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "str2"    # Ljava/lang/String;

    .line 39635
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 39636
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RichTextAnchorLink;->text:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 39637
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$RichTextAnchorLink;->anchorName:Ljava/lang/String;

    .line 39638
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$RichTextAnchorLink;->url:Ljava/lang/String;

    .line 39639
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39643
    const v0, -0x5be02d2a

    return v0
.end method
