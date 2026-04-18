.class public Lorg/drinkless/tdlib/TdApi$StoryFullId;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryFullId"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2da781a3


# instance fields
.field public posterChatId:J

.field public storyId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32848
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 32849
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 32838
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 32839
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StoryFullId;->posterChatId:J

    .line 32840
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$StoryFullId;->storyId:I

    .line 32841
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32845
    const v0, 0x2da781a3

    return v0
.end method
