.class public Lorg/drinkless/tdlib/TdApi$InputMessageText;
.super Lorg/drinkless/tdlib/TdApi$InputMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessageText"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xcaf276c


# instance fields
.field public clearDraft:Z

.field public linkPreviewOptions:Lorg/drinkless/tdlib/TdApi$LinkPreviewOptions;

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37996
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 37997
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FormattedText;Lorg/drinkless/tdlib/TdApi$LinkPreviewOptions;Z)V
    .locals 0
    .param p1, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p2, "linkPreviewOptions"    # Lorg/drinkless/tdlib/TdApi$LinkPreviewOptions;
    .param p3, "z8"    # Z

    .line 37985
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 37986
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessageText;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 37987
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputMessageText;->linkPreviewOptions:Lorg/drinkless/tdlib/TdApi$LinkPreviewOptions;

    .line 37988
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$InputMessageText;->clearDraft:Z

    .line 37989
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37993
    const v0, -0xcaf276c

    return v0
.end method
