.class public Lorg/drinkless/tdlib/TdApi$StoryInteractions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryInteractions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5b9db832


# instance fields
.field public interactions:[Lorg/drinkless/tdlib/TdApi$StoryInteraction;

.field public nextOffset:Ljava/lang/String;

.field public totalCount:I

.field public totalForwardCount:I

.field public totalReactionCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48996
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48997
    return-void
.end method

.method public constructor <init>(III[Lorg/drinkless/tdlib/TdApi$StoryInteraction;Ljava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "i11"    # I
    .param p4, "storyInteractionArr"    # [Lorg/drinkless/tdlib/TdApi$StoryInteraction;
    .param p5, "str"    # Ljava/lang/String;

    .line 48983
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48984
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$StoryInteractions;->totalCount:I

    .line 48985
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$StoryInteractions;->totalForwardCount:I

    .line 48986
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$StoryInteractions;->totalReactionCount:I

    .line 48987
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$StoryInteractions;->interactions:[Lorg/drinkless/tdlib/TdApi$StoryInteraction;

    .line 48988
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$StoryInteractions;->nextOffset:Ljava/lang/String;

    .line 48989
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48993
    const v0, 0x5b9db832

    return v0
.end method
