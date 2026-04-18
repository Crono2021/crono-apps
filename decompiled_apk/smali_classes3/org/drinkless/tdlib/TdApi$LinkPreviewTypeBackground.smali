.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeBackground;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeBackground"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3a48a1e0


# instance fields
.field public backgroundType:Lorg/drinkless/tdlib/TdApi$BackgroundType;

.field public document:Lorg/drinkless/tdlib/TdApi$Document;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28004
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 28005
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Document;Lorg/drinkless/tdlib/TdApi$BackgroundType;)V
    .locals 0
    .param p1, "document"    # Lorg/drinkless/tdlib/TdApi$Document;
    .param p2, "backgroundType"    # Lorg/drinkless/tdlib/TdApi$BackgroundType;

    .line 27994
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 27995
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeBackground;->document:Lorg/drinkless/tdlib/TdApi$Document;

    .line 27996
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeBackground;->backgroundType:Lorg/drinkless/tdlib/TdApi$BackgroundType;

    .line 27997
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28001
    const v0, 0x3a48a1e0

    return v0
.end method
