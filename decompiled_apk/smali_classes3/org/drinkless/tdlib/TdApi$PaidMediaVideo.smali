.class public Lorg/drinkless/tdlib/TdApi$PaidMediaVideo;
.super Lorg/drinkless/tdlib/TdApi$PaidMedia;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PaidMediaVideo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x33e7f02e


# instance fields
.field public cover:Lorg/drinkless/tdlib/TdApi$Photo;

.field public startTimestamp:I

.field public video:Lorg/drinkless/tdlib/TdApi$Video;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38854
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaidMedia;-><init>()V

    .line 38855
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Video;Lorg/drinkless/tdlib/TdApi$Photo;I)V
    .locals 0
    .param p1, "video"    # Lorg/drinkless/tdlib/TdApi$Video;
    .param p2, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;
    .param p3, "i9"    # I

    .line 38843
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaidMedia;-><init>()V

    .line 38844
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PaidMediaVideo;->video:Lorg/drinkless/tdlib/TdApi$Video;

    .line 38845
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PaidMediaVideo;->cover:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 38846
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$PaidMediaVideo;->startTimestamp:I

    .line 38847
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38851
    const v0, 0x33e7f02e

    return v0
.end method
