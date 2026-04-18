.class public Lorg/drinkless/tdlib/TdApi$SetChatActiveStoriesList;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatActiveStoriesList"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1f1ca2ef


# instance fields
.field public chatId:J

.field public storyList:Lorg/drinkless/tdlib/TdApi$StoryList;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31128
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31129
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$StoryList;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "storyList"    # Lorg/drinkless/tdlib/TdApi$StoryList;

    .line 31118
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31119
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatActiveStoriesList;->chatId:J

    .line 31120
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatActiveStoriesList;->storyList:Lorg/drinkless/tdlib/TdApi$StoryList;

    .line 31121
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31125
    const v0, -0x1f1ca2ef

    return v0
.end method
