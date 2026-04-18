.class public Lorg/drinkless/tdlib/TdApi$SetStoryAlbumName;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetStoryAlbumName"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StoryAlbum;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4422c6c2


# instance fields
.field public chatId:J

.field public name:Ljava/lang/String;

.field public storyAlbumId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40548
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40549
    return-void
.end method

.method public constructor <init>(JILjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "str"    # Ljava/lang/String;

    .line 40537
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40538
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetStoryAlbumName;->chatId:J

    .line 40539
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$SetStoryAlbumName;->storyAlbumId:I

    .line 40540
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SetStoryAlbumName;->name:Ljava/lang/String;

    .line 40541
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40545
    const v0, -0x4422c6c2

    return v0
.end method
