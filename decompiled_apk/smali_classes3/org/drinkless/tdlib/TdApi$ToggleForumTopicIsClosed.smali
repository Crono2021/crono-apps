.class public Lorg/drinkless/tdlib/TdApi$ToggleForumTopicIsClosed;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleForumTopicIsClosed"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3a8a78a0


# instance fields
.field public chatId:J

.field public forumTopicId:I

.field public isClosed:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41120
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41121
    return-void
.end method

.method public constructor <init>(JIZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "z8"    # Z

    .line 41109
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41110
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleForumTopicIsClosed;->chatId:J

    .line 41111
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleForumTopicIsClosed;->forumTopicId:I

    .line 41112
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ToggleForumTopicIsClosed;->isClosed:Z

    .line 41113
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41117
    const v0, 0x3a8a78a0

    return v0
.end method
