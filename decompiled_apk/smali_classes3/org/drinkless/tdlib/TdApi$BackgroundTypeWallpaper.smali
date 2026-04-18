.class public Lorg/drinkless/tdlib/TdApi$BackgroundTypeWallpaper;
.super Lorg/drinkless/tdlib/TdApi$BackgroundType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BackgroundTypeWallpaper"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x758c4c7b


# instance fields
.field public isBlurred:Z

.field public isMoving:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23084
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BackgroundType;-><init>()V

    .line 23085
    return-void
.end method

.method public constructor <init>(ZZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z

    .line 23074
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BackgroundType;-><init>()V

    .line 23075
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$BackgroundTypeWallpaper;->isBlurred:Z

    .line 23076
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$BackgroundTypeWallpaper;->isMoving:Z

    .line 23077
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23081
    const v0, 0x758c4c7b

    return v0
.end method
