.class public Lorg/drinkless/tdlib/TdApi$GetMessageThread;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetMessageThread"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$MessageThreadInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7af23e3e


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26424
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26425
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 26414
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26415
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetMessageThread;->chatId:J

    .line 26416
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetMessageThread;->messageId:J

    .line 26417
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26421
    const v0, 0x7af23e3e

    return v0
.end method
