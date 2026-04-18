.class public Lorg/drinkless/tdlib/TdApi$AlternativeVideo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AlternativeVideo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1ccfc90e


# instance fields
.field public codec:Ljava/lang/String;

.field public height:I

.field public hlsFile:Lorg/drinkless/tdlib/TdApi$File;

.field public id:J

.field public video:Lorg/drinkless/tdlib/TdApi$File;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49338
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49339
    return-void
.end method

.method public constructor <init>(JIILjava/lang/String;Lorg/drinkless/tdlib/TdApi$File;Lorg/drinkless/tdlib/TdApi$File;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "i10"    # I
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "file"    # Lorg/drinkless/tdlib/TdApi$File;
    .param p7, "file2"    # Lorg/drinkless/tdlib/TdApi$File;

    .line 49324
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49325
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AlternativeVideo;->id:J

    .line 49326
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$AlternativeVideo;->width:I

    .line 49327
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$AlternativeVideo;->height:I

    .line 49328
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$AlternativeVideo;->codec:Ljava/lang/String;

    .line 49329
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$AlternativeVideo;->hlsFile:Lorg/drinkless/tdlib/TdApi$File;

    .line 49330
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$AlternativeVideo;->video:Lorg/drinkless/tdlib/TdApi$File;

    .line 49331
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49335
    const v0, 0x1ccfc90e

    return v0
.end method
