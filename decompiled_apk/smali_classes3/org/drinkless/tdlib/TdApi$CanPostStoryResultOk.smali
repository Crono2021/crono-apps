.class public Lorg/drinkless/tdlib/TdApi$CanPostStoryResultOk;
.super Lorg/drinkless/tdlib/TdApi$CanPostStoryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CanPostStoryResultOk"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7c2b31ea


# instance fields
.field public storyCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9402
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CanPostStoryResult;-><init>()V

    .line 9403
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 9393
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CanPostStoryResult;-><init>()V

    .line 9394
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$CanPostStoryResultOk;->storyCount:I

    .line 9395
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9399
    const v0, 0x7c2b31ea

    return v0
.end method
