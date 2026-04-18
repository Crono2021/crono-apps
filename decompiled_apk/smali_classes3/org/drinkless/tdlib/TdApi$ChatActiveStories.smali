.class public Lorg/drinkless/tdlib/TdApi$ChatActiveStories;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatActiveStories"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x17a226f4


# instance fields
.field public canBeArchived:Z

.field public chatId:J

.field public list:Lorg/drinkless/tdlib/TdApi$StoryList;

.field public maxReadStoryId:I

.field public order:J

.field public stories:[Lorg/drinkless/tdlib/TdApi$StoryInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49478
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49479
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$StoryList;JZI[Lorg/drinkless/tdlib/TdApi$StoryInfo;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "storyList"    # Lorg/drinkless/tdlib/TdApi$StoryList;
    .param p4, "j9"    # J
    .param p6, "z8"    # Z
    .param p7, "i9"    # I
    .param p8, "storyInfoArr"    # [Lorg/drinkless/tdlib/TdApi$StoryInfo;

    .line 49464
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49465
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatActiveStories;->chatId:J

    .line 49466
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ChatActiveStories;->list:Lorg/drinkless/tdlib/TdApi$StoryList;

    .line 49467
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$ChatActiveStories;->order:J

    .line 49468
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$ChatActiveStories;->canBeArchived:Z

    .line 49469
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$ChatActiveStories;->maxReadStoryId:I

    .line 49470
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$ChatActiveStories;->stories:[Lorg/drinkless/tdlib/TdApi$StoryInfo;

    .line 49471
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49475
    const v0, 0x17a226f4

    return v0
.end method
