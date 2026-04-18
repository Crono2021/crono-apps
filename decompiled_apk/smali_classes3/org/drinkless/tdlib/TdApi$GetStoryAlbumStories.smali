.class public Lorg/drinkless/tdlib/TdApi$GetStoryAlbumStories;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetStoryAlbumStories"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Stories;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7225f49c


# instance fields
.field public chatId:J

.field public limit:I

.field public offset:I

.field public storyAlbumId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43590
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43591
    return-void
.end method

.method public constructor <init>(JIII)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "i10"    # I
    .param p5, "i11"    # I

    .line 43578
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43579
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetStoryAlbumStories;->chatId:J

    .line 43580
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetStoryAlbumStories;->storyAlbumId:I

    .line 43581
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$GetStoryAlbumStories;->offset:I

    .line 43582
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$GetStoryAlbumStories;->limit:I

    .line 43583
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43587
    const v0, 0x7225f49c

    return v0
.end method
