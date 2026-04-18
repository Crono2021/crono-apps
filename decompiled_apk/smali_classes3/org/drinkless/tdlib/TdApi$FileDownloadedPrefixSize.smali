.class public Lorg/drinkless/tdlib/TdApi$FileDownloadedPrefixSize;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FileDownloadedPrefixSize"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x781d9805


# instance fields
.field public size:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11922
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11923
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 11913
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11914
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$FileDownloadedPrefixSize;->size:J

    .line 11915
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11919
    const v0, -0x781d9805

    return v0
.end method
