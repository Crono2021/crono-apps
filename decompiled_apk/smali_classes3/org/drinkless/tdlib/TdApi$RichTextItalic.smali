.class public Lorg/drinkless/tdlib/TdApi$RichTextItalic;
.super Lorg/drinkless/tdlib/TdApi$RichText;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RichTextItalic"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6e77f03f


# instance fields
.field public text:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18996
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 18997
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 18987
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 18988
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RichTextItalic;->text:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 18989
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18993
    const v0, 0x6e77f03f

    return v0
.end method
