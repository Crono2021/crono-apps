.class public Lorg/drinkless/tdlib/TdApi$SavedMessagesTopicTypeSavedFromChat;
.super Lorg/drinkless/tdlib/TdApi$SavedMessagesTopicType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SavedMessagesTopicTypeSavedFromChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x66c052a8


# instance fields
.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19158
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SavedMessagesTopicType;-><init>()V

    .line 19159
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 19149
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SavedMessagesTopicType;-><init>()V

    .line 19150
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SavedMessagesTopicTypeSavedFromChat;->chatId:J

    .line 19151
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19155
    const v0, -0x66c052a8

    return v0
.end method
