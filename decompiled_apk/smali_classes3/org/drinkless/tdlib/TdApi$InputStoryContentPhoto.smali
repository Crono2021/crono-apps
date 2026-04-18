.class public Lorg/drinkless/tdlib/TdApi$InputStoryContentPhoto;
.super Lorg/drinkless/tdlib/TdApi$InputStoryContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputStoryContentPhoto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x126df7b7


# instance fields
.field public addedStickerFileIds:[I

.field public photo:Lorg/drinkless/tdlib/TdApi$InputFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27544
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputStoryContent;-><init>()V

    .line 27545
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;[I)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "iArr"    # [I

    .line 27534
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputStoryContent;-><init>()V

    .line 27535
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputStoryContentPhoto;->photo:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 27536
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputStoryContentPhoto;->addedStickerFileIds:[I

    .line 27537
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27541
    const v0, -0x126df7b7

    return v0
.end method
