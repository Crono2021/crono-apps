.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeWebApp;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeWebApp"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x59d11076


# instance fields
.field public photo:Lorg/drinkless/tdlib/TdApi$Photo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16080
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 16081
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Photo;)V
    .locals 0
    .param p1, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;

    .line 16071
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 16072
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeWebApp;->photo:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 16073
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16077
    const v0, -0x59d11076

    return v0
.end method
