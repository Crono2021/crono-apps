.class public Lorg/drinkless/tdlib/TdApi$UpdateChatHasProtectedContent;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatHasProtectedContent"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6b50071b


# instance fields
.field public chatId:J

.field public hasProtectedContent:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34028
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34029
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 34018
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34019
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatHasProtectedContent;->chatId:J

    .line 34020
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatHasProtectedContent;->hasProtectedContent:Z

    .line 34021
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34025
    const v0, 0x6b50071b

    return v0
.end method
