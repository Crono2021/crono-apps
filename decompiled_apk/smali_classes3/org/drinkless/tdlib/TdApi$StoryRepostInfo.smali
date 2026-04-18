.class public Lorg/drinkless/tdlib/TdApi$StoryRepostInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryRepostInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x805bc0


# instance fields
.field public isContentModified:Z

.field public origin:Lorg/drinkless/tdlib/TdApi$StoryOrigin;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32888
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 32889
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StoryOrigin;Z)V
    .locals 0
    .param p1, "storyOrigin"    # Lorg/drinkless/tdlib/TdApi$StoryOrigin;
    .param p2, "z8"    # Z

    .line 32878
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 32879
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoryRepostInfo;->origin:Lorg/drinkless/tdlib/TdApi$StoryOrigin;

    .line 32880
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$StoryRepostInfo;->isContentModified:Z

    .line 32881
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32885
    const v0, -0x805bc0

    return v0
.end method
