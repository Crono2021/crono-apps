.class public Lorg/drinkless/tdlib/TdApi$DeleteSavedMessagesTopicMessagesByDate;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteSavedMessagesTopicMessagesByDate"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x160a25


# instance fields
.field public maxDate:I

.field public minDate:I

.field public savedMessagesTopicId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36630
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36631
    return-void
.end method

.method public constructor <init>(JII)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "i10"    # I

    .line 36619
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36620
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteSavedMessagesTopicMessagesByDate;->savedMessagesTopicId:J

    .line 36621
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$DeleteSavedMessagesTopicMessagesByDate;->minDate:I

    .line 36622
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$DeleteSavedMessagesTopicMessagesByDate;->maxDate:I

    .line 36623
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36627
    const v0, 0x160a25

    return v0
.end method
