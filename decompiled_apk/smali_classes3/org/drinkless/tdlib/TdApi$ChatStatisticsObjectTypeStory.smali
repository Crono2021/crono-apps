.class public Lorg/drinkless/tdlib/TdApi$ChatStatisticsObjectTypeStory;
.super Lorg/drinkless/tdlib/TdApi$ChatStatisticsObjectType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatStatisticsObjectTypeStory"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x15baf9b0


# instance fields
.field public storyId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10392
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatStatisticsObjectType;-><init>()V

    .line 10393
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 10383
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatStatisticsObjectType;-><init>()V

    .line 10384
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsObjectTypeStory;->storyId:I

    .line 10385
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10389
    const v0, 0x15baf9b0

    return v0
.end method
