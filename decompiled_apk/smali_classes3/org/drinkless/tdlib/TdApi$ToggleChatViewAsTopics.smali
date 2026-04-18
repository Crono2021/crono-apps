.class public Lorg/drinkless/tdlib/TdApi$ToggleChatViewAsTopics;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleChatViewAsTopics"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2b2783dc


# instance fields
.field public chatId:J

.field public viewAsTopics:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33168
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33169
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33158
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33159
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleChatViewAsTopics;->chatId:J

    .line 33160
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleChatViewAsTopics;->viewAsTopics:Z

    .line 33161
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33165
    const v0, 0x2b2783dc

    return v0
.end method
