.class public Lorg/drinkless/tdlib/TdApi$UpdateSavedMessagesTopicCount;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateSavedMessagesTopicCount"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x42d862f


# instance fields
.field public topicCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22070
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22071
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 22061
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22062
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateSavedMessagesTopicCount;->topicCount:I

    .line 22063
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22067
    const v0, -0x42d862f

    return v0
.end method
