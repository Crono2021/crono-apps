.class public Lorg/drinkless/tdlib/TdApi$Thumbnail;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Thumbnail"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4a1ae06b


# instance fields
.field public file:Lorg/drinkless/tdlib/TdApi$File;

.field public format:Lorg/drinkless/tdlib/TdApi$ThumbnailFormat;

.field public height:I

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45846
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45847
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ThumbnailFormat;IILorg/drinkless/tdlib/TdApi$File;)V
    .locals 0
    .param p1, "thumbnailFormat"    # Lorg/drinkless/tdlib/TdApi$ThumbnailFormat;
    .param p2, "i9"    # I
    .param p3, "i10"    # I
    .param p4, "file"    # Lorg/drinkless/tdlib/TdApi$File;

    .line 45834
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45835
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$Thumbnail;->format:Lorg/drinkless/tdlib/TdApi$ThumbnailFormat;

    .line 45836
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$Thumbnail;->width:I

    .line 45837
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$Thumbnail;->height:I

    .line 45838
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$Thumbnail;->file:Lorg/drinkless/tdlib/TdApi$File;

    .line 45839
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45843
    const v0, 0x4a1ae06b    # 2537498.8f

    return v0
.end method
