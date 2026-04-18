.class public Lorg/drinkless/tdlib/TdApi$RichTextFixed;
.super Lorg/drinkless/tdlib/TdApi$RichText;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RichTextFixed"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4bc97e39


# instance fields
.field public text:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18978
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 18979
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 18969
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 18970
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RichTextFixed;->text:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 18971
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18975
    const v0, -0x4bc97e39

    return v0
.end method
