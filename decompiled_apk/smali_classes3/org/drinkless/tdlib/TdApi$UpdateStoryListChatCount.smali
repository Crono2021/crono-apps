.class public Lorg/drinkless/tdlib/TdApi$UpdateStoryListChatCount;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateStoryListChatCount"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x77cc32c1


# instance fields
.field public chatCount:I

.field public storyList:Lorg/drinkless/tdlib/TdApi$StoryList;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34948
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34949
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StoryList;I)V
    .locals 0
    .param p1, "storyList"    # Lorg/drinkless/tdlib/TdApi$StoryList;
    .param p2, "i9"    # I

    .line 34938
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34939
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateStoryListChatCount;->storyList:Lorg/drinkless/tdlib/TdApi$StoryList;

    .line 34940
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateStoryListChatCount;->chatCount:I

    .line 34941
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34945
    const v0, -0x77cc32c1

    return v0
.end method
