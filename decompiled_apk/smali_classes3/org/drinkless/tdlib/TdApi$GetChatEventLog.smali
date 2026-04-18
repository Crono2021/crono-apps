.class public Lorg/drinkless/tdlib/TdApi$GetChatEventLog;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatEventLog"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatEvents;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4c5fc49d


# instance fields
.field public chatId:J

.field public filters:Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;

.field public fromEventId:J

.field public limit:I

.field public query:Ljava/lang/String;

.field public userIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49786
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49787
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;JILorg/drinkless/tdlib/TdApi$ChatEventLogFilters;[J)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "j9"    # J
    .param p6, "i9"    # I
    .param p7, "chatEventLogFilters"    # Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;
    .param p8, "jArr"    # [J

    .line 49772
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49773
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatEventLog;->chatId:J

    .line 49774
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetChatEventLog;->query:Ljava/lang/String;

    .line 49775
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$GetChatEventLog;->fromEventId:J

    .line 49776
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$GetChatEventLog;->limit:I

    .line 49777
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$GetChatEventLog;->filters:Lorg/drinkless/tdlib/TdApi$ChatEventLogFilters;

    .line 49778
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$GetChatEventLog;->userIds:[J

    .line 49779
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49783
    const v0, -0x4c5fc49d

    return v0
.end method
