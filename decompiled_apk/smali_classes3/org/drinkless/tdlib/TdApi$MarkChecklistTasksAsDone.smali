.class public Lorg/drinkless/tdlib/TdApi$MarkChecklistTasksAsDone;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MarkChecklistTasksAsDone"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x17106653


# instance fields
.field public chatId:J

.field public markedAsDoneTaskIds:[I

.field public markedAsNotDoneTaskIds:[I

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44118
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44119
    return-void
.end method

.method public constructor <init>(JJ[I[I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "iArr"    # [I
    .param p6, "iArr2"    # [I

    .line 44106
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44107
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MarkChecklistTasksAsDone;->chatId:J

    .line 44108
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$MarkChecklistTasksAsDone;->messageId:J

    .line 44109
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$MarkChecklistTasksAsDone;->markedAsDoneTaskIds:[I

    .line 44110
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$MarkChecklistTasksAsDone;->markedAsNotDoneTaskIds:[I

    .line 44111
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44115
    const v0, 0x17106653

    return v0
.end method
