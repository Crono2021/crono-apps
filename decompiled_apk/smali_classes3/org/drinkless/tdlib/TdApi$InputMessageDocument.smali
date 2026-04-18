.class public Lorg/drinkless/tdlib/TdApi$InputMessageDocument;
.super Lorg/drinkless/tdlib/TdApi$InputMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessageDocument"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x615b72b9


# instance fields
.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public disableContentTypeDetection:Z

.field public document:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$InputThumbnail;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43902
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 43903
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;Lorg/drinkless/tdlib/TdApi$InputThumbnail;ZLorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "inputThumbnail"    # Lorg/drinkless/tdlib/TdApi$InputThumbnail;
    .param p3, "z8"    # Z
    .param p4, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 43890
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 43891
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessageDocument;->document:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 43892
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputMessageDocument;->thumbnail:Lorg/drinkless/tdlib/TdApi$InputThumbnail;

    .line 43893
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$InputMessageDocument;->disableContentTypeDetection:Z

    .line 43894
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InputMessageDocument;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 43895
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43899
    const v0, 0x615b72b9

    return v0
.end method
