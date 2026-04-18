.class public Lorg/drinkless/tdlib/TdApi$GetMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Messages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x19598d8a


# instance fields
.field public chatId:J

.field public messageIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26464
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26465
    return-void
.end method

.method public constructor <init>(J[J)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "jArr"    # [J

    .line 26454
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26455
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetMessages;->chatId:J

    .line 26456
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetMessages;->messageIds:[J

    .line 26457
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26461
    const v0, 0x19598d8a

    return v0
.end method
