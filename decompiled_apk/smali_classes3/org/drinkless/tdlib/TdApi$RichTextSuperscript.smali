.class public Lorg/drinkless/tdlib/TdApi$RichTextSuperscript;
.super Lorg/drinkless/tdlib/TdApi$RichText;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RichTextSuperscript"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x16c88a9d


# instance fields
.field public text:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19086
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 19087
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 19077
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 19078
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RichTextSuperscript;->text:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 19079
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19083
    const v0, -0x16c88a9d

    return v0
.end method
