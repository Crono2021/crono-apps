.class public Lorg/drinkless/tdlib/TdApi$SetForumTopicNotificationSettings;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetForumTopicNotificationSettings"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x76955d8c


# instance fields
.field public chatId:J

.field public forumTopicId:I

.field public notificationSettings:Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40372
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40373
    return-void
.end method

.method public constructor <init>(JILorg/drinkless/tdlib/TdApi$ChatNotificationSettings;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "chatNotificationSettings"    # Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;

    .line 40361
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40362
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetForumTopicNotificationSettings;->chatId:J

    .line 40363
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$SetForumTopicNotificationSettings;->forumTopicId:I

    .line 40364
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SetForumTopicNotificationSettings;->notificationSettings:Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;

    .line 40365
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40369
    const v0, -0x76955d8c

    return v0
.end method
