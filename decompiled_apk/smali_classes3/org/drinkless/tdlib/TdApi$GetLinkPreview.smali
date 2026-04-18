.class public Lorg/drinkless/tdlib/TdApi$GetLinkPreview;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetLinkPreview"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$LinkPreview;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3df69cdf


# instance fields
.field public linkPreviewOptions:Lorg/drinkless/tdlib/TdApi$LinkPreviewOptions;

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26304
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26305
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FormattedText;Lorg/drinkless/tdlib/TdApi$LinkPreviewOptions;)V
    .locals 0
    .param p1, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p2, "linkPreviewOptions"    # Lorg/drinkless/tdlib/TdApi$LinkPreviewOptions;

    .line 26294
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26295
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetLinkPreview;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 26296
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetLinkPreview;->linkPreviewOptions:Lorg/drinkless/tdlib/TdApi$LinkPreviewOptions;

    .line 26297
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26301
    const v0, -0x3df69cdf

    return v0
.end method
