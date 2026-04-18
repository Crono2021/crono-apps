.class public Lorg/drinkless/tdlib/TdApi$MessageChecklistTasksAdded;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageChecklistTasksAdded"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7aa38da8


# instance fields
.field public checklistMessageId:J

.field public tasks:[Lorg/drinkless/tdlib/TdApi$ChecklistTask;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28364
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28365
    return-void
.end method

.method public constructor <init>(J[Lorg/drinkless/tdlib/TdApi$ChecklistTask;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "checklistTaskArr"    # [Lorg/drinkless/tdlib/TdApi$ChecklistTask;

    .line 28354
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28355
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageChecklistTasksAdded;->checklistMessageId:J

    .line 28356
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$MessageChecklistTasksAdded;->tasks:[Lorg/drinkless/tdlib/TdApi$ChecklistTask;

    .line 28357
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28361
    const v0, 0x7aa38da8

    return v0
.end method
