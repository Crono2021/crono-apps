.class public Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButtonTypeWebApp;
.super Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButtonType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineQueryResultsButtonTypeWebApp"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x475e9c9e


# instance fields
.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14406
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButtonType;-><init>()V

    .line 14407
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 14397
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButtonType;-><init>()V

    .line 14398
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButtonTypeWebApp;->url:Ljava/lang/String;

    .line 14399
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14403
    const v0, -0x475e9c9e

    return v0
.end method
