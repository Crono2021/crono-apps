.class public Lorg/drinkless/tdlib/TdApi$DeleteChatBackground;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteChatBackground"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1316e678


# instance fields
.field public chatId:J

.field public restorePrevious:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24964
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24965
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 24954
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24955
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteChatBackground;->chatId:J

    .line 24956
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$DeleteChatBackground;->restorePrevious:Z

    .line 24957
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24961
    const v0, 0x1316e678

    return v0
.end method
