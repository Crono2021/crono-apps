.class public Lorg/drinkless/tdlib/TdApi$AddChecklistTasks;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddChecklistTasks"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5ca99c6b


# instance fields
.field public chatId:J

.field public messageId:J

.field public tasks:[Lorg/drinkless/tdlib/TdApi$InputChecklistTask;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35354
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35355
    return-void
.end method

.method public constructor <init>(JJ[Lorg/drinkless/tdlib/TdApi$InputChecklistTask;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "inputChecklistTaskArr"    # [Lorg/drinkless/tdlib/TdApi$InputChecklistTask;

    .line 35343
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35344
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AddChecklistTasks;->chatId:J

    .line 35345
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$AddChecklistTasks;->messageId:J

    .line 35346
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$AddChecklistTasks;->tasks:[Lorg/drinkless/tdlib/TdApi$InputChecklistTask;

    .line 35347
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35351
    const v0, 0x5ca99c6b

    return v0
.end method
