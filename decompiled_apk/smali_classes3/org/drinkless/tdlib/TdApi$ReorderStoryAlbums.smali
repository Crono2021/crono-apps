.class public Lorg/drinkless/tdlib/TdApi$ReorderStoryAlbums;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReorderStoryAlbums"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1ea97c8c


# instance fields
.field public chatId:J

.field public storyAlbumIds:[I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30108
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30109
    return-void
.end method

.method public constructor <init>(J[I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "iArr"    # [I

    .line 30098
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30099
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ReorderStoryAlbums;->chatId:J

    .line 30100
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ReorderStoryAlbums;->storyAlbumIds:[I

    .line 30101
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30105
    const v0, 0x1ea97c8c

    return v0
.end method
