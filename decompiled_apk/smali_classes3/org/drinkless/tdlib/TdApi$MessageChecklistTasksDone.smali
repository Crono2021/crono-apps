.class public Lorg/drinkless/tdlib/TdApi$MessageChecklistTasksDone;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageChecklistTasksDone"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2aae90c9


# instance fields
.field public checklistMessageId:J

.field public markedAsDoneTaskIds:[I

.field public markedAsNotDoneTaskIds:[I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38480
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38481
    return-void
.end method

.method public constructor <init>(J[I[I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "iArr"    # [I
    .param p4, "iArr2"    # [I

    .line 38469
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38470
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageChecklistTasksDone;->checklistMessageId:J

    .line 38471
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$MessageChecklistTasksDone;->markedAsDoneTaskIds:[I

    .line 38472
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$MessageChecklistTasksDone;->markedAsNotDoneTaskIds:[I

    .line 38473
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38477
    const v0, -0x2aae90c9

    return v0
.end method
