.class public Lorg/drinkless/tdlib/TdApi$UpdateStoryDeleted;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateStoryDeleted"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x22bbf47e


# instance fields
.field public storyId:I

.field public storyPosterChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34928
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34929
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 34918
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34919
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateStoryDeleted;->storyPosterChatId:J

    .line 34920
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateStoryDeleted;->storyId:I

    .line 34921
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34925
    const v0, -0x22bbf47e

    return v0
.end method
