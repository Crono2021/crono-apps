.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeChannelBoost;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeChannelBoost"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x390bfbaa


# instance fields
.field public photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15882
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15883
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatPhoto;)V
    .locals 0
    .param p1, "chatPhoto"    # Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 15873
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15874
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeChannelBoost;->photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 15875
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15879
    const v0, -0x390bfbaa

    return v0
.end method
