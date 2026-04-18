.class public Lorg/drinkless/tdlib/TdApi$UnpinAllForumTopicMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UnpinAllForumTopicMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x425c3b63


# instance fields
.field public chatId:J

.field public forumTopicId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33688
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33689
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 33678
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33679
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UnpinAllForumTopicMessages;->chatId:J

    .line 33680
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UnpinAllForumTopicMessages;->forumTopicId:I

    .line 33681
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33685
    const v0, -0x425c3b63

    return v0
.end method
