.class public Lorg/drinkless/tdlib/TdApi$StoryInteractionInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryInteractionInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x327534f1


# instance fields
.field public forwardCount:I

.field public reactionCount:I

.field public recentViewerUserIds:[J

.field public viewCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45726
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45727
    return-void
.end method

.method public constructor <init>(III[J)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "i11"    # I
    .param p4, "jArr"    # [J

    .line 45714
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45715
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$StoryInteractionInfo;->viewCount:I

    .line 45716
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$StoryInteractionInfo;->forwardCount:I

    .line 45717
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$StoryInteractionInfo;->reactionCount:I

    .line 45718
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$StoryInteractionInfo;->recentViewerUserIds:[J

    .line 45719
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45723
    const v0, -0x327534f1

    return v0
.end method
