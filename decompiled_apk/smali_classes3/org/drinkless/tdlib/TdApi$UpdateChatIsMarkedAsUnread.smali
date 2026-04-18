.class public Lorg/drinkless/tdlib/TdApi$UpdateChatIsMarkedAsUnread;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatIsMarkedAsUnread"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x57853334


# instance fields
.field public chatId:J

.field public isMarkedAsUnread:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34068
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34069
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 34058
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34059
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatIsMarkedAsUnread;->chatId:J

    .line 34060
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatIsMarkedAsUnread;->isMarkedAsUnread:Z

    .line 34061
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34065
    const v0, 0x57853334

    return v0
.end method
