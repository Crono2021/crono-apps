.class public Lorg/drinkless/tdlib/TdApi$GetMessageReadDate;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetMessageReadDate"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$MessageReadDate;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x587afcbd


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26404
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26405
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 26394
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26395
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetMessageReadDate;->chatId:J

    .line 26396
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetMessageReadDate;->messageId:J

    .line 26397
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26401
    const v0, -0x587afcbd

    return v0
.end method
