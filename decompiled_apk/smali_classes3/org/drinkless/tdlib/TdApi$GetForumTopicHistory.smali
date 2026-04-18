.class public Lorg/drinkless/tdlib/TdApi$GetForumTopicHistory;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetForumTopicHistory"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Messages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1436b5bf


# instance fields
.field public chatId:J

.field public forumTopicId:I

.field public fromMessageId:J

.field public limit:I

.field public offset:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47436
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47437
    return-void
.end method

.method public constructor <init>(JIJII)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "j9"    # J
    .param p6, "i10"    # I
    .param p7, "i11"    # I

    .line 47423
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47424
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetForumTopicHistory;->chatId:J

    .line 47425
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetForumTopicHistory;->forumTopicId:I

    .line 47426
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$GetForumTopicHistory;->fromMessageId:J

    .line 47427
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$GetForumTopicHistory;->offset:I

    .line 47428
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$GetForumTopicHistory;->limit:I

    .line 47429
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47433
    const v0, -0x1436b5bf

    return v0
.end method
