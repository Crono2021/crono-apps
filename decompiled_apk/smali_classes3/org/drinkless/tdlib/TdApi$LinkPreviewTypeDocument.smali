.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeDocument;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeDocument"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x40fe965e


# instance fields
.field public document:Lorg/drinkless/tdlib/TdApi$Document;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15918
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15919
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Document;)V
    .locals 0
    .param p1, "document"    # Lorg/drinkless/tdlib/TdApi$Document;

    .line 15909
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15910
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeDocument;->document:Lorg/drinkless/tdlib/TdApi$Document;

    .line 15911
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15915
    const v0, -0x40fe965e

    return v0
.end method
