.class public Lorg/drinkless/tdlib/TdApi$UpdateBusinessMessagesDeleted;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateBusinessMessagesDeleted"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x41f6f2ca


# instance fields
.field public chatId:J

.field public connectionId:Ljava/lang/String;

.field public messageIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41494
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41495
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;J[J)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "jArr"    # [J

    .line 41483
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41484
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateBusinessMessagesDeleted;->connectionId:Ljava/lang/String;

    .line 41485
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateBusinessMessagesDeleted;->chatId:J

    .line 41486
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$UpdateBusinessMessagesDeleted;->messageIds:[J

    .line 41487
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41491
    const v0, -0x41f6f2ca

    return v0
.end method
