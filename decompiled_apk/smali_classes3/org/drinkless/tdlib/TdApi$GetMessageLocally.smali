.class public Lorg/drinkless/tdlib/TdApi$GetMessageLocally;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetMessageLocally"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Message;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x23f9d494


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26364
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26365
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 26354
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26355
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetMessageLocally;->chatId:J

    .line 26356
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetMessageLocally;->messageId:J

    .line 26357
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26361
    const v0, -0x23f9d494

    return v0
.end method
