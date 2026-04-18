.class public Lorg/drinkless/tdlib/TdApi$DeleteDirectMessagesChatTopicMessagesByDate;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteDirectMessagesChatTopicMessagesByDate"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3854ca09


# instance fields
.field public chatId:J

.field public maxDate:I

.field public minDate:I

.field public topicId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43038
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43039
    return-void
.end method

.method public constructor <init>(JJII)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I
    .param p6, "i10"    # I

    .line 43026
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43027
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteDirectMessagesChatTopicMessagesByDate;->chatId:J

    .line 43028
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$DeleteDirectMessagesChatTopicMessagesByDate;->topicId:J

    .line 43029
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$DeleteDirectMessagesChatTopicMessagesByDate;->minDate:I

    .line 43030
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$DeleteDirectMessagesChatTopicMessagesByDate;->maxDate:I

    .line 43031
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43035
    const v0, 0x3854ca09

    return v0
.end method
