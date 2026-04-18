.class public Lorg/drinkless/tdlib/TdApi$InputStoryContentVideo;
.super Lorg/drinkless/tdlib/TdApi$InputStoryContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputStoryContentVideo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3a1fdb


# instance fields
.field public addedStickerFileIds:[I

.field public coverFrameTimestamp:D

.field public duration:D

.field public isAnimation:Z

.field public video:Lorg/drinkless/tdlib/TdApi$InputFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47826
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputStoryContent;-><init>()V

    .line 47827
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;[IDDZ)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "iArr"    # [I
    .param p3, "d9"    # D
    .param p5, "d10"    # D
    .param p7, "z8"    # Z

    .line 47813
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputStoryContent;-><init>()V

    .line 47814
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputStoryContentVideo;->video:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 47815
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputStoryContentVideo;->addedStickerFileIds:[I

    .line 47816
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$InputStoryContentVideo;->duration:D

    .line 47817
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$InputStoryContentVideo;->coverFrameTimestamp:D

    .line 47818
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$InputStoryContentVideo;->isAnimation:Z

    .line 47819
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47823
    const v0, 0x3a1fdb

    return v0
.end method
