.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentChecklistTasksAdded;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentChecklistTasksAdded"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7fa6258e


# instance fields
.field public taskCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18078
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18079
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 18069
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18070
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentChecklistTasksAdded;->taskCount:I

    .line 18071
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18075
    const v0, -0x7fa6258e

    return v0
.end method
