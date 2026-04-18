.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentChecklistTasksDone;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentChecklistTasksDone"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x46c98f5a


# instance fields
.field public taskCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18096
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18097
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 18087
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18088
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentChecklistTasksDone;->taskCount:I

    .line 18089
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18093
    const v0, 0x46c98f5a

    return v0
.end method
