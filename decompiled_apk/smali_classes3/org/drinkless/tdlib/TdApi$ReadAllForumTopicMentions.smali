.class public Lorg/drinkless/tdlib/TdApi$ReadAllForumTopicMentions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReadAllForumTopicMentions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3b6af094


# instance fields
.field public chatId:J

.field public forumTopicId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29748
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29749
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 29738
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29739
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ReadAllForumTopicMentions;->chatId:J

    .line 29740
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ReadAllForumTopicMentions;->forumTopicId:I

    .line 29741
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29745
    const v0, -0x3b6af094

    return v0
.end method
