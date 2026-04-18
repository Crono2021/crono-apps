.class public Lorg/drinkless/tdlib/TdApi$Photo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Photo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7892921f


# instance fields
.field public hasStickers:Z

.field public minithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

.field public sizes:[Lorg/drinkless/tdlib/TdApi$PhotoSize;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38920
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38921
    return-void
.end method

.method public constructor <init>(ZLorg/drinkless/tdlib/TdApi$Minithumbnail;[Lorg/drinkless/tdlib/TdApi$PhotoSize;)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "minithumbnail"    # Lorg/drinkless/tdlib/TdApi$Minithumbnail;
    .param p3, "photoSizeArr"    # [Lorg/drinkless/tdlib/TdApi$PhotoSize;

    .line 38909
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38910
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$Photo;->hasStickers:Z

    .line 38911
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$Photo;->minithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

    .line 38912
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$Photo;->sizes:[Lorg/drinkless/tdlib/TdApi$PhotoSize;

    .line 38913
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38917
    const v0, -0x7892921f

    return v0
.end method
