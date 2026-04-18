.class public Lorg/drinkless/tdlib/TdApi$StoryInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x76683cae


# instance fields
.field public date:I

.field public isForCloseFriends:Z

.field public storyId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40944
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40945
    return-void
.end method

.method public constructor <init>(IIZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "z8"    # Z

    .line 40933
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40934
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$StoryInfo;->storyId:I

    .line 40935
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$StoryInfo;->date:I

    .line 40936
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$StoryInfo;->isForCloseFriends:Z

    .line 40937
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40941
    const v0, -0x76683cae

    return v0
.end method
