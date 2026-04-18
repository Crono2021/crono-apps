.class public Lorg/drinkless/tdlib/TdApi$ToggleGeneralForumTopicIsHidden;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleGeneralForumTopicIsHidden"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5f1d1448


# instance fields
.field public chatId:J

.field public isHidden:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33208
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33209
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33198
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33199
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleGeneralForumTopicIsHidden;->chatId:J

    .line 33200
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleGeneralForumTopicIsHidden;->isHidden:Z

    .line 33201
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33205
    const v0, 0x5f1d1448

    return v0
.end method
