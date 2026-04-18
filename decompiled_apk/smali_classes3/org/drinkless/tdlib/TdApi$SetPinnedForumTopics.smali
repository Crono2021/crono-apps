.class public Lorg/drinkless/tdlib/TdApi$SetPinnedForumTopics;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetPinnedForumTopics"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6f8f6511


# instance fields
.field public chatId:J

.field public forumTopicIds:[I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31728
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31729
    return-void
.end method

.method public constructor <init>(J[I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "iArr"    # [I

    .line 31718
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31719
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetPinnedForumTopics;->chatId:J

    .line 31720
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetPinnedForumTopics;->forumTopicIds:[I

    .line 31721
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31725
    const v0, -0x6f8f6511

    return v0
.end method
