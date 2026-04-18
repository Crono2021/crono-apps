.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeApp;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeApp"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1c597211


# instance fields
.field public photo:Lorg/drinkless/tdlib/TdApi$Photo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15828
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15829
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Photo;)V
    .locals 0
    .param p1, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;

    .line 15819
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15820
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeApp;->photo:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 15821
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15825
    const v0, -0x1c597211

    return v0
.end method
