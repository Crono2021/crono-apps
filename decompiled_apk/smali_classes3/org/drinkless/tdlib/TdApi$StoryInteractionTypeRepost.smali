.class public Lorg/drinkless/tdlib/TdApi$StoryInteractionTypeRepost;
.super Lorg/drinkless/tdlib/TdApi$StoryInteractionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryInteractionTypeRepost"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3cdd863c


# instance fields
.field public story:Lorg/drinkless/tdlib/TdApi$Story;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20454
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryInteractionType;-><init>()V

    .line 20455
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Story;)V
    .locals 0
    .param p1, "story"    # Lorg/drinkless/tdlib/TdApi$Story;

    .line 20445
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryInteractionType;-><init>()V

    .line 20446
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoryInteractionTypeRepost;->story:Lorg/drinkless/tdlib/TdApi$Story;

    .line 20447
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20451
    const v0, -0x3cdd863c

    return v0
.end method
